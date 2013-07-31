package com.and1droid.ecohack.freesnowparking;

import javax.persistence.Entity;

@Entity
public class FreeSnowParking {

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

}
