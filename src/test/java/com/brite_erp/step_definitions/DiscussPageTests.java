package com.brite_erp.step_definitions;

import com.brite_erp.pages.ChooseERP;
import com.brite_erp.pages.DiscussPage;
import com.brite_erp.pages.LoginPage;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DiscussPageTests  {



        @Given("open brite url")
        public void open_brite_url()  {
            WebDriver driver= Driver.getDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(ConfigurationReader.getProperty("url"));
            Pages pages = new Pages();

            pages.chooseERP().rightERP.click();
        }

        @When("login as purchase user")
        public void login_as_user_and_password()  {
            Pages pages = new Pages();
            pages.login().login();
        }



        @Then("check if Inbox is presented")
        public void check_if_Inbox_is_presented() throws InterruptedException {
            Thread.sleep(3000);
            Pages pages = new Pages();
            Assert.assertTrue(pages.discussPage().inboxLink.isDisplayed());
        }

        @Then("open Inbox page")
        public void open_Inbox_page() {
            Pages pages = new Pages();
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

