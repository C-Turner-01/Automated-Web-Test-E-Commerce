package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public HomePage homePage;
    private CartPage cartPage;
    public WebDriver webDriver;

    public PageObjectManager(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public HomePage goToHomePage(){
        homePage = new HomePage(webDriver);
        return homePage;
    }

    public CartPage goToCartPage(String firstProduct, String secondProduct){
        cartPage = new CartPage(webDriver, firstProduct, secondProduct);
        return cartPage;
    }
    public CartPage getCartPage(){
        return cartPage;
    }
}
