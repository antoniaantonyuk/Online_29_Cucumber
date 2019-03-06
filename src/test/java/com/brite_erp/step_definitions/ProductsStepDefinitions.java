package com.brite_erp.step_definitions;

import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsStepDefinitions {


    private Pages pages=new Pages();


    @Given("^user on the products page$")
    public void user_on_the_products_page()  {

        pages.purchasesMain().titleProducts.click();
    }


    @When("^the user clicks on \"([^\"]*)\"$")
    public void the_user_clicks_on(String arg1) throws InterruptedException {
        pages.purchasesMain().Ipone8.click();

     }

    @When("^the user clicks on the \"([^\"]*)\" button$")
    public void the_user_clicks_on_the_button(String arg1) {
        pages.purchasesMain().addAMessage.click();
        }

    @When("^the user types on the message box this message \"([^\"]*)\" button$")
    public void the_user_types_on_the_message_box_this_message_button(String arg1)  {
        pages.purchasesMain().typingBox.sendKeys(ApplicationConstants.MESSAGE_TO_IPHONE8);
        pages.purchasesMain().messageButton.click();
    }

    @Then("^verify that the message added in the message box\\.$")
    public void verify_that_the_message_added_in_the_message_box()  {
        WebElement writtenMessage = Driver.getDriver().findElement(By.xpath("//div[@class='o_thread_message_content']"));
        Assert.assertEquals(writtenMessage.getText(), ApplicationConstants.MESSAGE_TO_IPHONE8);
    }

    @When("^the user click on \"([^\"]*)\"$")
    public void the_user_click_on(String arg1) throws InterruptedException {
        pages.purchasesMain().datacard.click();
        Thread.sleep(3000);
        }

    @When("^the user click on the \"([^\"]*)\" button$")
    public void the_user_click_on_the_button(String arg1) throws InterruptedException {
        pages.purchasesMain().updateQuantityButton.click();
        Thread.sleep(3000);
           }

    String qua = "15.000";

    @When("^the user enters \"([^\"]*)\" as new quantity$")
    public void the_user_enters_as_new_quantity(String arg1) throws InterruptedException {
        pages.purchasesMain().enterNewQuantity.clear();
        Thread.sleep(3000);
        pages.purchasesMain().enterNewQuantity.sendKeys(qua);
        Thread.sleep(3000);
        pages.purchasesMain().applyButtonenterQua.click();
        Thread.sleep(6000);

    }

    @Then("^verify that the quantity is updated\\.$")
    public void verify_that_the_quantity_is_updated()  {
        String updatedQua = pages.purchasesMain().updatedQuantity.getText();
        Assert.assertEquals(updatedQua, qua);
    }

    @When("^the user clicks on the product of \"([^\"]*)\"$")
    public void the_user_clicks_on_the_product_of(String arg1)  {
        BrowserUtils.wait(9);
        pages.purchasesMain().appleWatch3.click();
        BrowserUtils.wait(9);
    }

    @When("^the user clicks on the product's \"([^\"]*)\" button$")
    public void the_user_clicks_on_the_product_s_button(String arg1) throws Throwable {
        BrowserUtils.wait(9);
        pages.purchasesMain().printButton.click();
        BrowserUtils.wait(9);
        pages.purchasesMain().printLabelButton.click();
    }

    @Then("^verify that the label contains the product name\\.$")
    public void verify_that_the_label_contains_the_product_name() throws Throwable {
        WebElement iframe = Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/iframe"));
        BrowserUtils.wait(8);
        Driver.getDriver().switchTo().frame(iframe);
        BrowserUtils.wait(8);
        String appleTitleActual= pages.purchasesMain().appleTitle.getText();
        BrowserUtils.wait(11);
        Assert.assertEquals(appleTitleActual, ApplicationConstants.APPLE_TITLE);
    }
}
