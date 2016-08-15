package com.actian.amc.pages;

import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by uttam.kumar on 06-10-2015.
 */
public  class EditCloudDefinitionPage extends NewCloudDefinitionPage {

    By EditCloudTitle   = By.cssSelector(".GEG-4-BC");

    public EditCloudDefinitionPage(WebDriver driver) {
        super(driver);
        // Check that we're on the right page.
        if (!"Edit Cloud Definition".equals(driver.findElement(EditCloudTitle).getText()))
        { throw new IllegalStateException("This is not the edit cloud page.");
        }
    }


    public void clickButton(String buttonName) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {  try {
            List<WebElement> availableButtons = driver.findElements(buttonNames);
            for (WebElement button : availableButtons) {
                String x = button.getText();
                System.out.println("****" + x + "*");
                if (x.equals(buttonName)) {
                    button.click();       }             }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a stale element :" + e);
            count = count + 1;
            screenShot(driver);
            continue;
        }count = count + 4;
        }
    }
}
