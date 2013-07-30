package com.and1droid.ecohack.tool.shapefile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoordTransport {

    private String geometryType = "esriGeometryPoint";
    private List<Coord> geometries = new ArrayList<Coord>();

    public void setGeometries(List<Coord> geometries) {
        this.geometries = geometries;
    }

    public List<Coord> getGeometries() {
        return Collections.unmodifiableList(geometries);
    }

    public void add(double x, double y) {
        geometries.add(new Coord(x, y));
    }
    
    public static class Coord {

        private double x;
        private double y;

        public Coord() {
        }

        public Coord(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

    }
}
