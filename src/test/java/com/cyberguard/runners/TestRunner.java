package com.cyberguard.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.cyberguard.stepdefinitions",
        plugin = {"pretty"},
        tags = "@ui"
)
public class TestRunner {
}
