package com.brite_erp.pages;


import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuotationRequest {

    public QuotationRequest(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@data-menu='518']")
    public WebElement requestForQuote;

    @FindBy(xpath = "//a[@data-menu='504']")
    public WebElement PurchasesTab;

    @FindBy(xpath = "(//div[@class='btn-group']//button)[3]")
    public WebElement ActionTabOnDetails;

    @FindBy(xpath = "//a[contains(text(),'Deliveries')]")
    public WebElement deliveriesTab;

    @FindBy(xpath = "(//button[contains(text(),'Save')])[1]")
    public WebElement Save;
    @FindBy(xpath = "//a[contains(text(),'Products')]")
    public WebElement ProductsTab;

    @FindBy(css = "input[name*='date_order']")
    public WebElement orderDate;

    @FindBy(css = "input[name*='date_planned']")
    public WebElement scheduledDate;

    @FindBy(xpath = "//td[@title='Total amount']")
    public WebElement totalAmount;

    @FindBy(xpath = "//table//tbody//tr")
    public List<WebElement> requestCount;

    @FindBy(xpath = "(//div[@class='btn-group']//button)[1]")
    public WebElement printTab;

    @FindBy(xpath = "(//div[@class='btn-group']//button)[2]")
    public WebElement actionTab;

    @FindBy(xpath = "(//div[@class='btn-group']//ul//li)[1]")
    public WebElement purchaseOrderPrint;

    @FindBy(xpath = "//button[.='Cancel']")
    public WebElement cancel;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement create;

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement edit;


    @FindBy(xpath = "(//div[@class='btn-group']//ul//li)[2]")
    public WebElement RequestForQuotationPrint;

    @FindBy(xpath = "//span[.='Create']")
    public WebElement createVendor;




    @FindBy(xpath = "(//tbody/tr/td)[2]/a")
    public WebElement confirmVendorName;

    @FindBy(xpath = "(//div[@class='o_input_dropdown']/input)[1]")
    public WebElement VendorName;

    @FindBy(xpath = "//button[.='Confirm Order'][1]")
    public WebElement confirmOrder;


    @FindBy(name = "partner_ref")
    public WebElement reference;

    @FindBy(xpath = "(//div[@class='btn-group']//ul)[2]//li[1]")
    public WebElement export;

    @FindBy(xpath = "//span[.='Company']")
    public WebElement companyadd;

    @FindBy(xpath = "//a[contains(text(),'Add an item')]")
    public WebElement AddItem;

    @FindBy(xpath = "//div[@name='product_id']//input[@class='o_input ui-autocomplete-input']")
    public WebElement AddProductid;

    @FindBy(xpath = "//span[.='Currency']")
    public WebElement currency;

    @FindBy(name = "name")
    public WebElement quotename;

    @FindBy(xpath = "//thead/tr/th[2]")
    public WebElement SortByRef;

    @FindBy(xpath = "//span[.='Order Date']")
    public WebElement orderDateadd;

    @FindBy(xpath = "//span[.='Export To File']")
    public WebElement exportToFile;

    @FindBy(xpath = "//div[@class='o_notification_content']")
    public WebElement printMessage;

    @FindBy(xpath = "(//div[@class='btn-group']//ul)[2]//li[2]")
    public WebElement delete;


    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteOnDetails;

    @FindBy(xpath = "//span[(contains(text(),'Ok'))]")
    public WebElement OK;

    @FindBy(xpath = "//div[@class='o_form_buttons_edit']/button[1]")
    public WebElement save;

    public WebElement sort(String sortBy)
    {
        int column=6;
        switch (sortBy)
        {
            case "Reference":
                column=2;
                break;
            case "Order Date":
                column=3;
                break;
            case "Vendor":
                column=4;
                break;
            case "Scheduled Date":
                column=5;
                break;
            case "Untaxed":
                column=7;
                break;
            case "Total":
                column=8;
                break;
            case "Status":
                column=9;
                break;
                default:
                    System.out.println("No sorting");
                    break;
        }

        return Driver.getDriver().findElement(By.xpath("//table//th["+column+"]"));
    }


    public List<Double> indvPrices() throws InterruptedException {

        List<WebElement> as=Driver.getDriver().findElements(By.xpath("//tbody/tr/td[8]/span"));
        // System.out.println(as.size());
        List<Double> prices=new ArrayList<>();

        for (int i=0;i<as.size();i++) {
            BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.xpath("//tbody/tr["+(i+1)+"]/td[8]/span")));
            BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("//tbody/tr["+(i+1)+"]/td[8]/span")),7);
            prices.add(Double.valueOf(Driver.getDriver().findElement(By.xpath("//tbody/tr["+(i+1)+"]/td[8]/span"))
                    .getText().substring(2).replace(",","").trim()));
        }

        return prices;
    }

    public List<String> getRows()
    {
        List<WebElement> tableData=Driver.getDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));

        List<String> RefNames=new ArrayList<>();
        for (WebElement a: tableData) {
            RefNames.add(a.getText());
        }

        return RefNames;
    }


    public double getTotalAmount( List<Double> prices)
    {
        double priceTotal=0;
        for(int i=0;i<prices.size();i++)
        {
            priceTotal+=prices.get(i);
        }
        System.out.println(priceTotal);
        return priceTotal;
    }
//

    public WebElement ChangeView(String view)
    {
        return Driver.getDriver().findElement(By.xpath("//button[@data-view-type='"+view+"']"));
    }
    public WebElement PickAQuote(int row)
    {
        Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]//td[1]")).click();
        return Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]//td[7]"));
    }

    public void OpenAQuote(int row)
    {
        Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]")).click();
     //   return Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]"));
    }

//    public WebElement OpenQuoteDetails(int row)
//    {
//        Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]//td[1]")).click();
//        return Driver.getDriver().findElement(By.xpath("//table//tbody//tr["+row+"]//td[7]"));
//    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                // File has been found, it can now be deleted:
                //dirContents[i].delete();
                return true;
            }
        }
        return false;
    }
}