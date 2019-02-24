package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasesMain extends Menu {
    public PurchasesMain() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@data-menu='504']")
    public WebElement titlePurchasePage;

    @FindBy(xpath = "//a[@data-menu='518']")
    public WebElement titleRequestForQuotationPage;

    @FindBy(xpath = "//a[@data-menu='519']")
    public WebElement titlePurchaseOrders;

    @FindBy(xpath = "//a[@data-menu='506']")
    public WebElement titleVendors;

    @FindBy(xpath = "//a[@data-menu='516']")
    public WebElement titleProducts;

    @FindBy(xpath = "//a[@data-menu='514']")
    public WebElement titleIncomingProducts;

    @FindBy(xpath = "//a[@data-menu='515']")
    public WebElement titleVendorBills;

    @FindBy(xpath = "//a[@data-menu='521']")
    public WebElement titleReporting;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement WrongCredentialsAlert;

    @FindBy (xpath = "//span[.='iphone 8']")
    public WebElement Ipone8;

    @FindBy (xpath = "//button[@title='Send a message']")
    public WebElement addAMessage;

    @FindBy (xpath = "//textarea")
    public WebElement typingBox;

    @FindBy (xpath = "//button[@tabindex='3']")
    public WebElement messageButton;

    @FindBy (xpath = "(//div[@class='oe_kanban_details'])[42]")
    public WebElement datacard;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-default']")
    public WebElement updateQuantityButton;

    @FindBy (xpath = "//input[@name='new_quantity']")
    public WebElement enterNewQuantity;

    @FindBy (xpath = "//span[.='Apply']")
    public WebElement applyButtonenterQua;

    @FindBy (xpath = "(//span[@class='o_stat_value'])[3]")
    public WebElement updatedQuantity;


    @FindBy(xpath = "(//div[@class='oe_kanban_global_click o_kanban_record'])[21]")
    public WebElement appleWatch3;

    @FindBy (xpath = "//button[@data-toggle='dropdown']")
    public WebElement printButton;

    @FindBy(xpath = "//a[@data-section='print']")
    public WebElement printLabelButton;

    @FindBy(xpath = "//td[@class='col-xs-8 danger']")
    public WebElement appleTitle;

}