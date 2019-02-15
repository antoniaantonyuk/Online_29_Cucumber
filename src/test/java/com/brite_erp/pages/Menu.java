package com.brite_erp.pages;

import com.brite_erp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Menu {
    public Menu() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Purchases")
    public WebElement purchaseInMenu;

    @FindBy(linkText = "Discuss")
    public WebElement discussInMenu;
}
