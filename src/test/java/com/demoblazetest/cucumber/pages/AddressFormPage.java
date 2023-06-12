package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class AddressFormPage {

    private WebDriver webDriver;
    private By addressFormLink = By.xpath("/html/body/div[6]/div/div[2]/button");
    private By nameID = By.id("name");
    private By countryID = By.id("country");
    private By cityID = By.id("city");
    private By creditCardID = By.id("card");
    private By monthID = By.id("month");
    private By yearID = By.id("year");
    private By purchaseButton = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
    private By confirmationMessage = By.xpath("/html/body/div[10]/h2");

    public AddressFormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToAddressFormPage();
    }

    public void goToAddressFormPage(){
        webDriver.findElement(addressFormLink).click();
    }

    public void fillInFormDetails(String name, String country, String city, String creditCardNumber){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int year = date.getYear();
        webDriver.findElement(nameID).sendKeys(name);
        webDriver.findElement(countryID).sendKeys(country);
        webDriver.findElement(cityID).sendKeys(city);
        webDriver.findElement(creditCardID).sendKeys(creditCardNumber);
        webDriver.findElement(monthID).sendKeys("" + month);
        webDriver.findElement(yearID).sendKeys("" + year);
    }

    public void clickPurchase(){
        webDriver.findElement(purchaseButton).click();
    }

    public String getPurchaseMessage(){
        return webDriver.findElement(confirmationMessage).getText();
    }

}
