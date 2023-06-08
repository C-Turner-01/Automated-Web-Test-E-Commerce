package com.demoblazetest.cucumber.util;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GenericUtils {

    WebDriver webDriver;

    public GenericUtils(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void implicitTimeOut(int secs){
        webDriver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
    }
    public void threadSleep(int secs){
        try {
            Thread.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
