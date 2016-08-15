package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constant;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by pphelan on 9/6/15.
 */
public class InstancesHomePage extends AMCPage {

    By InstanceContainer = By.xpath(".//*[@id='kpiFieldContainer']/div[1]/div[1]");
    By newProvisionButton = By.xpath(".//*[@id='provisionButton']/div");
    By DashbrdprovisionButton = By.xpath(".//*[@id='dashBoardWithInstanceProvisionButton']/div");

    By addexistinginstnacebtn = By.xpath("//div[text()='Add Existing Instance']");
    By DashbrdaddexistingInstbtn = By.xpath(".//*[@id='addExistingInstanceButton']/div");
    By instanceNames = By.xpath(".//*[@id='instanceInfoContainer']/div[1]/div/div");

    // update instance objects path
    By updateinstname = By.id("updateNameFieldId-input");
    By updateinstdetail = By.id("updateDescriptionFieldId-input");
    By updatelabel = By.id("labelTextFieldId-input");
    By updateurl = By.id("urlTextField-input");
    By addurl = By.xpath(".//*[@id='managementToolsAddButtonId']");
    By datanode = By.name("cluster.server1.publicipaddresses");
    By datanodehostname = By.id("cluster.server1.hostname-input");
    By sshname = By.id("cluster.user-input");
    By sshpwd = By.xpath("//input[@type='password']");
    By privatekey = By.id("cluster.privatekey.protected-input");
    By manageAmc = By.xpath(".//*[@id='actianDirectorMenuitemId']/span");
    By failure_text = By.cssSelector(".GEG-4-BFDB");
    By instanceIndex = By.cssSelector(".gwt-Label.instanceNameLabelStyle.cursorPointer.instanceNameLabelListViewStyle");
    By ungroupInst = By.cssSelector("#instanceHeaderContainer");

    By warningicon = By.cssSelector(".GEG-4-BOC");
    By alertdialog = By.cssSelector(".GEG-4-BOY.GEG-4-BBGC");
    By settingicon = By.cssSelector(".GEG-4-BLC.cursorPointer");
    By textFeilds = By.xpath("//input[starts-with(@id,'x-auto')]");

    Wait<WebDriver> wait;

    public InstancesHomePage(WebDriver driver) {
        super(driver);
        // Check that we're on the right page.
        if (!driver.getCurrentUrl().contains("#MainDashBoardPlace:MainDashBoardPlace")) {
            throw new IllegalStateException("This is not a valid login landing page");
        }
    }

