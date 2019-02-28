package com.brite_erp.step_definitions;

import com.brite_erp.utilities.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;



public class DirectMessageStep_definitions {
    private Pages pages=new Pages();

    @Then("click on plus sign on direct message")
    public void click_on_plus_sign_on_direct_message() throws Throwable {
    WebDriver driver= Driver.getDriver();
        Pages pages = new Pages();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pages.discussPage().discussInMenu.isDisplayed();
        pages.discussPage().addDirectMessagePlusButton.click();
        //Thread.sleep(20);
  }

    @Then("add \"([^\"]*)\" to the list")
    public void add_to_the_list(String arg1) throws Throwable {
        WebDriver driver= Driver.getDriver();
        pages.discussPage().AddOtherUserNameBar.sendKeys(ApplicationConstants.OTHER_USER);


    }

    @Then("select user in drop down menu")
    public void select_user_in_drop_down_menu() throws Throwable {
        WebDriver driver= Driver.getDriver();
        pages.discussPage().selectOtherUserInDropDownMenu.click();
        driver.navigate().refresh();
        //Thread.sleep(1000);

    }

    @Then("check if selected user is displayed")
    public void check_if_selected_user_is_displayed() throws Throwable {
        WebDriver driver= Driver.getDriver();
        Assert.assertTrue(pages.discussPage().OtherUserName.isDisplayed());
    }





//scenario 2

    @Then("add other_user to discuss list")
    public void add_other_user_to_discuss_list() throws Throwable {
        WebDriver driver = Driver.getDriver();
        pages.discussPage().discussInMenu.isDisplayed();
        pages.discussPage().addDirectMessagePlusButton.click();
        pages.discussPage().AddOtherUserNameBar.sendKeys(ApplicationConstants.OTHER_USER);
        pages.discussPage().selectOtherUserInDropDownMenu.click();
        driver.navigate().refresh();
        pages.discussPage().OtherUserName.click();
    }

    @Then("type and send the message")
    public void type_and_send_message() throws Throwable {
        WebDriver driver = Driver.getDriver();
    pages.discussPage().writeText.sendKeys("how are you"+ Keys.ENTER);
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.navigate().refresh();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Then("message displays on the page")
    public void message_displays_on_the_page() throws Throwable {
        System.out.println(pages.discussPage().actualMessage.isDisplayed());

    }

//scenario 3

    @Then("message displayes on the page")
    public void message_displayes_on_the_page()  {
        WebDriver driver = Driver.getDriver();
        pages.discussPage().discussInMenu.isDisplayed();
        pages.discussPage().addDirectMessagePlusButton.click();
        pages.discussPage().AddOtherUserNameBar.sendKeys(ApplicationConstants.OTHER_USER);
        pages.discussPage().selectOtherUserInDropDownMenu.click();
        driver.navigate().refresh();
        pages.discussPage().OtherUserName.click();

    }

    @Then("user selects message from the list")
    public void user_selects_message_from_the_list()  {
        WebDriver driver = Driver.getDriver();
        pages.discussPage().starMessage.equals("how are you jack");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pages.discussPage().starMark.click();
        driver.navigate().refresh();
        pages.discussPage().starred.isDisplayed();

    }

    @Then("message displays on the starred list")
    public void message_displays_on_the_starred_list()  {
        pages.discussPage().starred.isDisplayed();
    }
    @Then("delete the selected user")
    public void delete_the_selected_user() throws Throwable {
        WebDriver driver = Driver.getDriver();
        pages.discussPage().deleteOtherUserNameXButton.click();
        driver.navigate().refresh();
    }

    @Then("check if user is deleted")
        public void check_if_user_is_deleted() throws Throwable {
            pages.discussPage().isElementPreset();
            System.out.println("Fail is expected.");

        }
}
