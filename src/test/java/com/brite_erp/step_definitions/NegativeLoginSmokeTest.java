package com.brite_erp.step_definitions;

import com.brite_erp.pages.Menu;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class NegativeLoginSmokeTest extends Menu {

    protected Pages pages=new Pages();
    @Given("^user on the home page$")
    public void user_on_the_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.login().open();
    }

    @When("^user click on BriteErpDemo option$")
    public void user_click_on_BriteErpDemo_option() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.chooseERP().rightERP.click();
    }

    @Then("^user logs in wrong password \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_logs_in_wrong_password_and(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.login().username.sendKeys("username");
        pages.login().password.sendKeys("wrongpassword");
        pages.login().login();
        String alert1= pages.purchasesMain().WrongCredentialsAlert.getText();
        assertEquals(alert1, ApplicationConstants.WRONG_CREDENTIALS_ALERT);
    }
    @Then("^user logs in wrong username \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_logs_in_wrong_username_and(String arg1, String arg2) throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        pages.login().username.sendKeys("wrong username");
        pages.login().password.sendKeys("password");
        pages.login().login();
        String alert1= pages.purchasesMain().WrongCredentialsAlert.getText();
        assertEquals(alert1, ApplicationConstants.WRONG_CREDENTIALS_ALERT);
    }

}
