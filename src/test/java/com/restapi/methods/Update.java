package com.restapi.methods;

import com.restapi.pojo.EmployeePojo;
import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Update extends TestBase {
    @Test
    public void updateEmployee() {


        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployee_name("man");

        Response response= given()
                .body(employeePojo)
                .when()
                .put("api/v1/update/2178");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
