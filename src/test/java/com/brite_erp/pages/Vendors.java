package com.brite_erp.pages;

import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vendors {

    public Vendors() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // @FindBy (xpath = "//a[@data-menu='261']")
    @FindBy(xpath = "//a[@data-menu='506']")
    public WebElement vendorsTab;

    @FindBy(xpath = "//span[contains(.,'Purchases')]")
    public WebElement mainPurchaseTab;


    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement createVendor;
    //(//*[starts-with(@id,'o_field')])[3]
    // @FindBy (xpath = ("(//*[contains(@id,'o_field_input')])[3]")
    @FindBy(xpath = "(//*[contains(@id,'o_field_input')])[3]")
    public WebElement newVendorName;

    @FindBy(xpath = "(//button[contains(.,'')])[8]")
    public WebElement saveNewVendor;

    @FindBy(xpath = "//span[@name='name']")
    public WebElement vendorNameCheck;

    @FindBy(xpath = "//button[contains(.,'Import')]")
    public WebElement importVendor;

    @FindBy(xpath = "//label[@class='btn btn-primary']")
    public WebElement loadFile;

    //search button
    @FindBy(xpath = "//input[@placeholder='Search...']")
    public WebElement searchVendor;

    //@FindBy (xpath = "//input[@id='radio1144_company']" )
    @FindBy(xpath = "//input[@data-value='company']")
    public WebElement radioButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement Name;

    @FindBy(xpath = "//input[@name='street']")
    public WebElement Address;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement Phone;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    public WebElement Email;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchField;

    @FindBy(xpath = "//span[contains(@title,'Advanced Search...')]")
    public WebElement advancedSearch;

    @FindBy(xpath = "(//button[contains(.,'')])[8]")
    public WebElement filters;

    @FindBy(xpath = "//a[contains(.,'Companies')]")
    public WebElement companies;


//   Select dropdown =new Select(Driver.getDriver().findElement(By.xpath("(//button[contains(.,'')])[8]")));
//
//    public Select getDropdown() {
//
//        return dropdown;
//    }

    @FindBy(xpath = "//button[contains(@accesskey,'l')]")
    public WebElement listView;

    public WebElement sortedVendor() {
        List<WebElement> sv = Driver.getDriver().findElements(By.xpath("//tbody/tr"));
        System.out.println(sv.size());
        //List<Integer> randomVendor = new ArrayList<>();
        Random rnd=new Random();
        int chooseRow=1+rnd.nextInt(sv.size());
        System.out.println(chooseRow);

//        for (int i = 1; i < sv.size(); i++) {
//            BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.xpath("(//tbody/tr[i]")));
//            BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("(//tbody/tr/td[2])[i]")), 7);
//
//        }
        return Driver.getDriver().findElement(By.xpath("//tbody/tr["+chooseRow+"]"));
    }


}
