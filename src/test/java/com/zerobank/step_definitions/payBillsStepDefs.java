package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class payBillsStepDefs {

    @When("The user enter amount, put a date,press the pay button and {string}")
    public void the_user_enter_amount_put_a_date_press_the_pay_button_and(String expectedMessage) {

        new PayBillsPage().paymentProcess();
        Assert.assertEquals(expectedMessage,new PayBillsPage().messagePopUp.getText());
    }

    @Then("The message {string} pop up")
    public void the_message_pop_up(String string) {
      new PayBillsPage().payButton.click();

        System.out.println(new PayBillsPage().dateBox.getAttribute("validationmessage"));
        System.out.println(new PayBillsPage().dateBox.isDisplayed());

    }

    @Then("the user clicks on {string} subTab")
    public void the_user_clicks_on_subTab(String string) {
       PayBillsPage payBillsPage = new PayBillsPage();
       payBillsPage.nativageToSubTab(string);

    }

    @Then("the user creates new payee using the following informations")
    public void the_user_creates_new_payee_using_the_following_informations(Map<String,String> PayeeDetails) {
    PayBillsPage payBillsPage = new PayBillsPage();
        System.out.println(PayeeDetails.get("Payee Name"));
        BrowserUtils.waitForVisibility(payBillsPage.payeeName,5);
        payBillsPage.payeeName.sendKeys(PayeeDetails.get("Payee Name"));
        payBillsPage.payeeAddress.sendKeys(PayeeDetails.get("Payee Address"));
        payBillsPage.payeeAccount.sendKeys(PayeeDetails.get("Account"));
        payBillsPage.payeeDetails.sendKeys(PayeeDetails.get("Payee details"));
        payBillsPage.addBUtton.click();
        BrowserUtils.waitFor(1);
    }
    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        String actual=new PayBillsPage().confirmationMessage.getText();
        Assert.assertEquals(string,actual);

    }

    @Then("the following currencies should available")
    public void the_following_currencies_should_available(List<String> expectedCurrencyOptions) {
        PayBillsPage payBillsPage = new PayBillsPage();
        List<WebElement> options =payBillsPage.getCurrencyOptions().getOptions();
        List<String> actualCurrencyOptions=new ArrayList<>();

        for (int i = 1; i <options.size() ; i++) {
            actualCurrencyOptions.add(options.get(i).getText());
        }
         Assert.assertEquals(expectedCurrencyOptions,actualCurrencyOptions);
        }
    @When("the user clicks on the calculate button without entering any value")
    public void the_user_clicks_on_the_calculate_button_without_entering_any_value() {
        BrowserUtils.waitForVisibility(new PayBillsPage().calculateButton,3);
       new PayBillsPage().calculateButton.click();
        BrowserUtils.waitFor(2);
    }
    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expectedErrorMessage) {

        Alert alert= Driver.get().switchTo().alert();
        String actualErrorMessage= alert.getText();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    }


