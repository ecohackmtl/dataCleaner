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

package diewald_shapeFile.shapeFile;

import java.io.File;
import java.util.List;

import diewald_shapeFile.files.dbf.DBF_Field;
import diewald_shapeFile.files.dbf.DBF_File;
import diewald_shapeFile.files.shp.SHP_File;
import diewald_shapeFile.files.shp.shapeTypes.ShpShape;
import diewald_shapeFile.files.shx.SHX_File;

/**
 * main class for loading/reading a "ShapeFile".<br>
 * a ShapeFile consists of at least the following files:<br>
 * 
 * <pre>
 * dBaseFile:      *.dbf
 * shapeFile:      *.shp
 * ShapeIndexFile: *.shx
 * </pre>
 * 
 * all this files must be located in the same given folder and start with the same name.<br>
 * example: "my_shapefile.dbf", "my_shapefile.shp", "my_shapefile.shx"<br>
 * In each of the .shp, .shx, and .dbf files, the shapes in each file correspond to each other in sequence. <br>
 * That is, the first record in the .shp file corresponds to the first record in the .shx and .dbf files, and so on.<br>
 * <br>
 * 
 * <a href="http://en.wikipedia.org/wiki/Shapefile" target=blank>http://en.wikipedia.org/wiki/Shapefile"</a><br>
 * 
 * @author thomas diewald (2012)
 * 
 */
public class ShapeFile<S extends ShpShape> {

    // library info
    public final static String _LIBRARY_NAME = "diewald_shapeFileReader";
    public final static String _LIBRARY_VERSION = "1.0";
    public final static String _LIBRARY_AUTHOR = "Thomas Diewald";
    public final static String _LIBRARY_LAST_EDIT = "2012.04.09";

    // mandatory files
    private SHX_File<S> shx_file; // index-File: contains offsets and content lengths of each record in the main shp-file.
    private DBF_File<S> dbf_file; // dBASE-file: attribute format; columnar attributes for each shape, in dBase IV format.
    private SHP_File<S> shp_file; // shape-File: contains geometry.

    /**
     * <pre>
     * init the ShapeFile, and load the following files:
     *   "path + filename.shx",
     *   "path + filename.dbf",
     *   "path + filename.shp"
     * </pre>
     * 
     * @param path
     * @param filename
     * @throws Exception
     */
    public ShapeFile(String path, String filename) throws Exception {

        // MAIN DIRECTORY
        File dir = new File(path);

        // GENERATE NEW READERS
        shx_file = new SHX_File<S>(this, new File(dir, filename + ".shx"));
        dbf_file = new DBF_File<S>(this, new File(dir, filename + ".dbf"));
        shp_file = new SHP_File<S>(this, new File(dir, filename + ".shp"));
    }

    /**
     * read shape file.
     * 
     * @return current instance
     * @throws Exception
     */
    public ShapeFile<S> read() throws Exception {
        shx_file.read();
        dbf_file.read();
        shp_file.read(getDBF_record(), getDBF_fieldCount(), getDBF_field());
        return this;
    }

    // ----------------------------------------------------------------------------
    // SIMPLE DATA ACCESS
    // ----------------------------------------------------------------------------

    // ----------------------------------------------------------------------------
    // SHAPE FILE
    // ----------------------------------------------------------------------------


    /**
     * get a list of all shapes. <br>
     * e.g. ArrayList<ShpPolygon> shape = shape_file.getShapes();
     * 
     * @param <T>
     *            Shape: ShpPolygon, ShpPolyLine, ShpPoint, or ShpMultiPoint
     * @return list of Shapes
     */
    public List<S> getSHP_shapes() {
        return shp_file.getShpShapes();
    }

    /**
     * get a shapes by the given index.<br>
     * e.g. ShpPolygon shape = shape_file.getShape(0);
     * 
     * @param <T>
     *            Shape: ShpPolygon, ShpPolyLine, ShpPoint, or ShpMultiPoint
     * @param index
     * @return shape
     */
    private S getSHP_shape(int index) {
        return getSHP_shapes().get(index);
    }

    /**
     * get the shapeType of the shapes contained in the file.
     * 
     * @return shapeType
     */
    private ShpShape.Type getSHP_shapeType() {
        return shp_file.getHeader().getShapeType();
    }

    /**
     * same as: {@link diewald_shapeFile.files.shp.SHP_Header#getBoundingBox()}
     * 
     * @return boundingbox-values
     */
    private double[][] getSHP_boundingBox() {
        return shp_file.getHeader().getBoundingBox();
    }

    // ----------------------------------------------------------------------------
    // DATA BASE FILE
    // ----------------------------------------------------------------------------

    // DATA BASE FIELD
    private int getDBF_fieldCount() {
        return dbf_file.getFields().length;
    }

    private DBF_Field[] getDBF_field() {
        return dbf_file.getFields();
    }

    private DBF_Field getDBF_field(int index) {
        return dbf_file.getFields()[index];
    }

    // DATA BASE RECORD
    /**
     * get the number of data-base records, contained in the dbf-file (same as number of shapes).
     * 
     * @return number of data-base records.
     */
    private int getDBF_recordCount() {
        return dbf_file.getContent().length;
    }

    /**
     * same as: {@link diewald_shapeFile.files.dbf.DBF_File#getContent()}
     * 
     * @return 2D-String-Table.
     */
    private String[][] getDBF_record() {
        return dbf_file.getContent();
    }

    private String[] getDBF_record(int index) {
        return dbf_file.getContent()[index];
    }

    private String getDBF_record(int row, int col) {
        return dbf_file.getContent()[row][col];
    }

    @Override
    public String toString() {
        return "shape_type = " + getSHP_shapeType();
    }

}