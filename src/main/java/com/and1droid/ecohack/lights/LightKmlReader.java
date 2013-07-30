package com.and1droid.ecohack.lights;

import com.and1droid.ecohack.tool.KMLReader;

import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;

public class LightKmlReader extends KMLReader<Light> {

    @Override
    protected String getFileName() {
        return "lights/lumieres.kml";
    }

    @Override
    protected Light convertToData(Placemark placemark) {
        Light light = new Light();
        light.setName(placemark.getName());
        light.setId(placemark.getId());
        Point point = (Point) placemark.getGeometry();
        light.setCoordinates(point.getCoordinates());
        return light;
    }
}
