package com.and1droid.ecohack;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class BikeSupportReader {

    private final static String FILE_NAME = "bike_support/support_velo_sigs.csv";

    public static List<BikeSupport> extractBikeSupport() {
        List<BikeSupport> bikesSupport = new ArrayList<BikeSupport>();
        try {
            final File file = CsvFileHelper.getResource(FILE_NAME);
            List<String> lines = CsvFileHelper.readFile(file);
            boolean columIgnored = false;
            for (String line : lines) {
                if (columIgnored) {
                    bikesSupport.add(createBikeSupport(line));
                } else {
                    columIgnored = true;
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bikesSupport;
    }

    private static BikeSupport createBikeSupport(String line) {
        BikeSupport bikeSupport = new BikeSupport();
        String[] columns = line.split(",");
        bikeSupport.INV_ID = columns[0];
        bikeSupport.INV_NO = columns[1];
        bikeSupport.ANC_NUM = columns[2];
        bikeSupport.INV_CATL_NO = columns[3];
        bikeSupport.CATL_MODELE = columns[4];
        bikeSupport.MARQ = columns[5];
        bikeSupport.DATE_INSPECTION = columns[6];
        bikeSupport.CE_NO = columns[7];
        bikeSupport.ELEMENT = columns[8];
        bikeSupport.CATEGORIE = columns[9];
        bikeSupport.COULEUR = columns[10];
        bikeSupport.MATERIAU = columns[11];
        bikeSupport.CONDITION = columns[12];
        bikeSupport.INTERVENTION = columns[13];
        bikeSupport.EMPL_X = columns[14];
        bikeSupport.EMPL_Y = columns[15];
        bikeSupport.EMPL_Z = columns[16];
        bikeSupport.TERRITOIRE = columns[17];
        bikeSupport.STATUT = columns[18];
        bikeSupport.BASE = columns[19];
        bikeSupport.ANCRAGE = columns[20];
        bikeSupport.PARC = columns[21];
        bikeSupport.AIRE = columns[22];
        bikeSupport.EMPL_ID = columns[23];
        bikeSupport.ORDRE_AFFICHAGE = columns[24];
        bikeSupport.LONG = columns[25];
        bikeSupport.LAT = columns[26];
        return bikeSupport;
    }

}
