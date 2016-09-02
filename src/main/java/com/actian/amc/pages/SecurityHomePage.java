package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vikram.Suresh on 10/26/2015.
 */
public class SecurityHomePage extends AMCPage {

    By usernamelist = By.cssSelector(".gwt-Label.groupNameLabelStyle");

    public SecurityHomePage(WebDriver driver) {
        super(driver);

        if (!driver.getCurrentUrl().toString().contains("#SecurityPlace:SecurityPlace"))
            throw new IllegalStateException("This is not the Security page");
    }

    public CreateNewUserPage createNewuserBttn(String action) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;

        try {
            List<WebElement> availablebtn = driver.findElements(buttonNames);
            for (int i = 0; i < availablebtn.size(); i++) {
                if (availablebtn.get(i).getText().contains(action)) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", availablebtn.get(i));
                    break;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a (createNewuserBttn)stale element :-");

        }
        return new CreateNewUserPage(driver);
    }

    public int getUserIndex(String username) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;

        try {
            List<WebElement> availableUsers = driver.findElements(usernamelist);
            int userIndex = -1;
            for (WebElement userName : availableUsers) {
                userIndex = userIndex + 1;
                System.out.println("****" + userName.getText() + "****" + username + "****" + "*" + userIndex + "*");
                if (userName.getText().equals(username)) {
                    return userIndex;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a (selectInstanceActionButton)stale element :-");
        }
        return -1;
    }


    public SecurityHomePage selectUserActionButton(String instancename) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        try {
            int UserIndex = getUserIndex(instancename);
            new FluentWait<WebDriver>(driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
            List<WebElement> MenuItem = driver.findElements(By.xpath(".//*[@id='contextMenuId']/div"));
            for (int i = 0; i < MenuItem.size(); i++) {
                if (i == UserIndex) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", MenuItem.get(i));
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a (selectCloudActionsButton) Exception :-");
        }
        return new SecurityHomePage(driver);
    }


    public SecurityHomePage selectUserAction(String username, String action1) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectUserActionButton(username);
        int count = 0;
        try {
            List<WebElement> instanaceMenuItems = driver.findElements(popupMenuItems);
            for (WebElement menuoption : instanaceMenuItems) {
                if (menuoption.getText().equals(action1)) {
                    if (action1.contains("Delete User")) {
                        menuoption.click();
                        this.selectDialogButton("Yes");
                        this.selectDialogButton("OK");
                        break;
                    }
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a StaleElementReferenceException :-");
        }
        return new SecurityHomePage(driver);
    }

    public CreateNewUserPage selectUserEditAction(String username, String action1) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectUserActionButton(username);

        try {
            List<WebElement> instanaceMenuItems = driver.findElements(popupMenuItems);
            for (WebElement menuoption : instanaceMenuItems) {
                if (menuoption.getText().equals(action1)) {
                    if (action1.contains("Edit User")) {
                        menuoption.click();
                        break;
                    }
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a StaleElementReferenceException :-");
        }
        return new CreateNewUserPage(driver);
    }


    public SecurityHomePage createNewUser(String Firstname, String Lastname, String Username, String email, String password, String confpassword, String priviliage) {

        if (getUserIndex(Username) == -1) {
            CreateNewUserPage newuserpage = createNewuserBttn("Create User");
            newuserpage.typeUserData("First Name", Firstname);
            newuserpage.typeUserData("Last Name", Lastname);
            newuserpage.typeUserData("Username", Username);
            newuserpage.typeUserData("Email Address", email);
            newuserpage.typeUserData("Password", password);
            newuserpage.typeUserData("Confirm Password", confpassword);
            newuserpage.getRadiobttnOption(priviliage);
            newuserpage.clickButton("Create");
        }
        return new SecurityHomePage(driver);
    }
}
