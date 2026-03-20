package com.cyberguard.stepdefinitions;

import com.cyberguard.steps.AutenticacionActor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class AutenticacionSteps {

    @Steps
    private AutenticacionActor autenticacionActor;

    @Given("que el administrador abre la página de login")
    public void queElAdministradorAbreLaPaginaDeLogin() {
        autenticacionActor.abreLaPaginaDeLogin();
    }

    @When("inicia sesión con usuario {string} y contraseña {string}")
    public void iniciaSesionConUsuarioYContrasena(String usuario, String contrasena) {
        autenticacionActor.iniciaSesionCon(usuario, contrasena);
    }

    @Then("debe visualizar el dashboard de amenazas")
    public void debeVisualizarElDashboardDeAmenazas() {
        autenticacionActor.validaDashboardVisible();
    }

    @And("no debe visualizar mensajes de error de autenticación")
    public void noDebeVisualizarMensajesDeErrorDeAutenticacion() {
        autenticacionActor.validaSinErroresDeAutenticacion();
    }

    @Then("debe visualizar un mensaje de error de autenticación")
    public void debeVisualizarUnMensajeDeErrorDeAutenticacion() {
        autenticacionActor.validaErrorDeAutenticacionVisible();
    }

    @And("debe permanecer en la pantalla de login")
    public void debePermaneceEnLaPantallaDeLogin() {
        autenticacionActor.validaPermaneceEnLogin();
    }
}
