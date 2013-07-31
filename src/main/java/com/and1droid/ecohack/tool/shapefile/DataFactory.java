package com.and1droid.ecohack.tool.shapefile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.and1droid.ecohack.ilot.Ilot;
import com.and1droid.ecohack.parks.Park;

public class DataFactory {

    public static Object createPersistable(Class clazz, ShapeFileItem data) throws UnsupportedEncodingException, IOException {
        List<String> boundaries = CoordinateConverter.convertToShapes(data.getPoints());
        if (clazz.equals(Ilot.class)) {
            return new Ilot(boundaries);
        } else if (clazz.equals(Park.class)) {
            return new Park(data.getId(), data.getName(), boundaries);
        }
        throw new RuntimeException(clazz.getSimpleName() + " not yet implemented");
    }
}
