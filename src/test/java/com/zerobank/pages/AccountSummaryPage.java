package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage {

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".board-header")
    public List<WebElement> headers;

    @FindBy(xpath = "//div[@class='board'][3]//table//thead//th")
    public List<WebElement> CreditAccountColoums;

    @FindBy(xpath = "(//a[text()='Savings'])[1]")
    public WebElement savingsButton;

    @FindBy(xpath = "//a[text()='Brokerage']")
    public WebElement brokerageButton;


    public void clickOn(String string){
        String el="//a[text()='"+string+"']";
        WebElement element=Driver.get().findElement(By.xpath(el));
        element.click();


    }


    public void navigateToTab(String tabName){
        String tab = "//li/a[contains(text(),'"+tabName+"')]";
        Driver.get().findElement(By.xpath(tab)).click();
    }

    public List<String> getColoums(){
        List<String> Coloums = new ArrayList<>();
        for (WebElement creditAccountColoum : CreditAccountColoums) {
            Coloums.add(creditAccountColoum.getText());
        }
        return Coloums;
    }

    public List<String> getElements(){
        List<String> elements = new ArrayList<>();
        for (WebElement header : headers) {
            elements.add(header.getText());
        }
        return elements;
    }
}
