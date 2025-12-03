package co.edu.udea.certificacion.innosistemas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class InnosistemasLoginPage extends PageObject {

    public static final Target EMAIL_FIELD = Target.the("Email field")
            .locatedBy("#email");

    public static final Target PASSWORD_FIELD = Target.the("Password field")
            .locatedBy("#password");

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("//button[@type='submit' and contains(., 'Iniciar Sesión')]");
}
