package com.and1droid.ecohack.tool;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public abstract class KMLReader<Data> {

    public List<Data> extractInfos() throws URISyntaxException {
        final File file = FileHelper.getResource(getFileName());
        final Kml kml = Kml.unmarshal(file);
        return findDatas(kml.getFeature());
    }

    protected List<Data> findDatas(Feature feature) {
        List<Data> datas = new ArrayList<Data>();
        if (feature instanceof Document) {
            for (Feature f : ((Document) feature).getFeature()) {
                datas.addAll(findDatas(f));
            }
        }
        if (feature instanceof Folder) {
            for (Feature f : ((Folder) feature).getFeature()) {
                datas.addAll(findDatas(f));
            }
        }
        if (feature instanceof Placemark) {
            try {
                datas.add(convertToData((Placemark) feature));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return datas;
    }
    
    protected abstract Data convertToData(Placemark feature);

    protected abstract String getFileName();

}
