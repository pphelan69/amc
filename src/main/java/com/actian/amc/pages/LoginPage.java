package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by pphelan on 9/6/15.
 */
public class LoginPage {

    private final WebDriver driver;

    By usernameLocator      = By.id("usernameField-input");
    By passwordLocator      = By.id("passwordField-input");
    By loginButtonLocator   = By.id("loginButton");
    By amcVersion=By.cssSelector(".productLabelStyle");
    By dialogMessage = By.cssSelector(".gwt-Label.dialogMessageStyle");
    By dialogButtons = By.cssSelector(".GEG-4-BBJ.GEG-4-BMJ"); // confirmation button 


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        WebElement element = (new WebDriverWait(driver, 100)).until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        // Check that we're on the right page.
        if (!"Actian Management Console".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the AMC login page.");
        }
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }


    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    // The login page allows the user to submit the login form
    public InstancesHomePage submitLogin() {
        System.out.println("Current AMC Version: " + driver.findElement(amcVersion).getText());
        driver.findElement(loginButtonLocator).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new InstancesHomePage(driver);
    }

    public InstancesHomePage submitValidLogin(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    // The login page allows the user to submit the login form
    public LoginPage submitInValidLogin(String username, String password) {
        typeUsername(username);
        typePassword(password);
        driver.findElement(loginButtonLocator).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(dialogMessage).getText();
        driver.findElement(dialogButtons).click();
        return new LoginPage(driver);
    }
}