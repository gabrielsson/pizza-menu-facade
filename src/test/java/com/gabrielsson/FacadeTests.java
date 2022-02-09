package com.gabrielsson;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class FacadeTests {

    @Test
    public void testIngredients() {
        given()
                .when()
                .get("/ingredients")
                .then()
                .assertThat()
                .statusCode(200)
                .body("size", is(15))
                .body("[0]", is("Pepperoni"));
    }
}