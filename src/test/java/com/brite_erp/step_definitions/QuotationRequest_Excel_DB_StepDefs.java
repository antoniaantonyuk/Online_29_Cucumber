package com.brite_erp.step_definitions;

import com.brite_erp.utilities.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.bcel.generic.BREAKPOINT;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import sun.security.krb5.internal.PAData;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class QuotationRequest_Excel_DB_StepDefs {

    Pages pages=new Pages();
    Random rndm=new Random();
    @When("^user opens random quote$")
    public void user_opens_random_quote() throws Throwable {
        int randomRow=rndm.nextInt(pages.quotationRequest().requestCount.size());
        pages.quotationRequest().OpenAQuote(randomRow);
    }
    Date d=new Date();
    @Then("^user edit required parts$")
    public void user_edit_required_parts() throws Throwable {


        ExcelUtilities excelObject=new ExcelUtilities("C:\\Users\\oozturk\\Documents\\parallel-multi-browser-testng-framework\\Online_29_Cucumber\\src\\test\\resources\\test-data\\Brite-ERP_system.xlsx","Purchases");

        // pages.quotationRequest().VendorName.sendKeys(vendorr,Keys.ENTER);
        pages.quotationRequest().edit.click();
        List<Map<String,String>> myData=excelObject.getDataList();
        System.out.println(myData.size());
        for (int i=0;i<myData.size();i++)
        {
            String vendor=myData.get(i).get("Vendor");
            Thread.sleep(2);
            pages.quotationRequest().VendorName.clear();
            pages.quotationRequest().VendorName.sendKeys(vendor);
            vendorRef=myData.get(i).get("VendorReference");
            pages.quotationRequest().reference.sendKeys(vendorRef, Keys.ENTER);
            BrowserUtils.wait(1);
            TODO:
            //  pages.quotationRequest().createVendor.click();
            // String Product=myData.get(i).get("Products");
            //  pages.quotationRequest().AddItem.click();
            // BrowserUtils.waitForClickablility(By.id("ui-id-71"),5);
            // BrowserUtils.clickWithJS( pages.quotationRequest().AddProductid);
            // BrowserUtils.wait(5);
            //pages.quotationRequest().AddProductid.clear();
            //  pages.quotationRequest().AddProductid.sendKeys(Product, Keys.ENTER);
            // pages.quotationRequest().createVendor.click();
            //  pages.quotationRequest().VendorName.sendKeys(vendorRef);
            pages.quotationRequest().orderDate.clear();
            Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Create')])[1]")).click();
            String Orderdate=myData.get(i).get("Order Date");
            pages.quotationRequest().orderDate.sendKeys(convertDate(Orderdate), Keys.ENTER);
            pages.quotationRequest().deliveriesTab.click();
            pages.quotationRequest().scheduledDate.click();
            String schduledDate=myData.get(i).get("Purchase Date");
            System.out.println(schduledDate);
            //pages.quotationRequest().scheduledDate.clear();
            String date=convertDate(schduledDate)+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
            pages.quotationRequest().scheduledDate.sendKeys(date, Keys.ENTER);
            // Driver.getDriver().findElement(By.name("action_set_date_planned")).click();
            //pages.quotationRequest().ProductsTab.click();
            pages.quotationRequest().save.click();
            BrowserUtils.wait(2);
            Assert.assertEquals(pages.quotationRequest().confirmVendorName.getText(),vendor);
            pages.quotationRequest().edit.click();

        }
    }
    @Then("^PO should be updated on DB$")
    public void po_should_be_updated_on_DB() throws Throwable {

    }

    @When("^user on Purchase Orders Page$")
    public void user_on_Purchase_Orders_Page() throws Throwable {


        pages.purchasesMain().titlePurchaseOrders.click();
        BrowserUtils.wait(2);
    }

    @Then("^number of purchase orders should match with database records$")
    public void number_of_purchase_orders_should_match_with_database_records() throws Throwable {
       String query="Select * from purchase_order where state <> 'draft' ORDER BY id;";
        List<Map<String, Object>> tableData = DBUtilities.getQueryResultMap(query);
        System.out.println("databs"+tableData.size());
       int UIRowCount=pages.quotationRequest().getRows().size();
        System.out.println("ui count"+UIRowCount);
       Assert.assertEquals(tableData.size(),UIRowCount);

    }
    @When("^user on Purchase Orders Page and POs are sorted by Reference no$")
    public void user_on_Purchase_Orders_Page_and_POs_are_sorted_by_Reference_no() throws Throwable {
        user_on_Purchase_Orders_Page();
        pages.quotationRequest().sort("Reference").click();
        BrowserUtils.wait(1);
        //pages.quotationRequest().sort("Reference");
    }

    @Then("^Reference numbers should match with database records$")
    public void reference_numbers_should_match_with_database_records() throws Throwable {

        String query="Select * from purchase_order " +
                "where state <> 'draft'" +
                "ORDER BY id;";
        List<Object> RefIdsfromDB = DBUtilities.getColumnData(query, "name");
        List<String> RefIdsfromUI= pages.quotationRequest().getRows();

        for (int i = 0; i < RefIdsfromDB.size(); i++) {
            System.out.println("DB "+RefIdsfromDB.get(i)+" -- UI "+RefIdsfromUI.get(i));
            Assert.assertEquals(RefIdsfromDB.get(i),RefIdsfromUI.get(i));
        }
    }
    String vendorRef;
    @When("^user creates new PO$")
    public void user_creates_new_PO() throws Throwable {

        pages.quotationRequest().create.click();
        ExcelUtilities excelObject=new ExcelUtilities("C:\\Users\\oozturk\\Documents\\parallel-multi-browser-testng-framework\\Online_29_Cucumber\\src\\test\\resources\\test-data\\Brite-ERP_system.xlsx","Purchases");
        List<Map<String,String>> myData=excelObject.getDataList();
        int row=rndm.nextInt(myData.size()-1)+1;
        String vendor=myData.get(row).get("Vendor");
        Thread.sleep(2);
        pages.quotationRequest().VendorName.clear();
        pages.quotationRequest().VendorName.sendKeys(vendor,Keys.ENTER);
        BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("(//li/a[contains(text(),'Create')])[1]")));

        vendorRef=myData.get(row).get("VendorReference");
      //  pages.quotationRequest().reference.click();
      //  pages.quotationRequest().createVendor.click();
        pages.quotationRequest().reference.sendKeys(vendorRef, Keys.ENTER);
        BrowserUtils.wait(1);
        pages.quotationRequest().deliveriesTab.click();
        pages.quotationRequest().scheduledDate.click();
        String schduledDate=myData.get(row).get("Purchase Date");
        //pages.quotationRequest().scheduledDate.clear();
        String date=convertDate(schduledDate)+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
        pages.quotationRequest().scheduledDate.sendKeys(date, Keys.ENTER);
        pages.quotationRequest().confirmOrder.click();

    }

    @Then("^new PO should be added to DB$")
    public void new_PO_should_be_added_to_DB() throws Throwable {

        System.out.println(vendorRef);
        String query="Select * from purchase_order " +
                "where partner_ref='"+vendorRef+"';";
        List<Object> partner_ref = DBUtilities.getColumnData(query, "partner_ref");
        System.out.println(partner_ref.toString());
        Assert.assertTrue(partner_ref.get(0).toString().contains(vendorRef));
    }


    public String convertDate(String date)
    {
        String[] reverse=date.split("-");
        switch (reverse[1].toLowerCase()) {
            case "jan":
                reverse[1] = "01";
                break;
            case "feb":
                reverse[1] = "02";
                break;
            case "march":
                reverse[1] = "03";
                break;
            case "apr":
                reverse[1] = "04";
                break;
            case "may":
                reverse[1] = "05";
                break;
            case "jun":
                reverse[1] = "06";
                break;
            case "july":
                reverse[1] = "07";
                break;
            case "aug":
                reverse[1] = "08";
                break;
            case "sep":
                reverse[1] = "09";
                break;
            case "oct":
                reverse[1] = "10";
                break;
            case "nov":
                reverse[1] = "11";
                break;
            case "dec":
                reverse[1] = "12";
                break;

            default:
                System.out.println("Not found");
                break;

        }

        String ret=reverse[1]+"/"+reverse[0]+"/"+reverse[2];

        return ret;
    }
}
