package br.com.wfincatti.userapi.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class StepDefinitions {

    private ValidatableResponse response;
    private Integer id;

    @Before
    public void setup() {
        RestAssured.port = 8081;
        RestAssured.basePath = "/api/v1/user";
    }

    @Given("^I have id user$")
    public void getId() {
        id = 1;
    }

    @When("^I make a request$")
    public void request() {
        response = given()
                .pathParam("id", this.id)
                .when()
                .get("/{id}")
                .then();
    }

    @Then("^valid the status code$")
    public void statusCode() {
        response
                .statusCode(200);
    }
}
