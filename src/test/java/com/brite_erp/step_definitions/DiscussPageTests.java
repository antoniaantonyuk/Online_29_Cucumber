package com.brite_erp.step_definitions;

import com.brite_erp.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DiscussPageTests  {

    Pages pages = new Pages();

        @Given("open brite url")
        public void open_brite_url()  {
            pages.login().open();
           // pages.chooseERP().rightERP.click();
        }

        @When("login as purchase user")
        public void login_as_user_and_password()  {
            pages.login().login();
        }



        @Then("check if Inbox is presented")
        public void check_if_Inbox_is_presented() {
            BrowserUtils.wait(2);
            Assert.assertTrue(pages.discussPage().inboxLink.isDisplayed());
        }

        @Then("open Inbox page")
        public void open_Inbox_page() {
            pages.discussPage().inboxLink.click();
        }

        @Then("check the page title")
        public void check_the_page_title()  {
            Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.APPLICATION_TITLE);
            Driver.closeDriver();

        }

    /**
     * ziyoda
     */
    @When("login as inventory user")
    public void login_as_inventory_user_and_password()  {
        Pages pages = new Pages();
        pages.login().loginAsInventory();
    }

    @When("user successfully should see inbox folder on right menu")
    public void user_should_see_inbox_on_right_side_menu() throws InterruptedException{
        Thread.sleep(3000);
        Pages pages = new Pages();
        Assert.assertTrue(pages.discussPage().inboxLink.isDisplayed());
    }

    @When("click on inbox")
    public void click_on_inbox() throws InterruptedException{
        Thread.sleep(3000);
        Pages pages = new Pages();
       pages.discussPage().inboxLink.click();
    }

    @When("inbox should successfully clickable")
    public void inbox_should_successfully_clickable() throws InterruptedException{
        Thread.sleep(3000);
        Pages pages = new Pages();
        Assert.assertTrue(pages.discussPage().inboxLink.isEnabled());
    }


    @When("the title on the page successfully should be inbox")
    public void verify_page_title_as_inbox() throws InterruptedException{
        Thread.sleep(3000);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.APPLICATION_TITLE);
    }


    }

