package com.demoblazetest.cucumber.util;

import com.demoblazetest.cucumber.pages.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
public WebDriver webDriver;
public PageObjectManager pageObjectManager;
public TestBase testBase;
public GenericUtils genericUtils;
public TestContextSetup(){
    testBase = new TestBase();
    genericUtils = new GenericUtils(testBase.webDriverManager());
    pageObjectManager = new PageObjectManager(testBase.webDriverManager());
}
}
