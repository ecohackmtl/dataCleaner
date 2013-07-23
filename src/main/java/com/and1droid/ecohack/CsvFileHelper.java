package com.and1droid.ecohack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
}