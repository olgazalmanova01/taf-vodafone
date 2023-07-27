package by.itacademy.zalmanova.olga.api;

import by.itacademy.zalmanova.olga.util.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {
    Util util;
    Post post;

    @BeforeEach
    public void warmUp() {
        util = new Util();
        post = new Post();
    }

    @Test
    public void submitLoginFormWithIncorrectData() {
        String response = given().formParams(post.getFormParamsWithIncorrectData()).when().post(post.endpoint).then().assertThat()
                .statusCode(200).extract().asString();
        Document document = Jsoup.parse(response);
        String actual = document.getElementsByTag("").text();
        Assertions.assertEquals(post.errorMessage, actual);
    }

    @Test
    public void searchForValidData() {
        String response = given().queryParams(post.getQueryParams("")).when().
                get(post.searchEndpoint).then().assertThat().statusCode(200).extract().body().asString();
        Document document = Jsoup.parse(response);
        String actual = document.select("").select("").get(2).attr("value").toString();
        Assertions.assertEquals("", actual);
    }

    @Test
    public void searchForInvalidData() {
        String response = given().queryParams(post.getQueryParams("")).when().
                get(post.searchEndpoint).then().assertThat().statusCode(200).extract().body().asString();
        Document document = Jsoup.parse(response);
        String actual = document.select("").text();
        Assertions.assertEquals("", actual);
    }
}
