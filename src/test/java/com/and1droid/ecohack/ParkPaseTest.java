package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.and1droid.ecohack.parks.Park;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ParkPaseTest {

    private final static String FILE_NAME = "/parks/park.json";
    
    @Test
    public void testParsePark() throws UnsupportedEncodingException {
        InputStream resourceAsStream = getClass().getResourceAsStream(FILE_NAME);
        JsonReader jsonReader = new JsonReader(new InputStreamReader(resourceAsStream, "UTF-8"));
        Park park = new Gson().fromJson(jsonReader, Park.class);
        assertEquals(79, park.getBoundaries().size());
    }
}
