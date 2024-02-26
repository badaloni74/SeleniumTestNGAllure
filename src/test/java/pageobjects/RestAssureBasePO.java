package pageobjects;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static auxiliars.constants.URL_APPDOMAIN;
import static auxiliars.constants.URL_HEROKU;

public class RestAssureBasePO {

    public static void setupRestAssuredHeroku() {
        RestAssured.baseURI = URL_HEROKU;
        RestAssured.basePath = "/api";
        RequestSpecification requestSpecification = new RequestSpecBuilder().
                addHeader("Content-Type", ContentType.JSON.toString()).
                addHeader("Accept", ContentType.JSON.toString()).
                build();
        RestAssured.requestSpecification = requestSpecification;
    }

    public static void setupRestAssuredAppdomain() {
        RestAssured.baseURI = URL_APPDOMAIN;
        RestAssured.basePath = "/123/api";
        RequestSpecification requestSpecification = new RequestSpecBuilder().
                addHeader("Content-Type", ContentType.JSON.toString()).
                addHeader("Accept", ContentType.JSON.toString()).
                build();
        RestAssured.requestSpecification = requestSpecification;
    }

}
