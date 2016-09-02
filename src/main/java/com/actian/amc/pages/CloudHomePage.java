package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constant;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by pphelan on 9/7/15.
 */
public class CloudHomePage extends AMCPage {

    By cloudDefButton = By.xpath("//div[text()='New Cloud']");
    By newCloudBtnLocator = By.xpath("//div[text()='Define Cloud']");
    By cloudNames = By.cssSelector("div.gwt-Label.groupNameLabelStyle");

    By cloudContainer = By.cssSelector("#instanceHeaderContainer");
    By addUserName = By.xpath("//input[@placeholder='Select username']");
    By addUserRole = By.xpath("//input[@placeholder='Select user role']");
    By userList = By.xpath(".//*[@id='userSharingGridId']/div[2]/div[1]/table/tbody[2]/tr/td[1]/div");

    WebDriverWait wait;
    Actions act;

    public CloudHomePage(WebDriver driver) {
        super(driver);
        if (!driver.getCurrentUrl().toString().contains("#CloudManagementPlace:CloudManagementPlace"))
            throw new IllegalStateException("This is not the Cloud page");

    }

    public CloudNewPage submitNewCloud() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        int y = getKpiCloudStatus();

        try {
            if (y != 0) {
                wait.until(ExpectedConditions.elementToBeClickable(cloudDefButton));
                driver.findElement(cloudDefButton).click();
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(newCloudBtnLocator));
                driver.findElement(newCloudBtnLocator).click();
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a Exception :-");
        }
        return new CloudNewPage(driver);
    }

    public int getCloudNameIndex(String cldName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            List<WebElement> availableClouds = driver.findElements(cloudNames);
            int cloudNameIndex;
            cloudNameIndex = -1;
            for (WebElement cloudName : availableClouds) {
                cloudNameIndex = cloudNameIndex + 1;
                System.out.println("****" + cloudName.getText() + "****" + cldName + "****" + "*" + cloudNameIndex + "*");
                if (cloudName.getText().equals(cldName)) {
                    return cloudNameIndex;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a (getCloudNameIndex)stale element :-");
        }
        return -1;
    }

    public CloudHomePage selectCloudActionsButton(String cloudName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            int cloudIndex = getCloudNameIndex(cloudName);
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
            List<WebElement> MenuItem = driver.findElements(By.xpath("./*//*[@id='contextMenuId']/div"));
            for (int i = 0; i < MenuItem.size(); i++) {
                if (i == cloudIndex) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", MenuItem.get(i));
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a (selectCloudActionsButton) Exception :-");
        }

        return new CloudHomePage(driver);
    }

    public CloudHomePage selectCloudAction(String cloudName, String action1) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectCloudActionsButton(cloudName);

        try {
            List<WebElement> cloudMenuItems = driver.findElements(popupMenuItems);
            for (WebElement btn : cloudMenuItems) {
                System.out.println(btn.getText());
                if (btn.getText().equals(action1)) {
                    if (action1.equals("Delete Cloud")) {
                        btn.click();
                        this.selectDialogButton("Yes");
                        this.selectDialogButton("OK");
                        break;
                    } else {
                        btn.click();
                        break;
                    }
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a (selectCloudAction) stale element :-");
        }
        return new CloudHomePage(driver);
    }

    public EditCloudDefinitionPage selectCloudAction2(String cloudName, String action1) {
        selectCloudActionsButton(cloudName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            List<WebElement> cloudMenuItems = driver.findElements(popupMenuItems);
            for (WebElement btn : cloudMenuItems) {
                System.out.println(btn.getText());
                if (btn.getText().equals(action1)) {
                    btn.click();
                    this.selectDialogButton("Yes");
                    break;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a (selectCloudAction2) Exception :-");
        }
        return new EditCloudDefinitionPage(driver);
    }

    public CloudHomePage createCloudDefAWS(
            String CloudProvider,
            String CloudNameAWS,
            String CloudDescriptionAWS,
            String CloudGroupNameAWS,
            String CloudProviderAWS,
            String CloudAccessKeyAWS,
            String CloudSecretAccessKeyAWS, String CloudZoneAWS, String SubnetIdAWS, String SecurityGroupIdAWS,
            String CloudRegionAWS) {
        CloudHomePage cloudPage = navigateToClouds();
        if (cloudPage.getCloudNameIndex(CloudNameAWS) == -1) {
            CloudNewPage newCloudPage = cloudPage.submitNewCloud();
            NewCloudDefinitionPage awsCloudPage = newCloudPage.selectCloudProvider(CloudProvider);
            awsCloudPage.textfield_Type("Cloud name", CloudNameAWS);
            awsCloudPage.textfield_Type("Description", CloudDescriptionAWS);
            awsCloudPage.textfield_Type("Cloud group name", CloudGroupNameAWS);
            awsCloudPage.textfield_Type("Cloud Provider/API", CloudProviderAWS);
            awsCloudPage.textfield_Type("Access Key", CloudAccessKeyAWS);
            awsCloudPage.textfield_Type("Secret Access Key", CloudSecretAccessKeyAWS);
            awsCloudPage.radioButton_Select(CloudZoneAWS);
            if (CloudZoneAWS.equals(Constant.SubnetIdZoneAWS)) {
                awsCloudPage.textfield_Type("Subnet ID", SubnetIdAWS);
                //awsCloudPage.textfield_Type("Security Group ID", SecurityGroupIdAWS);
            } else {
                awsCloudPage.selectAWSRegion(CloudRegionAWS);
            }
            awsCloudPage.clickNewCloudDefButton("Create");
        }
        return new CloudHomePage(driver);
    }

    public CloudHomePage createCloudDefRackSpace(
            String CloudServiceProviderRackSpace,
            String CloudNameRS,
            String CloudDescriptionRS,
            String CloudGroupNameRS,
            String CloudProviderRS,
            String CloudUserNameRS,
            String CloudAPIKeyRS,
            String CloudRegionRS) {

        CloudHomePage cloudPage = navigateToClouds();
        if (cloudPage.getCloudNameIndex(CloudNameRS) == -1) {
            CloudNewPage newCloudPage = cloudPage.submitNewCloud();
            NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(CloudServiceProviderRackSpace);
            rackspaceCloudPage.textfield_Type("Cloud name", CloudNameRS);
            rackspaceCloudPage.textfield_Type("Description", CloudDescriptionRS);
            rackspaceCloudPage.textfield_Type("Cloud group name", CloudGroupNameRS);
            rackspaceCloudPage.textfield_Type("Cloud Provider/API", CloudProviderRS);
            rackspaceCloudPage.textfield_Type("Username", CloudUserNameRS);
            rackspaceCloudPage.textfield_Type("API Key", CloudAPIKeyRS);
            rackspaceCloudPage.textfield_Type("Region Name", CloudRegionRS);
            rackspaceCloudPage.clickNewCloudDefButton("Create");
        }
        return new CloudHomePage(driver);
    }

    public int getKpiCloudStatus() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            List<WebElement> cloudStatus = driver.findElements(cloudContainer);
            int x = cloudStatus.size();
            return x;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a NoSuchElementException :-");
            reLogin();
        }
        return 0;
    }

    public void selectUserRole(String role) {

        try {
            act = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            driver.findElement(addUserRole).sendKeys(Keys.ARROW_DOWN);
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemsInDropdown));
            List<WebElement> rolelist = driver.findElements(itemsInDropdown);
            for (WebElement roles : rolelist) {
                System.out.println("********" + roles.getText() + "********");
                if (roles.getText().equals(role)) {
                    act.moveToElement(roles).perform();
                    act.contextClick(roles).perform();
                    break;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            System.out.println("Trying to recover from a StaleElementReferenceException :-");
        }
    }

    public CloudHomePage typeUserName(String username) {
        driver.findElement(addUserName).sendKeys(username);
        driver.findElement(addUserName).sendKeys(Keys.TAB);
        return this;
    }

    public CloudHomePage clickButton(String btnname) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> availablebuttons = driver.findElements(buttonNames);
        for (int i = 0; i < availablebuttons.size(); i++) {
            System.out.println("*****" + availablebuttons.get(i).getText() + "*****");
            if (availablebuttons.get(i).getText().equals(btnname)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", availablebuttons.get(i));
                return new CloudHomePage(driver);
            }
        }
        return this;
    }

    public CloudHomePage addUser(String username, String role) {
        if (!getCloudUser(username, role)) {
            clickButton("Add Users");
            typeUserName(username);
            selectUserRole(role);
            clickButton("Add");
        }
        return new CloudHomePage(driver);
    }

    public boolean getCloudUser(String username, String role) {
        By userrole = By.xpath("//div[text()='" + username + "']/following::div[1]");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> userlist = driver.findElements(userList);
        for (WebElement user : userlist) {
            if (user.getText().equals(username)) {
                if (driver.findElement(userrole).getText().equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAvailableOptions(String cloudname, String cloudoption[]) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectCloudActionsButton(cloudname);
        int counter = 0;

        try {
            List<WebElement> cloudMenuItems = driver.findElements(popupMenuItems);
            for (WebElement cloud : cloudMenuItems) {
                for (int i = 0; i < cloudoption.length; i++) {
                    if (cloud.getText().equals(cloudoption[i])) {
                        counter++;
                    }
                }
            }
            return counter == cloudoption.length;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a StaleElementReferenceException :-");
        }
        return false;
    }
}