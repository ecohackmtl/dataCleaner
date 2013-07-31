package com.and1droid.ecohack.freesnowparking;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "freesnowparkingendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = ""))
public class FreeSnowParkingEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    @ApiMethod(name = "listFreeSnowParking")
    public CollectionResponse<FreeSnowParking> listFreeSnowParking() {
        return CollectionResponse.<FreeSnowParking> builder().setItems(new FreeSnowParkingReader().extractDatas()).build();
    }
}
