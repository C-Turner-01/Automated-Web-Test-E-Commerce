package com.demoblazetest.cucumber.stepdefinitions;

import com.demoblazetest.cucumber.pages.CartPage;
import com.demoblazetest.cucumber.util.TestContextSetup;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class CartPageStepdefs {
    TestContextSetup testContextSetup;
    private CartPage cartPage;

    private static final Logger logger = LogManager.getLogger(CartPageStepdefs.class);

    private String firstProductName;
    private String secondProductName;

    public CartPageStepdefs(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("I should view both items in my basket")
    public void iShouldViewBothItemsInMyBasket() {
        cartPage = testContextSetup.pageObjectManager.getCartPage();
        //order of items in cart is variable so code has been written to account for this
        testContextSetup.genericUtils.implicitTimeOut(50);
        String basketItems = cartPage.getBasketItems();
        System.out.println(basketItems);
        firstProductName = cartPage.getFirstProductName();
        secondProductName = cartPage.getSecondProductName();
        Boolean firstProductAdded = basketItems.contains(firstProductName);
        Boolean secondProductAdded = basketItems.contains(secondProductName);

        Assertions.assertTrue(firstProductAdded && secondProductAdded);
        logger.info("Asserted if both items have been added to the cart");

    }
}
