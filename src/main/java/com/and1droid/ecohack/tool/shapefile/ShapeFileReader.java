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

package com.and1droid.ecohack.tool.shapefile;

import java.util.ArrayList;
import java.util.List;

import diewald_shapeFile.files.dbf.DBF_File;
import diewald_shapeFile.files.shp.SHP_File;
import diewald_shapeFile.files.shp.shapeTypes.ShpShape;
import diewald_shapeFile.files.shx.SHX_File;
import diewald_shapeFile.shapeFile.ShapeFile;

public abstract class ShapeFileReader<S extends ShpShape> {

    public List<ShapeFileItem> extractDatas() {
        DBF_File.LOG_INFO = false;
        SHX_File.LOG_INFO = false;
        SHP_File.LOG_INFO = false;
        List<ShapeFileItem> datas = new ArrayList<ShapeFileItem>();
        try {
            // LOAD SHAPE FILE (.shp, .shx, .dbf)
            ShapeFile<S> shapefile = new ShapeFile<S>(getFolder(), getFileName()).read();

            for (S data : shapefile.getSHP_shapes()) {
                datas.add(createData(data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    protected abstract ShapeFileItem createData(S shape);

    protected abstract String getFolder();

    protected abstract String getFileName();

}
