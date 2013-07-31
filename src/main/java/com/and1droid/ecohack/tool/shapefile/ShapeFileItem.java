package com.and1droid.ecohack.tool.shapefile;

public class ShapeFileItem {

    private String id;
    private String name;

    protected double[][][] points;
    private String description;

    public ShapeFileItem() {
    }

    public ShapeFileItem(double[][][] points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public double[][][] getPoints() {
        return points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(double[][][] points) {
        this.points = points;
    }

    public String getIdField() {
        return "id";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
