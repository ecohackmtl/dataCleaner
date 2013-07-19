package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BikeSupportReaderTest {

    @Test
    public void testGetResource() {
        assertEquals(746, BikeSupportReader.extractBikeSupport().size());
    }

}
