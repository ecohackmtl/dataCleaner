package com.and1droid.ecohack.garden;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;

public class Garden {
    private String name;
    private String description;
    private Coordinate coordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

}
