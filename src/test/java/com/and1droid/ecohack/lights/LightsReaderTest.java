package com.and1droid.ecohack.lights;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;

public class LightsReaderTest {

    @Test
    public void testGetResource() throws URISyntaxException {
        assertEquals(2218, new LightKmlReader().extractInfos().size());
    }
}
