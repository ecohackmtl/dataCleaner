package com.and1droid.ecohack.garden.commun;

import java.net.URISyntaxException;

import com.and1droid.ecohack.tool.shapefile.ShapeFileEndPointHelper;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "gardencommunendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = ""), description = "Liste des jardins communautaires")
public class GardenCommunEndpoint {
    
    @ApiMethod(name = "listGardenCommun")
    public CollectionResponse<CommunGarden> listGardenCommun() throws URISyntaxException {
        return new ShapeFileEndPointHelper<CommunGarden>().listDatas(new GardenCommunShapeFileReader(), 99, CommunGarden.class, "gardenId");
    }
}
