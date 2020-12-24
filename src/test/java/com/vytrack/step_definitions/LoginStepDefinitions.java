package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
     LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("http://qa1.vytrack.com");
    }

        @When("user logs in")
        public void user_logs_in() throws InterruptedException {
           loginPage.login();
           Thread.sleep(3000);
        }


    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {

        String expected = "Dashboard";
        String actual = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals( "Title is not correct" , expected, actual);
        // In TestNG, comment is coming after, in Junit comment comes before.

        System.out.println("I see Dashboard page!");
        Driver.closeDriver();
    }

    @Then("user should see {string} page")
    public void user_should_see_page(String string) {
        String actual = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("Page title is not correct!", string, actual);
    }

    //test parametrization
     //this is how we implement data driven test.
     // When user logs in as "driver"
    // When user logs in as "sales manager"
    // When user logs in as "store manager"
    //the string here is referring role. it will handle all of these role cases.
    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        //so we use our login method with one parameter created in the base page
        loginPage.login(string);

    }

    // When user logs in with "storemanager85" username and "wrong" password
    // String string = "storemanager85";
    // String string2 = "wrong";
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @Then("user verifies that {string} message is displayed")//we can rename the String here
    //String expected = "Invalid username or password."
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult = loginPage.getWarningMessageText();
        Assert.assertEquals(expected,actualResult);
    }


    }

