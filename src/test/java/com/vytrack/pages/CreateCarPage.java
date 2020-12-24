package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCarPage extends BasePage{

    @FindBy(css = "[title='Create Car']")
    private WebElement createCarBtn;

   @FindBy(name= "custom_entity_type[LicensePlate]")
    private WebElement licencePlateInputBox;

   @FindBy (name = "custom_entity_type[ModelYear]")
   private WebElement modelYearInputBox;


    public void clickOnCreateCar(){  //becoz of synchronization issue
                                      // we have to add wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(createCarBtn)).click();
        System.out.println("Clicking on 'Create car' button");
    }

    public void enterLicencePlate(String licencePlate){
       /* WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(licencePlateInputBox));
        licencePlateInputBox.sendKeys(licencePlate);
         */
        // rather using above steps we can call from BrowserUtils
        BrowserUtils.enterText(licencePlateInputBox,licencePlate);
      }
    /*
    sometimes , for very long string webdriver might enter text not fully
    */

    public void enterModelYear(String modelyear){
        BrowserUtils.enterText(modelYearInputBox, modelyear);
    }




}
