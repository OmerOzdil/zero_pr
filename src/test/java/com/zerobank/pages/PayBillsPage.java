package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="sp_amount")
    public WebElement amountBox;

    @FindBy(id = "sp_date")
    public WebElement dateBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//span[contains(text(),'The payment was successfully submitted.')]")
    public WebElement messagePopUp;


    public void paymentProcess(){
        amountBox.sendKeys("345");
        dateBox.sendKeys("5");
        payButton.click();
    }
}
