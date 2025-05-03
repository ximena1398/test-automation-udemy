package starter.ui.addtransaction;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddTransactionPage {
    public static Target BUTTON_ADD_TRANSACTION = Target.the("Add transaction button").locatedBy("//button[@data-target='#transactionModal']");
    public static Target INPUT_DATE = Target.the("Date input").located(By.id("date"));
    public static Target INPUT_AMOUNT = Target.the("Amount input").located(By.id("amount"));
    public static Target INPUT_DESCRIPTION = Target.the("Description input").located(By.id("description"));
    public static Target BUTTON_SAVE = Target.the("Save button").locatedBy("//button[contains(text(),'Guardar')]");

    public static Target TRANSACTIONS_TABLE = Target.the("Descripction Label").locatedBy("//tbody[@id='transactions-list']");
    public static String TRANSACTIONS_TABLE_XPATH = "//tbody[@id='transactions-list']";
}
