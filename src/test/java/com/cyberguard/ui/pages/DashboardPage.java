package com.cyberguard.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends PageObject {

    @FindBy(css = ".dashboard-container")
    private WebElement dashboardContainer;

    @FindBy(css = ".dashboard-header h1")
    private WebElement dashboardTitle;

    public boolean esDashboardVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(dashboardContainer));
            return dashboardContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean estaEnDashboard() {
        return getDriver().getCurrentUrl().contains("dashboard");
    }
}
