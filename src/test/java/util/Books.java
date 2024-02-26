package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.RestAssureBasePO;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Books extends RestAssureBasePO {

   private Response response;

    @Test
    void getBooksList(){
        RestAssureBasePO.setupRestAssuredHeroku();
        response = RestAssured.get("/books");
        ArrayList<String> allBooks = response.jsonPath().get("data");
        Assert.assertTrue(allBooks.size()>1, "No books returned");
    }

    @Test
    void getAccountsList(){
        RestAssureBasePO.setupRestAssuredAppdomain();
        response = RestAssured.get("/123/accounts");
        ArrayList<String> allBooks = response.jsonPath().get("data");
        Assert.assertTrue(allBooks.size()>1, "No books returned");
    }


    @Test
    void createAndDeleteBook() throws URISyntaxException, MalformedURLException {
        String responseId;
        RestAssureBasePO.setupRestAssuredHeroku();
        File bookFile = new File("C:\\Coses\\Selenium\\SeleniumTestNGAllure\\src\\test\\resources\\books.json");
        //Create
        response = given()
            .body(bookFile.toURI())
            .when()
            .post("/books");

        responseId = response.jsonPath().getString("post.book_id");
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertTrue(responseId.length()>0);
    }



}
