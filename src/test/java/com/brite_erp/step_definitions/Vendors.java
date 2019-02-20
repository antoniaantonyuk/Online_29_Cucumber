package com.brite_erp.step_definitions;

import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Vendors {
    private Pages pages = new Pages();

    public void user_on_the_purchases_page() throws Throwable {
        pages.login().open();
        pages.chooseERP().rightERP.click();
        pages.login().login();
        BrowserUtils.wait(2);
        pages.purchasesMain().purchaseInMenu.click();

    }

    @Given("^user clicks on vendors tab$")
    public void user_clicks_on_vendors_tab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user clicks on Create button$")
    public void user_clicks_on_Create_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user clicks on company radio button$")
    public void user_clicks_on_company_radio_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user clicks on save button$")
    public void user_clicks_on_save_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}