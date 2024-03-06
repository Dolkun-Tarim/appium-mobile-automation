package com.thescore.regression;

import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeSuite;

public class AppiumBaseTest {

    public AndroidDriver driver;

    @BeforeSuite(alwaysRun=true)
    public void setUp() throws Exception {
        MutableCapabilities capabilities = new UiAutomator2Options();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        //capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 60000);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);
        capabilities.setCapability("appium:app","/Users/unitedcoder/IdeaProjects/testng-appium-app-browserstack-sdk/android/testng-examples/thescore_24_3_0.apk");
        capabilities.setCapability("appium:NoReset",false);
        //capabilities.setCapability("appium:appPackage","com.fivemobile.thescore");
        capabilities.setCapability("appium:appWaitForLaunch",true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),capabilities);
    }
    @AfterSuite(alwaysRun=true)
    public void tearDown() {
        driver.quit();
    }
}
