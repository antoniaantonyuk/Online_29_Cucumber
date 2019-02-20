package com.brite_erp.step_definitions;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class PrivateChannelFunctionalTest {
    protected Pages pages=new Pages();
    @Then("^Create Private Channel$")
    public void create_Private_Channel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.discussPage().addPrivateChannelPlusButton.click();

    }

    @Then("^Write Private Channel Name$")
    public void write_Private_Channel_Name() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.discussPage().privateChannelCreatorBar.sendKeys(ApplicationConstants.NEW_CHANNEL + Keys.ENTER);

    }

    @Then("^Verify that new Channel Name is displayed on the page$")
    public void verify_that_new_Channel_Name_is_displayed_on_the_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(pages.discussPage().privateChannelNameNew.isDisplayed());

    }

}
