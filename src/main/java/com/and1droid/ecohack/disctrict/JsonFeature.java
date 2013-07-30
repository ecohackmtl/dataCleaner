package com.and1droid.ecohack.disctrict;

public class JsonFeature {

    private JsonGeometry geometry;
    
    private JsonProperty properties;
    
    public double[][][] getCoordinates() {
        return geometry.getCoordinates();
    }
    
    public String getName() {
        return properties.getName();
    }
}
