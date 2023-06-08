package com.demoblazetest.cucumber.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase  {
    public WebDriver webDriver;
    private ChromeDriverService service;
    FileInputStream fis;
    Properties properties;
    private String browser;
    private String DRIVER_LOCATION;

    public WebDriver webDriverManager() throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
        properties = new Properties();
        properties.load(fis);
        browser = properties.getProperty("browser");
        DRIVER_LOCATION = System.getProperty("user.dir") + properties.getProperty("driverpath");


        if(webDriver == null){
            if(browser.equalsIgnoreCase("chrome")) {
                service = ChromeDriverServiceSetup.getChromeDriverService(DRIVER_LOCATION);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                webDriver = new ChromeDriver(service, options);
                webDriver.manage().window().maximize();
            }
    }
        return webDriver;

    }
}
