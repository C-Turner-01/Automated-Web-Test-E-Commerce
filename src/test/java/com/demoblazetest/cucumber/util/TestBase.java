package com.demoblazetest.cucumber.util;

import com.demoblazetest.cucumber.stepdefinitions.CartPageStepdefs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase  {
    public WebDriver webDriver;
    private ChromeDriverService service;
    FileInputStream fis;
    File logger;
    Properties properties;
    private String browser;
    private String DRIVER_LOCATION;
    //private static final Logger logger = LogManager.getLogger(TestBase.class);

    public WebDriver webDriverManager() throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
        logger = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\logFile.log");
        properties = new Properties();
        properties.load(fis);
        browser = properties.getProperty("browser");
        DRIVER_LOCATION = System.getProperty("user.dir") + properties.getProperty("driverpath");


        if(webDriver == null){
            logger.delete();
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
