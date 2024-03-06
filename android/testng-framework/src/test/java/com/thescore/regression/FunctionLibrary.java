package com.thescore.regression;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FunctionLibrary {
    private AndroidDriver driver;
    public FunctionLibrary(AndroidDriver driver)
    {
        this.driver=driver;
    }
    public void waitUntilElementIsVisible(WebElement element)
    {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilButtonIsClickable(WebElement element)
    {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilMultipleItemsDisplayed(List<WebElement> elements)
    {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
