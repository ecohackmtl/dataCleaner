package com.and1droid.ecohack.buildingaccessibility;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "buildingAccessibilityendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = ""), description = "Petit test de description")
public class BuildingAccessibilityEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    @ApiMethod(name = "listAccessibleBuildings")
    public CollectionResponse<BuildingAccessibility> listAccessibleBuildings() {
        return CollectionResponse.<BuildingAccessibility> builder().setItems(new BuildingAccessibilityReader().extractDatas()).build();
    }
}
