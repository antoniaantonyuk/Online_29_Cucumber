package com.brite_erp.step_definitions;
import com.brite_erp.pages.RepairsPage;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.DBUtilities;
import com.brite_erp.utilities.Driver;
import com.brite_erp.utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.util.List;
import java.util.Map;

public class ReapirsDataStepDefinitions extends BrowserUtils {

    @When("^user adds products to repair from excel$")
    public void user_adds_products_to_repair_from_excel() throws Throwable  {

        String filePath = "./src/test/resources/test-data/repairsdata.xlsx";
        ExcelUtil excelUtil = new ExcelUtil(filePath,"repairs");
        List<Map<String,String>> testData = excelUtil.getDataList();

        RepairsPage repairsPage = new RepairsPage();
        waitForClickablility(repairsPage.repairs,10);
        repairsPage.repairs.click();

        for (Map<String,String> repairsData : testData){

            waitForClickablility(repairsPage.create,10);
            repairsPage.create.click();

            waitForClickablility(repairsPage.reference,10);
            repairsPage.reference.clear();
            repairsPage.reference.sendKeys(repairsData.get("reference"));

            waitForVisibility(repairsPage.product,10);
            repairsPage.product.sendKeys(repairsData.get("Product to reapair"));
            waitForClickablility(repairsPage.productName(repairsData.get("Product to reapair")),10);
            repairsPage.productName(repairsData.get("Product to reapair")).click();

            repairsPage.customer.sendKeys(repairsData.get("customer"));
            waitForClickablility(repairsPage.customertName(repairsData.get("customer")),10);
            repairsPage.customertName(repairsData.get("customer")).click();

            repairsPage.save.click();
            wait(2);
        }

        }
    @Then("^all data of excel should be in the repair orders page$")
    public void all_data_of_excel_should_be_in_the_repair_orders_page() throws Throwable {

        RepairsPage repairsPage = new RepairsPage();
        repairsPage.repairs.click();

        String filePath = "./src/test/resources/test-data/repairsdata.xlsx";
        ExcelUtil excelUtil = new ExcelUtil(filePath,"repairs");
        List<Map<String,String>> testData = excelUtil.getDataList();

        DBUtilities.createConnection();
        String sql = "select p.name\n" +
                "from product_template p,product_product k, mrp_repair m\n" +
                "where p.id=k.product_tmpl_id and k.id=m.product_id;";
        List<Object> names = DBUtilities.getColumnData(sql,"name");
        System.out.println(names);


        List<String> referenceNumber = BrowserUtils.getElementsText(repairsPage.repairReference);
        System.out.println(referenceNumber);

        for (Map<String,String> dl:testData){
            System.out.println(dl.get("Product to reapair"));
            Assert.assertTrue(referenceNumber.contains(dl.get("reference")));
        }
    }

    @When("^user goes to the repairs page$")
    public void user_goes_to_the_repairs_page() throws Throwable {
        RepairsPage repairsPage = new RepairsPage();
        repairsPage.repairs.click();
    }

    @Then("^all names of Products to repair should be match with database records$")
    public void all_names_of_Products_to_repair_should_be_match_with_database_records() throws Throwable {
        RepairsPage repairsPage = new RepairsPage();
        List<String> productNames = BrowserUtils.getElementsText(repairsPage.productToRepair);
//        System.out.println(productNames);
        DBUtilities.createConnection();
        String sql = "select concat('[' ,p.default_code,'] ', p.name) as \"product_name\" \n" +
                "from product_template p,product_product k, mrp_repair m\n" +
                "where p.id=k.product_tmpl_id and k.id=m.product_id;";

        List<Object> names = DBUtilities.getColumnData(sql,"name");
        System.out.println(names);

        for(Object o: names){
            Assert.assertTrue(productNames.contains(o.toString()));
        }
    }

    @Test
    public void test(){
        RepairsPage repairsPage = new RepairsPage();
        List<String> productNames = BrowserUtils.getElementsText(repairsPage.productToRepair);
//        System.out.println(productNames);
        DBUtilities.createConnection();
        String sql = "select concat('[' ,p.default_code,'] ', p.name) as \"product_name\" \n" +
                "from product_template p,product_product k, mrp_repair m\n" +
                "where p.id=k.product_tmpl_id and k.id=m.product_id;";

        List<Object> names = DBUtilities.getColumnData(sql,"name");
        System.out.println(names);

        for(Object o: names){
            Assert.assertTrue(productNames.contains(o.toString()));
        }
    }

}
