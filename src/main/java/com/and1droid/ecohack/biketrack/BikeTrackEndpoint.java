package com.and1droid.ecohack.biketrack;

import java.net.URISyntaxException;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "biketrackendpoint", namespace = @ApiNamespace(ownerDomain = "ecohack.com", ownerName = "ecohack.com", packagePath = ""))
public class BikeTrackEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     * @throws URISyntaxException 
     */
    @ApiMethod(name = "listBikeTracks")
    public CollectionResponse<BikeTrack> listbikesTracks() throws URISyntaxException {
        List<BikeTrack> lights = new BikeTrackKmlReader().extractInfos();
        return CollectionResponse.<BikeTrack> builder().setItems(lights).build();
    }
}
