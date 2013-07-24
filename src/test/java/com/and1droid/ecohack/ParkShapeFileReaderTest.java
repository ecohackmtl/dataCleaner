package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class ParkShapeFileReaderTest {

    @Test
    public void extractParks() {
        assertEquals(27, ParkShapeFileReader.extractParks().size());
    }
    
}
