package com.talent;


import com.talent.bind.BaseApiResponse;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class SWApiTestRA1 {

        @Test
        public void requestAResourcesThenLinkReturn(){

            BaseApiResponse baseApiResponse = RestAssured
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
                        .statusCode(is(equalTo(200)))
                        .and()
                        .body("films", response -> notNullValue())
                        .body("vehicles", response -> notNullValue())
                        .body("people", response -> notNullValue())
                        .body("starships", response -> notNullValue())
                        .body("species", response -> notNullValue())
                    .and().extract().body().as(BaseApiResponse.class);


            RestAssured
                    .given()
                    .queryParam("format", "json")
                    .log().all()
                    .when()
                    .post(baseApiResponse.getFilms())
                    .then()
                    .log().all()
                    .and()
                    .assertThat()
                    .statusCode(is(equalTo(405)));
        }

}
