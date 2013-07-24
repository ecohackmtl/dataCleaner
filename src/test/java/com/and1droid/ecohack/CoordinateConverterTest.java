package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.and1droid.ecohack.CoordTransport.Coord;
import com.google.gson.Gson;

public class CoordinateConverterTest {

    @Test
    public void convertDatas() throws IOException {
        List<Coord> coords = new ArrayList<Coord>();
        add10Coordinate(coords);
        add10Coordinate(coords);
        add10Coordinate(coords);
        add10Coordinate(coords);
        List<String> convert = CoordinateConverter.callConvertService(coords, new Gson());
        assertEquals(coords.size(), convert.size());
    }

    private void add10Coordinate(List<Coord> coords) {
        coords.add(new Coord(269898.9028125005, 5035677.154843751));
        coords.add(new Coord(269890.33265625127, 5035673.2790625));
        coords.add(new Coord(269888.26265625097, 5035678.458906252));
        coords.add(new Coord(269888.4425000008, 5035685.739218747));
        coords.add(new Coord(269882.63250000123, 5035699.0990625005));
        coords.add(new Coord(269880.84375000186, 5035708.967656253));
        coords.add(new Coord(269880.93281250075, 5035726.14890625));
        coords.add(new Coord(269881.6128125014, 5035729.898906251));
        coords.add(new Coord(269887.3028124999, 5035729.329062499));
        coords.add(new Coord(269899.45843750145, 5035728.974843752));
    }

    public void convertMoreDatas() throws IOException {
        List<Coord> coords = new ArrayList<Coord>();
        add10Coordinate(coords);
        add10Coordinate(coords);
        add10Coordinate(coords);
        add10Coordinate(coords);
        List<String> convert = CoordinateConverter.callConvertService(coords, new Gson());
        assertEquals(coords.size(), convert.size());
    }
}
