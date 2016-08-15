package cloudTests;

import com.actian.amc.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.Constant;
import utility.Select_Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha.n on 30-03-2016.
 */
public class cloudConnectionRSTest {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of cloudConnectionRSTest");
        Select_Browser Browser = new Select_Browser() ;
        System.out.println("Browser Selection: " + Constant.Browser);
        driver = Browser.Define_Browser(Constant.Browser);
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) Assert.fail(verificationErrorString);
    }

    @Test(description="RackSpace - Test a valid Rackspace cloud definition connection.")
    public void clouds_creation_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderRackSpace);
        rackspaceCloudPage.textfield_Type("Cloud name",Constant.CloudNameRS);
        rackspaceCloudPage.textfield_Type("Description",Constant.CloudDescriptionRS);
        rackspaceCloudPage.textfield_Type("Cloud group name",Constant.CloudGroupNameRS);
        rackspaceCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderRS);
        rackspaceCloudPage.textfield_Type("Username",Constant.CloudUserNameRS);
        rackspaceCloudPage.textfield_Type("API Key",Constant.CloudAPIKeyRS);
        rackspaceCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        Assert.assertTrue((rackspaceCloudPage.clickNewCloudDefButton("Test Cloud") == "PASS"), "We expected a valid Test Cloud operation.");
    }
}
