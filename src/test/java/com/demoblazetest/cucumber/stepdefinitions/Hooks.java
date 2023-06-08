package com.demoblazetest.cucumber.stepdefinitions;

import com.demoblazetest.cucumber.util.TestContextSetup;
import io.cucumber.java.After;

public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }
    
    @After
    public void teardown(){
        testContextSetup.testBase.webDriverManager().quit();
    }
}
