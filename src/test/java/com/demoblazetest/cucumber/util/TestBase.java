package com.demoblazetest.cucumber.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase  {
    public WebDriver webDriver;
    private ChromeDriverService chromeService;
    FileInputStream fis;
    File logger;
    Properties properties;
    private String browser;
    private String DRIVER_LOCATION;

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
                chromeService = ChromeDriverServiceSetup.getChromeDriverService(DRIVER_LOCATION);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                webDriver = new ChromeDriver(chromeService, options);
                webDriver.manage().window().maximize();
            } else if(browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.firefox.marionette", DRIVER_LOCATION);
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                webDriver.manage().deleteAllCookies();
                webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }

    }
        return webDriver;

    }
}
