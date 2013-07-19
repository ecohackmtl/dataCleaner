package com.and1droid.ecohack;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "bikesupportendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = ""))
public class BikeSupportEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    @ApiMethod(name = "listBikeSupport")
    public CollectionResponse<BikeSupport> listBikeSupport() {
        return CollectionResponse.<BikeSupport> builder().setItems(BikeSupportReader.extractBikeSupport()).build();
    }
}