    public InstanceNewPage provisionNewInstance() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count =0;
        while (count < 4) {
            try {
                String x = getKpiContainerStatus();
                if (x.equals("0")) {
                    driver.findElement(newProvisionButton).click();
                    return new InstanceNewPage(driver);
                } else {
                    driver.findElement(DashbrdprovisionButton).click();
                    return new InstanceNewPage(driver); }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException of provisionNewInstance :-");
                count = count + 1; screenShot(driver);
                continue; }
        }return new InstanceNewPage(driver);
    }

    public InstanceNewPage addexistingInstance() {
        String x = getKpiContainerStatus();
        if (x.equals("0")) {
            driver.findElement(addexistinginstnacebtn).click();
            return new InstanceNewPage(driver);
        } else {
            driver.findElement(DashbrdaddexistingInstbtn).click();
            return new InstanceNewPage(driver);
        }
    }

    public String getKpiContainerStatus() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                String x = driver.findElement(InstanceContainer).getText();
                count = count + 4;
                return x;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException :-");
                count = count + 1; screenShot(driver);
                reLogin();
                continue;
            }
        } return "0";
    }


    public String getProvisionStatus(String instanceName) {
        int count = 0;
        while (count < 4) {
            try {
                String y = getKpiContainerStatus();
                if (!y.equals("0")) {
                    By provisionStatus = By.xpath("//div[text()='" + instanceName + "']/following::div[1]/following::div[1]/div[1]/div[1]");
                    List<WebElement> availableInstances = driver.findElements(instanceNames);
                    if (y.equals(Integer.toString(availableInstances.size()))) {
                        for (int i = 0; i < availableInstances.size(); i++) {
                            WebElement instName = availableInstances.get(i);
                            System.out.println("****" + instName.getText() + "****");
                            if (instName.getText().equals(instanceName)) {
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(30, TimeUnit.SECONDS)
                                        .ignoring(StaleElementReferenceException.class)
                                        .pollingEvery(1, TimeUnit.SECONDS);
                                WebElement p = wait.until(ExpectedConditions.elementToBeClickable(provisionStatus));
                                return instName.findElement(provisionStatus).getText();
                            }
                        }
                    } else {
                        reloadpage();
                        count = count + 1;
                        continue;
                    }
                }
            }catch (NoSuchElementException | StaleElementReferenceException | NumberFormatException e) {
                System.out.println("Trying to recover from a stale element :-");
                count = count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        }return "NoInstance";
    }

    public String getSharedInstanceStatus(String instanceName) {
        int count = 0;
        while (count < 4) {
            try {
                String y = getKpiContainerStatus();
                if (!y.equals("0")) {
                    WebElement provisionStatus = driver.findElement(By.xpath("//div[text()='" + instanceName + "']/following::div[1]/following::div[1]/div[1]/div[1]"));
                    List<WebElement> availableInstances = driver.findElements(instanceNames);
                    if (y.equals(Integer.toString(availableInstances.size()))) {
                        for (int i = 0; i < availableInstances.size(); i++) {
                            WebElement instName = availableInstances.get(i);
                            JavascriptExecutor executor1 = (JavascriptExecutor) driver;
                            String inst = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", instName);
                            System.out.println("****" + inst + "****");
                            if (inst.equals(instanceName)) {
                                JavascriptExecutor executor2 = (JavascriptExecutor) driver;
                                return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", provisionStatus);
                            }
                        }
                    }  else {
                        reloadpage();
                        count = count + 1;
                        continue;  }
                } } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a stale element :-");
                count = count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        } return "NoInstance";
    }

    public String getProvisionStatusDetails(String instName) {
        wait= new WebDriverWait(driver,10);
        By failure_error= By.xpath("//div[text()='" + instName + "']/preceding::div[1]/following::div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count =400; int count1 =1200;
        String status = "";
        int elapsedTime = 0;
        int counter = 0;
        String outcome = "RUNNING";

        while (!status.contains("RUNNING")) {
            status = this.getProvisionStatus(instName);

            if (status.contains("NoInstance")) {
                System.out.println("Instance is FAILED to Provisoin: " + instName);
                screenShot(driver);
                outcome = "FAILED";
                break;
            }

            if (status.contains("STOPPED")) {
                System.out.println("The provisioned instance is STOPPED: " + instName);
                screenShot(driver);
                outcome = "STOPPED";
                break;
            }

            if (status.contains("FAILED")) {
                System.out.println("The provisioned instance is FAILED: " + instName);
                try{
                    wait.until(ExpectedConditions.elementToBeClickable(failure_error));
                    driver.findElement(failure_error).click();
                    System.out.println("Instance Failure details:- "+driver.findElement(failure_text).getText());}
                catch (TimeoutException|NoSuchElementException e){ System.out.println("Error image icon is not visible to capture Error details");}
                screenShot(driver);
                outcome = "FAILED";
                break;
            }

            if (status.contains("DELETING")) {
                System.out.println("The provisioned instance is DELETING: " + instName);
                screenShot(driver);
                outcome = "DELETING";
                break;
            }

            if (status.contains("ERROR")) {
                System.out.println("The provisioned instance got ERROR: " + instName);
                screenShot(driver);
                outcome = "ERROR";
                break;
            }

            // Matrix provision of "extra small","small","medium" or custom less than 7 nodes should not take longer than 30 minutes on AWS
            if (elapsedTime == 3900) {
                System.out.println("The provisioned instance got TIMEOUT: " + instName);
                screenShot(driver);
                outcome = "TIMEOUT";
                break;
            }
            if(Constant.hostNameOrIP.equals("10.4.24.244"))
            {
                if ((instName.contains("AMC"))) {
                    if (elapsedTime >= count) {
                        { reloadpage(); count=count+100; }
                    }
                }
                if ((!instName.contains("AMC")))
                { if (elapsedTime >= count1) {
                    { reloadpage(); count1 = count1 + 150; }
                } }
            }
            try {
                Thread.sleep(10000); // 10 second sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime = (counter * 10) + 10;
            System.out.println("Elapsed time: " + elapsedTime + "secs - " + status);
            counter = counter + 1; screenShot(driver);
        }return outcome;
    }

    public String getDeletionStatusDetails(String instName) {
        By failure_error= By.xpath("//div[text()='" + instName + "']/preceding::div[1]/following::div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count =150; int count1 =200;
        String status = "";
        int elapsedTime = 0;
        int counter = 0;
        String outcome = "NoInstance";

        while (!status.contains("NoInstance")) {
            status = this.getProvisionStatus(instName);

            if (status.contains("NoInstance")) {
                System.out.println("Instance sucessfully Deleted: " + instName);
                screenShot(driver);
                outcome = "NoInstance";
                break;
            }
            if (status.contains("FAILED")) {
                System.out.println("Instance is FAILED to Delete: " + instName);
                try{
                    wait.until(ExpectedConditions.elementToBeClickable(failure_error));
                    driver.findElement(failure_error).click();
                    System.out.println("Instance Failure details "+driver.findElement(failure_text).getText());
                }catch (TimeoutException|NoSuchElementException e){ System.out.println("Error image icon is not visible");}
                screenShot(driver);
                outcome = "FAILED";
                break;
            }

            if (status.contains("ERROR")) {
                System.out.println("Instance got ERROR while Deleting: " + instName);
                screenShot(driver);
                outcome = "ERROR";
                break;
            }

            // Matrix provision of "extra small","small","medium" or custom less than 7 nodes should not take longer than 30 minutes on AWS
            if (elapsedTime == 2700) {
                System.out.println("Instance is FAILED to Delete got TIMEOUT: " + instName);
                screenShot(driver);
                outcome = "TIMEOUT";
                break;
            }
            if(Constant.hostNameOrIP.equals("10.4.24.244"))
            {
                if ((instName.contains("AMC"))) {
                    if (elapsedTime >= count) {
                        { reloadpage(); count=count+50; }
                    }
                }
                if ((!instName.contains("AMC")))
                { if (elapsedTime >= count1) {
                    { reloadpage(); count1 = count1 + 100; }
                } }
            }
            try {
                Thread.sleep(10000); // 10 second sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime = (counter * 10) + 10;
            System.out.println("Elapsed time: " + elapsedTime + "secs - " + status);
            counter = counter + 1; screenShot(driver);
        }return outcome;
    }


    public int getInstanceIndex(String instancename) {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> availableInstances = driver.findElements(instanceIndex);
                int instIndex = -1;
                for (WebElement instName : availableInstances) {
                    instIndex = instIndex + 1;
                    System.out.println("****" + instName.getText() + "****" + instancename + "****" + "*" + instIndex + "*");
                    if (instName.getText().equals(instancename)) {
                        return instIndex;} }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a (selectInstanceActionButton)stale element :-");
                count = count + 1; screenShot(driver);
                continue;
            }count = count + 4;
        } return -1;
    }

    public InstancesHomePage selectInstanceActionButton( String instancename) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                int InstanceIndex = getInstanceIndex(instancename);
                if(InstanceIndex!=-1){
                    new FluentWait<WebDriver>(driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
                    List<WebElement> MenuItem = driver.findElements(By.xpath("./*//*[@id='contextMenuId']/div"));
                    for (int i=0; i<MenuItem.size();i++)
                    {
                        if(i==InstanceIndex) {
                            JavascriptExecutor js = (JavascriptExecutor)driver;
                            js.executeScript("arguments[0].click();", MenuItem.get(i));
                        }
                    } }else
                {
                    reloadpage();
                    count = count + 1;
                    continue;
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a (selectCloudActionsButton) Exception :-");
                count = count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        }return new InstancesHomePage(driver);
    }


    public InstancesHomePage selectInstanceAction(String instancename, String action1) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectInstanceActionButton(instancename);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> instanaceMenuItems = driver.findElements(popupMenuItems);
                for (WebElement menuoption : instanaceMenuItems) {
                    if (menuoption.getText().equals(action1)) {
                        if (action1.contains("Delete Instance") || action1.contains("Recover Instance")) {
                            menuoption.click();
                            this.selectDialogButton("Yes");
                            this.selectDialogButton("OK");
                            break;
                        } else if (action1.contains("Manage Instance")) {
                            menuoption.click();
                            driver.findElement(manageAmc).click();
                            break;
                        } else {
                            menuoption.click();
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return new InstancesHomePage(driver);
                        }              }
                }
            }catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1; screenShot(driver);
                continue;
            }count = count + 4;
        } return new InstancesHomePage(driver);
    }

    public InstanceDetailsPage selectInstanceDetails(String instancename, String action1) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectInstanceActionButton(instancename);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> instanaceMenuItems = driver.findElements(popupMenuItems);
                for (WebElement menuoption : instanaceMenuItems) {
                    if (menuoption.getText().equals(action1)) {
                        menuoption.click();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return new InstanceDetailsPage(driver);
                    }              }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        } return new InstanceDetailsPage(driver);
    }

    private InstancesHomePage typeInstanceName(String instancename) {
        driver.findElement(updateinstname).clear();
        driver.findElement(updateinstname).sendKeys(instancename);
        return this;
    }

    private InstancesHomePage typeInstanceDescription(String instancedescription) {
        driver.findElement(updateinstdetail).clear();
        driver.findElement(updateinstdetail).sendKeys(instancedescription);
        return this;
    }

    private InstancesHomePage typeManagementlabel(String label) {
        driver.findElement(updatelabel).clear();
        driver.findElement(updatelabel).sendKeys(label);
        return this;
    }

    private InstancesHomePage typeUrl(String url) {
        driver.findElement(updateurl).clear();
        driver.findElement(updateurl).sendKeys(url);
        return this;
    }

    private InstancesHomePage addManagementTool() {
        driver.findElement(addurl).click();
        return this;
    }

    public InstancesHomePage updateInstancewiz1(String instancename, String instancedescription, String label, String url, String wizbtn)
    {
        typeInstanceName(instancename);
        typeInstanceDescription(instancedescription);
        typeManagementlabel(label);
        typeUrl(url);
        if(!label.contains("") && url.contains("")) {
            addManagementTool();
        } return updateInstanceWizardScreen1(wizbtn);
    }

    private InstancesHomePage typeDatanode(String datanodes) {
        driver.findElement(datanode).clear();
        driver.findElement(datanode).sendKeys(datanodes);
        return this;
    }

    private InstancesHomePage typeHostName(String hostname) {
        driver.findElement(datanodehostname).clear();
        driver.findElement(datanodehostname).sendKeys(hostname);
        return this;
    }

    private InstancesHomePage typeSshName(String sshusername) {
        driver.findElement(sshname).clear();
        driver.findElement(sshname).sendKeys(sshusername);
        return this;
    }

    private InstancesHomePage typeSshPassword(String sshpassword) {
        driver.findElement(sshpwd).clear();
        driver.findElement(sshpwd).sendKeys(sshpassword);
        return this;
    }

    private InstancesHomePage typeprvtkey(String key) {
        driver.findElement(privatekey).clear();
        driver.findElement(privatekey).sendKeys(key);
        return this;
    }

    public InstancesHomePage updateInstancewiz2(String datanode, String hostname, String ssh, String sshpwd, String pvtkey, String wizbtn)
    {
        typeDatanode(datanode);
        typeHostName(hostname);
        typeSshName(ssh);
        typeSshPassword(sshpwd);
        typeprvtkey(pvtkey);
        return updateInstanceWizardScreen1(wizbtn);
    }

    private InstancesHomePage updateInstanceWizardScreen1(String wizbttn)  {
        int count = 0;
        while (count < 4)
        { try {
            List<WebElement> wizardBtns = driver.findElements(buttonNames);
            for (WebElement wizbutton : wizardBtns) {
                System.out.println("Wizard : " + wizbutton.getText());
                if (wizbutton.getText().contains(wizbttn)) {
                    wizbutton.click();
                }               }
        }catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("Trying to recover from a stale element :-");
            count = count + 1; screenShot(driver);
            continue;
        }   count = count + 4;
        }return new InstancesHomePage(driver);
    }

    public String getUpdatedInstancename(String updateinstname)  {
        String updateInstanceName = driver.findElement(By.xpath("//div[text()='"+ updateinstname +"']")).getText();
        return updateInstanceName;
    }

    public String getInstanceWindowcount()
    {
        Set<String> instancewindow= driver.getWindowHandles();
        Iterator<String> it = instancewindow.iterator();
        String parent =it.next();
        String child = it.next();
        driver.switchTo().window(child);
        // checkPageIsReady();
        String url =driver.getCurrentUrl();
        System.out.println(url);
        return url;
    }

    public InstancesHomePage clickUngroupedInstance()
    {  int count = 0;
        while (count < 4) {
            try {
                WebElement list1 = driver.findElement(ungroupInst);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", list1);
                count=count+4;
                screenShot(driver);
                return new InstancesHomePage(driver);
            } catch (NoSuchElementException | TimeoutException e) {
                count = count + 1;
                continue;
            }
        } return new InstancesHomePage(driver);
    }

    public boolean checkAvailableOptions(String instancename,String instanceoptions[])
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectInstanceActionButton(instancename);
        int count = 0, counter=0;
        while (count < 4) {
            try {
                List<WebElement> instanaceMenuItems = driver.findElements(popupMenuItems);
                for (WebElement we : instanaceMenuItems) {
                    for (int i = 0; i < instanceoptions.length; i++) {
                        if (we.getText().equals(instanceoptions[i])) {
                            counter++;
                        }    }
                } if (counter == instanceoptions.length) {
                    return true;
                } else {
                    return false;
                }
            }catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                continue;
            }
        } return false;
    }

    public boolean clickAdminlink() {
        boolean flag=false;
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(warningicon).click();
            flag= driver.findElement(alertdialog).isDisplayed();
            driver.findElement(settingicon).click();
            driver.findElement(popupMenuItems).click();
            return flag;
        }catch (NoSuchElementException e)
        {
            return flag;
        }
    }

    public void editActianId(String username,String password, String confirmpassword ) {
        List<WebElement> fields = driver.findElements(textFeilds);
        for(int i=0; i<fields.size();i++)
        {
            fields.get(0).clear();
            fields.get(0).sendKeys(username);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fields.get(1).clear();
            fields.get(1).sendKeys(password);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }fields.get(2).clear();
            fields.get(2).sendKeys(confirmpassword,Keys.TAB);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } break;
        }
    }
}

