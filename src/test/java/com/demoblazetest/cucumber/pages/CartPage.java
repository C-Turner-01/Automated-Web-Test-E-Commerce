package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
