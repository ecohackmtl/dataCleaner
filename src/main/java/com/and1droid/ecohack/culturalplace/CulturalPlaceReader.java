package com.and1droid.ecohack.culturalplace;

import com.and1droid.ecohack.tool.CsvReader;

public class CulturalPlaceReader extends CsvReader<CulturalPlace> {

    @Override
    protected CulturalPlace createData(String line) {
        CulturalPlace accessibleBuilding = new CulturalPlace();
        String[] columns = line.split(";");
        accessibleBuilding.setId(Integer.parseInt(columns[0]));
        accessibleBuilding.setEtat(columns[1]);
        accessibleBuilding.setDistrict(columns[2]);
        accessibleBuilding.setType(columns[3]);
        accessibleBuilding.setName(columns[4]);
        accessibleBuilding.setAddress(columns[5]);
        accessibleBuilding.setZip(columns[6]);
        accessibleBuilding.setCity(columns[7]);
        accessibleBuilding.setState(columns[8]);
        for (int i = 9; i < 12; i++) {
            accessibleBuilding.addPhone(columns[i]);    
        }
        accessibleBuilding.setWebsite(columns[12]);
        accessibleBuilding.setType(columns[13]);
        return accessibleBuilding;
    }

    @Override
    protected String getFileName() {
        return "culturalplace/culturalplace.csv";
    }

}
