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

package com.and1droid.ecohack;

import java.util.ArrayList;
import java.util.List;

import diewald_shapeFile.files.dbf.DBF_File;
import diewald_shapeFile.files.shp.SHP_File;
import diewald_shapeFile.files.shp.shapeTypes.ShpPolygon;
import diewald_shapeFile.files.shx.SHX_File;
import diewald_shapeFile.shapeFile.ShapeFile;

public class ParkShapeFileReader {

    public static List<Park> extractParks() {
        DBF_File.LOG_INFO = !false;
        DBF_File.LOG_ONLOAD_HEADER = false;
        DBF_File.LOG_ONLOAD_CONTENT = false;

        SHX_File.LOG_INFO = !false;
        SHX_File.LOG_ONLOAD_HEADER = false;
        SHX_File.LOG_ONLOAD_CONTENT = false;

        SHP_File.LOG_INFO = !false;
        SHP_File.LOG_ONLOAD_HEADER = false;
        SHP_File.LOG_ONLOAD_CONTENT = false;
        List<Park> parks = new ArrayList<Park>();
        try {
            // GET DIRECTORY
            String curDir = System.getProperty("user.dir");
            String folder = "/ecohack/parks/";
            // LOAD SHAPE FILE (.shp, .shx, .dbf)
            ShapeFile shapefile = new ShapeFile(curDir + folder, "GrandsParcs130218").READ();
            // TEST: printing some content
            int number_of_shapes = shapefile.getSHP_shapeCount();

            for (int i = 0; i < number_of_shapes; i++) {
                ShpPolygon shape = shapefile.getSHP_shape(i);
                String[] shape_info = shapefile.getDBF_record(i);

                Park park = new Park("" + shape.getRecordNumber(), shape_info[1].trim());
                for (double[] points : shape.getPoints()) {
                    park.addBoundary(points[0], points[1]);
                }
                parks.add(park);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parks;
    }
}
