package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountActivityPageDefs {

    @Then("The user click on savings")
    public void the_user_click_on_savings() {
        // Write code here that turns the phrase above into concrete actions
       new AccountSummaryPage().savingsButton.click();
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String Savings) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<WebElement> list =accountActivityPage.getDropDownOptions().getOptions();
        List<String> listNames= BrowserUtils.getElementsText(list);
        String actualseen= accountActivityPage.getDropDownOptions().getFirstSelectedOption().getText();

        System.out.println(actualseen);
        Assert.assertEquals(Savings,actualseen);
        //Assert.assertTrue(accountActivityPage.getDropDownOptions().getFirstSelectedOption().getText().contains(Savings));
    }
    @When("the user clicks on Brokerage link on the Account Summary Page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_Page() {
        new AccountSummaryPage().brokerageButton.click();
    }

    @Then("the user click on {string} tab")
    public void the_user_click_on_tab(String string) {
        new AccountActivityPage().navigatetosubtab(string);
    }
    @Then("the user enters date range from {string} to {string} and click search")
    public void the_user_enters_date_range_from_to_and_click_search(String string, String string2) {
        new AccountActivityPage().enterDates("2012-09-01","2012-09-06");
        new AccountActivityPage().signButton.click();
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        System.out.println(accountActivityPage.toDateBox.getAttribute("value"));

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitForVisibility(accountActivityPage.descriptionBox,4);
        accountActivityPage.descriptionBox.clear();
        accountActivityPage.descriptionBox.sendKeys(string);
    }

    @When("the user clicks search")
    public void the_user_clicks_search() {
        new AccountActivityPage().signButton.click();
    }
    @Then("the result table should only show descriptions containing {string}")
    public void the_result_table_should_only_show_descriptions_containing(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitFor(2);
        accountActivityPage.getTransactionsResults(string);
        for(int i=0;i<accountActivityPage.getTransactionsResults(string).size();i++){
            Assert.assertTrue(accountActivityPage.getTransactionsResults(string).get(i).contains(string));
        }
    }
    @Then("the result table should not show descriptions containing {string}")
    public void the_result_table_should_not_show_descriptions_containing(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Assert.assertFalse(accountActivityPage.getTransactionsResults(string).contains(string));
    }


}
