package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestData {

    @JsonProperty("TestDataSets")
    private ArrayList<HashMap<String,String>>  dataSets;


    public HashMap<String,String> getDataSet(String id){

        HashMap<String,String> dataSet= null;
        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
        for (HashMap<String,String> ds: dataSets){
            if (ds.get("testcaseID").equalsIgnoreCase(id)) {
                dataSet =  ds;
                break;
            }
        }
        return dataSet;
    }


}
