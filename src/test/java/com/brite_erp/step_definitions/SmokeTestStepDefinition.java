package com.brite_erp.step_definitions;

import com.brite_erp.pages.Menu;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class SmokeTestStepDefinition {

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

    @Then("^title of the page should be \"([^\"]*)\"$")
    public void title_of_the_page_should_be(String purchasesTitle) throws Throwable {

      switch (purchasesTitle)
      {
        case "Requests for Quotation - Odoo":
          pages.purchasesMain().titleRequestForQuotationPage.click();
          BrowserUtils.wait(5);
          Assert.assertEquals(Driver.getDriver().getTitle(),purchasesTitle);
          break;

        case "Purchase Orders - Odoo":
          pages.purchasesMain().titlePurchaseOrders.click();
          BrowserUtils.wait(5);
          Assert.assertEquals(purchasesTitle,Driver.getDriver().getTitle());
          break;

        case "Vendors - Odoo":
          pages.purchasesMain().titleVendors.click();
          BrowserUtils.wait(5);
          Assert.assertEquals(purchasesTitle,Driver.getDriver().getTitle());
          break;

        case "Products - Odoo":
          pages.purchasesMain().titleProducts.click();
          BrowserUtils.wait(5);
          Assert.assertEquals(Driver.getDriver().getTitle(),purchasesTitle);
          break;

        case "Incoming Products - Odoo":
          pages.purchasesMain().titleIncomingProducts.click();
          BrowserUtils.wait(5);
          Assert.assertEquals(Driver.getDriver().getTitle(),purchasesTitle);
          break;

        case "Vendor Bills - Odoo":
          pages.purchasesMain().titleVendorBills.click();
          BrowserUtils.wait(5);
          Assert.assertEquals(Driver.getDriver().getTitle(),purchasesTitle);
          break;

        case "Purchase Analysis - Odoo":
          pages.purchasesMain().titleReporting.click();
          BrowserUtils.wait(5);
          Assert.assertEquals(Driver.getDriver().getTitle(),purchasesTitle);
          break;

          default:
            System.out.println("Wrong Title");

      }


    }

}
