package com.and1droid.ecohack.greenstreet;

import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;

public class GreenStreet {

    private String name;
    private String description;
    private Boolean tessellate;
    private List<Coordinate> coordinates;

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

    public Boolean isTessellate() {
        return tessellate;
    }

    public void setTessellate(Boolean tessellate) {
        this.tessellate = tessellate;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

}
