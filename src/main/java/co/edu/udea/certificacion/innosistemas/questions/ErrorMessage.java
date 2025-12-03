package co.edu.udea.certificacion.innosistemas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ErrorMessage implements Question<String> {

    public static final Target ERROR_MESSAGE_LABEL = Target.the("Error message label")
            .locatedBy("//p[contains(@class, 'text-red-700')]");

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ERROR_MESSAGE_LABEL).answeredBy(actor);
    }

    public static ErrorMessage is() {
        return new ErrorMessage();
    }
}
