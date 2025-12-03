package co.edu.udea.certificacion.innosistemas.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import co.edu.udea.certificacion.innosistemas.interactions.Wait;
import co.edu.udea.certificacion.innosistemas.questions.ErrorMessage;
import co.edu.udea.certificacion.innosistemas.questions.TheCurrentUrl;
import co.edu.udea.certificacion.innosistemas.tasks.LoginAsAdmin;
import co.edu.udea.certificacion.innosistemas.tasks.LoginAsProfessor;
import co.edu.udea.certificacion.innosistemas.tasks.LoginToInnosistemas;
import co.edu.udea.certificacion.innosistemas.tasks.LoginWithInvalidCredentials;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class Login_innosistemasStepDefinition {

    @Managed
    public WebDriver driver;

    private Actor user;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("user");
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("I am on the login page of Innosistemas")
    public void iAmOnTheLoginPageOfInnosistemas() {
        user.wasAbleTo(Open.url("https://frontend-innosistemas-sprint2.vercel.app/auth/login"));
    }

    @When("I enter my student credentials")
    public void iEnterMyStudentCredentials() {
        user.attemptsTo(LoginToInnosistemas.withCredentials());
    }

    @When("I enter my professor credentials")
    public void iEnterMyProfessorCredentials() {
        user.attemptsTo(LoginAsProfessor.withCredentials());
    }

    @When("I enter my administrator credentials")
    public void iEnterMyAdministratorCredentials() {
        user.attemptsTo(LoginAsAdmin.withCredentials());
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        user.attemptsTo(LoginWithInvalidCredentials.attempt());
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        user.attemptsTo(Wait.forSeconds(5));
        user.should(seeThat(TheCurrentUrl.is(), containsString("/dashboard")));
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        user.attemptsTo(Wait.forSeconds(2));
        user.should(seeThat(ErrorMessage.is(), containsString("incorrectos")));
    }
}
