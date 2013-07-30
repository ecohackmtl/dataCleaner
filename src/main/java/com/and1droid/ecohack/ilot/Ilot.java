package com.and1droid.ecohack.ilot;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Ilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key ilotId;

    private List<String> boundaries;

    public Ilot() {
    }
    
    public Ilot(List<String> boundaries) {
        this.boundaries = boundaries;
    }
    
    public void setBoundaries(List<String> boundaries) {
        this.boundaries = boundaries;
    }
    
    public List<String> getBoundaries() {
        return boundaries;
    }
    
}
