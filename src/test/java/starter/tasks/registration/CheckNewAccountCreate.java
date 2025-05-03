package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.ui.registration.SummaryPage;

public class CheckNewAccountCreate implements Task {

    private final String expectedName;
    private final String expectedLastName;
    private final String expectedAge;

    public CheckNewAccountCreate(String expectedName, String expectedLastName, String expectedAge){
        this.expectedName = expectedName;
        this.expectedLastName = expectedLastName;
        this.expectedAge = expectedAge;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toWindowTitled("Summary"),
                Ensure.that(SummaryPage.LABEL_NAME)
                        .text().containsIgnoringCase(expectedName),
                Ensure.that(SummaryPage.LABEL_LAST_NAME)
                        .text().containsIgnoringCase(expectedLastName),
                Ensure.that(SummaryPage.LABEL_AGE)
                        .text().containsIgnoringCase(expectedAge)
        );
    }
}
