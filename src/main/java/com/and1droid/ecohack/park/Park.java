package com.and1droid.ecohack.park;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Park {

    @Id
    private String parkID;
    private String name;

    private List<String> boundaries;

    public Park() {
    }

    public Park(String parkID, String name, List<String> convertToShapes) {
        this.parkID = parkID;
        this.name = name;
        this.boundaries = convertToShapes;
    }

    public String getName() {
        return name;
    }

    public void setId(String parkID) {
        this.parkID = parkID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return parkID;
    }

    @Transient
    public String getIdField() {
        return "parkID";
    }

    public List<String> getBoundaries() {
        return boundaries;
    }

    void setBoundaries(List<String> boundaries) {
        this.boundaries = boundaries;
    }
}
