package com.wiley.ranku;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.gauge.BeforeSuite;
import com.wiley.ranku.datamodel.TestData;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;

public class APIBase {
    public Headers header;
    public JSONObject json;

    protected static TestData testData;

    @BeforeSuite
    public void initializeDriver() throws InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        try {
            testData = mapper.readValue(getClassLoader().getResourceAsStream(System.getenv("test")+".json"), TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getEnv(){
        String env=System.getenv("");
    }

    public void setHeaders(){
        Header h1 = new Header("Content-Type","application/json");
        Header h2 = new Header("x-api-key","102a4fec2007388288ae37c9882c3604");
        List<Header> list = new ArrayList<Header>();
        list.add(h1);
        list.add(h2);

        header = new Headers(list);
    }

    public void setResponseBody(HashMap<String, String> dataset){

        json=new JSONObject();
        System.out.println(dataset.get("program_id"));

        for(HashMap.Entry<String, String> entry : dataset.entrySet()){
            json.put(entry.getKey(),entry.getValue());
        }


//        json=new JSONObject();
//        json.put("site","msu");
//        json.put("program_id","1578571507889");
//        json.put("email","testD3@test.com");
//        json.put("zipcode","56211");
//        json.put("originCountry","US");
//        json.put("educationLevel","high_school_diploma");
//        json.put("first_name","Test");
//        json.put("last_name","TestD");
//        json.put("inquiryTopic","admission_requirements");
//        json.put("message","none");
//        json.put("interestedInApplying","false");
//        json.put("fromRecommendation","false");
//        json.put("phone","2342342345");

    }
}
