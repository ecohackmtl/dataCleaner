package com.and1droid.ecohack.buildingaccessibility;

public class BuildingAccessibility {

    private int id;
    private String address;
    private boolean universalAccessibility;
    private String typeChauffage;
    private Integer elevatorCount;
    private String lon;
    private String lat;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isUniversalAccessibility() {
        return universalAccessibility;
    }

    public void setUniversalAccessibility(boolean universalAccessibility) {
        this.universalAccessibility = universalAccessibility;
    }

    public Integer getElevatorCount() {
        return elevatorCount;
    }

    public void setElevatorCount(Integer elevatorCount) {
        this.elevatorCount = elevatorCount;
    }

    public String getTypeChauffage() {
        return typeChauffage;
    }

    public void setTypeChauffage(String typeChauffage) {
        this.typeChauffage = typeChauffage;
    }

}
