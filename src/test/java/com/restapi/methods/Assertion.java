package com.restapi.methods;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Assertion  {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        //RestAssured.port= ;
        response = given()
                .when()
                .get("api/v1/employees")
                .then().statusCode(200);
    }

    // 1. total records are 24
    @Test
    public void getTotalRecords() {
        List<Integer> total = response.extract().path("data");
        System.out.println("Total records are 24 = " + total);
        org.junit.Assert.assertEquals("number", 24, total);
    }

    //2. data[23].id = 24
    @Test
    public void getId() {
        int id = response.extract().path("data[23].id");
        System.out.println("data[23].id 24 =" + id);
        org.junit.Assert.assertEquals("id number", 24, id);
    }

    //3. data[23].employee_name = “Doris Wilder”
    @Test
    public void employeeDorisWilder() {
        String employeeName = response.extract().path("data[23].employee_name");
        System.out.println("data[23].employee_name  “Doris Wilder” =" + employeeName);
        org.junit.Assert.assertEquals("Name is ", "Doris Wilder", employeeName);
    }
    //4. message = “Successfully! All records has been
    //fetched.”
    @Test
    public void getMessage(){
        String message =response.extract().path("message");
        System.out.println("Successfully! All records has been fetched.” =" + message);
        org.junit.Assert.assertEquals("Message not found ","Successfully! All records has been fetched.",message);
    }
    //5.status = success
    @Test
    public void getStatus(){
        String success =response.extract().path("status");
        System.out.println("Status =" +success);
        org.junit.Assert.assertEquals("not success","success",success);
    }
    //6. id = 3 has employee_salary = 86000
    @Test
    public void getEmployeesSalary(){
        int salary =response.extract().path("data[2].employee_salary");
        System.out.println("id = 3 has employee_salary 86000 =" +salary);
        org.junit.Assert.assertEquals("salary is not",86000,salary);
    }
    //7. id = 6 has employee_age = 61
    @Test
    public void getEmployeeAge(){
        int age =response.extract().path("data[5].employee_age");
        System.out.println("id = 6 has employee_age 61 =" + age);
        org.junit.Assert.assertEquals("Age is ",61,age);
    }
    //8. id = 11 has employee_name = Jena Gaines
    @Test
    public void getName(){
        String name =response.extract().path("data[10].employee_name");
        System.out.println("id = 11 has employee_name Jena Gaines =" + name);
        org.junit.Assert.assertEquals("name is ","Jena Gaines",name);
    }

}
