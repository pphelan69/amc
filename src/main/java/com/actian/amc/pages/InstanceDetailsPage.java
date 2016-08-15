package com.actian.amc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha.n on 18-02-2016.
 */
public class InstanceDetailsPage extends AMCPage {
    By contentpanel = By.cssSelector(".GEG-4-BEAB");
    By instanceStatus = By.xpath(".//*[@id='instanceSummaryContainerId']/div[9]/div/div[2]");

    By userList = By.cssSelector(".GEG-4-BJV.GEG-4-BIBE.nodeNameInfo");
    By addUserName =  By.xpath("//input[@placeholder='Select username']");
    By addUserRole = By.xpath("//input[@placeholder='Select user role']");
    Actions act;

    public InstanceDetailsPage(WebDriver driver) {
        super(driver);
        // Check that we're on the right page.
        if (!driver.getCurrentUrl().contains("#InstanceDetailsPlace:InstanceDetailsPlace")) {
            throw new IllegalStateException("This is not a valid login landing page");
        }
    }

    public InstanceDetailsPage selectTabLinks(String tabname) {
        List<WebElement> tabnames = driver.findElements(contentpanel);
        for (WebElement tab : tabnames) {
            if (tab.getText().contains(tabname)) {
                tab.click();
                break;    }
        } return new InstanceDetailsPage(driver);
    }


    public String getInstanceStatusfromDetailspage()
    {
        String status=driver.findElement(instanceStatus).getText();
        return status;
    }


    public InstanceDetailsPage clickButton(String btnname)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> availablebuttons = driver.findElements(buttonNames);
        for (int i=0; i<availablebuttons.size();i++ )
        {   System.out.println("*****" + availablebuttons.get(i).getText() + "*****");
            if(availablebuttons.get(i).getText().equals(btnname))
            {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click();", availablebuttons.get(i));
                return new InstanceDetailsPage(driver);
            }
        } return this;
    }



    public InstanceDetailsPage typeUserName(String username) {
        driver.findElement(addUserName).sendKeys(username);
        driver.findElement(addUserName).sendKeys(Keys.TAB);
        return this;
    }


    public void selectUserRole(String role) {
        act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.findElement(addUserRole).sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemsInDropdown));
        List<WebElement> rolelist= driver.findElements(itemsInDropdown);
        for (WebElement roles: rolelist)
        {   System.out.println("********"+roles.getText()+"********");
            if(roles.getText().equals(role))
            {act.moveToElement(roles).perform();
                act.contextClick(roles).perform();
                break;
            }    }
    }

    public InstanceDetailsPage addUser(String username, String role) {
        if (getInstanceUser(username,role)!=true) {
            clickButton("Add Users");
            typeUserName(username);
            selectUserRole(role);
            clickButton("Add");
        }return  new InstanceDetailsPage(driver);
    }

    public boolean getInstanceUser(String username,String role)
    {  By userrole = By.xpath("//div[text()='"+username+"']/following::div[1]");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        List<WebElement> userlist= driver.findElements(userList);
        for (WebElement user: userlist) {
            if(user.getText().equals(username))
            { if (driver.findElement(userrole).getText().equals(role))
                { return true; }
            }
        }return false;
    }

    public void removeShareuser()
    {  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        List<WebElement> userlist= driver.findElements(buttonNames);
        for (int i= 0; i<userlist.size();i++) {
            if(userlist.get(i).getText().equals("Remove"))
            {   JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click();", userlist.get(i));
            } }
    }
}
