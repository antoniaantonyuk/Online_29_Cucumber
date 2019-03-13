package com.brite_erp.step_definitions;

import com.brite_erp.pages.ContactsPage;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.DBUtilities;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactsPageStepDefinitions extends BrowserUtils{
    @When("^user goes to contacts page$")
    public void user_goes_to_contacts_page() throws Throwable {

        ContactsPage contactsPage = new ContactsPage();
        waitForClickablility(contactsPage.contacts,10);
        contactsPage.contacts.click();

    }

    @Then("^all contact names should be match with database records$")
    public void all_contact_names_should_be_match_with_database_records() throws Throwable {

        ContactsPage contactsPage = new ContactsPage();
        List<String> productNames = BrowserUtils.getElementsText(contactsPage.contactName);

        DBUtilities.createConnection();
        String sql = "select name from res_partner\n" +
                "order by name;";

        List<Object> names = DBUtilities.getColumnData(sql,"name");
//        System.out.println(names);

        List<String> contactNames = new ArrayList <String>();

        for (Object o : names){
            contactNames.add(o.toString());
        }
        System.out.println(productNames);
        System.out.println(contactNames);

//        Assert.assertTrue(contactNames.containsAll(productNames));

    }
}
