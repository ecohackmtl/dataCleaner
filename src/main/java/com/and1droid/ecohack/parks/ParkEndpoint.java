package com.and1droid.ecohack.parks;

import com.and1droid.ecohack.tool.shapefile.ShapeFileEndPointHelper;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "parkendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = "ecohack"), description = "Liste des grands parcs")
public class ParkEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    @ApiMethod(name = "listPark")
    public CollectionResponse<Park> listPark() {
        return new ShapeFileEndPointHelper<Park>().listDatas(new ParkShapeFileReader(), 27, Park.class, "parkID");
    }

}
