package starter.tasks.addtransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.questions.GetTransactionsInfo;
import starter.ui.addtransaction.AddTransactionPage;

public class CheckNewTransactionWasAdded implements Task {
    private final String registeredAmount;
    private final String registeredDescription;

    public CheckNewTransactionWasAdded(String registeredDate, String registeredDescription){
        this.registeredAmount = registeredDate;
        this.registeredDescription = registeredDescription;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(GetTransactionsInfo.getDescription()).contains(registeredAmount),
                Ensure.that(AddTransactionPage.TRANSACTIONS_TABLE).text().contains(registeredDescription)
        );
    }
}
