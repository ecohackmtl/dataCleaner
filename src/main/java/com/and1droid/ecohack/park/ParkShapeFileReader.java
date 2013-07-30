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

package com.and1droid.ecohack.park;

import com.and1droid.ecohack.tool.shapefile.ShapeFileItem;
import com.and1droid.ecohack.tool.shapefile.ShapeFileReader;

import diewald_shapeFile.files.shp.shapeTypes.ShpPolygon;

public class ParkShapeFileReader extends ShapeFileReader<ShpPolygon> {

    protected ShapeFileItem createData(ShpPolygon shape) {
        ShapeFileItem shapeFileItem = new ShapeFileItem();
        shapeFileItem.setId(shape.getParams().get("Index_").trim());
        shapeFileItem.setName(shape.getParams().get("Nom_parc").trim());
        shapeFileItem.setPoints(shape.getPointsAs3DArray());
        return shapeFileItem;
    }

    protected String getFileName() {
        return "GrandsParcs130218";
    }

    protected String getFolder() {
        String curDir = System.getProperty("user.dir");
        String folder = "/ecohack/parks/";
        return curDir + folder;
    }
}
