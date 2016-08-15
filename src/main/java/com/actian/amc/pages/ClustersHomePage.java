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
 * Created by manjunatha.n on 22-04-2016.
 */
public class ClustersHomePage extends AMCPage {

    By ClusterContainer = By.xpath(".//*[@id='kpiFieldContainer']/div[1]/div[1]");
    By ClusterNames = By.cssSelector(".gwt-Label.groupNameLabelStyle");

    By userList = By.xpath(".//*[@id='userSharingGridId']/div[2]/div[1]/table/tbody[2]/tr/td[1]/div");
    By addUserName =  By.xpath("//input[@placeholder='Select username']");
    By addUserRole = By.xpath("//input[@placeholder='Select user role']");
    By clusternameinfo = By.cssSelector(".GEG-4-BJV.GEG-4-BIBE.nodeNameInfo");
    By shareClusterCancelbutton = By.cssSelector(".GEG-4-BCK.GEG-4-BEGC"); // (X) symbol in dialog

    Wait<WebDriver> wait;
    Actions act;

    public ClustersHomePage(WebDriver driver) {
        super(driver);
        if (!driver.getCurrentUrl().toString().contains("#ClusterManagementPlace:ClusterManagementPlace"))
            throw new IllegalStateException("This is not a Cluster HomePage");
    }

