package com.vytrack.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
   private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    public static void wait (int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
                     //JS means Javascript
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor)(Driver.getDriver())).executeScript("arguments[0].click()",element);
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        //this wait here is to give selenium time to enter the String fully to the InputBox.
     //   wait.until(ExpectedConditions.attributeToBe(element,"value",text));
        BrowserUtils.wait(1);   //hard coding way
        System.out.println("Entering text: "+text);
    }


    }




