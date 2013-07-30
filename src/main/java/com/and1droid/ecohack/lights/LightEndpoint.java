package com.and1droid.ecohack.lights;

import java.net.URISyntaxException;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "lightsendpoint", namespace = @ApiNamespace(ownerDomain = "ecohack.com", ownerName = "ecohack.com", packagePath = ""))
public class LightEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     * @throws URISyntaxException 
     */
    @ApiMethod(name = "listLights")
    public CollectionResponse<Light> listLights() throws URISyntaxException {
        List<Light> lights = new LightKmlReader().extractInfos();
        return CollectionResponse.<Light> builder().setItems(lights).build();
    }
}
