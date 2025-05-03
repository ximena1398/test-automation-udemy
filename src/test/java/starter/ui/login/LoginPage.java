package starter.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target INPUT_USERNAME = Target.the("username input").located(By.id("username"));
    public static Target INPUT_PASSWORD = Target.the("username password").located(By.id("password"));
    public static Target BUTTON_LOGIN = Target.the("login botton").located(By.xpath("//button[@type='submit']"));
}
