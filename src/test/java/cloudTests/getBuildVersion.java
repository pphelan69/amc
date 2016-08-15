package cloudTests;

import com.actian.amc.pages.CloudHomePage;
import com.actian.amc.pages.InstanceNewPage;
import com.actian.amc.pages.InstancesHomePage;
import com.actian.amc.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.Constant;
import utility.Select_Browser;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha.n on 04-04-2016.
 */
public class getBuildVersion {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setup()
    {
        System.out.println("Begin of AMC Build Version Test");
        Select_Browser browser = new Select_Browser();
        driver=browser.Define_Browser(Constant.Browser);
        System.out.println("Browser Selection: " + Constant.Browser);
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        browser.implicitly_Wait();
        browser.browser_Maximize();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("End of Build Version Test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(priority=1,description="Get Build version & Product Version")
    public void get_build_Product_version1() {
        driver.get(baseUrl);
        Reporter.log("AMC Build Version is :");
        Reporter.log(driver.findElement(By.cssSelector(".productLabelStyle")).getText());
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        cloudPage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                Constant.CloudNameRS2, Constant.CloudNameRS2, "", Constant.CloudProviderRS,Constant.CloudUserNameRS,
                Constant.CloudAPIKeyRS,Constant.CloudRegionRS);
        Assert.assertTrue((cloudPage.getCloudNameIndex("RS") != -1), "We created RackSpace cloud definition so expecting to exist.");
        InstancesHomePage instancehomepage =homePage.navigateToInstances();
        InstanceNewPage newInstancePage = instancehomepage.provisionNewInstance();
        List<WebElement> products =newInstancePage.listAllProduct();
        for (WebElement product : products) {
            Reporter.log("Available Products are : " + product.getText());
            System.out.println("Available Products are : " + product.getText());
        }
    }

    @Test(priority=0,description="Check ESD account Enabled for User to List Products.")
    public void edit_ActianAccount()
    {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if(homePage.clickAdminlink()) {
            homePage.editActianId(Constant.esdusername,Constant.esdpassword,Constant.esdpassword);
            homePage.selectDialogButton("Test ID");
            Assert.assertTrue(homePage.getDialogMessage().contains("Actian ID test successful!"));
            homePage.selectDialogButton("OK");
            homePage.selectDialogButton("Update ID");
            System.out.println("ESD account updated..");
        } else {System.out.println("portal already have ESD account");}
    }
}
