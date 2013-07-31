package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;

import com.and1droid.ecohack.bike.track.BikeTrackKmlReader;

public class BikeTrackReaderTest {

    @Test
    public void testGetResource() throws URISyntaxException {
        assertEquals(1908, new BikeTrackKmlReader().extractInfos().size());
    }

}
