package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.and1droid.ecohack.parks.ParkShapeFileReader;
import com.and1droid.ecohack.tool.shapefile.ShapeFileItem;
import com.google.gson.Gson;

public class ParkShapeFileReaderTest {

    @Test
    public void extractParks() {
        List<ShapeFileItem> parks = new ParkShapeFileReader().extractDatas();
        assertEquals(27, parks.size());
        System.out.println(new Gson().toJson(parks.get(0)));
    }

}
