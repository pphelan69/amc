package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pphelan on 9/8/15.
 */
public class NewCloudDefinitionPage extends AMCPage {

    By textField_CloudName = By.name("cloud.name");
    By textField_Description = By.name("cloud.description");
    By textField_CloudGroupName = By.name("cloud.group.name");
    By textField_CloudProvider = By.name("cloud.connectioninfo.cloudprovider");
    By textField_Region = By.name("cloud.connectioninfo.region");

    // Used by AWS Cloud Definition
    By textField_SecretKey = By.name("cloud.aws.connectioninfo.secretkey.protected");
    By textField_APIKey = By.name("cloud.aws.connectioninfo.apikey.protected");
    By textField_subnetID = By.name("cloud.connectioninfo.subnet");
    By textField_securityGrpId = By.name("cloud.connectioninfo.security.group");

    By dropdown_Region = By.name("cloud.connectioninfo.availability.zone");

    // Used by Rackspace Cloud Definition
    By textField_RS_UserName = By.name("cloud.rackspace.connectioninfo.username");
    By textField_RS_APIKey = By.name("cloud.rackspace.connectioninfo.apikey.protected");

    // Used By Virtual Test Cloud
    By textField_Virtual_Delay = By.name("provider.virtual.connectioninfo.delayms");
    By textField_Virtual_FailState = By.name("provider.virtual.auto.fail.state");

    By CloudServiceAlertMsgLink = By.cssSelector(".gwt-Image.informationIconStyle");
    By cloudAlertMsg = By.cssSelector(".GEG-4-BEDB");

    //un-used locators
    By alert_Link = By.cssSelector("div.GEG-4-BJ");
    By alert_Image = By.cssSelector("div.GEG-4-BJ > img.gwt-Image.informationIconStyle");
    By alertMsgText = By.cssSelector("span.GEG-4-BIDB");
    By alertMsgClose = By.cssSelector("div.GEG-4-BGK.GEG-4-BIGC.GEG-4-BM3D");
    By alert_Link_cloudServ = By.cssSelector("div.GEG-4-BI");
    By alert_Image_cloudServ = By.cssSelector("div.GEG-4-BI >img.gwt-Image.informationIconStyle");
    By alertMsgText_cloudServ = By.cssSelector("span.GEG-4-BIDB");
    By alertMsgClose_cloudServ = By.cssSelector("div.GEG-4-BGK.GEG-4-BIGC.GEG-4-BM3D");

    By warningLink = By.cssSelector("img[class='gwt-Image']");
    By tooltip = By.cssSelector(".GEG-4-BLN");

    public NewCloudDefinitionPage(WebDriver driver) {
        super(driver);
        // Check that we're on the right page.
        if (!"Actian Management Console".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the AMC login page.");
        }
    }

    public NewCloudDefinitionPage textfield_Type(String target_TF, String text) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count1 = 0;

        try {
            switch (target_TF) {
                case "Cloud name":  // Common to AWS, RackSpace, and Virtual Test Cloud
                    driver.findElement(textField_CloudName).clear();
                    driver.findElement(textField_CloudName).sendKeys(text);
                    break;
                case "Description": // Common to AWS, RackSpace, and Virtual Test Cloud
                    driver.findElement(textField_Description).clear();
                    driver.findElement(textField_Description).sendKeys(text);
                    break;
                case "Cloud group name":  // Common to AWS, RackSpace, and Virtual Test Cloud
                    driver.findElement(textField_CloudGroupName).clear();
                    driver.findElement(textField_CloudGroupName).sendKeys(text);
                    break;
                case "Cloud Provider/API": // Common to AWS and RackSpace
                    driver.findElement(textField_CloudProvider).clear();
                    driver.findElement(textField_CloudProvider).sendKeys(text);
                    break;
                case "Username":  // Unique to RackSpace
                    driver.findElement(textField_RS_UserName).clear();
                    driver.findElement(textField_RS_UserName).sendKeys(text);
                    break;
                case "API Key":  // Unique to RackSpace
                    driver.findElement(textField_RS_APIKey).clear();
                    driver.findElement(textField_RS_APIKey).sendKeys(text);
                    break;
                case "Access Key":  // Unique to AWS
                    driver.findElement(textField_APIKey).clear();
                    driver.findElement(textField_APIKey).sendKeys(text);
                    break;
                case "Secret Access Key":  // Unique to AWS
                    driver.findElement(textField_SecretKey).clear();
                    driver.findElement(textField_SecretKey).sendKeys(text);
                    break;
                case "Delay in MS":  // Unique to Virtual Text Cloud
                    driver.findElement(textField_Virtual_Delay).clear();
                    driver.findElement(textField_Virtual_Delay).sendKeys(text);
                    break;
                case "Region Name": // Common to AWS and RackSpace
                    driver.findElement(textField_Region).clear();
                    driver.findElement(textField_Region).sendKeys(text);
                    break;
                case "Subnet ID": // Unique to AWS
                    driver.findElement(textField_subnetID).clear();
                    driver.findElement(textField_subnetID).sendKeys(text);
                    break;
                case "Security Group ID": // Unique to AWS
                    driver.findElement(textField_securityGrpId).clear();
                    driver.findElement(textField_securityGrpId).sendKeys(text);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid textfield: " + target_TF);
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a Exception (textfield_Type) :-");
        }

        return this;
    }

