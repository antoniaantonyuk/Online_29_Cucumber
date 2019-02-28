package com.brite_erp.step_definitions;
import com.brite_erp.utilities.BrowserUtils;
import com.brite_erp.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.Map;

public class NewPublichChannel {

    Pages pages=new Pages();

    @Given("User log in")
    public void user_log_in() {
        pages.login().singIn.click();

        //pages.login().login();

    }

    @Then("Create new chanell NewChannelToCheck")
    public void create_new_chanell(String arg1) {


    }

    @Then("User log out")
    public void user_log_out() {
    }

    @Given("User should log in with user_email and password")
    public void user_should_log_in_with_and(Map<String, String> words) {

    }

    @Then("Channel NewChannelToCheck should be visible")
    public void channel_should_be_visible(String arg1) {

    }

    @Then("User should be able to join to channel")
    public void user_should_be_able_to_join_to_channel()  {

    }

    @Given("Main user should log in")
    public void main_user_should_log_in()  {

    }

    @Then("Main user shoul delete created channel")
    public void main_user_shoul_delete_created_channel() {
    }

}
