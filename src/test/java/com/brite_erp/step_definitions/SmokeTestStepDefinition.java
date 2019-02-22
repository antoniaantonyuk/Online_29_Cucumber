package com.brite_erp.step_definitions;

import com.brite_erp.pages.Menu;
import com.brite_erp.utilities.ApplicationConstants;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class SmokeTestStepDefinition extends Menu {

  protected Pages pages=new Pages();
/*    @Given("^user on the purchases page$")
    public void user_on_the_purchases_page() throws Throwable {
      pages.login().open();
        pages.chooseERP().rightERP.click();
        pages.login().login();
        pages.purchasesMain().purchaseInMenu.click();

    }*/

    @Then("^title of the page should be \"([^\"]*)\"$")
    public void title_of_the_page_should_be(String tab) throws Throwable {

      switch (tab)
      {
        case "Requests for Quotation - Odoo":
          pages.purchasesMain().titleRequestForQuotationPage.click();
        BrowserUtils.wait(3);
           Assert.assertEquals(tab,Driver.getDriver().getTitle());
        break;
        case "Purchase Orders - Odoo":
          pages.purchasesMain().titlePurchaseOrders.click();
          break;
       /* case tab:"Requests for Quotation - Odoo"
          pages.purchasesMain().titleRequestForQuotationPage.click();
          break;
        case tab:"Requests for Quotation - Odoo"
          pages.purchasesMain().titleRequestForQuotationPage.click();
          break;case tab:"Requests for Quotation - Odoo"
        pages.purchasesMain().titleRequestForQuotationPage.click();
        break;*/


      }








       /* BrowserUtils.wait(5);
        //String quotationTitle =pages.purchasesMain().titleRequestForQuotationPage.getText();
      String quotationTitle = Driver.getDriver().getTitle();
      System.out.println(quotationTitle);

      BrowserUtils.wait(4);
      pages.purchasesMain().titlePurchaseOrders.click();
      BrowserUtils.wait(4);
        Assert.assertEquals(ApplicationConstants.PURCHASES_TITLE,quotationTitle);
      //Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.PURCHASES_ORDERS_TITLE);

      BrowserUtils.wait(4);
      //String purchasesOrderTitle =pages.purchasesMain().titlePurchaseOrders.getText();
      pages.purchasesMain().titleVendors.click();
      BrowserUtils.wait(4);
      String purchasesOrderTitle = Driver.getDriver().getTitle();
      System.out.println(purchasesOrderTitle);
      Assert.assertEquals(ApplicationConstants.PURCHASES_ORDERS_TITLE,purchasesOrderTitle);

      BrowserUtils.wait(10);
      String vendorsTitle =pages.purchasesMain().titleVendors.getText();
      System.out.println(vendorsTitle);
      Assert.assertEquals(ApplicationConstants.VENDORS_TITLE,vendorsTitle);
*/

    }

}
