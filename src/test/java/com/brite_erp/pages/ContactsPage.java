package com.brite_erp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends Menu {

    @FindBy(xpath = "//a[@data-menu-xmlid='contacts.menu_contacts']")
    public WebElement contacts;

    @FindBy(xpath = "//div//strong[@class='o_kanban_record_title oe_partner_heading']")
    public List<WebElement> contactName;


}
