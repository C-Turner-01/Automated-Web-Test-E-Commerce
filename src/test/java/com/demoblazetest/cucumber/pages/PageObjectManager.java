package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public HomePage homePage;
    public CartPage cartPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage gotoHomePage(){
        homePage = new HomePage(driver);
        return homePage;
    }

    public CartPage CartPage(){
        cartPage = new CartPage(driver);
        return cartPage;
    }
}
