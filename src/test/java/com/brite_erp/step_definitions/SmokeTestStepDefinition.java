package com.brite_erp.step_definitions;

import com.brite_erp.pages.Menu;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class SmokeTestStepDefinition extends Menu {

  protected Pages pages=new Pages();
    @Given("^user on the purchases page$")
    public void user_on_the_purchases_page() throws Throwable {
      pages.login().open();
        pages.chooseERP().rightERP.click();
        pages.login().login();
        pages.purchasesMain().purchaseInMenu.click();
        pages.purchasesMain().titleProducts.click();

    }

    @Then("^title of the page should be \"([^\"]*)\"$")
    public void title_of_the_page_should_be(String arg1) throws Throwable {
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PURCHASES_TITLE);
    }
}
