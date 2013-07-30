package com.and1droid.ecohack.garden;

import java.net.URISyntaxException;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "gardenendpoint", namespace = @ApiNamespace(ownerDomain = "vdfvdfvdfvdfvdfvdf.com", ownerName = "vdfvdfvdfvdfvdfvdf.com", packagePath = ""))
public class GardenEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     * @throws URISyntaxException 
     */
    @ApiMethod(name = "listGarden")
    public CollectionResponse<Garden> listGarden() throws URISyntaxException {
        List<Garden> gardens = new GardenReader().extractInfos();

        return CollectionResponse.<Garden> builder().setItems(gardens).build();
    }
}
