package com.and1droid.ecohack.freesnowparking;

import com.and1droid.ecohack.tool.CsvReader;

public class FreeSnowParkingReader extends CsvReader<FreeSnowParking> {

    @Override
    protected FreeSnowParking createData(String line) {
        FreeSnowParking freeSnowParking = new FreeSnowParking();
        String[] columns = line.split(",");
        freeSnowParking.setLon(columns[0]);
        freeSnowParking.setLat(columns[1]);
        return freeSnowParking;
    }

    @Override
    protected String getFileName() {
        return "freesnowparking/freesnowparking.csv";
    }

}
