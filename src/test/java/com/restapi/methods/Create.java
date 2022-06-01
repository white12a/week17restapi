package com.restapi.methods;

import com.restapi.pojo.EmployeePojo;
import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Create extends TestBase {
    @Test
    public void createData() {
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployee_name("bhave");
        employeePojo.setEmployee_salary("6745");
        employeePojo.setEmployee_age("45");

        Response response = given()
                .body(employeePojo)
                .when()
                .post("api/v1/create");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
