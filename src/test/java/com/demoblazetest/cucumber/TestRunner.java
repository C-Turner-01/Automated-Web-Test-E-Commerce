package com.demoblazetest.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json", "rerun:target/rerun.txt"},
        monochrome = true,
        glue = {"com.demoblazetest.cucumber.stepdefinitions"}
        //,tags ="@AddingItemsToCart"
        ,tags ="@PurchasingItem"
)
public class TestRunner {

}
