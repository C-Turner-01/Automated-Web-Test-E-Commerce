package com.demoblazetest.cucumber.stepdefinitions;

import com.demoblazetest.cucumber.util.TestContextSetup;
import io.cucumber.java.After;

import java.io.IOException;

public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }
    
    @After
    public void teardown() throws IOException {
        testContextSetup.testBase.webDriverManager().quit();
    }
}
