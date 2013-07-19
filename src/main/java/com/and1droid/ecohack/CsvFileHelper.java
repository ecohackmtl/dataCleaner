package com.and1droid.ecohack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHelper {

    public static List<String> readFile(File file) throws IOException {

        List<String> result = new ArrayList<String>();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
        }

        br.close();
        fr.close();

        return result;
    }

    private static URL getResourcePath(String fileName) {
        return CsvFileHelper.class.getResource("/" + fileName);
    }

    public static File getResource(String fileName) throws URISyntaxException {
        final URL resourceUrl = getResourcePath(fileName);
        return new File(resourceUrl.toURI());
    }
}