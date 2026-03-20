package com.cyberguard.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("http://localhost:4200/autenticacion")
public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".alert-error")
    private WebElement errorMessage;

    public void abrirPaginaDeLogin() {
        open();
        waitForLoginFormVisible();
    }

    public void ingresarCredenciales(String usuario, String contrasena) {
        usernameInput.clear();
        usernameInput.sendKeys(usuario);
        passwordInput.clear();
        passwordInput.sendKeys(contrasena);
        submitButton.click();
    }

    public boolean estaVisibleMensajeDeError() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerTextoDeError() {
        return errorMessage.getText();
    }

    public boolean estaEnPaginaDeLogin() {
        return getDriver().getCurrentUrl().contains("autenticacion");
    }

    private void waitForLoginFormVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
    }
}
