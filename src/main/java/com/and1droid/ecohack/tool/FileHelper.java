package com.and1droid.ecohack.tool;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


public class FileHelper {

    public static File getResource(String fileName) throws URISyntaxException {
        final URL resourceUrl = CsvFileHelper.class.getResource("/" + fileName);
        return new File(resourceUrl.toURI());
    }
}
