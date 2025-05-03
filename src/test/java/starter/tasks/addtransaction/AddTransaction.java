package starter.tasks.addtransaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.addtransaction.AddTransactionPage;

public class AddTransaction {
    public static Performable withInfo(String date, String amount, String description){
        return Task.where("{0} adds a new transaction",
                Click.on(AddTransactionPage.BUTTON_ADD_TRANSACTION),
                Enter.theValue(date).into(AddTransactionPage.INPUT_DATE),
                Enter.theValue(amount).into(AddTransactionPage.INPUT_AMOUNT),
                Enter.theValue(description).into(AddTransactionPage.INPUT_DESCRIPTION),
                Click.on(AddTransactionPage.BUTTON_SAVE)
                );
    }
}
