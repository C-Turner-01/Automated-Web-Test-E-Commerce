package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver webDriver;
    private By firstBasketItem = By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[1]/td[2]");
    private By secondBasketItem = By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[2]/td[2]");

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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
}
