package com.and1droid.ecohack.tool.shapefile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.and1droid.ecohack.EMF;
import com.google.api.server.spi.response.CollectionResponse;

import diewald_shapeFile.files.shp.shapeTypes.ShpPolygon;

public class ShapeFileEndPointHelper<S> {

    /**
     * This method lists all the entities inserted in datastore. It uses HTTP GET method and paging support.
     * 
     * @param idField
     * 
     * @return A CollectionResponse class containing the list of all entities persisted and a cursor to the next page.
     */
    public CollectionResponse<S> listDatas(ShapeFileReader<ShpPolygon> shapeFileReader, int recordCount, Class<S> clazz, String idField) {
        List<S> datas = new ArrayList<S>();
        EntityManager mgr = null;
        try {
            mgr = getEntityManager();
            Query query = mgr.createQuery("select from " + clazz.getSimpleName() + " as " + clazz.getSimpleName());
            datas = (List<S>) query.getResultList();
            for (S data : datas)
                ;
            if (datas.isEmpty() || datas.size() < recordCount) {
                System.out.println("Il manque de datas (" + datas.size() + "/" + recordCount + ")");
                List<ShapeFileItem> items = shapeFileReader.extractDatas();
                mergeDatas(items, mgr, clazz, idField);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.close();
        }
        return CollectionResponse.<S> builder().setItems(datas).build();
    }

    private void mergeDatas(List<ShapeFileItem> datas, EntityManager mgr, Class<S> clazz, String idField) {
        for (ShapeFileItem data : datas) {
            if (!contains(data, clazz, idField)) {
                try {
                    mgr.getTransaction().begin();
                    System.out.println(data.getName() + " est absent. Traitement de ses coordonnées");
                    mgr.persist(DataFactory.createPersistable(clazz, data));
                    System.out.println(data.getName() + " persisté");
                    mgr.getTransaction().commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    mgr.getTransaction().rollback();
                }
            } else {
                System.out.println(data.getName() + " est déjà présent");
            }
        }
    }

    public void clear(Class<S> shapeFileItemClass) {
        List<S> datas = new ArrayList<S>();
        EntityManager mgr = null;
        try {
            mgr = getEntityManager();
            Query query = mgr.createQuery("select from " + shapeFileItemClass.getSimpleName() + " as " + shapeFileItemClass.getSimpleName());
            datas = (List<S>) query.getResultList();
            while (!datas.isEmpty()) {
                clearDatas(datas, mgr);
                query = mgr.createQuery("select from " + shapeFileItemClass.getSimpleName() + " as " + shapeFileItemClass.getSimpleName());
                datas = (List<S>) query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.close();
        }
    }

    private void clearDatas(List<S> datas, EntityManager mgr) {
        for (S data : datas) {
            try {
                mgr.getTransaction().begin();
                mgr.remove(data);
                mgr.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e);
                mgr.getTransaction().rollback();
            }
        }
    }


    private boolean contains(ShapeFileItem data, Class<S> clazz, String idField) {
        if (data.getId() == null) {
            return false;
        }
        EntityManager mgr = getEntityManager();
        try {
            Query query = mgr.createQuery("select from " + clazz.getSimpleName() + " as " + clazz.getSimpleName() + " where " + idField + "='" + data.getId()
                    + "'");
            return query.getResultList().size() != 0;
        } finally {
            mgr.close();
        }
    }

    private static EntityManager getEntityManager() {
        return EMF.get().createEntityManager();
    }
}
