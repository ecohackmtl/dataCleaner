package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;

import com.and1droid.ecohack.greenstreet.GreenStreetReader;

public class GreenStreetReaderTest {

    @Test
    public void testGetResource() throws URISyntaxException {
        assertEquals(155, new GreenStreetReader().extractInfos().size());
    }
}
