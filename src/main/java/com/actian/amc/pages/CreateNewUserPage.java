package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha.n on 17-02-2016.
 */
public class CreateNewUserPage extends AMCPage {
    By userpropertylink = By.cssSelector(".GEG-4-BKL");
    By userAlertlink = By.cssSelector(".gwt-Image");
    By userAlertMsg = By.cssSelector(".GEG-4-BMN");

    public CreateNewUserPage(WebDriver driver) {
        super(driver);

        if (!driver.getCurrentUrl().toString().contains("#ManageUserPlace:ManageUserPlace"))
            throw new IllegalStateException("This is not the Create new user page");

    }

    public String getAlertInfoMsg(String userPropertyInfo) {
        WebDriverWait wait= new WebDriverWait(driver, 10);
        WebElement x = driver.findElement(By.xpath("//input[@placeholder='" + userPropertyInfo + "']"));
        String alertMessage = "";
        x.sendKeys(Keys.TAB);
        List<WebElement> alertlinks = driver.findElements(userAlertlink);
        for (int i = 0; i < alertlinks.size(); i++) {
            if (x.getAttribute("placeholder").equalsIgnoreCase(userPropertyInfo)) {
                mouseHoverJScript(alertlinks.get(0));
                wait.until(ExpectedConditions.visibilityOfElementLocated(userAlertMsg));
                WebElement alertMsg = driver.findElement(userAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
                return alertMessage;
            } else {
                alertMessage = "Not a valid user property: " + userPropertyInfo;  }
        }return alertMessage;
    }


    public CreateNewUserPage typeUserData(String propertyname, String fieldvalue) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                By fieldname = By.xpath("//input[@placeholder='" + propertyname + "']");
                switch (propertyname) {
                    case "First Name":
                        driver.findElement(fieldname).clear();
                        driver.findElement(fieldname).sendKeys(fieldvalue);
                        break;
                    case "Last Name":
                        driver.findElement(fieldname).clear();
                        driver.findElement(fieldname).sendKeys(fieldvalue);
                        break;
                    case "Username":
                        driver.findElement(fieldname).clear();
                        driver.findElement(fieldname).sendKeys(fieldvalue);
                        break;
                    case "Email Address":
                        driver.findElement(fieldname).clear();
                        driver.findElement(fieldname).sendKeys(fieldvalue);
                        break;
                    case "Password":
                        driver.findElement(fieldname).clear();
                        driver.findElement(fieldname).sendKeys(fieldvalue);
                        break;
                    case "Confirm Password":
                        driver.findElement(fieldname).clear();
                        driver.findElement(fieldname).sendKeys(fieldvalue);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid propertyname: " + propertyname);
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("recovering from Exception for button :-" );
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        }return this;
    }

    public SecurityHomePage clickButton(String btnname) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> listBtns = driver.findElements(buttonNames);
                for (int i=0;i<listBtns.size();i++) {
                    System.out.println("Button is : " + listBtns.get(i).getText());
                    if (listBtns.get(i).getText().contains(btnname)) {
                        JavascriptExecutor js = (JavascriptExecutor)driver;
                        js.executeScript("arguments[0].click();", listBtns.get(i));
                        break;  }
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("recovering from StaleElementReferenceException for button :-" );
                count = count + 1;
                screenShot(driver);
                continue;
            }count = count + 4;
        }return new SecurityHomePage(driver);
    }

    public CreateNewUserPage getRadiobttnOption(String privilegeoption) {
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> radiobtn = driver.findElements(userpropertylink);
                for (WebElement btn : radiobtn) {
                    if (btn.getText().contains(privilegeoption)) {
                        btn.click();
                        break; }
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("recovering from StaleElementReferenceException for radio button :-");
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        }return new CreateNewUserPage(driver);
    }

    public String getTextFieldValue(String fieldName) {
        int count = 0;
        while (count < 4) {
            try { By fieldname = By.xpath("//input[@placeholder='" + fieldName + "']");
                switch (fieldName) {
                    case "First Name":
                       return driver.findElement(fieldname).getAttribute("value");
                    case "Last Name":
                        return driver.findElement(fieldname).getAttribute("value");
                    case "Username":
                        return driver.findElement(fieldname).getAttribute("value");
                    case "Email Address":
                        return driver.findElement(fieldname).getAttribute("value");
                    case "Password":
                        return driver.findElement(fieldname).getAttribute("value");
                    case "Confirm Password":
                        return driver.findElement(fieldname).getAttribute("value");
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("recovering from Exception for button :-" );
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        } return "";
    }

}