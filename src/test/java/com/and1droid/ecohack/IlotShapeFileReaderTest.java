package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.and1droid.ecohack.ilot.IlotShapeFileReader;
import com.and1droid.ecohack.tool.shapefile.ShapeFileItem;
import com.google.gson.Gson;

public class IlotShapeFileReaderTest {

    @Test
    public void extractIlots() {
        List<ShapeFileItem> ilots = new IlotShapeFileReader().extractDatas();
        assertEquals(3, ilots.size());
        assertEquals(5865, ilots.get(0).getPoints().length);
        assertEquals(3283, ilots.get(1).getPoints().length);
        assertEquals(3, ilots.get(2).getPoints().length);
        String json = new Gson().toJson(ilots.get(2));
        System.out.println(json);
    }
}
