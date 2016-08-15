package cloudTests;

import com.actian.amc.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utility.Constant;
import utility.Select_Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha.n on 30-03-2016.
 */
public class cloudCreationRSTest {
    public WebDriver driver;
    public String        baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of cloudCreationRSTest");
        Select_Browser Browser = new Select_Browser() ;
        System.out.println("Browser Selection: " + Constant.Browser);
        driver = Browser.Define_Browser(Constant.Browser);
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) Assert.fail(verificationErrorString);
    }

    @Test(description="RackSpace - Create a Rackspace cloud definition and test the cancelling of its creation.")
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
        rackspaceCloudPage.clickNewCloudDefButton("Cancel");
        Assert.assertTrue((cloudPage.getCloudNameIndex(Constant.CloudNameRS) == -1), "We cancelled cloud creation so expecting cloud definition to not exist.");
    }

    @Test(description="RackSpace - Create a Rackspace cloud definition.")
    public void clouds_creation_test2 () {

        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudHomePage test1 =cloudPage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                Constant.CloudNameRS,
                Constant.CloudDescriptionRS,
                Constant.CloudGroupNameRS,
                Constant.CloudProviderRS,
                Constant.CloudUserNameRS,
                Constant.CloudAPIKeyRS,
                Constant.CloudRegionRS);

        Assert.assertTrue((cloudPage.getCloudNameIndex(Constant.CloudNameRS) != -1), "We created RackSpace cloud definition so expecting to exist.");
        test1.selectCloudAction(Constant.CloudNameRS, "Delete Cloud");
    }

    @Test(description = "Verify alert message for cloud service Rackspace")
    public void clouds_creation_test3() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderRackSpace);

        String test1 = rackspaceCloudPage.getAlertInfoMsg("Cloud service");
        softAssert.assertEquals(test1,Constant.AlertMsgCloudServiceRackSpace, "verifying alert message");

        String test2 = rackspaceCloudPage.getAlertInfoMsg("Cloud Provider/API");
        softAssert.assertEquals(test2,Constant.AlertMsgCloudProviderAPIRackSapce, "verifying alert message");

        String test3 = rackspaceCloudPage.getAlertInfoMsg("Username");
        softAssert.assertEquals(test3,Constant.AlertMsgUsernameRackSapce, "verifying alert message");

        String test4 = rackspaceCloudPage.getAlertInfoMsg("API Key");
        softAssert.assertEquals(test4, Constant.AlertMsgAPIKeyRackSapce, "verifying alert message");

        String test5 = rackspaceCloudPage.getAlertInfoMsg("Region Name");
        softAssert.assertEquals(test5,Constant.AlertMsgRegionNameRackSapce, "verifying alert message");

        rackspaceCloudPage.clickNewCloudDefButton("Cancel");
        softAssert.assertAll();
    }

    @Test(description = "RackSpace - Verify Warning message Cloud Name")
    public void clouds_creation_test4() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderRackSpace);

        //rackspaceCloudPage.textfield_Type("Cloud name", Constant.CloudNameRS);
        rackspaceCloudPage.textfield_Type("Description", Constant.CloudDescriptionRS);
        rackspaceCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        rackspaceCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderRS);
        rackspaceCloudPage.textfield_Type("Username", Constant.CloudUserNameRS);
        rackspaceCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        rackspaceCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);

        String x1= rackspaceCloudPage.getWarningMsgRequiredField("Cloud Name");
        Assert.assertTrue(x1.equals(Constant.WarningMsgReqField), "verifying alert message");
        rackspaceCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description = "RackSpace - Verify Warning message Cloud Provider/API")
    public void clouds_creation_test5() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderRackSpace);

        rackspaceCloudPage.textfield_Type("Cloud name", Constant.CloudNameRS);
        rackspaceCloudPage.textfield_Type("Description", Constant.CloudDescriptionRS);
        rackspaceCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        // rackspaceCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderRS);
        rackspaceCloudPage.textfield_Type("Username", Constant.CloudUserNameRS);
        rackspaceCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        rackspaceCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);

        String x2= rackspaceCloudPage.getWarningMsgRequiredField("Cloud Provider/API");
        Assert.assertTrue(x2.equals(Constant.WarningMsgReqField), "verifying alert message");
        rackspaceCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description = "RackSpace - Verify Warning message Username")
    public void clouds_creation_test6() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderRackSpace);

        rackspaceCloudPage.textfield_Type("Cloud name", Constant.CloudNameRS);
        rackspaceCloudPage.textfield_Type("Description", Constant.CloudDescriptionRS);
        rackspaceCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        rackspaceCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderRS);
        //rackspaceCloudPage.textfield_Type("Username", Constant.CloudUserNameRS);
        rackspaceCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        rackspaceCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);

        String x3= rackspaceCloudPage.getWarningMsgRequiredField("Username");
        Assert.assertTrue(x3.equals(Constant.WarningMsgReqField), "verifying alert message");
        rackspaceCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description = "RackSpace - Verify Warning message API Key")
    public void clouds_creation_test7() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderRackSpace);

        rackspaceCloudPage.textfield_Type("Cloud name", Constant.CloudNameRS);
        rackspaceCloudPage.textfield_Type("Description", Constant.CloudDescriptionRS);
        rackspaceCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        rackspaceCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderRS);
        rackspaceCloudPage.textfield_Type("Username", Constant.CloudUserNameRS);
        // rackspaceCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        rackspaceCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);

        String x4= rackspaceCloudPage.getWarningMsgRequiredField("API Key");
        Assert.assertTrue(x4.equals(Constant.WarningMsgReqField), "verifying alert message");
        rackspaceCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description = "RackSpace - Verify Warning messageRegion Name")
    public void clouds_creation_test8() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage rackspaceCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderRackSpace);

        rackspaceCloudPage.textfield_Type("Cloud name", Constant.CloudNameRS);
        rackspaceCloudPage.textfield_Type("Description", Constant.CloudDescriptionRS);
        rackspaceCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        rackspaceCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderRS);
        rackspaceCloudPage.textfield_Type("Username", Constant.CloudUserNameRS);
        rackspaceCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        // rackspaceCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);

        String x5= rackspaceCloudPage.getWarningMsgRequiredField("Region Name");
        Assert.assertTrue(x5.equals(Constant.WarningMsgReqField), "verifying alert message");
        rackspaceCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description="RackSpace - Create a RackSpace cloud definition.")
    public void clouds_creation_test9() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        cloudPage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                Constant.CloudNameRS2, Constant.CloudNameRS2, "", Constant.CloudProviderRS,Constant.CloudUserNameRS,
                Constant.CloudAPIKeyRS,Constant.CloudRegionRS);
        Assert.assertTrue((cloudPage.getCloudNameIndex("RS") != -1), "We created RackSpace cloud definition so expecting to exist.");
    }
}
