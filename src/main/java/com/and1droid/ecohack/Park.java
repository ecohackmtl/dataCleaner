package com.and1droid.ecohack;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Park {

    @Id
    @PrimaryKey
    private final String parkID;

    @Embedded
    @OneToOne(cascade = CascadeType.DETACH)
    private final List<LatLng> boundaries = new ArrayList<LatLng>();

    private final String name;

    public Park(String parkID, String name) {
        this.parkID = parkID;
        this.name = name;
    }

    public List<LatLng> getBoundaries() {
        return boundaries;
    }

    public String getName() {
        return name;
    }

    public String getParkID() {
        return parkID;
    }

    @Embeddable
    private static class LatLng {

        private double lat;
        private double lon;

        public LatLng(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }

    }

    public void addBoundary(double latitude, double longitude) {
        boundaries.add(new LatLng(latitude, longitude));
    }

}
