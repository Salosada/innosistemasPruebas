package co.edu.udea.certificacion.innosistemas.tasks;

import static co.edu.udea.certificacion.innosistemas.userinterfaces.InnosistemasLoginPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginAsAdmin implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("juan@gmail.com").into(EMAIL_FIELD),
                Enter.theValue("12345").into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static LoginAsAdmin withCredentials() {
        return Tasks.instrumented(LoginAsAdmin.class);
    }
}
