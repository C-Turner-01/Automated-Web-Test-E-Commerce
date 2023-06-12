package com.demoblazetest.cucumber.stepdefinitions;

import com.demoblazetest.cucumber.pages.AddressFormPage;
import com.demoblazetest.cucumber.util.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class AddressFormStepdefs {

    TestContextSetup testContextSetup;
    AddressFormPage addressFormPage;

    private static final Logger logger = LogManager.getLogger(AddressFormStepdefs.class);

    public AddressFormStepdefs(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @And("I fill form details {string} {string} {string} {string}")
    public void iFillFormDetails(String name, String country, String city, String creditCardNumber) {
        addressFormPage = testContextSetup.pageObjectManager.goToAddressFormPage();
        testContextSetup.genericUtils.implicitTimeOut(20);
        addressFormPage.fillInFormDetails(name, country, city, creditCardNumber);
        logger.info("Filled in form details");
    }

    @And("I click the purchase button")
    public void iClickThePurchaseButton() {
        testContextSetup.genericUtils.implicitTimeOut(10);
        addressFormPage.clickPurchase();
        logger.info("Clicked purchase button");
    }

    @Then("I should see a confirmation message showing that the item has been purchased")
    public void iShouldSeeAConfirmationMessageShowingThatTheItemHasBeenPurchased() {
        testContextSetup.genericUtils.implicitTimeOut(10);
        String confirmationMessage = "Thank you for your purchase!";
        String actualMessage = addressFormPage.getPurchaseMessage();
        Assertions.assertEquals(confirmationMessage, actualMessage);
        logger.info("Confirmed if confirmation message is correct");
    }

}
