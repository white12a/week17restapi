package com.restapi.methods;

import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get extends TestBase {
  @Test
  public void getEmployees(){
      Response response=given()
              .when()
              .get("api/v1/employees");
      response.prettyPrint();
      response.then().statusCode(200);
  }
}
