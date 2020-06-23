package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "alert_content")
    public WebElement confirmationMessage;

    @FindBy(id = "add_new_payee")
    public WebElement addBUtton;

    @FindBy(id = "pc_currency")
    public WebElement currencySelectButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateButton;


    public Select getCurrencyOptions(){
        BrowserUtils.waitForVisibility(currencySelectButton,3);
        return new Select(currencySelectButton);
    }



    public void nativageToSubTab(String str){
        String xpath="//a[text()='"+str+"']";
        Driver.get().findElement(By.xpath(xpath)).click();
    }

    public void paymentProcess(){
        amountBox.sendKeys("345");
        dateBox.sendKeys("5");
        payButton.click();
    }
}
