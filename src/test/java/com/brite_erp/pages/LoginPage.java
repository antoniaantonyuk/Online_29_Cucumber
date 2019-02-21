package com.brite_erp.pages;



import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage extends Menu {
        public LoginPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(id="login")
        public WebElement username;

        @FindBy(id="password")
        public WebElement password;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement loginButton;



        public void login(){
            username.sendKeys(ConfigurationReader.getProperty("username"));
            password.sendKeys(ConfigurationReader.getProperty("password"));
            loginButton.click();
        }

        /**
         * ziyoda
         */
        public void loginAsInventory(){
            username.sendKeys(ConfigurationReader.getProperty("username2"));
            password.sendKeys(ConfigurationReader.getProperty("password2"));
            loginButton.click();
        }

        public void open() {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        }

    }

