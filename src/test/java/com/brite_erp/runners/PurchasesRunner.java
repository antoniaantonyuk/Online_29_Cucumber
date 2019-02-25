package com.brite_erp.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {
        "json:target/cucumber.json",
        "html:target/default-cucumber-report"},
        features ="src/test/resources/Purchases/",
        glue = "com/brite_erp/step_definitions"
        ,tags = "@Run"
// ,dryRun = true

        )
public class PurchasesRunner {
}
