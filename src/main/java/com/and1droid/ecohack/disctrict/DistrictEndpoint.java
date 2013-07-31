package com.and1droid.ecohack.disctrict;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@Api(name = "districtendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = ""), description = "Liste des arrondissements")
public class DistrictEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     * @throws URISyntaxException 
     * @throws UnsupportedEncodingException 
     */
    @ApiMethod(name = "listDistricts")
    public CollectionResponse<District> listDistricts() throws URISyntaxException, UnsupportedEncodingException {
        List<District> districts = new ArrayList<District>();
        InputStream resourceAsStream = getClass().getResourceAsStream("/district/district.json");
        JsonReader jsonReader = new JsonReader(new InputStreamReader(resourceAsStream, "UTF-8"));
        JsonDistrict jsonDistrict = new Gson().fromJson(jsonReader, JsonDistrict.class);
        for (JsonFeature feature : jsonDistrict.getFeatures()) {
            districts.add(new District(feature.getName(), feature.getCoordinates()));
        }
        return CollectionResponse.<District> builder().setItems(districts).build();
    }
}
