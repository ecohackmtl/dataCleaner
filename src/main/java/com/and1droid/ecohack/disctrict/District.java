package com.and1droid.ecohack.disctrict;

public class District {

    private String name;
    private double[][][] coordinates;

    public District(String name, double[][][] coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public double[][][] getCoordinates() {
        return coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(double[][][] coordinates) {
        this.coordinates = coordinates;
    }

}
