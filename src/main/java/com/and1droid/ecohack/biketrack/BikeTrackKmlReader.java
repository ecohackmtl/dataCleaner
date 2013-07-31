package com.and1droid.ecohack.biketrack;

import com.and1droid.ecohack.tool.KMLReader;

import de.micromata.opengis.kml.v_2_2_0.Geometry;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.MultiGeometry;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class BikeTrackKmlReader extends KMLReader<BikeTrack> {

    @Override
    protected String getFileName() {
        return "biketrack/bike_track.kml";
    }

    @Override
    protected BikeTrack convertToData(Placemark placemark) {
        BikeTrack bikeTrack = new BikeTrack();
        bikeTrack.setName(placemark.getName());
        bikeTrack.setId(placemark.getId());
        MultiGeometry multiGeometry = (MultiGeometry) placemark.getGeometry();
        for (Geometry geometry : ((MultiGeometry)multiGeometry).getGeometry()) {
            bikeTrack.addCoordinates(((LineString)geometry).getCoordinates());
        }
        return bikeTrack;
    }
}
