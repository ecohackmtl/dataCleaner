package com.and1droid.ecohack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;

import com.and1droid.ecohack.tool.CsvFileHelper;
import com.and1droid.ecohack.tool.FileHelper;

public class CsvFileHelperTest {
    private final static String FILE_NAME = "bike_support/support_velo_sigs.csv";

    @Test
    public void testGetResource() throws URISyntaxException {
        final File file = FileHelper.getResource(FILE_NAME);
        assertTrue(file.exists());
    }

    @Test
    public void testReadFile() throws URISyntaxException, IOException {
        final File file = FileHelper.getResource(FILE_NAME);
        List<String> lines = CsvFileHelper.readFile(file);

        // Test
        assertEquals(747, lines.size());
        String[] columns = lines.get(0).split(",");
        for (String column : columns) {
            System.out.println(column);
        }
        for (int i = 1; i < lines.size(); i++) {
            System.out.println("i=" + i);
            assertEquals(26, lines.get(i).split(",").length);
        }
    }
}
