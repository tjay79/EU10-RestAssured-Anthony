package com.cybertek.day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetTest {

    @BeforeAll
    public static void init(){

        baseURI = "http://52.91.121.140:8000";


    }

    /*
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code should be 406
    And response content type should be application/xml;charset=UTF-8
     */
    @Test
    public void test1(){

        Response response = given().accept(ContentType.XML).when().get("/api/spartans/10");

        assertEquals(406,response.statusCode());
        assertEquals("application/xml;charset=UTF-8", response.contentType());






    }
}
