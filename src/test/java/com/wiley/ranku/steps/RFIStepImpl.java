package com.wiley.ranku.steps;


import com.thoughtworks.gauge.Step;
import com.wiley.ranku.APIBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RFIStepImpl extends APIBase {

    String rfiURL = "https://ranku-api-dev.herokuapp.com/inquiry/submit";

    Response response;
    RequestSpecification request;

    HashMap<String, String> dataset;


    @Step("Submit Requests for Information for <MSU>")
    public void implementation1(String testcaseID) {

        dataset = testData.getDataSet(testcaseID);

        setHeaders();
        setResponseBody(dataset);

        request = RestAssured.given();
        request.headers(header);
        request.body(json.toJSONString());

        response = request.put(rfiURL);

        System.out.println("Status : " + response.getStatusCode());
        System.out.println("ID : " + response.jsonPath().get("id"));
    }
}
