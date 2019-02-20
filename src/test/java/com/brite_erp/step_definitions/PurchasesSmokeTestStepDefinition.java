package com.brite_erp.step_definitions;

import com.brite_erp.pages.Menu;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class PurchasesSmokeTestStepDefinition extends Menu {

//    protected Pages pages=new Pages();
//    @Given("^user on the purchases page$")
//    public void user_on_the_purchases_page() throws Throwable {
//        pages.login().open();
//        pages.chooseERP().rightERP.click();
//        pages.login().login();
//        pages.purchasesMain().purchaseInMenu.click();
//
//    }
//
//    @Then("^title of the page should be \"([^\"]*)\"$")
//    public void title_of_the_page_should_be(String arg1) throws Throwable {
//        BrowserUtils.wait(6);
//        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PURCHASES_TITLE);
//        //Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PURCHASES_ORDERS_TITLE);
//    }


//  @Then("^(\\d+) title of the page should be \"([^\"]*)\"$")
//  public void title_of_the_page_should_be(int arg1, String arg2) throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new PendingException();
//    BrowserUtils.wait(10);
//    Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PURCHASES_ORDERS_TITLE);
//    BrowserUtils.wait(10);
//    Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.VENDORS_TITLE);
//    BrowserUtils.wait(3);
//    Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PRODUCTS_TITLE);
//    }


}