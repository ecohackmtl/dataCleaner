package com.and1droid.ecohack.lights;

import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;

public class Light {

    private String name;
    private List<Coordinate> coordinates;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
