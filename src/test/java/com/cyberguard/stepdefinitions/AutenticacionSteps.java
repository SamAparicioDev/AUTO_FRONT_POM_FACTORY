package com.cyberguard.stepdefinitions;

import com.cyberguard.ui.pages.DashboardPage;
import com.cyberguard.ui.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class AutenticacionSteps {

    @Steps
    private LoginPage loginPage;

    @Steps
    private DashboardPage dashboardPage;

    @Given("que el administrador abre la página de login")
    public void queElAdministradorAbreLaPaginaDeLogin() {
        loginPage.abrirPaginaDeLogin();
    }

    @When("inicia sesión con usuario {string} y contraseña {string}")
    public void iniciaSesionConUsuarioYContrasena(String usuario, String contrasena) {
        loginPage.ingresarCredenciales(usuario, contrasena);
    }

    @Then("debe visualizar el dashboard de amenazas")
    public void debeVisualizarElDashboardDeAmenazas() {
        assertThat(dashboardPage.esDashboardVisible())
                .as("El dashboard debe ser visible tras autenticación exitosa")
                .isTrue();
    }

    @And("no debe visualizar mensajes de error de autenticación")
    public void noDebeVisualizarMensajesDeErrorDeAutenticacion() {
        assertThat(loginPage.estaVisibleMensajeDeError())
                .as("No debe haber mensaje de error en login exitoso")
                .isFalse();
    }

    @Then("debe visualizar un mensaje de error de autenticación")
    public void debeVisualizarUnMensajeDeErrorDeAutenticacion() {
        assertThat(loginPage.estaVisibleMensajeDeError())
                .as("Debe mostrarse mensaje de error por credenciales inválidas")
                .isTrue();
    }

    @And("debe permanecer en la pantalla de login")
    public void debePermaneceEnLaPantallaDeLogin() {
        assertThat(loginPage.estaEnPaginaDeLogin())
                .as("El usuario debe permanecer en la página de login")
                .isTrue();
    }
}
