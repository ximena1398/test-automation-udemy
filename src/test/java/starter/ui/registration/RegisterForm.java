package starter.ui.registration;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterForm {
    public static Target INPUT_NAME = Target.the("input name").locatedBy("//input[@id='name']");
    public static Target INPUT_LAST_NAME = Target.the("last name").locatedBy("//input[@id='last-name']");
    public static Target INPUT_AGE = Target.the("age").locatedBy("//input[@id='age']");
    public static Target SELECT_COUNTRY = Target.the("country").locatedBy("//select[@id='country']");
    public static Target SELECT_SEX = Target.the("sex").locatedBy("//input[@id='sex-f']");
    public static Target INPUT_EMAIL = Target.the("email").locatedBy("//input[@type='email']");
    public static Target SELECT_DAY = Target.the("day").locatedBy("//input[@id='monday']");
    public static Target INPUT_PICTURE = Target.the("picture").locatedBy("//input[@id='picture']");
    public static Target BUTTON_SAVE = Target.the("button save").locatedBy("//button[@id='save-btn']");
    public static Target ALERT_REQUIRED_FIELDS = Target.the("alert required field").locatedBy("//div[@role= 'alert']");
}