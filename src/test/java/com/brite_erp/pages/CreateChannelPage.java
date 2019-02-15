package com.brite_erp.pages;


import com.brite_erp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateChannelPage {

    public CreateChannelPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "o_mail_open_channels")
    public WebElement channelTab;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement createBtn;

    @FindBy(name="name")
    public WebElement channelName;

    @FindBy(name="description")
    public  WebElement channelDescription;

    @FindBy(name = "email_send")
    public WebElement emailCheckbox;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement saveBtn;




}
