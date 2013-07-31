package com.and1droid.ecohack.bike.track;

import java.net.URISyntaxException;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "biketrackendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = ""), description = "Liste des pistes cyclables")
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
