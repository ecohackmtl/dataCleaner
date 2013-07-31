package com.and1droid.ecohack.ilot.chaleur;

import com.and1droid.ecohack.ilot.Ilot;
import com.and1droid.ecohack.ilot.IlotShapeFileReader;
import com.and1droid.ecohack.tool.shapefile.ShapeFileEndPointHelper;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

@Api(name = "ilotChaleurendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = ""), description = "Liste des ilots de chaleur")
public class IlotChaleurEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    @ApiMethod(name = "listIlotsChaleurs")
    public CollectionResponse<Ilot> listIlotsChaleurs() {
        return new ShapeFileEndPointHelper().listDatas(new IlotShapeFileReader(), 3, Ilot.class, "ilotId");
    }

    @ApiMethod(name = "clearIlotsChaleurs")
    public void clearIlotsChaleurs() {
        new ShapeFileEndPointHelper().clear(Ilot.class);
    }
    
}
