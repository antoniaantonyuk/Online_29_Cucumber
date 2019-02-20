package com.brite_erp.step_definitions;

import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class PrivateChannelSmokeTEst {
    protected Pages pages=new Pages();
    @Given("^User in the Duscuss Page$")
    public void user_in_the_Duscuss_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.login().open();
        pages.chooseERP().rightERP.click();
        pages.login().login();

    }

    @Then("^We confirm Private Channel is available$")
    public void we_confirm_Private_Channel_is_available() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String prCh = "PRIVATE CHANNELS";
        String actualPrCh = pages.discussPage().privateChannel.getText();

        Assert.assertEquals(prCh,actualPrCh);
    }

}
