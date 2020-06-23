package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement AccountDropDown;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//tr/th")
    public List<WebElement> transactionColoums;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signButton;

    @FindBy(id = "aa_description")
    public  WebElement descriptionBox;

    @FindBy(id = "aa_fromDate")
    public WebElement datesBox;

    @FindBy(id = "aa_toDate")
    public WebElement toDateBox;

    public void navigatetosubtab(String tab){

        String locate="//a[text()='"+tab+"']";
        Driver.get().findElement(By.xpath(locate)).click();
    }

    public void enterDates(String str, String str1){

        BrowserUtils.waitForVisibility(signButton,4);
        datesBox.sendKeys(str);
        toDateBox.sendKeys(str1);
        signButton.click();
    }
    public List<String> getTransactionsResults(String str) {

        BrowserUtils.waitForVisibility(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"),3);
        List<WebElement> onlineTransctions = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));
        //System.out.println(onlineTransctions.size());
        List<String> onlineTexts = BrowserUtils.getElementsText(onlineTransctions);
        return onlineTexts;
    }
    public List<String> getTransactionColoums() {

        List<String> getTexts = new ArrayList<>();
        getTexts = BrowserUtils.getElementsText(transactionColoums);
        return getTexts;
    }

    public Select getDropDownOptions(){
        return new Select(AccountDropDown);
    }

}
