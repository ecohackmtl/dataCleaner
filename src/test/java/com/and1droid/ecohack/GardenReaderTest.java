package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;

import com.and1droid.ecohack.garden.initiatives.GardenReader;

public class GardenReaderTest {

    @Test
    public void testGetResource() throws URISyntaxException {
        assertEquals(23, new GardenReader().extractInfos().size());
    }
}
