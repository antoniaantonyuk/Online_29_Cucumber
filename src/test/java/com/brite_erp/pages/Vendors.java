package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendors {

    public Vendors (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@data-menu='261']")
    public WebElement vendorsTab;

    @FindBy(xpath = "//button[contains(text(),'Create')]" )
    public WebElement createVendor;
    //(//*[starts-with(@id,'o_field')])[3]
    // @FindBy (xpath = ("(//*[contains(@id,'o_field_input')])[3]")
    @FindBy (xpath = "(//*[contains(@id,'o_field_input')])[3]")
    public WebElement newVendorName;

    @FindBy (xpath=("(//button[contains(.,'')])[8]"))
    public WebElement saveNewVendor;

    @FindBy (xpath = "//span[@name='name']")
    public WebElement vendorNameCheck;

    @FindBy (xpath = "//button[contains(text(),'Import')]" )
    public WebElement importVendor;

    @FindBy (xpath = "//label[@class='btn btn-primary']")
    public WebElement loadFile;

    //search button
    @FindBy(xpath ="//input[@placeholder='Search...']" )
    public WebElement searchVendor;

}

