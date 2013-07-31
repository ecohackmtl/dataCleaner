package com.and1droid.ecohack.buildingaccessibility;

import com.and1droid.ecohack.tool.CsvReader;

public class BuildingAccessibilityReader extends CsvReader<BuildingAccessibility> {

    @Override
    protected BuildingAccessibility createData(String line) {
        BuildingAccessibility accessibleBuilding = new BuildingAccessibility();
        String[] columns = line.split(";");
        accessibleBuilding.setId(Integer.parseInt(columns[0]));
        accessibleBuilding.setAddress(columns[1]);
        accessibleBuilding.setUniversalAccessibility("NON".equals(columns[2]) ? false : true);
        try {
            accessibleBuilding.setElevatorCount(Integer.parseInt(columns[3]));
        } catch (NumberFormatException e) {
        }
        accessibleBuilding.setTypeChauffage(columns[4]);
        accessibleBuilding.setLon(columns[6]);
        accessibleBuilding.setLat(columns[7]);
        return accessibleBuilding;
    }

    @Override
    protected String getFileName() {
        return "buildingaccessibility/buildingaccessibility.csv";
    }

}
