package com.and1droid.ecohack;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Park {

    @Id
    private String parkID;
    private String name;

    List<String> boundaries = new ArrayList<String>();

    @Transient
    private double[][] points;

    public Park() {
    }
    
    public Park(String parkID, String name, double[][] points) {
        this.parkID = parkID;
        this.name = name;
        this.points = points;
    }

    public List<String> getBoundaries() {
        return boundaries;
    }

    public String getName() {
        return name;
    }

    public String getParkID() {
        return parkID;
    }

    public void setBoundaries(List<String> boundaries) {
        this.boundaries = boundaries;
    }
    public void setParkID(String parkID) {
        this.parkID = parkID;
    }

    public void setPoints(double[][] points) {
        this.points = points;        
    }

    public double[][] getPoints() {
        return points;
    }

    /*@Embeddable
    */
}
