package com.and1droid.ecohack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHelper {

    public static List<String> readFile(File file) throws IOException {

        List<String> result = new ArrayList<String>();

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "utf8");
        BufferedReader br = new BufferedReader(isr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
        }

        fis.close();
        isr.close();
        br.close();

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