    public String clickNewCloudDefButton(String btn) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<WebElement> cloudBtns = driver.findElements(buttonNames);
            for (WebElement button : cloudBtns)
                if (button.getText().contains(btn)) {
                    String sButton = button.getText();
                    if (sButton.contains("Cancel")) {
                        button.click();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "";
                    } else if (sButton.contains("Create") | sButton.contains("Test Cloud")) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        button.click();
                        return this.getCreationTestStatus();
                    } else {
                        System.out.println("Not a valid button: " + btn);
                        return "";
                    }
                }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a stale element :-");
        }
        return "";
    }

    public String getCreationTestStatus() {
        String connStatus;
        connStatus = this.getDialogMessage();
        if (connStatus.contains("Cloud test successful!") | connStatus.contains("created")) {
            System.out.println("Successful Cloud Connection.");
            this.selectDialogButton("OK");
            return "PASS";
        } else if (connStatus.contains("Cloud name cannot be empty or duplicated")) {
            System.out.println("Cloud name cannot be empty or duplicated." + connStatus);
            this.selectDialogButton("OK");
            return "DUPE";
        } else if (connStatus.contains("FAIL")) {
            System.out.println("Bad cloud definition:" + connStatus);
            this.selectDialogButton("OK");
            return "FAIL";
        } else {
            System.out.println("Error message is :" + connStatus);
        }
        return "";
    }

    public String get_textfield_Value(String FieldName) {
        String Value;
        switch (FieldName) {
            case "Cloud name":  // Common to AWS, RackSpace, and Virtual Test Cloud
                Value = driver.findElement(textField_CloudName).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Description": // Common to AWS, RackSpace, and Virtual Test Cloud
                Value = driver.findElement(textField_Description).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Cloud group name":  // Common to AWS, RackSpace, and Virtual Test Cloud
                Value = driver.findElement(textField_CloudGroupName).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Cloud Provider/API": // Common to AWS and RackSpace
                Value = driver.findElement(textField_CloudProvider).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Username":  // Unique to RackSpace
                Value = driver.findElement(textField_RS_UserName).getAttribute("value");
                System.out.println(Value);
                return (Value);

            case "API Key":  // Unique to RackSpace
                Value = driver.findElement(textField_RS_APIKey).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Access Key":  // Unique to AWS
                Value = driver.findElement(textField_APIKey).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Secret Access Key":  // Unique to AWS
                Value = driver.findElement(textField_SecretKey).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Delay in MS":  // Unique to Virtual Text Cloud
                Value = driver.findElement(textField_Virtual_Delay).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Region Name": // Common to RackSpace
                Value = driver.findElement(textField_Region).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Subnet ID": // Unique to AWS
                Value = driver.findElement(textField_subnetID).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);

            case "Security Group ID": // Unique to AWS
                Value = driver.findElement(textField_securityGrpId).getAttribute("value");
                System.out.println("The entered Value is " + Value);
                return (Value);
        }
        return ("");
    }

    public NewCloudDefinitionPage selectAWSRegion(String region) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        try {
            driver.findElement(dropdown_Region).click();
            List<WebElement> cloudProviders = driver.findElements(itemsInDropdown);
            for (WebElement cloud : cloudProviders) {
                System.out.println("Cloud Zone Name : " + cloud.getText());
                if (cloud.getText().equalsIgnoreCase(region)) {
                    cloud.click();
                    break;
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException | IndexOutOfBoundsException e) {
            System.out.println("Trying to recover from a stale element :-");
        }
        return new NewCloudDefinitionPage(driver);
    }

    public NewCloudDefinitionPage radioButton_Select(String target_RB) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        try {
            String x = "//input[@name='" + target_RB + "']";
            if (driver.findElement(By.xpath(x)).isSelected() != true) {
                driver.findElement(By.xpath(x)).click();
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a stale element :-");
        }
        return new NewCloudDefinitionPage(driver);
    }

    public String getAlertInfoMsg(String cloudPropertyInfo) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String alertMessage = "";
        int count = 0;
        try {
            List<WebElement> alertlinks = driver.findElements(CloudServiceAlertMsgLink);
            if (cloudPropertyInfo == "Cloud service") {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(0));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if (cloudPropertyInfo == "Cloud Provider/API") {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(1));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if ((cloudPropertyInfo == "Username") || (cloudPropertyInfo == "Access Key")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(2));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if ((cloudPropertyInfo == "API Key") || (cloudPropertyInfo == "Secret Access Key")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(3));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if ((cloudPropertyInfo == "Subnet ID")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(4));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if ((cloudPropertyInfo == "Security Group ID")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(5));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if ((cloudPropertyInfo == "Storage Availability Zone")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(6));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if (cloudPropertyInfo == "Availability Zone") {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(5));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if (cloudPropertyInfo == "Region Name") {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(4));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else if (cloudPropertyInfo == "CentOS License agreement") {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", alertlinks.get(6));
                WebElement alertMsg = driver.findElement(cloudAlertMsg);
                alertMessage = alertMsg.getText();
                driver.findElement(lablefielld).click();
            } else {
                alertMessage = "Not a valid Cloud definition property: " + cloudPropertyInfo;
            }
        } catch (NoSuchElementException | StaleElementReferenceException | IndexOutOfBoundsException e) {
            System.out.println("Trying to recover from a alert Exception(getAlertInfoMsg) :-");
        }
        return alertMessage;
    }

    public String getAlertMsg(String Name) {

        List<WebElement> alertlinks = driver.findElements(alert_Link);//(By.cssSelector("div.GEG-4-BJ"));

        int size = alertlinks.size();

        int i = 0;
        System.out.println("The size is *** " + size);

        while (i < size) {

            String test1 = alertlinks.get(i).getText();
            System.out.println("The id is *** " + test1);

            if (test1.equals(Name)) {

                alertlinks.get(i).findElement(alert_Image).click();
                WebElement alertmsg = driver.findElement(alertMsgText);
                String messgae = alertmsg.getText();
                System.out.println("The alertmsg is *** " + messgae);
                driver.findElement(alertMsgClose).click();
                return (messgae);
            }
            i++;
        }
        return ("");
    }

    public String getAlertMsgCloudService(String Name) {

        List<WebElement> alertlinks = driver.findElements(alert_Link_cloudServ);
        int size = alertlinks.size();
        int i = 0;
        System.out.println("The size is *** " + size);
        while (i < size) {

            String test1 = alertlinks.get(i).getText();
            System.out.println("The id is *** " + test1);

            if (test1.equals(Name)) {
                alertlinks.get(i).findElement(alert_Image_cloudServ).click();

                List<WebElement> MenuItem = driver.findElements(alertMsgText_cloudServ);
                for (WebElement cloudName : MenuItem) {

                    String alertMessage1 = cloudName.getText();
                    System.out.println("The alertmsg for cloud service is *** " + alertMessage1);
                    driver.findElement(alertMsgClose_cloudServ).click();
                    return (alertMessage1);
                }
            }
            i++;
        }
        return ("");
    }


    private String getToolTipText() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> WarningLink = driver.findElements(warningLink);    //(By.cssSelector("img[class='gwt-Image']"));
        wait = new WebDriverWait(driver, 20);
        mouseHoverJScript(WarningLink.get(0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tooltip));
        String toolTipText = driver.findElement(tooltip).getText();
        System.out.println("Tooltip/ Help message is " + toolTipText);
        return (toolTipText);
    }

    public String getWarningMsgRequiredField(String Name) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            switch (Name) {
                case "Cloud Name": {// Common to AWS, RackSpace, and Virtual Test Cloud
                    driver.findElement(textField_CloudName).clear();
                    driver.findElement(textField_CloudName).sendKeys(Keys.TAB);
                    return getToolTipText();
                }
                case "Cloud Provider/API": // Common to AWS and RackSpace
                {
                    driver.findElement(textField_CloudProvider).clear();
                    driver.findElement(textField_CloudProvider).sendKeys(Keys.TAB);
                    return getToolTipText();
                }
                case "Username":  // Unique to RackSpace
                {
                    driver.findElement(textField_RS_UserName).clear();
                    driver.findElement(textField_RS_UserName).sendKeys(Keys.TAB);
                    return getToolTipText();
                }
                case "API Key":  // Unique to RackSpace
                {
                    driver.findElement(textField_RS_APIKey).clear();
                    driver.findElement(textField_RS_APIKey).sendKeys(Keys.TAB);
                    return getToolTipText();
                }
                case "Access Key":  // Unique to AWS
                {
                    driver.findElement(textField_APIKey).clear();
                    driver.findElement(textField_APIKey).sendKeys(Keys.TAB);
                    return getToolTipText();
                }
                case "Secret Access Key":  // Unique to AWS
                {
                    driver.findElement(textField_SecretKey).clear();
                    driver.findElement(textField_SecretKey).sendKeys(Keys.TAB);
                    return getToolTipText();
                }
                case "Region Name": // Common to RackSpace only.
                {
                    driver.findElement(textField_Region).clear();
                    driver.findElement(textField_Region).sendKeys(Keys.TAB);
                    return getToolTipText();
                }
            }
        } catch (NoSuchElementException | StaleElementReferenceException | IndexOutOfBoundsException e) {
            System.out.println("Trying to recover from a Exception(getWarningMsgRequiredField) :-");
        }
        return ("");
    }
}