package com.brite_erp.step_definitions;

import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {



    @Before
    public void setUp() throws InterruptedException {
       // driver = Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        /*driver.get(ConfigurationReader.getProperty("url"));
        Thread.sleep(15000);*/
    }

   @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {

            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.embed(screenshot, "image/png");
        }

        Driver.closeDriver();
    }
}
