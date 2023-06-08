package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver webDriver;
    private String firstProductName;
    private String secondProductName;
    private By cartPageLink = new By.ById("cartur");
    private By firstBasketItem = By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[1]/td[2]");
    private By secondBasketItem = By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[2]/td[2]");

    public CartPage(WebDriver webDriver, String firstProductName, String secondProductName) {
        this.webDriver = webDriver;
        this.firstProductName = firstProductName;
        this.secondProductName = secondProductName;
        goToCartPage();
    }

    private void goToCartPage(){
        webDriver.findElement(cartPageLink).click();
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getBasketItems(){
        WebElement firstBasketItemElement = webDriver.findElement(firstBasketItem);
        WebElement secondBasketItemElement = webDriver.findElement(secondBasketItem);
        String basketItems = firstBasketItemElement.getAttribute("innerHTML") + secondBasketItemElement.getAttribute("innerHTML");
        return basketItems;
    }

    public String getFirstProductName() {
        return firstProductName;
    }

    public String getSecondProductName() {
        return secondProductName;
    }

    public void setFirstProductName(String firstProductName) {
        this.firstProductName = firstProductName;
    }

    public void setSecondProductName(String secondProductName) {
        this.secondProductName = secondProductName;
    }
}
