package com.actian.amc.pages;

import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pphelan on 9/7/15.
 */
public class CloudNewPage extends AMCPage {

    By cloudServiceDropDown = By.cssSelector(".GEG-4-BBS");

    public CloudNewPage(WebDriver driver) {
        super(driver);

        if (!driver.getCurrentUrl().toString().contains("#CloudDefinitionPlace:CloudDefinitionPlace"))
            throw new IllegalStateException("This is not the page for creating a new Cloud.");
    }


    public NewCloudDefinitionPage selectCloudProvider(String cloudProvider) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.findElement(cloudServiceDropDown).click();
            List<WebElement> cloudProviders = driver.findElements(itemsInDropdown);
            for (WebElement cloud : cloudProviders) {
                if (cloud.getText().contains(cloudProvider)) {
                    cloud.click();
                    break;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a stale element :" + e);
        }
        return new NewCloudDefinitionPage(driver);
    }
}