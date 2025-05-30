package dev.mkomarov.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class JsonPlaceholderTest {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test(description = "[positive] Get existing post by its id (id=1)")
    public void getPostById() {
        RestAssured.given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(1))
                .body("userId", notNullValue())
                .body("title", notNullValue())
                .body("body", notNullValue());
    }

    @Test(description = "[positive] Get posts filtered by existing userId (id=1)")
    public void getPostByUserId() {
        RestAssured.given()
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", not(empty()))
                .body("userId", everyItem(equalTo(1)))
                .body("id", everyItem(notNullValue()))
                .body("title", everyItem(notNullValue()));
    }

    @Test(description = "[negative] Get single post by non-existing id (id=999999)")
    public void getNonExistentPostById() {
        RestAssured.given()
                .when()
                .get("/posts/999999")
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body("$", anEmptyMap());
    }

    @Test(description = "[negative] Get single post with invalid id format (id=abc)")
    public void getPostByInvalidId() {
        RestAssured.given()
                .when()
                .get("/posts/abc")
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body("$", anEmptyMap());
    }
}
