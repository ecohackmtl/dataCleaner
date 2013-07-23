package com.and1droid.ecohack;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public abstract class KMLReader<Data> {

    public List<Data> extractInfos() throws URISyntaxException {
        List<Data> datas = new ArrayList<Data>();
        final File file = FileHelper.getResource(getFileName());
        final Kml kml = Kml.unmarshal(file);
        final Document document = (Document) kml.getFeature();
        for (Feature feature : document.getFeature()) {
            if (feature instanceof Placemark) {
                try {
                    datas.add(convertToData((Placemark) feature));
                } catch (ClassCastException cce) {
                }
            }
        }
        return datas;
    }

    protected abstract Data convertToData(Placemark feature);

    protected abstract String getFileName();

}
