package com.demoblazetest.cucumber.util;

import com.demoblazetest.cucumber.pages.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
public PageObjectManager pageObjectManager;
public TestBase testBase;
public GenericUtils genericUtils;

public TestContextSetup() throws IOException {
    testBase = new TestBase();
    genericUtils = new GenericUtils(testBase.webDriverManager());
    pageObjectManager = new PageObjectManager(testBase.webDriverManager());
}
}
