package com.restapi.methods;

import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetId extends TestBase {

    @Test
    public void getEmployeesId(){
        Response response= given()
                .when()
                .get("api/v1/employee/2");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
