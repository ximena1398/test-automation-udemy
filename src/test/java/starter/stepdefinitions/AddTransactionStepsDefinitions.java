package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.models.LoginModel;
import starter.models.TransactionModel;
import starter.tasks.addtransaction.AddTransaction;
import starter.tasks.addtransaction.CheckNewTransactionWasAdded;
import starter.tasks.login.Login;
import starter.tasks.navigation.Navigate;
import starter.util.GetInfoFromTable;

import java.util.List;

public class AddTransactionStepsDefinitions {

    @Given("{actor} is logged into the application")
    public void isLoggedIntoTheApplication(Actor actor, DataTable userLogin){
        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);

        actor.attemptsTo(
                Navigate.loginPage(),
                new Login(loginModel.getUsername(), loginModel.getPassword())
        );
    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor, DataTable transactionInfo){
        TransactionModel transactionModel = GetInfoFromTable.getTransactionData(transactionInfo);

        actor.attemptsTo(
                AddTransaction.withInfo(transactionModel.getDate(), transactionModel.getAmount(), transactionModel.getDescription())
        );
    }

    @Then("{actor} should see a new transaction in the transaction list whit correct details")
    public void shouldSeeANewTransaction(Actor actor, DataTable newTransactionInfo){
        List<List<String>> rows = newTransactionInfo.asLists(String.class);
        String registeredAmount = "";
        String registeredDescription = "";

        for (List<String> columns: rows){
            registeredAmount = columns.get(0);
            registeredDescription = columns.get(1);
        }

        actor.attemptsTo(
                new CheckNewTransactionWasAdded(registeredAmount, registeredDescription)
        );
    }
}
