package by.itacademy.zalmanova.olga.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    Post post;

    @Test
    public void testPOSTWithEmptyData() {
        post = new Post();
        given().header("Content-Type", "application/json").body(post.generateBody("", "")).
                when().post(post.endpoint).then().assertThat().statusCode(400).body("title", equalTo("One or more validation errors occurred."));
    }

    @Test
    public void testPostWithIncorrectData() {
        post = new Post();
        given().header("Content-Type", "application/json").body(post.generateBody("user", "password")).
                when().post(post.endpoint).then().
                assertThat().statusCode(401).assertThat().body("errorMessage", equalTo("User wrong password"));
    }
}

