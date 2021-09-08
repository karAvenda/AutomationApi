package com.talent;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;


public class SWApiTestWithRestAssured {
    @Test
    public void requestAResourcesThenLinkReturn(){

        String body = RestAssured
                .given()
                .baseUri("https://swapi.dev/api" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "" +
                        "")
                .and()
                .queryParam("format", "json")
                .when()
                .get("/")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and()
                .body("films", response -> notNullValue())
                .body("vehicles", response -> notNullValue())
                .body("people", response -> notNullValue())
                .body("starships", response -> notNullValue())
                .body("species", response -> notNullValue())
                .and().extract().body().asString();

    }
}
