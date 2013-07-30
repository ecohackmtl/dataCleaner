package com.and1droid.ecohack.tool.shapefile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.and1droid.ecohack.tool.shapefile.CoordTransport.Coord;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class CoordinateConverter {

    static Gson gson = new Gson();

    protected static List<String> callConvertService(List<Coord> temp, Gson gson, int numShape) throws UnsupportedEncodingException, IOException {
        CoordTransport coordTransport = new CoordTransport();
        coordTransport.setGeometries(temp);
        String json = URLEncoder.encode(gson.toJson(coordTransport), "UTF-8");
        String spec = "http://tasks.arcgisonline.com/ArcGIS/rest/services/Geometry/GeometryServer/project?inSR=32188&outSR=4326&f=json&geometries=" + json;
        URL url = new URL(spec);
        // System.out.println("Url appelée : " + spec);
        JsonReader jsonReader = new JsonReader(new InputStreamReader(url.openStream(), "UTF-8"));
        coordTransport = gson.fromJson(jsonReader, CoordTransport.class);
        List<String> coordsString = new ArrayList<String>();
        for (Coord coord : coordTransport.getGeometries()) {
            coordsString.add(numShape + ";" + coord.getY() + ";" + coord.getX());
        }
        return coordsString;
    }

    public static List<String> convertToShapes(double[][][] points) throws UnsupportedEncodingException, IOException {
        List<String> shapes = new ArrayList<String>();
        for (int i = 0; i < points.length; i++) {
            shapes.addAll(convertPointsToCoords(points[i], i));
        }
        return shapes;
    }

    protected static List<String> convertPointsToCoords(double[][] points, int numShape) throws UnsupportedEncodingException, IOException {
        List<Coord> temp = new ArrayList<Coord>();
        List<String> coords = new ArrayList<String>();
        for (int j = 0; j < points.length; j++) {
            temp.add(new Coord(points[j][0], points[j][1]));
            if (j % 15 == 14) {
                coords.addAll(callConvertService(temp, gson, numShape));
                temp.clear();
            }
        }
        coords.addAll(callConvertService(temp, gson, numShape));
        return coords;
    }

}
