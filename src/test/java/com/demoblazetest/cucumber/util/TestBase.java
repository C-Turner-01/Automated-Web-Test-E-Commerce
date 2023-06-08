package com.demoblazetest.cucumber.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public WebDriver webDriver;
    private ChromeDriverService service;
    private static final String DRIVER_LOCATION = "src\\test\\resources\\chromedriver.exe";
    public WebDriver webDriverManager() {
        if(webDriver == null){
        service = WebAutomationUtil.getChromeDriverService(DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(service, options);
        webDriver.manage().window().maximize();
    }
        return webDriver;

    }
}
