package com.and1droid.ecohack.bike.track;

import java.util.ArrayList;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;

public class BikeTrack {

    private String name;
    private List<Coordinate> coordinates = new ArrayList<Coordinate>();
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

    public void addCoordinates(List<Coordinate> coordinates) {
        this.coordinates.addAll(coordinates);
    }

}
