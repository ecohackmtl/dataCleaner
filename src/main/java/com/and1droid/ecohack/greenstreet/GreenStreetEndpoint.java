package com.and1droid.ecohack.greenstreet;

import java.net.URISyntaxException;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "greenstreetendpoint", namespace = @ApiNamespace(ownerDomain = "vdfvdfvdfvdfvdfvdf.com", ownerName = "vdfvdfvdfvdfvdfvdf.com", packagePath = ""))
public class GreenStreetEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     * @throws URISyntaxException 
     */
    @ApiMethod(name = "listGreenStreet")
    public CollectionResponse<GreenStreet> listGreenStreet() throws URISyntaxException {
        List<GreenStreet> streets = new GreenStreetReader().extractInfos();
        return CollectionResponse.<GreenStreet> builder().setItems(streets).build();
    }
}
