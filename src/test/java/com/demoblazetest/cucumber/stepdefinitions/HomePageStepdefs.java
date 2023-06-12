package com.demoblazetest.cucumber.stepdefinitions;

import com.demoblazetest.cucumber.pages.CartPage;
import com.demoblazetest.cucumber.pages.HomePage;
import com.demoblazetest.cucumber.util.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePageStepdefs {

    TestContextSetup testContextSetup;
    private HomePage homePage;
    private CartPage cartPage;
    private String firstProductName;
    private String secondProductName;

    private static final Logger logger = LogManager.getLogger(HomePageStepdefs.class);

    public HomePageStepdefs(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage = testContextSetup.pageObjectManager.goToHomePage();
        logger.info("Opened homepage");
    }

    @When("^I click the link for the first product (.+)$")
    public void iClickTheLinkForTheFirstProduct(String productSection) {
        if("laptopOne".equals(productSection)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToLaptopSection();
        }else if("monitorOne".equals(productSection)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToMonitorSection();
        } else if (!("mobileOne".equals(productSection) || "laptopOne".equals(productSection) || "monitorOne".equals(productSection))){
            logger.error("First product not found");
        }
        testContextSetup.genericUtils.threadSleep(5000);
        firstProductName = homePage.findProductName(1);
        homePage.clickOnProduct(1);
        logger.info("Found first product");
    }

    @And("I click the add to cart")
    public void iClickTheAddToCart() {
        testContextSetup.genericUtils.implicitTimeOut(30);
        homePage.clickAddToCart();
        logger.info("Added first product to cart");
    }

    @And("I click the ok button to the confirmation message")
    public void iClickTheOkButtonToTheConfirmationMessage() {
        testContextSetup.genericUtils.threadSleep(3000);
        homePage.closeAddedToCartConfirmationMessage();
        logger.info("Closed alert");
    }

    @And("I navigate to the homepage")
    public void iNavigateToTheHomepage() {
        testContextSetup.genericUtils.implicitTimeOut(30);
        homePage.goBackToHomePage();
        logger.info("Navigated back to homepage");
    }

    @And("^I click the link for the second product (.+)$")
    public void iClickTheLinkForTheSecondProduct(String productSection) {
        if("laptopTwo".equals(productSection)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToLaptopSection();
        }else if("monitorTwo".equals(productSection)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToMonitorSection();
        } else if (!"mobileTwo".equals(productSection)){
            logger.error("Second product not found");
        }
        testContextSetup.genericUtils.threadSleep(5000);
        secondProductName = homePage.findProductName(2);
        homePage.clickOnProduct(2);
        logger.info("Found second product");
    }

    @And("I click add to cart for the second product")
    public void iClickAddToCartForTheSecondProduct() {
        testContextSetup.genericUtils.implicitTimeOut(30);
        homePage.clickAddToCart();
        logger.info("Added second product to cart");
    }

    @And("I click the ok button to the second confirmation message")
    public void iClickTheOkButtonToTheSecondConfirmationMessage() {
        testContextSetup.genericUtils.threadSleep(3000);
        homePage.closeAddedToCartConfirmationMessage();
        logger.info("Closed alert");
    }

    @And("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        cartPage = testContextSetup.pageObjectManager.goToCartPage(firstProductName, secondProductName);
        logger.info("Opened cart page");
    }

}