    public String getKpiContainerStatus() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                String x = driver.findElement(ClusterContainer).getText();
                count = count + 4;
                return x;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException :-");
                count = count + 1;
                screenShot(driver);
                reLogin();
                continue;
            }
        } return "0";
    }


    public String getProvisionStatus(String clusterName) {
        int count = 0;
        while (count < 4) {
            try {
                String y = getKpiContainerStatus();
                if (!y.equals("0")) {
                    By provisionStatus = By.xpath("//div[text()='" + clusterName + "']/following::div[1]/following::div[1]");
                    List<WebElement> availableClusters = driver.findElements(ClusterNames);
                    if (y.equals(Integer.toString(availableClusters.size()))) {
                        for (int i = 0; i < availableClusters.size(); i++) {
                            WebElement clustName = availableClusters.get(i);
                            System.out.println("****" + clustName.getText() + "****");
                            if (clustName.getText().equals(clusterName)) {
                                wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(30, TimeUnit.SECONDS)
                                        .ignoring(StaleElementReferenceException.class)
                                        .pollingEvery(1, TimeUnit.SECONDS);
                                WebElement p = wait.until(ExpectedConditions.elementToBeClickable(provisionStatus));
                                return clustName.findElement(provisionStatus).getText();
                            }
                        } } else {
                        reloadpage();
                        count = count + 1;
                        continue;
                    }
                }
            }catch (NoSuchElementException | StaleElementReferenceException | NumberFormatException e) {
                System.out.println("Trying to recover from a stale element :-");
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        }return "NoCluster";
    }


    public String getProvisionStatusDetails(String clustName) {
        String Clustername= clustName+" Cluster";
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count =100; int count1 =200;
        String status = "";
        int elapsedTime = 0;
        int counter = 0;
        String outcome = "RUNNING";

        while (!status.contains("RUNNING")) {
            status = this.getProvisionStatus(Clustername);
            if (status.contains("NoCluster")) {
                System.out.println("Cluster is FAILED to Provision " + Clustername);
                screenShot(driver);
                outcome = "FAILED";
                break;
            }

            if (status.contains("STOPPED")) {
                System.out.println("The provisioned cluster is STOPPED: " + Clustername);
                screenShot(driver);
                outcome = "STOPPED";
                break;
            }

            if (status.contains("FAILED")) {
                System.out.println("The provisioned cluster is FAILED: " + Clustername);
                outcome = "FAILED";
                break;
            }

            if (status.contains("DELETING")) {
                System.out.println("The provisioned cluster is DELETING: " + Clustername);
                screenShot(driver);
                outcome = "DELETING";
                break;
            }

            if (status.contains("ERROR")) {
                System.out.println("The provisioned cluster got ERROR: " + Clustername);
                screenShot(driver);
                outcome = "ERROR";
                break;
            }

            if (elapsedTime == 2100) {
                System.out.println("The provisioned cluster got TIMEOUT: " + Clustername);
                screenShot(driver);
                outcome = "TIMEOUT";
                break;
            }
            if(Constant.hostNameOrIP.equals("10.4.24.244"))
            {
                if ((Clustername.contains("AMC"))) {
                    if (elapsedTime >= count) {
                        { reloadpage(); count=count+50; }
                    }
                }
                if ((!Clustername.contains("AMC")))
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
            counter = counter + 1;
            screenShot(driver);
        }return outcome;
    }


    public String getDeletionStatusDetails(String clustName) {
        String Clustername= clustName+" Cluster";
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count =100; int count1 =200;
        String status = "";
        int elapsedTime = 0;
        int counter = 0;
        String outcome = "NoCluster";

        while (!status.contains("NoCluster")) {
            status = this.getProvisionStatus(Clustername);

            if (status.contains("NoCluster")) {
                System.out.println("Instance sucessfully Deleted: " + Clustername);
                screenShot(driver);
                outcome = "NoCluster";
                break;
            }
            if (status.contains("FAILED")) {
                System.out.println("Cluster is FAILED to Delete: " + Clustername);
                screenShot(driver);
                outcome = "FAILED";
                break;
            }

            if (status.contains("ERROR")) {
                System.out.println("Cluster got ERROR while Deleting: " + Clustername);
                screenShot(driver);
                outcome = "ERROR";
                break;
            }

            if (elapsedTime == 2100) {
                System.out.println("Cluster is FAILED to Delete got TIMEOUT: " + Clustername);
                screenShot(driver);
                outcome = "TIMEOUT";
                break;
            }
            if(Constant.hostNameOrIP.equals("10.4.24.244"))
            {
                if ((Clustername.contains("AMC"))) {
                    if (elapsedTime >= count) {
                        { reloadpage(); count=count+50; }
                    }
                }
                if ((!Clustername.contains("AMC")))
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
            counter = counter + 1;
            screenShot(driver);
        }return outcome;
    }


    public int getClusterIndex(String clustername) {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> availableCluster = driver.findElements(ClusterNames);
                int clustIndex = -1;
                for (WebElement clustName : availableCluster) {
                    clustIndex = clustIndex + 1;
                    System.out.println("****" + clustName.getText() + "****" + clustername + "****" + "*" + clustIndex + "*");
                    if (clustName.getText().equals(clustername)) {
                        return clustIndex;} }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a (getClusterIndex)stale element :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }count = count + 4;
        } return -1;
    }

    public ClustersHomePage selectClusterActionButton( String clustername) {
        String Clustername= clustername+" Cluster";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                int ClusterIndex = getClusterIndex(Clustername);
                if(ClusterIndex!=-1){
                    new FluentWait<WebDriver>(driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
                    List<WebElement> MenuItem = driver.findElements(By.xpath("./*//*[@id='contextMenuId']/div"));
                    for (int i=0; i<MenuItem.size();i++)
                    {
                        if(i==ClusterIndex) {
                            JavascriptExecutor js = (JavascriptExecutor)driver;
                            js.executeScript("arguments[0].click();", MenuItem.get(i));
                        }
                    } }else
                {   reloadpage(); count = count + 1; continue; }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a (selectClusterActionButton) Exception :-");
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        }return new ClustersHomePage(driver);
    }


    public ClustersHomePage selectClusterAction(String clustername, String action1) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectClusterActionButton(clustername);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> clusterMenuItems = driver.findElements(popupMenuItems);
                for (WebElement menuoption : clusterMenuItems) {
                    if (menuoption.getText().equals(action1)) {
                        if (action1.contains("Delete Cluster")) {
                            menuoption.click();
                            this.selectDialogButton("Yes");
                            this.selectDialogButton("OK");
                            break;
                        } else
                        { menuoption.click();
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } return new ClustersHomePage(driver);
                        }              } }
            }catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        } return new ClustersHomePage(driver);
    }
    public ClustersHomePage addUser(String username, String role) {
        if (getClusterUser(username,role)!=true) {
            clickButton("Add Users");
            typeUserName(username);
            selectUserRole(role);
            clickButton("Add");
        }return  new ClustersHomePage(driver);
    }

    public boolean getClusterUser(String username,String role)
    {  By userrole = By.xpath("//div[text()='"+username+"']/following::div[1]");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        List<WebElement> userlist= driver.findElements(userList);
        for (WebElement user: userlist) {
            if(user.getText().equals(username))
            {   if (driver.findElement(userrole).getText().equals(role))
            { return true; }
            }
        }return false;
    }

    public ClustersHomePage clickButton(String btnname)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> availablebuttons = driver.findElements(buttonNames);
        for (int i=0; i<availablebuttons.size();i++ )
        {   System.out.println("*****" + availablebuttons.get(i).getText() + "*****");
            if(availablebuttons.get(i).getText().equals(btnname))
            {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click();", availablebuttons.get(i));
                return new ClustersHomePage(driver);
            }
        } return this;
    }

    public ClustersHomePage typeUserName(String username) {
        driver.findElement(addUserName).sendKeys(username);
        driver.findElement(addUserName).sendKeys(Keys.TAB);
        return this;
    }

    public void selectUserRole(String role) {
        int count = 0;
        while (count < 4) {
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
                        count=count+4;
                        break;
                    }  }
            } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }  }
    }

    public List<WebElement> getPrimaryClusterNodeInfo()
    {
        List<WebElement> PrimaryNodeInfo = driver.findElements(clusternameinfo);
        return PrimaryNodeInfo;
    }

    public boolean checkAvailableNodes()
    {   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0, counter=0;
        while (count < 4) {
            try {
                List<WebElement> SharedNodeInfo = driver.findElements(clusternameinfo);
                List<WebElement> PrimaryNodeInfo =getPrimaryClusterNodeInfo();
                for (WebElement shareNode : SharedNodeInfo) {
                    for (int i = 0; i < PrimaryNodeInfo.size(); i++) {
                        if (shareNode.getText().equals(PrimaryNodeInfo.get(i).getText())) {
                            System.out.println("******* sharedNode **** " + shareNode.getText()+ " ***** Primary Node **** " +PrimaryNodeInfo.get(i).getText() );
                            counter++;
                        }    }
                } if (counter == PrimaryNodeInfo.size()) {
                    return true;
                } else {
                    return false;
                }
            }catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }
        } return false;
    }

    public void clickElement() {
        WebElement ClusterNames = driver.findElement(By.cssSelector(".gwt-Label.groupNameLabelStyle"));
        super.clickElement(ClusterNames);
    }

    public void clickCancelElement() {
        WebElement shareWindow = driver.findElement(shareClusterCancelbutton);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", shareWindow);
        reloadpage();
    }
    public boolean checkAvailableOptions(String clustername,String clusteroptions[])
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectClusterActionButton(clustername);
        int count = 0, counter=0;
        while (count < 4) {
            try {
                List<WebElement> instanaceMenuItems = driver.findElements(popupMenuItems);
                for (WebElement we : instanaceMenuItems) {
                    for (int i = 0; i < clusteroptions.length; i++) {
                        if (we.getText().equals(clusteroptions[i])) {
                            counter++;
                        }    }
                } if (counter == clusteroptions.length) {
                    return true;
                } else {
                    return false;
                }
            }catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            }
        } return false;
    }
}
