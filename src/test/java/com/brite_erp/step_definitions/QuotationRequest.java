package com.brite_erp.step_definitions;

import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.ConfigurationReader;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.Pages;
import com.gargoylesoftware.htmlunit.html.ScriptElement;
import com.github.javafaker.Faker;
import com.sun.jna.platform.win32.OaIdl;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import javax.jws.soap.SOAPBinding;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class QuotationRequest {
    private Pages pages=new Pages();

    @Given("^user on the purchases page$")
    public void user_on_the_purchases_page() throws Throwable {
        pages.login().open();
        //pages.chooseERP().rightERP.click();
        pages.login().login();
        BrowserUtils.wait(2);
        pages.purchasesMain().purchaseInMenu.click();


    }
    @Then("^total value shown at the bottom of the page should match with addition of all quote values$")
    public void total_value_shown_at_the_bottom_of_the_page_should_match_with_addition_of_all_quote_values() throws Throwable {
        double money= pages.quotationRequest().getTotalAmount(pages.quotationRequest().indvPrices());
        double totalAmount=Double.valueOf(pages.quotationRequest().totalAmount.getText().replace(",","").trim());
        System.out.println(totalAmount);
        Assert.assertEquals(money,totalAmount,1);

    }
    private String quoteAmount;

    private Random rndm=new Random();
    @Then("^user selects random quotes from the list$")
    public void user_selects_random_quotes_from_the_list() throws Throwable {


        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        quoteAmount=pages.quotationRequest().PickAQuote(randomRow).getText().substring(2);
    }

    @Then("^total value shown at the bottom of the page should match with addition of all selected quote values$")
    public void total_value_shown_at_the_bottom_of_the_page_should_match_with_addition_of_all_selected_quote_values() throws Throwable {

        String totalAmount=pages.quotationRequest().totalAmount.getText();
        Assert.assertEquals(quoteAmount,totalAmount);
    }

    @Then("^user can click on print tab and select print as a Purchase Order option$")
    public void user_can_click_on_print_tab_and_select_print_as_a_Purchase_Order_option() throws Throwable {
        pages.quotationRequest().printTab.click();
        pages.quotationRequest().purchaseOrderPrint.click();
        Assert.assertTrue(pages.quotationRequest().printMessage.getText().contains("Successfully Printed"));
    }
    @Then("^user can click on print tab and select print as a request for quotation option$")
    public void user_can_click_on_print_tab_and_select_print_as_a_request_for_quotation_option() throws Throwable {
        pages.quotationRequest().printTab.click();
        pages.quotationRequest().RequestForQuotationPrint.click();
        Assert.assertTrue(pages.quotationRequest().printMessage.getText().contains("Successfully Printed"));
    }

    @Then("^user can click on action tab and selects export option$")
    public void user_can_click_on_action_tab_and_selects_export_option() throws Throwable {
        pages.quotationRequest().actionTab.click();
        pages.quotationRequest().export.click();


    }

    @Then("^user selects exporting options by double clicking on them$")
    public void user_selects_exporting_options_by_double_clicking_on_them() throws Throwable {
        BrowserUtils.doubleClick(pages.quotationRequest().companyadd);
        BrowserUtils.doubleClick(pages.quotationRequest().currency);
        BrowserUtils.doubleClick(pages.quotationRequest().orderDateadd);
    }

    @Then("^user clicks on export to File button$")
    public void user_clicks_on_export_to_File_button() throws Throwable {
        pages.quotationRequest().exportToFile.click();
        String path = "E:\\Downloads";
        Assert.assertTrue(pages.quotationRequest().isFileDownloaded(path, "purchase.order"));
    }

    @Then("^user click on \"([^\"]*)\" view$")
    public void user_click_on_view(String view) throws Throwable {
        pages.quotationRequest().ChangeView("list").click();
        pages.quotationRequest().ChangeView("kanban").click();
        pages.quotationRequest().ChangeView("pivot").click();
        pages.quotationRequest().ChangeView("graph").click();
        pages.quotationRequest().ChangeView("calendar").click();

    }
    @Then("^user clicks on the quote he wants to delete$")
    public void user_clicks_on_the_quote_he_wants_to_delete() throws Throwable {
        BrowserUtils.wait(1);
        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        BrowserUtils.wait(1);
        pages.quotationRequest().PickAQuote(randomRow).click();

    }

    @Then("^user clicks on cancel button$")
    public void user_clicks_on_cancel_button() throws Throwable {

        if (pages.quotationRequest().cancel.isDisplayed())
        {
            pages.quotationRequest().cancel.click();
        }
        System.out.println("already canceled");
    }

    @Then("^user clicks on action tab and selects delete option$")
    public void user_clicks_on_action_tab_and_selects_delete_option() throws Throwable {
        BrowserUtils.wait(2);
        pages.quotationRequest().ActionTabOnDetails.click();
        pages.quotationRequest().deleteOnDetails.click();

    }

    @Then("^user confirms the delete$")
    public void user_confirms_the_delete() throws Throwable {
        BrowserUtils.wait(3);
        String quoteNameBefore=pages.quotationRequest().quotename.getText();
        System.out.println(quoteNameBefore);
        pages.quotationRequest().OK.click();
        BrowserUtils.wait(6);
        String quoteNameAfter=pages.quotationRequest().quotename.getText();
        //System.out.println(quoteNameAfter);
        Assert.assertNotEquals(quoteNameAfter,quoteNameBefore);
    }

    @Then("^user clicks on \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" head$")
    public void user_clicks_on_head(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {

         pages.quotationRequest().sort(arg1).click();
         BrowserUtils.wait(1);
           pages.quotationRequest().sort(arg2).click();
        BrowserUtils.wait(1);
        pages.quotationRequest().sort(arg3).click();
        BrowserUtils.wait(1);
        pages.quotationRequest().sort(arg4).click();
        BrowserUtils.wait(1);
        pages.quotationRequest().sort(arg5).click();
        BrowserUtils.wait(1);
        pages.quotationRequest().sort(arg6).click();
        BrowserUtils.wait(1);
        pages.quotationRequest().sort(arg7).click();
        BrowserUtils.wait(1);

       }

    @Then("^user clicks on create button$")
    public void user_clicks_on_create_button() throws Throwable {
        pages.quotationRequest().create.click();
    }
private String vendorName;
    @Then("^user fills out required information \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void user_fills_out_required_information(String vendorr, String reference, String orderDate, String scheduledDate) throws Throwable {
        Date d=new Date();
       vendorName=vendorr;
       // pages.quotationRequest().VendorName.sendKeys(vendorr,Keys.ENTER);
        pages.quotationRequest().VendorName.sendKeys(vendorr);
        pages.quotationRequest().reference.sendKeys(reference,Keys.ENTER);
        BrowserUtils.wait(1);
        pages.quotationRequest().createVendor.click();
        pages.quotationRequest().orderDate.clear();
        String time=""+d.getHours()+d.getMinutes()+d.getSeconds();
        pages.quotationRequest().orderDate.sendKeys(orderDate+time, Keys.ENTER);
       // Driver.getDriver().findElement(By.cssSelector("input[name*='date_order']")).clear();
        BrowserUtils.wait(3);
        pages.quotationRequest().deliveriesTab.click();
        pages.quotationRequest().scheduledDate.click();
        time=""+d.getHours()+d.getMinutes()+d.getSeconds();
        pages.quotationRequest().scheduledDate.sendKeys(scheduledDate+time,Keys.ENTER);
        //BrowserUtils.wait(2);

    }

    @Then("^user confirms the request$")
    public void user_confirms_the_request() throws Throwable {
        pages.quotationRequest().confirmOrder.click();
        BrowserUtils.wait(2);
        Assert.assertEquals(pages.quotationRequest().confirmVendorName.getText(),vendorName);

    }

}
