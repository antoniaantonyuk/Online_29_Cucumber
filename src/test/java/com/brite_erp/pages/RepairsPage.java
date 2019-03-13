package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RepairsPage extends Menu{

    @FindBy(xpath = "//span[contains(. , 'Repairs')]")
    public WebElement repairs;

    @FindBy(xpath = "//button[@accesskey='c' and contains(. , 'Create')]")
    public WebElement create;

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement reference;



    @FindBy(xpath = "//div[@name='product_id']//input[@class='o_input ui-autocomplete-input']")
    public WebElement product;

    @FindBy(xpath = "//div[@name='partner_id']//input[@class='o_input ui-autocomplete-input']")
    public WebElement customer;

//
    @FindBy(xpath = "//div[@name='address_id']//input[@class='o_input ui-autocomplete-input']")
    public WebElement deliverAddress;

    @FindBy(xpath = "//button[@accesskey='s' and contains(. , 'Save')]")
    public WebElement save;

    @FindBy(xpath = "//tr[@class='o_data_row text-info']//td[3]")
    public List<WebElement> productToRepair;

    @FindBy(xpath = "//tr[@class='o_data_row text-info']//td[2]")
    public List<WebElement> repairReference;

    public WebElement productName(String name){
        WebElement pname = Driver.getDriver().findElement(By.xpath("//li/a[contains(text(),'"+name+"')]"));
        return pname;
    }

    public WebElement customertName(String name){
        WebElement pname = Driver.getDriver().findElement(By.xpath("//li/a[contains(text(),'"+name+"')]"));
        return pname;
    }

    public WebElement deliveryAddress(String name){
        WebElement pname = Driver.getDriver().findElement(By.xpath("//li/a[contains(text(),'"+name+"')]"));
        return pname;
    }


}
