package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("The user logged in with {string} {string}")
    public void the_user_logged_in_with(String username, String password) {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitForVisibility(new LoginPage().userNameInput,5);
        new LoginPage().login(username,password);

    }
    @Then("The user should be able to ne in the {string} page")
    public void the_user_should_be_able_to_ne_in_the_page(String expectedTitle) {
        String actualtitle=Driver.get().getTitle();
        System.out.println("actualtitle = " + actualtitle);

        Assert.assertTrue(actualtitle.contains(expectedTitle));

    }

    @Then("The user should see the message {string}")
    public void the_user_should_see_the_message(String expectedMessage) {

        String actualMessage= new LoginPage().getMessage();
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
