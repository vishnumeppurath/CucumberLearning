package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class EmployeeStepDefs {
    private Response response;
    @Given("My application is up and running")
    public void myApplicationIsUpAndRunning(DataTable dataTable) {
       // List<List<String>> tableList=dataTable.asList(String.class);
        List<Map<String,String>> tableMapList=dataTable.asMaps(String.class,String.class);
    }

    @When("I request for list of employees")
    public void iRequestForListOfEmployees() {
        response= RestAssured.given().baseUri("http://dummy.restapiexample.com").when().get("/api/v1/employees");
    }

    @Then("I should get a {int} response")
    public void iShouldGetAResponse(int responseCode) {
        Assert.assertEquals(responseCode,response.statusCode());

    }

    @And("The response should include employee id field")
    public void theResponseShouldIncludeEmployeeIdField() {
    }

    @And("The response should include employee name field")
    public void theResponseShouldIncludeEmployeeNameField() {
    }

    @And("The response should include employee salary field")
    public void theResponseShouldIncludeEmployeeSalaryField() {

    }

    @And("The response/result should include {string} field")
    public void theResponseShouldIncludeField(String expected) {
        Assert.assertTrue(response.getBody().asString().contains(expected));
    }
}
