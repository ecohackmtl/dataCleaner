package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.and1droid.ecohack.garden.commun.GardenCommunShapeFileReader;
import com.and1droid.ecohack.tool.shapefile.ShapeFileItem;
import com.google.gson.Gson;

public class GardenShapeFileReaderTest {

    @Test
    public void extractParks() {
        List<ShapeFileItem> gardens = new GardenCommunShapeFileReader().extractDatas();
        assertEquals(99, gardens.size());
        System.out.println(new Gson().toJson(gardens.get(0)));
    }

}
