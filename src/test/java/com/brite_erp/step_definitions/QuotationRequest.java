package com.brite_erp.step_definitions;

import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class QuotationRequest {
    private Pages pages=new Pages();

    @Given("^user on the home page$")
    public void user_on_the_home_page() throws Throwable {
     pages.login().open();
    }
    @When("^user click on BriteErpDemo option$")
    public void user_click_on_BriteErpDemo_option() throws Throwable {
        pages.chooseERP().rightERP.click();
    }
    @Then("^user logs in by using credentials from config file$")
    public void user_logs_in_by_using_credentials_from_config_file() throws Throwable {
      pages.login().login();
    }
    @Then("^use clicks on purchase tab$")
    public void use_clicks_on_purchase_tab() throws Throwable {
        pages.quotationRequest().PurchasesTab.click();
    }
    @Then("^total value shown at the bottom of the page should match with addition of all quote values$")
    public void total_value_shown_at_the_bottom_of_the_page_should_match_with_addition_of_all_quote_values() throws Throwable {
        double money= pages.quotationRequest().getTotalAmount(pages.quotationRequest().indvPrices());
        double totalAmount=Double.valueOf(pages.quotationRequest().totalAmount.getText().replace(",","").trim());
        System.out.println(totalAmount);
        Assert.assertEquals(money,totalAmount,1);

    }
}
