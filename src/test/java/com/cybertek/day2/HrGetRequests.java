package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetRequests {

    //BeforeAll is an annotation equals to @BeforeClass in Testng, we use with static method name
    @BeforeAll
    public static void init(){

        RestAssured.baseURI = "http://52.91.121.140:1000/ords/hr";


    }

    @DisplayName("Get request to /regions")
    @Test
    public void test1(){

        Response response = RestAssured.get("/regions");

        System.out.println(response.statusCode());
    }

    /*
    Given accept type is application/json
    When user sends get request to /regions/2
    Then response status code should be 200
    And content type should be application/json
    And response body should contain Americas
     */

    @Test
    public void test2(){

        Response response = RestAssured.given().accept(ContentType.JSON).
                when().
                get("/regions/2");

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/json",response.contentType());
        Assertions.assertTrue(response.body().asString().contains("Americas"));




    }



}
