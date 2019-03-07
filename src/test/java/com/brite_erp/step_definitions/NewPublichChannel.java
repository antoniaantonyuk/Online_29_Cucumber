package com.brite_erp.step_definitions;
import com.brite_erp.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.security.Key;
import java.util.List;
import java.util.Map;

public class NewPublichChannel {

    Pages pages = new Pages();

    @Given("User log in")
    public void user_loged_in() {
        pages.login().open();
        // pages.chooseERP().rightERP.click();
        pages.login().login();
        BrowserUtils.wait(2);
    }

    @Then("^Create new chanell \"([^\"]*)\"$")
    public void create_new_chanell(String arg1) {
        pages.discussPage().plusButtonPublicChannel.click();
        pages.discussPage().fieldForPublicChannelName.sendKeys(arg1);
        pages.discussPage().approvCreationPublicChannel.click();
        WebElement newChannel = Driver.getDriver().findElement(By.partialLinkText(arg1));
        Assert.assertTrue(newChannel.isDisplayed());
    }

    @Then("User log out")
    public void user_log_out() {
        pages.discussPage().avatar.click();
        BrowserUtils.wait(2);
        pages.discussPage().logOut.click();
    }

    @Given("^User should log in with \"([^\"]*)\" and \"([^\"]*)\" and join to \"([^\"]*)\"$")
    public void user_should_log_in_with_and_and_join_to(String arg1, String arg2, String arg3) {
        String path = ".\\src\\test\\resources\\test-data\\Brite-ERP_system.xlsx";
        String sheetName = "Users BRITE ERP";
        ExcelUtilities users = new ExcelUtilities(path, sheetName);
        List<Map<String, String>> userList = users.getDataList();
        for (Map<String, String> user : userList) {

            arg1 = user.get("UserName");
            arg2 = user.get("Password");
            if(arg1.equals(ConfigurationReader.getProperty("username"))){
                break;
            }
            pages.login().open();

            Driver.getDriver().findElement(By.linkText("Sign in")).click();
            //  pages.login().singIn.click();
            pages.login().username.sendKeys(arg1);
            pages.login().password.sendKeys(arg2);
            pages.login().loginButton.click();
            pages.discussPage().channelsLink.click();
            BrowserUtils.wait(2);
            try {
                String xPath="//span[.='"+arg3+"']";
                WebElement newChannel = Driver.getDriver().findElement(By.xpath(xPath));
            } catch (RuntimeException e) {
                throw new RuntimeException("New channel was not found");
            }
            List<WebElement> join = Driver.getDriver().findElements(By.xpath("//button[.='Join']"));
            int n = join.size();
            join.get(n - 1).click();
            pages.discussPage().avatar.click();
            BrowserUtils.wait(2);
            pages.discussPage().logOut.click();
        }
    }


    @Then("Main user shoul delete created channel")
    public void main_user_shoul_delete_created_channel() {
        pages.discussPage().channelsLink.click();
        WebElement addedChannel = Driver.getDriver().findElement(By.xpath("//span[.='NewChannelToCheck']"));
        addedChannel.click();
        BrowserUtils.wait(2);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", Driver.getDriver().findElement(By.xpath("(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[3]")));
        Driver.getDriver().findElement(By.xpath("//a[@data-index='0']")).click();
        Driver.getDriver().findElement(By.xpath("//span[.='Ok']")).click();

    }
}


