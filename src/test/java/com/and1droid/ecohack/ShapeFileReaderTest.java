package com.and1droid.ecohack;

import diewald_shapeFile.files.dbf.DBF_File;
import diewald_shapeFile.files.shp.SHP_File;
import diewald_shapeFile.files.shp.shapeTypes.ShpPolygon;
import diewald_shapeFile.files.shx.SHX_File;
import diewald_shapeFile.shapeFile.ShapeFile;

public class ShapeFileReaderTest {

    private static final String fileName = "GrandsParcs130218";
    static String folder = System.getProperty("user.dir") + "/ecohack/parks/";

    public static void main(String[] args) {
        DBF_File.LOG_INFO = !false;

        SHX_File.LOG_INFO = !false;

        SHP_File.LOG_INFO = !false;

        try {
            // LOAD SHAPE FILE (.shp, .shx, .dbf)
            ShapeFile<ShpPolygon> shapefile = new ShapeFile<ShpPolygon>(folder, fileName).read();
            System.out.println(shapefile);

            for (ShpPolygon shape : shapefile.getSHP_shapes()) {
                System.out.println(shape);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}