package com.demoblazetest.cucumber.stepdefinitions;

import com.demoblazetest.cucumber.pages.CartPage;
import com.demoblazetest.cucumber.pages.HomePage;
import com.demoblazetest.cucumber.util.WebAutomationUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AddingProductsToCartStepdefs {

    private static WebDriver webDriver;
    private HomePage homePage;
    private CartPage cartPage;

    private static ChromeDriverService service;
    private static final String DRIVER_LOCATION = "src\\test\\resources\\chromedriver.exe";

    private static final Logger logger = LogManager.getLogger(AddingProductsToCartStepdefs.class);

    private String firstProductName;
    private String secondProductName;

    @Before
    public void setup(){
        service = WebAutomationUtil.getChromeDriverService(DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(service, options);
        webDriver.manage().window().maximize();

    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage = new HomePage(webDriver);
        logger.info("Opened homepage");
    }

    @When("I click the link for the first product {string}")
    public void iClickTheLinkForTheFirstProduct(String arg0) {
        if("laptopOne".equals(arg0)){
            homePage.goToLaptopSection();
        }else if("monitorOne".equals(arg0)){
            homePage.goToMonitorSection();
        } else if (!"mobileOne".equals(arg0)){
            logger.error("First product not found");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement firstProductElement = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a"));
        firstProductName = firstProductElement.getAttribute("innerHTML");
        webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a")).click();
        logger.info("Found first product");
    }

    @And("I click the add to cart")
    public void iClickTheAddToCart() {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();
        logger.info("Added first product to cart");
    }

    @And("I click the ok button to the confirmation message")
    public void iClickTheOkButtonToTheConfirmationMessage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.switchTo().alert().accept();
        logger.info("Closed alert");
    }

    @And("I navigate to the homepage")
    public void iNavigateToTheHomepage() {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("/html/body/nav/div/div/ul/li[1]/a")).click();
        logger.info("Navigated back to homepage");
    }

    @And("I click the link for the second product {string}")
    public void iClickTheLinkForTheSecondProduct(String arg0) {
        if("laptopTwo".equals(arg0)){
            homePage.goToLaptopSection();
        }else if("monitorTwo".equals(arg0)){
            homePage.goToMonitorSection();
        } else if (!"mobileTwo".equals(arg0)){
            logger.error("Second product not found");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement secondProductElement = webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a"));
        secondProductName = secondProductElement.getAttribute("innerHTML");
        webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a")).click();
        logger.info("Found second product");
    }

    @And("I click add to cart for the second product")
    public void iClickAddToCartForTheSecondProduct() {
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();
        logger.info("Added second product to cart");
    }

    @And("I click the ok button to the second confirmation message")
    public void iClickTheOkButtonToTheSecondConfirmationMessage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.switchTo().alert().accept();
        logger.info("Closed alert");
    }

    @And("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        cartPage = homePage.goToCartPage();
        logger.info("Opened cart page");
    }

    @Then("I should view both items in my basket")
    public void iShouldViewBothItemsInMyBasket() {

        //order of items in cart is variable so code has been written accordingly
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement firstBasketItemElement = webDriver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[1]/td[2]"));
        WebElement secondBasketItemElement = webDriver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[2]/td[2]"));
        String basketItems = firstBasketItemElement.getAttribute("innerHTML") + secondBasketItemElement.getAttribute("innerHTML");
        System.out.println(basketItems);

        Boolean firstProductAdded = basketItems.contains(firstProductName);
        Boolean secondProductAdded = basketItems.contains(secondProductName);

        Assertions.assertTrue(firstProductAdded && secondProductAdded);
        logger.info("Asserted if both items have been added to the cart");

    }

    @After
    public void teardown(){
        webDriver.close();
        webDriver.quit();
    }

}
