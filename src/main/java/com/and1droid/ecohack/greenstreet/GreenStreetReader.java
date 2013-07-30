package com.and1droid.ecohack.greenstreet;

import com.and1droid.ecohack.tool.KMLReader;

import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class GreenStreetReader extends KMLReader<GreenStreet> {

    @Override
    protected String getFileName() {
        return "green_street/Ruellesvertes.kml";
    }

    @Override
    protected GreenStreet convertToData(Placemark placemark) {
        GreenStreet greenStreet = new GreenStreet();
        greenStreet.setName(placemark.getName());
        greenStreet.setDescription(placemark.getDescription());
        LineString lineString = (LineString) placemark.getGeometry();
        greenStreet.setCoordinates(lineString.getCoordinates());
        greenStreet.setTessellate(lineString.isTessellate());
        return greenStreet;
    }

    
}
