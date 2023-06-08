package com.demoblazetest.cucumber.util;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class ChromeDriverServiceSetup {

    public static ChromeDriverService getChromeDriverService(String path) {
        return new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File(path))
                .usingAnyFreePort()
                .build();
    }
}
