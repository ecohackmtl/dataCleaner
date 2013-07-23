package com.and1droid.ecohack;

import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;

public class GardenReader extends KMLReader<Garden> {

    @Override
    protected String getFileName() {
        return "urban_agri/Initiativesenagricultureurbaine.kml";
    }

    @Override
    protected Garden convertToData(Placemark placemark) {
        Garden garden = new Garden();
        garden.setName(placemark.getName());
        garden.setDescription(placemark.getDescription());
        Point point = (Point) placemark.getGeometry();
        garden.setCoordinates(point.getCoordinates().get(0));
        return garden;
    }
}
