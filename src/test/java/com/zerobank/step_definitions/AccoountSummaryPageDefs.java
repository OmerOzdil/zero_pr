package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccoountSummaryPageDefs {

    @Then("The page should the title {string}")
    public void The_page_should_the_title(String expectedTitle) {

        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("the page should contains the followings")
    public void the_page_should_contains_the_followings(List<String> expectedTitles) {

        System.out.println(new AccountSummaryPage().getElements());

        Assert.assertEquals(expectedTitles,new AccountSummaryPage().getElements());
    }

    @Then("The user must see the following coloums")
    public void the_user_must_see_the_following_coloums(List<String> expectedColoums) {
        System.out.println(new AccountSummaryPage().getColoums());
        Assert.assertEquals(expectedColoums,new AccountSummaryPage().getColoums());
    }
    @When("The user navigates to {string}")
    public void the_user_navigates_to(String tabName) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.navigateToTab(tabName);
    }
    @Then("The user should the default option as {string}")
    public void the_user_should_the_default_option_as(String string) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<WebElement> dropDownOptions = accountActivityPage.getDropDownOptions().getOptions();

//        List<String> options= BrowserUtils.getElementsText(dropDownOptions);
//        System.out.println(options);

//        for (WebElement dropDownOption : dropDownOptions) {
//            System.out.println(dropDownOption.getText());
//
//        }
        System.out.println(accountActivityPage.getDropDownOptions().getFirstSelectedOption().isSelected());
        String actualDefault= accountActivityPage.getDropDownOptions().getFirstSelectedOption().getText();
        //System.out.println(accountActivityPage.getDropDownOptions().getFirstSelectedOption().getText());
        String expectedDefault=string;
        Assert.assertEquals(expectedDefault,actualDefault);
    }
    @Then("the dropdown has to contains following options")
    public void the_dropdown_has_to_contains_following_options(List<String> expectedDropdownOptions) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();

        List<WebElement> options=accountActivityPage.getDropDownOptions().getOptions();

        List<String> actualoptionList=BrowserUtils.getElementsText(options);
        Assert.assertEquals(expectedDropdownOptions,actualoptionList);

    }
    @Then("The transaction table coloums mus have the followings")
    public void the_transaction_table_coloums_mus_have_the_followings(List<String> expectedtableColoums) {
        BrowserUtils.waitFor(1);
        
        System.out.println(new AccountActivityPage().getTransactionColoums());
        Assert.assertEquals(expectedtableColoums,new AccountActivityPage().getTransactionColoums());
    }

    @When("the user clicks on {string} link on the Account Summary Page")
    public void the_user_clicks_on_link_on_the_Account_Summary_Page(String string) {
        new AccountSummaryPage().clickOn(string);
    }

    }
