package com.restapi.methods;

import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete extends TestBase {
    @Test
    public void delete() {
        Response response = given()
                .when()
                .delete("api/v1/delete/7");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
