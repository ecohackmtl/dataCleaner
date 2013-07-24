package com.and1droid.ecohack;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.and1droid.ecohack.CoordTransport.Coord;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class CoordinateConverter {

    protected static List<String> callConvertService(List<Coord> temp, Gson gson) throws UnsupportedEncodingException, IOException {
        CoordTransport coordTransport = new CoordTransport();
        coordTransport.setGeometries(temp);
        String json = URLEncoder.encode(gson.toJson(coordTransport), "UTF-8");
        String spec = "http://tasks.arcgisonline.com/ArcGIS/rest/services/Geometry/GeometryServer/project?inSR=32188&outSR=4326&f=json&geometries=" + json;
        URL url = new URL(spec);
        //System.out.println("Url appelée : " + spec);
        JsonReader jsonReader = new JsonReader(new InputStreamReader(url.openStream(), "UTF-8"));
        coordTransport = gson.fromJson(jsonReader, CoordTransport.class);
        List<String> coordsString = new ArrayList<String>();
        for (Coord coord : coordTransport.getGeometries()) {
            coordsString.add(coord.getY() + ";" + coord.getX());
        }
        return coordsString;
    }

    protected static List<String> convert(double[][] points) throws UnsupportedEncodingException, IOException {
        Gson gson = new Gson();
        List<Coord> temp = new ArrayList<Coord>();
        List<String> coords = new ArrayList<String>();
        for (int i = 0; i < points.length; i++) {
            temp.add(new Coord(points[i][0], points[i][1]));
            if (i % 15 == 14) {
                coords.addAll(callConvertService(temp, gson));
                temp.clear();
            }
        }
        coords.addAll(callConvertService(temp, gson));
        return coords;
    }

}
