/**
 * diewald_shapeFileReader.
 * 
 * a Java Library for reading ESRI-shapeFiles (*.shp, *.dfb, *.shx).
 * 
 * 
 * Copyright (c) 2012 Thomas Diewald
 *
 *
 * This source is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This code is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * A copy of the GNU General Public License is available on the World
 * Wide Web at <http://www.gnu.org/copyleft/gpl.html>. You can also
 * obtain it by writing to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package diewald_shapeFile.files.dbf;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;

import diewald_shapeFile.files.ShapeFileReader;
import diewald_shapeFile.files.shp.shapeTypes.ShpShape;
import diewald_shapeFile.shapeFile.ShapeFile;

// http://de.wikipedia.org/wiki/DBASE
// http://www.clicketyclick.dk/databases/xbase/format/
// http://www.dbase.com/KnowledgeBase/int/db7_file_fmt.htm
// http://ulisse.elettra.trieste.it/services/doc/dbase/DBFstruct.htm#T1
// http://www.dbf2002.com/dbf-file-format.html
// http://www.oocities.org/geoff_wass/dBASE/GaryWhite/dBASE/FAQ/qformt.htm
// http://www.digitalpreservation.gov/formats/fdd/fdd000325.shtml
/**
 * dBase File Reader (*.dbf).<br>
 * <br>
 * extracts HEADER, FIELDS and RECORDS from a given ByteBuffer.<br>
 * <br>
 * RECORDS: 2D-String Table:<br>
 * String[row][col]... String[number of records][number of fields].<br>
 * <br>
 * FIELDS: information about type, length, name (can be useful for converting the values).<br>
 * 
 * @author thomas diewald (2012)
 */
public class DBF_File<S extends ShpShape> extends ShapeFileReader<S> {

    /** enable/disable general info-logging. */
    public static boolean LOG_INFO = true;

    // HEADER
    private byte DBF_file_type;
    private int DBF_date_yy;
    private int DBF_date_mm;
    private int DBF_date_dd;

    private int DBF_number_of_records; // number of records.
    private int DBF_size_header_bytes; // size of header (bytes).
    private int DBF_size_record_bytes; // size of record (bytes).

    // FIELDS
    private DBF_Field[] DBF_fields;

    // RECORD TABLE
    private String[][] DBF_records;

    public DBF_File(ShapeFile<S> parent_shapefile, File file) throws IOException {
        super(parent_shapefile, file);
    }

    public void read() throws Exception {
        // --------------------------------------------------------------------------
        // READ HEADER
        bb.order(ByteOrder.LITTLE_ENDIAN);
        DBF_file_type = bb.get(0);
        DBF_date_yy = bb.get(1) + 1900;
        DBF_date_mm = bb.get(2);
        DBF_date_dd = bb.get(3);
        DBF_number_of_records = bb.getInt(4);
        DBF_size_header_bytes = bb.getShort(8);
        DBF_size_record_bytes = bb.getShort(10);

        // --------------------------------------------------------------------------
        // READ FIELDS
        int POS = 32; // start of fields
        bb.position(POS);

        int num_fields = (DBF_size_header_bytes - POS - 1) / DBF_Field.SIZE_BYTES; // cant this be easier???
        DBF_fields = new DBF_Field[num_fields];

        for (int i = 0; i < DBF_fields.length; i++) {
            DBF_fields[i] = new DBF_Field(this, bb, i);
            // DBF_fields[i].print();
            POS += DBF_Field.SIZE_BYTES;
            bb.position(POS);
        }

        // --------------------------------------------------------------------------
        // HEADER END
        @SuppressWarnings("unused")
        byte DBF_header_terminator = bb.get(); // = 13 or 0x0D
        // System.out.println("DBF_header_terminator = "+DBF_header_terminator);

        // --------------------------------------------------------------------------
        // RECORD CONTENT
        POS = DBF_size_header_bytes;
        bb.position(POS);

        DBF_records = new String[DBF_number_of_records][num_fields];
        for (int i = 0; i < DBF_number_of_records; i++) {

            byte[] string_tmp = new byte[DBF_size_record_bytes];
            bb.get(string_tmp);

            try {
                String DBF_record = new String(string_tmp, "ISO-8859-1");
                // System.out.printf("DBF_record = %s\n", DBF_record);
                int from = 1;
                int to = 1;
                for (int j = 0; j < DBF_fields.length; j++) {
                    to += DBF_fields[j].getLength();
                    DBF_records[i][j] = DBF_record.substring(from, to);
                    // System.out.print(records[i][j]+"|");
                    from = to;
                }
                // System.out.println("");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
                // System.out.println(e);
            }

            POS += DBF_size_record_bytes;
            bb.position(POS);
        }
        if (LOG_INFO) {
            System.out.println(toString());
            System.out.printf("(ShapeFile) loaded File: \"%s\", records=%d\n", file.getName(), DBF_number_of_records);
        }
    }

    /**
     * get a 2D-String-table from the dbf-file.<br>
     * data-storage: String[row][col]... String[number of records][number of fields].<br>
     * data can be converted by using the DBaseField's information.<br>
     * 
     * @return 2D-String-table
     */
    public String[][] getContent() {
        return DBF_records;
    }

    /**
     * get the fields of the dbf-file.
     * 
     * @return fields
     */
    public DBF_Field[] getFields() {
        return DBF_fields;
    }

    /**
     * get Date of the file (HEADER-information).
     * 
     * @return date of the file as a String.
     */
    public String getDate() {
        return String.format("%d.%d.%d", DBF_date_yy, DBF_date_mm, DBF_date_dd);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("________________________< HEADER >________________________\n");
        stringBuilder.append("  FILE: " + file.getName() + "\n");
        stringBuilder.append("  DBF_file_type         = " + DBF_file_type + "\n");
        stringBuilder.append("  DBF_number_of_records = " + DBF_number_of_records + "\n");
        stringBuilder.append("________________________< /HEADER >________________________\n");
        stringBuilder.append("\n");
        stringBuilder.append("________________________< CONTENT >________________________\n");
        stringBuilder.append("\n");
        stringBuilder.append("  FIELDS:\n");
        for (int i = 0; i < DBF_fields.length; i++) {
            DBF_Field field = DBF_fields[i];
            field.print();
        }
        stringBuilder.append("\n");
        stringBuilder.append("  RECORDS:\n");
        for (int i = 0; i < DBF_number_of_records; i++) {
            stringBuilder.append("  [" + i + "]"); // print row
            for (int j = 0; j < DBF_fields.length; j++) {
                stringBuilder.append("\t[" + j + "]" + DBF_records[i][j]); // print fields
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("________________________< /CONTENT >________________________\n");
        return stringBuilder.toString();
    }
}
