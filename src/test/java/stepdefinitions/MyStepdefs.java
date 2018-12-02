package stepdefinitions;

import cucumber.api.java8.En;

public class MyStepdefs implements En {
    public MyStepdefs() {
        Given("^System is active$", () -> {
            System.out.println("Given");
        });
        When("^Action is performed$", () -> {
            System.out.println("When");
        });
        Then("^Result is as expected$", () -> {
            System.out.println("Then");
        });
    }
}
