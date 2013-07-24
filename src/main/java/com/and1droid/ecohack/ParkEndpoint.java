package com.and1droid.ecohack;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.gson.Gson;

@Api(name = "parkendpoint", namespace = @ApiNamespace(ownerDomain = "and1droid.com", ownerName = "and1droid.com", packagePath = "ecohack"))
public class ParkEndpoint {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    @ApiMethod(name = "listPark")
    public CollectionResponse<Park> listPark() {
        List<Park> parks = new ArrayList<Park>();
        EntityManager mgr = null;
        try {
            mgr = getEntityManager();
            Query query = mgr.createQuery("select from Park as Park");
            parks = (List<Park>) query.getResultList();
            for (Park park : parks)
                ;
            if (parks.isEmpty() || parks.size() < 27) {
                System.out.println("Il manque de parcs (" + parks.size() + "/27)");
                parks = ParkShapeFileReader.extractParks();
                for (Park park : parks) {
                    if (!containsPark(park)) {
                        System.out.println(park.getName() + " est absent. Traitement de ses coordonnées");
                        try {
                            mgr.getTransaction().begin();
                            park.setBoundaries(CoordinateConverter.convert(park.getPoints()));
                            mgr.persist(park);
                            mgr.getTransaction().commit();
                            System.out.println(park.getName() + " persisté");
                        } catch (Exception e) {
                            System.out.println(e);
                            mgr.getTransaction().rollback();
                        }
                    } else {
                        System.out.println(park.getName() + " est déjà présent");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            mgr.close();
        }
        return CollectionResponse.<Park> builder().setItems(parks).build();
    }

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    @ApiMethod(name = "clearPark")
    public void clearPark() {
        List<Park> parks = new ArrayList<Park>();
        EntityManager mgr = null;
        try {
            mgr = getEntityManager();
            Query query = mgr.createQuery("select from Park as Park");
            parks = (List<Park>) query.getResultList();
            for (Park park : parks)
                mgr.remove(park);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            mgr.close();
        }
    }

    private boolean containsPark(Park park) {
        EntityManager mgr = getEntityManager();
        boolean contains = true;
        try {
            Park item = mgr.find(Park.class, park.getParkID());
            if (item == null) {
                contains = false;
            }
        } finally {
            mgr.close();
        }
        return contains;
    }

    private static EntityManager getEntityManager() {
        return EMF.get().createEntityManager();
    }
}
