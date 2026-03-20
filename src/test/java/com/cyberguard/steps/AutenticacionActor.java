package com.cyberguard.steps;

import com.cyberguard.ui.pages.DashboardPage;
import com.cyberguard.ui.pages.LoginPage;
import net.serenitybdd.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class AutenticacionActor {

    @Steps
    private LoginPage loginPage;

    @Steps
    private DashboardPage dashboardPage;

    public void abreLaPaginaDeLogin() {
        loginPage.abrirPaginaDeLogin();
    }

    public void iniciaSesionCon(String usuario, String contrasena) {
        loginPage.ingresarCredenciales(usuario, contrasena);
    }

    public void validaDashboardVisible() {
        assertThat(dashboardPage.esDashboardVisible())
                .as("El dashboard debe ser visible tras autenticación exitosa")
                .isTrue();
    }

    public void validaSinErroresDeAutenticacion() {
        assertThat(loginPage.estaVisibleMensajeDeError())
                .as("No debe haber mensaje de error en login exitoso")
                .isFalse();
    }

    public void validaErrorDeAutenticacionVisible() {
        assertThat(loginPage.estaVisibleMensajeDeError())
                .as("Debe mostrarse mensaje de error por credenciales inválidas")
                .isTrue();
    }

    public void validaPermaneceEnLogin() {
        assertThat(loginPage.estaEnPaginaDeLogin())
                .as("El usuario debe permanecer en la página de login")
                .isTrue();
    }
}