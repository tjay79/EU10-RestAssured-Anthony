package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SpartanGetRequests {

    String baseUrl = "http://52.91.121.140:8000";

    //Given Accept type application/json
    //When user send GET request to api/spartans end point
    //Then status code should be 200
    //Then response Content Type must be application/json
    //And response body should include spartan result

    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl+"/api/spartans");

        //printing status code from response object
        System.out.println(response.statusCode());

        //printing response content type from response object
        System.out.println(response.contentType());

        //print whole response body
        response.prettyPrint();

        //how to do API testing then?
        //verify status code is 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(),"application/json");


    }

    //Given accept is application/json
    //When user sends a get request to /api/spartans/3
    //Then status code should be 200
    //And content type should be application/json
    //And json body should contain Fidole

    @Test
    public void test2(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl+"/api/spartans/3");

        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.contentType(),"application/json");
        Assertions.assertTrue(response.prettyPrint().contains("Fidole"));

    }

    //Given no headers provided
    //When user send GET request to /api/hello
    //Then response code should be 200
    //And Content Type header should be "text/plain;charset=UTF-8"
    //And header should contain date
    //And Content-Length should be 17
    //And body should be "Hello from Sparta"

    @Test
    public void test3(){

        Response response = RestAssured.get(baseUrl+"/api/hello");

        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        //verify we have headers named date
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        //how to get the header from response using header key?

        Assertions.assertEquals("17",response.header("Content-Length"));

        Assertions.assertEquals("Hello from Sparta", response.body().asString());







    }
}
