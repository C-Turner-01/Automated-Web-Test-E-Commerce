package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver webDriver;
    private By cartPage = new By.ById("cartur");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToHomePage();
    }

    private void goToHomePage() {
        webDriver.get("https://www.demoblaze.com/index.html");
    }

    public CartPage goToCartPage() {
        webDriver.findElement(cartPage).click();
        return new CartPage(webDriver);
    }
}
