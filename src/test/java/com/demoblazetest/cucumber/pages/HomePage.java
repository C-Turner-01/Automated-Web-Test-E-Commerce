package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

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

    public void goToLaptopSection() {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("#itemc[onclick='byCat(\\'notebook\\')']")).click();
    }


    public void goToMonitorSection() {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("a#itemc.list-group-item[onclick='byCat(\\'monitor\\')']")).click();
    }

}
