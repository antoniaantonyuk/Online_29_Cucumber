package com.brite_erp.step_definitions;

import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

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
        //BrowserUtils.wait(10);
        BrowserUtils.wait(7);
       pages.vendors().vendorsTab.click();
        //BrowserUtils.waitForVisibility(pages.vendors().createVendor,12);
        BrowserUtils.wait(5);
    }

    @Then("^user clicks on Create button$")
    public void user_clicks_on_Create_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.vendors().createVendor.click();
        BrowserUtils.waitForVisibility(pages.vendors().radioButton,6);
    }

    @Then("^user clicks on company radio button$")
    public void user_clicks_on_company_radio_button() throws Throwable {
        pages.vendors().radioButton.click();
       BrowserUtils.wait(2);

    }

    @Then("^user clicks on save button$")
    public void user_clicks_on_save_button(String Name, String Address, String Phone, String Email) throws Throwable {

        pages.vendors().newVendorName.sendKeys(Name,Keys.ENTER);
        pages.vendors().Address.sendKeys(Address,Keys.ENTER);
        pages.vendors().Phone.sendKeys(Phone,Keys.ENTER);
        pages.vendors().Email.sendKeys(Email,Keys.ENTER);
        pages.vendors().saveNewVendor.click();

    }

    @Then("^user write vendor name which want to search \"([^\"]*)\"$")
    public void user_write_vendor_name_which_want_to_search(String arg1) throws Throwable {
        pages.vendors().searchField.sendKeys(arg1);
    }

    @Then("^user clicks on advanced search button$")
    public void user_clicks_on_advanced_search_button() throws Throwable {
        pages.vendors().advancedSearch.click();

    }

    @Then("^user clicks on filters dropdown button$")
    public void user_clicks_on_filters_dropdown_button() throws Throwable {
        pages.vendors().filters.click();
    }

    @Then("^user clicks on companies$")
    public void user_clicks_on_companies() throws Throwable {
        //pages.vendors().getDropdown().selectByIndex(3);
        pages.vendors().companies.click();
    }

    @Then("^user clicks on import button$")
    public void user_clicks_on_import_button() throws Throwable {
pages.vendors().importVendor.click();
    }

    @Then("^user uploads data file #excel file upload$")
    public void user_uploads_data_file_excel_file_upload() throws Throwable {
   // BrowserUtils.verifyElementDisplayed(pages.vendors().loadFile);
        pages.vendors().loadFile.click();
        BrowserUtils.wait(3);
        String path= "/Macintosh HD/Users/oibek/Document/SalesTest11.xlsx";
        pages.vendors().loadFile.sendKeys(path);

    }
private  Random random = new Random();
    @Then("^user clicks any vendor #use random method$")
    public void user_clicks_any_vendor_use_random_method() throws Throwable {
        pages.vendors().listView.click();
        BrowserUtils.wait(2);
        int randomRow =random.nextInt(pages.vendors().sortedVendor().size());


    }




}