package com.brite_erp.step_definitions;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class PublicChannelsLink {

    private Pages pages=new Pages();
    @Given("User loged in")
    public void user_loged_in() {
        pages.login().open();
       // pages.chooseERP().rightERP.click();
        pages.login().login();
        BrowserUtils.wait(2);
    }

    @Then("Check if Channels is visible")
    public void check_if_Channels_is_visible()  {
        Assert.assertTrue(pages.discussPage().channelsLink.isDisplayed());
    }

    @Then("Check if Channels is clickable")
    public void check_if_Channels_is_clickable()  {
        pages.discussPage().channelsLink.click();
    }

    @Then("Click on link Channels")
    public void click_on_link_Channels() {
        pages.discussPage().channelsLink.click();
    }

    @Then("Assert the title of opened page")
    public void assert_the_title_of_opened_page_with_Public_Channels()  {
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.CHANNELS_TITLE);
    }

    @Then("Assert that General channel is presented$")
    public void assert_that_General_channel_is_presented() {
        BrowserUtils.wait(2);
        Assert.assertTrue(pages.discussPage().generalChannelBlock.isDisplayed());
    }
}
