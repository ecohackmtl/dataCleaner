package com.and1droid.ecohack.garden.commun;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommunGarden {

    @Id
    private String gardenId;
    private String name;
    private String district;
    private List<String> boundaries;

    public CommunGarden(String id, String name, String district, List<String> boundaries) {
        this.gardenId = id;
        this.name = name;
        this.district = district;
        this.setBoundaries(boundaries);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
        this.gardenId = gardenId;
    }

    public List<String> getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(List<String> boundaries) {
        this.boundaries = boundaries;
    }

}
