package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import starter.tasks.registration.CheckNewAccountCreate;
import starter.tasks.registration.DoNotSendAllRequiredInformation;
import starter.tasks.registration.RegisterUser;
import starter.tasks.registration.ShouldSeeAllFieldsAreRequired;
import starter.ui.registration.RegisterPage;

import java.net.URISyntaxException;
import java.util.List;

public class RegistrationStepDefinitions {
    String expectedName = "";
    String expectedLastName = "";
    String expectedAge = "";
    String expectedCountry = "";
    String expectedEmail = "";

    @Given("{actor} wants to sign up in the application")
    public void wantsToSignUpInTheApplication(Actor actor){

        actor.attemptsTo(
                Open.browserOn(new RegisterPage())
        );
    }

    @When("{actor} sends the require information to sign up" )
    public void sendsRequireInformationToSignUp(Actor actor, DataTable userInfo) throws URISyntaxException{
        List<List<String>> rows = userInfo.asLists(String.class);
        for(List<String> columns: rows){
            expectedName = columns.get(0);
            expectedLastName = columns.get(1);
            expectedAge = columns.get(2);
            expectedCountry = columns.get(3);
            expectedEmail = columns.get(4);
        }
        actor.attemptsTo(
                new RegisterUser(expectedName, expectedLastName, expectedAge, expectedCountry, expectedEmail)
        );
    }

    @Then("{actor} should have a new account created")
    public void shouldHaveAnewAccountCreated(Actor actor){
        actor.attemptsTo(
                new CheckNewAccountCreate(expectedName, expectedLastName, expectedAge)
        );
    }

    @When("{actor} does not send the required information")
    public void doesNotSendTheRequiredInformation(Actor actor){
        actor.attemptsTo(
                new DoNotSendAllRequiredInformation(expectedName, expectedLastName)
        );
    }

    @Then("{actor} should be told all fields are required")
    public void shouldBeToldAllFieldsAreRequired(Actor actor){
        actor.attemptsTo(
                new ShouldSeeAllFieldsAreRequired()
        );
    }
}
