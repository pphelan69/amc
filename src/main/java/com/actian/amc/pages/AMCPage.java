package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constant;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by pphelan on 9/16/2015.
 */
public class AMCPage {

    public final WebDriver driver;

    public String PAGE_URL;
    public String PAGE_TITLE;

    By navbar_INSTANCES = By.cssSelector("div[id=dashboardTabId]");
    By navbar_CLUSTERS = By.cssSelector("div[id=clusterTabId]");
    By navbar_CLOUDS = By.cssSelector("div[id=cloudTabId]");
    By navbar_SECURITY = By.cssSelector("div[id=securityTabId]");

    By navbar_SIGNOUT1 = By.id("userProfileMenuBarItem");
    By navbar_SIGNOUT2 = By.xpath("//*[@id='signOutMenuItem']/span");
    By dialogMessage = By.cssSelector(".gwt-Label.dialogMessageStyle");

    //re-used locators
    By popupMenuItems = By.cssSelector(".GEG-4-BN-");
    By itemsInDropdown= By.cssSelector(".GEG-4-BDY");
    By buttonNames = By.cssSelector(".GEG-4-BBJ.GEG-4-BMJ");
    By lablefielld = By.cssSelector(".GEG-4-BCK");

    WebDriverWait wait;

    public AMCPage(WebDriver driver) {
        this.driver = driver;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!driver.getCurrentUrl().contains("amc")) {
            throw new IllegalStateException("This is not an AMC page");
        }
    }

    public InstancesHomePage navigateToInstances() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.elementToBeClickable(navbar_INSTANCES));
                driver.findElement(navbar_INSTANCES).click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }count = count + 4;
        }
        return new InstancesHomePage(driver);
    }

    public ClustersHomePage navigateToClusters() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.elementToBeClickable(navbar_CLUSTERS));
                driver.findElement(navbar_CLUSTERS).click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchElementException | StaleElementReferenceException  e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-" );
                count = count + 1;
                screenShot(driver);
                continue;
            }count = count + 4;
        }
        return new ClustersHomePage(driver);
    }

    public CloudHomePage navigateToClouds() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.elementToBeClickable(navbar_CLOUDS));
                driver.findElement(navbar_CLOUDS).click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchElementException | StaleElementReferenceException  e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }count = count + 4;
        }
        return new CloudHomePage(driver);
    }

    public SecurityHomePage navigateToSecurity() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.elementToBeClickable(navbar_SECURITY));
                driver.findElement(navbar_SECURITY).click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }catch (NoSuchElementException | StaleElementReferenceException  e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        }
        return new SecurityHomePage(driver);
    }

    public LoginPage signOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.elementToBeClickable(navbar_SIGNOUT1));
                driver.findElement(navbar_SIGNOUT1).click();
                driver.findElement(navbar_SIGNOUT2).click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchElementException | StaleElementReferenceException  e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                continue;
            }catch (WebDriverException e) {
                System.out.println("Trying to recover from a WebDriverException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }count = count + 4;
        }return new LoginPage(driver);
    }


    public String getDialogMessage() {
        WebDriverWait wait;
        String dialogMsg="";
        try {
            if(!driver.getCurrentUrl().contains("#ProvisionPlace:ProvisionPlace")) {
                 wait = new WebDriverWait(driver, 25); }
            else {
                 wait = new WebDriverWait(driver, 10); }
            wait.until(ExpectedConditions.visibilityOfElementLocated(dialogMessage));
            dialogMsg = driver.findElement(dialogMessage).getText();
            return dialogMsg;
        } catch (Exception e) {
            return dialogMsg;
        }
    }

    public void selectDialogButton(String btnChoice) {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> dialogBtns = driver.findElements(buttonNames);
                for(int i=0; i<dialogBtns.size();i++)
                {      if (dialogBtns.get(i).getText().equals(btnChoice)) {
                    WebDriverWait wait = new WebDriverWait(driver, 10);
                    wait.until(ExpectedConditions.elementToBeClickable(dialogBtns.get(i)));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", dialogBtns.get(i));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } break;
                }}
            } catch (NoSuchElementException | StaleElementReferenceException  e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }count = count + 4;
        }
    }

    public boolean verifyElementIsPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyElementIsvisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyTextvisible(String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//div[text()='"+text+"']"));
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickElement(WebElement element) {

        element.click();
    }

    public void setElementText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        // Assert.assertEquals(element.getAttribute("value"),text);
    }

    public void selectValueInDropdown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public String getPageUrl() {
        PAGE_URL= driver.getCurrentUrl();
        return PAGE_URL;
    }

    public String getPageTitle() {
        PAGE_TITLE=driver.getTitle();
        return PAGE_TITLE;
    }

    public void reloadpage() {
        driver.navigate().refresh();
        checkPageIsReady();
    }

    private void checkPageIsReady()
    {   JavascriptExecutor js = (JavascriptExecutor) driver;
        if (js.executeScript("return document.readyState").toString().equals("complete"))
        { return; }
    }

    public void screenShot(WebDriver driver)
    {
        /*Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        String timestamp = dateFormat.format(date);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path="src/zRunTimeScreenCapture";
        String currentsessionFolder =path+"/"+timestamp;
        File SnapFloder = new File(currentsessionFolder);
        try {
            FileUtils.copyFileToDirectory(scrFile, SnapFloder);
        } catch (IOException e) {
            System.out.println("destination path to save screenshot is not : "+ e);
        }*/
    }

    public void reLogin()
    {
        LoginPage login;
        if(getPageUrl().contains("#LoginPlace:LoginPlace"))
        {   System.out.println("********* Application Session Expired ************* re-Logging-in*****");
            selectDialogButton("OK");
            login =new LoginPage(driver);
            login.submitValidLogin(Constant.Username,Constant.Password);
        }
    }

    public void mouseHoverJScript(WebElement HoverElement) {
        try {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while hovering" + e.getStackTrace());
        }
    }
}