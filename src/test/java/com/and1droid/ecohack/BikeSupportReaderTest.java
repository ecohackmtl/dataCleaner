package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.and1droid.ecohack.bikesupport.BikeSupportReader;

public class BikeSupportReaderTest {

    @Test
    public void testGetResource() {
        assertEquals(746, new BikeSupportReader().extractDatas().size());
    }

}
