package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement AccountDropDown;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//tr/th")
    public List<WebElement> transactionColoums;


    public List<String> getTransactionColoums() {

        List<String> getTexts = new ArrayList<>();
        getTexts = BrowserUtils.getElementsText(transactionColoums);
        return getTexts;
    }

    public Select getDropDownOptions(){

        return new Select(AccountDropDown);
    }

}
