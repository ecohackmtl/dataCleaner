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
            final File file = FileHelper.getResource(FILE_NAME);
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
        String[] columns = line.split(";");
        bikeSupport.setInv_id(columns[0]);
        bikeSupport.setInv_no(columns[1]);
        bikeSupport.setAnc_num(columns[2]);
        bikeSupport.setInv_catl_no(columns[3]);
        bikeSupport.setCatl_modele(columns[4]);
        bikeSupport.setMarq(columns[5]);
        bikeSupport.setCe_no(columns[6]);
        bikeSupport.setElement(columns[7]);
        bikeSupport.setCategorie(columns[8]);
        bikeSupport.setCouleur(columns[9]);
        bikeSupport.setMateriau(columns[10]);
        bikeSupport.setCondition(columns[11]);
        bikeSupport.setIntervention(columns[12]);
        bikeSupport.setEmpl_x(columns[13]);
        bikeSupport.setEmpl_y(columns[14]);
        bikeSupport.setEmpl_z(columns[15]);
        bikeSupport.setTerritoire(columns[16]);
        bikeSupport.setStatut(columns[17]);
        bikeSupport.setBase(columns[18]);
        bikeSupport.setAncrage(columns[19]);
        bikeSupport.setParc(columns[20]);
        bikeSupport.setAire(columns[21]);
        bikeSupport.setEmpl_id(columns[22]);
        bikeSupport.setOrdre_affichage(columns[23]);
        bikeSupport.setLon(columns[24]);
        bikeSupport.setLat(columns[25]);
        return bikeSupport;
    }

}
