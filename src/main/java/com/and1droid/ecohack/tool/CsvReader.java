package com.and1droid.ecohack.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class CsvReader<Data> {

    public List<Data> extractDatas() {
        List<Data> datas = new ArrayList<Data>();
        try {
            final File file = FileHelper.getResource(getFileName());
            List<String> lines = CsvFileHelper.readFile(file);
            boolean columIgnored = false;
            for (String line : lines) {
                if (columIgnored) {
                    datas.add(createData(line));
                } else {
                    columIgnored = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    protected abstract Data createData(String line);

    protected abstract String getFileName();

    

}
