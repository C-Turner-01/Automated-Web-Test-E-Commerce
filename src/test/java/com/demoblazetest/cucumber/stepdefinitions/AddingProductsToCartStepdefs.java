package com.demoblazetest.cucumber.stepdefinitions;

import com.demoblazetest.cucumber.pages.CartPage;
import com.demoblazetest.cucumber.pages.HomePage;
import com.demoblazetest.cucumber.util.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class AddingProductsToCartStepdefs {

    TestContextSetup testContextSetup;
    private HomePage homePage;
    private CartPage cartPage;

    private static final Logger logger = LogManager.getLogger(AddingProductsToCartStepdefs.class);

    private String firstProductName;
    private String secondProductName;

    public AddingProductsToCartStepdefs(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage = testContextSetup.pageObjectManager.gotoHomePage();
        logger.info("Opened homepage");
    }

    @When("I click the link for the first product {string}")
    public void iClickTheLinkForTheFirstProduct(String arg0) {
        if("laptopOne".equals(arg0)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToLaptopSection();
        }else if("monitorOne".equals(arg0)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToMonitorSection();
        } else if (!"mobileOne".equals(arg0)){
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

    @And("I click the link for the second product {string}")
    public void iClickTheLinkForTheSecondProduct(String arg0) {
        if("laptopTwo".equals(arg0)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToLaptopSection();
        }else if("monitorTwo".equals(arg0)){
            testContextSetup.genericUtils.implicitTimeOut(30);
            homePage.goToMonitorSection();
        } else if (!"mobileTwo".equals(arg0)){
            logger.error("Second product not found");
        }
        testContextSetup.genericUtils.threadSleep(5000);
        secondProductName =homePage.findProductName(2);
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
        cartPage = homePage.goToCartPage();
        logger.info("Opened cart page");
    }

    @Then("I should view both items in my basket")
    public void iShouldViewBothItemsInMyBasket() {

        //order of items in cart is variable so code has been written to account for this
        testContextSetup.genericUtils.implicitTimeOut(30);
        String basketItems = cartPage.getBasketItems();
        System.out.println(basketItems);

        Boolean firstProductAdded = basketItems.contains(firstProductName);
        Boolean secondProductAdded = basketItems.contains(secondProductName);

        Assertions.assertTrue(firstProductAdded && secondProductAdded);
        logger.info("Asserted if both items have been added to the cart");

    }

}
