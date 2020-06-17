package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
}
