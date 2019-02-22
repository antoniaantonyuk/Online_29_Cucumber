package com.brite_erp.step_definitions;

import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.bcel.generic.BREAKPOINT;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class VendorsStepDefs {
    private Pages pages = new Pages();


    @Given("^user clicks on vendors tab$")
    public void user_clicks_on_vendors_tab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        BrowserUtils.wait(5);
        pages.vendors().vendorsTab.click();
       // BrowserUtils.doubleClick(pages.vendors().vendorsTab);
      // pages.vendors().vendorsTab.click();
        //BrowserUtils.waitForVisibility(pages.vendors().createVendor,12);
        BrowserUtils.wait(10);
    }

    @Then("^user clicks on VendorCreate button$")
    public void user_clicks_on_VendorCreate_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.vendors().createVendor.click();
        BrowserUtils.waitForVisibility(pages.vendors().radioButton,6);
    }

    @Then("^user clicks on company radio button$")
    public void user_clicks_on_company_radio_button() throws Throwable {
        BrowserUtils.wait(4);
        pages.vendors().radioButton.click();
       BrowserUtils.wait(4);

    }

    @Then("^user creates new vendor \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void user_creates_new_vendor(String Name, String Address, String Phone, String Email) throws Throwable {
        pages.vendors().Name.sendKeys(Name);
         pages.vendors().Address.sendKeys(Address,Keys.ENTER);
         pages.vendors().Phone.sendKeys(Phone);
         pages.vendors().Email.sendKeys(Email);
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

    @Then("^user uploads data file excel file upload$")
    public void user_uploads_data_file_excel_file_upload() throws Throwable {
   // BrowserUtils.verifyElementDisplayed(pages.vendors().loadFile);

        String path= "C:\\Users\\oozturk\\Desktop\\SalesJan2009.csv";
        Driver.getDriver().findElement(By.name("file")).sendKeys(path);
        //pages.vendors().loadFile.sendKeys(path);
        BrowserUtils.wait(5);

        //pages.vendors().loadFile.sendKeys(path);

    }
private  Random random = new Random();
    @Then("^user clicks any vendor use random method$")
    public void user_clicks_any_vendor_use_random_method() throws Throwable {


        pages.vendors().listView.click();
        pages.vendors().sortedVendor().click();
        BrowserUtils.wait(10);
        //int randomRow =random.nextInt(pages.vendors().sortedVendor().size());


    }




}