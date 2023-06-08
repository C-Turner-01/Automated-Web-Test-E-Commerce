package com.demoblazetest.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver webDriver;
    private CartPage cartPage;
    private By cartPageLink = new By.ById("cartur");
    private String homePageURL = "https://www.demoblaze.com/index.html";
    private By laptopSection = By.cssSelector("#itemc[onclick='byCat(\\'notebook\\')']");
    private By monitorSection = By.cssSelector("a#itemc.list-group-item[onclick='byCat(\\'monitor\\')']");
    private By firstProduct = By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a");
    private By secondProduct = By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a");
    private By addToCart = By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a");
    private By homeTab = By.xpath("/html/body/nav/div/div/ul/li[1]/a");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToHomePage();
    }

    private void goToHomePage() {
        webDriver.get(homePageURL);
    }

    public void goToLaptopSection() {
        webDriver.findElement(laptopSection).click();
    }

    public void goToMonitorSection() {
        webDriver.findElement(monitorSection).click();
    }

    private By selectProduct(int productNum){
        By product = null;
        if(productNum == 1){
            product = firstProduct;
        } else if (productNum == 2){
            product = secondProduct;
        } else {
            System.out.println("Product Number out of range");
        }
        return product;
    }

    public String findProductName(int productNum){
        By product = selectProduct(productNum);
        WebElement firstProductElement = webDriver.findElement(product);
        String productName = firstProductElement.getAttribute("innerHTML");
        return productName;
    }
    public void clickOnProduct(int productNum){
        By product = selectProduct(productNum);
        webDriver.findElement(product).click();
    }

    public void clickAddToCart(){
        webDriver.findElement(addToCart).click();
    }

    public void closeAddedToCartConfirmationMessage(){
        webDriver.switchTo().alert().accept();
    }

    public void goBackToHomePage(){
        webDriver.findElement(homeTab).click();
    }

}
