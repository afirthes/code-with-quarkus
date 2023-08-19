package org.acme;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.*;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BookResourceTest {
    @Test
    public void shouldCountAllBooks() {
        given()
        .when()
                .get("/api/books/count")
        .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("4"));
    }

    @Test
    public void shouldGetABook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
        .when()
                .get("/api/books/book/{id}")
        .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("title", is("Understanding Quarkus"));
    }
}
