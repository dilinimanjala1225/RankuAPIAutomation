package com.wiley.ranku.steps;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class ProgramSearchImpl {

    //String searchprogramURL  = "https://ranku-api-dev.herokuapp.com/programs/search/1000?n=health&clientIp=%3A%3Affff%3A10.0.2.2&socialProfile=%7B%7D&skip=0&site=msu";

    String searchprogramURL  = "https://ranku-api-dev.herokuapp.com/programs/search/1000";


    @Test
    public void findprogram(){

        Header h1 = new Header("Content-Type","application/json");
        Header h2 = new Header("x-api-key","102a4fec2007388288ae37c9882c3604");
        List<Header> list = new ArrayList<Header>();
        list.add(h1);
        list.add(h2);
        Headers header = new Headers(list);


        Response response = (Response) given()
                .headers(header)
                .param("n","health")
                .param("clientIp","%3A%3Affff%3A10.0.2.2")
                .param("socialProfile","%7B%7D")
                .param("skip",0)
                .param("site","msu")
                .get(searchprogramURL);


        System.out.println(response.getStatusCode());



    }
}
