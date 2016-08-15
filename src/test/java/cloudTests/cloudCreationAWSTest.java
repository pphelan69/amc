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

//import org.testng.asserts.SoftAssert;

/**
 * Created by pphelan on 9/30/2015.
 */
public class cloudCreationAWSTest {
    public WebDriver     driver;
    public String        baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private SoftAssert   softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of cloudCreationAWSTest");
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

    @Test(description="AWS - Create an AWS cloud definition and test the cancelling of its creation.")
    public void clouds_creation_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage awsCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderAWS);
        awsCloudPage.textfield_Type("Cloud name", Constant.CloudNameAWS);
        awsCloudPage.textfield_Type("Description",Constant.CloudDescriptionAWS);
        awsCloudPage.textfield_Type("Cloud group name",Constant.CloudGroupNameAWS);
        awsCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderAWS);
        awsCloudPage.textfield_Type("Access Key",Constant.CloudAccessKeyAWS);
        awsCloudPage.textfield_Type("Secret Access Key", Constant.CloudSecretAccessKeyAWS);
        awsCloudPage.radioButton_Select(Constant.AvailableZoneAWS);
        awsCloudPage.selectAWSRegion(Constant.CloudRegionAWS);
        awsCloudPage.clickNewCloudDefButton("Cancel");
        System.out.println("index ***" + cloudPage.getCloudNameIndex(Constant.CloudNameAWS));
        Assert.assertTrue((cloudPage.getCloudNameIndex(Constant.CloudNameAWS) == -1), "We cancelled cloud creation so expecting cloud definition to not exist.");
    }

    @Test(description="AWS - Create an AWS cloud definition.")
    public void clouds_creation_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();

        CloudHomePage test1 = cloudPage.createCloudDefAWS(Constant.CloudServiceProviderAWS,
                Constant.CloudNameAWS,
                Constant.CloudDescriptionAWS,
                Constant.CloudGroupNameAWS,
                Constant.CloudProviderAWS,
                Constant.CloudAccessKeyAWS,
                Constant.CloudSecretAccessKeyAWS,Constant.AvailableZoneAWS,"","",
                Constant.CloudRegionAWS);

        System.out.println("index ***"+cloudPage.getCloudNameIndex(Constant.CloudNameAWS));
        Assert.assertTrue((cloudPage.getCloudNameIndex(Constant.CloudNameAWS) != -1), "We created AWS cloud definition so expecting to exist.");
        test1.selectCloudAction(Constant.CloudNameAWS, "Delete Cloud");
    }

    @Test(description = "Verify alert message for cloud service Amazon Web Services")
    public void clouds_creation_test3() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage AWSCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderAWS);

        String test1 = AWSCloudPage.getAlertInfoMsg("Cloud service");
        softAssert.assertEquals(test1,Constant.AlertMsgCloudServiceAWS, "verifying alert message");

        String test2 = AWSCloudPage.getAlertInfoMsg("Cloud Provider/API");
        softAssert.assertEquals(test2,Constant.AlertMsgCloudProviderAPIAWS, "verifying alert message");

        String test3 = AWSCloudPage.getAlertInfoMsg("Access Key");
        softAssert.assertEquals(test3,Constant.AlertMsgAccessAWS, "verifying alert message");

        String test4 = AWSCloudPage.getAlertInfoMsg("Secret Access Key");
        softAssert.assertEquals(test4,Constant.AlertMsgSecretAccesskeyAWS, "verifying alert message");
        AWSCloudPage.radioButton_Select(Constant.AvailableZoneAWS);
        String test5 = AWSCloudPage.getAlertInfoMsg("Availability Zone");
        softAssert.assertEquals(test5,Constant.AlertMsgRegionNameAWS, "verifying alert message");

        String test6 = AWSCloudPage.getAlertInfoMsg("CentOS License agreement");
        softAssert.assertEquals(test6,Constant.AlertMsgAwsLicenseAgreement, "verifying alert message");

        AWSCloudPage.clickNewCloudDefButton("Cancel");
        softAssert.assertAll();
    }

    @Test(description = "AWS - Verify Warning message for Cloud name")
    public void clouds_creation_test4() {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage awsCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderAWS);

        // awsCloudPage.textfield_Type("Cloud name", Constant.CloudNameAWS);
        awsCloudPage.textfield_Type("Description", Constant.CloudDescriptionAWS);
        awsCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameAWS);
        awsCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderAWS);
        awsCloudPage.textfield_Type("Access Key", Constant.CloudAccessKeyAWS);
        awsCloudPage.textfield_Type("Secret Access Key", Constant.CloudSecretAccessKeyAWS);
        awsCloudPage.radioButton_Select(Constant.AvailableZoneAWS);
        awsCloudPage.selectAWSRegion(Constant.CloudRegionAWS);

        String x1 = awsCloudPage.getWarningMsgRequiredField("Cloud Name");
        Assert.assertTrue(x1.equals(Constant.WarningMsgCloudField)||x1.equals(Constant.WarningMsgReqField) , "verifying alert message");
        awsCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description = "AWS - Verify Warning message for Cloud Provider/API ")
    public void clouds_creation_test5() {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage awsCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderAWS);

        awsCloudPage.textfield_Type("Cloud name", Constant.CloudNameAWS);
        awsCloudPage.textfield_Type("Description", Constant.CloudDescriptionAWS);
        awsCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameAWS);
        //awsCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderAWS);
        awsCloudPage.textfield_Type("Access Key", Constant.CloudAccessKeyAWS);
        awsCloudPage.textfield_Type("Secret Access Key", Constant.CloudSecretAccessKeyAWS);
        awsCloudPage.radioButton_Select(Constant.AvailableZoneAWS);
        awsCloudPage.selectAWSRegion(Constant.CloudRegionAWS);

        String x2 = awsCloudPage.getWarningMsgRequiredField("Cloud Provider/API");
        Assert.assertTrue(x2.equals(Constant.WarningMsgReqField), "verifying alert message");
        awsCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description = "AWS - Verify Warning message for Access Key")
    public void clouds_creation_test6() {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage awsCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderAWS);

        awsCloudPage.textfield_Type("Cloud name", Constant.CloudNameAWS);
        awsCloudPage.textfield_Type("Description", Constant.CloudDescriptionAWS);
        awsCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameAWS);
        awsCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderAWS);
        //awsCloudPage.textfield_Type("Access Key", Constant.CloudAccessKeyAWS);
        awsCloudPage.textfield_Type("Secret Access Key", Constant.CloudSecretAccessKeyAWS);
        awsCloudPage.radioButton_Select(Constant.AvailableZoneAWS);
        awsCloudPage.selectAWSRegion(Constant.CloudRegionAWS);

        String x3 = awsCloudPage.getWarningMsgRequiredField("Access Key");
        Assert.assertTrue(x3.equals(Constant.WarningMsgReqField), "verifying alert message");
        awsCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description = "AWS - Verify Warning message for Secret Access Key")
    public void clouds_creation_test7() {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        CloudNewPage newCloudPage = cloudPage.submitNewCloud();
        NewCloudDefinitionPage awsCloudPage = newCloudPage.selectCloudProvider(Constant.CloudServiceProviderAWS);
        awsCloudPage.textfield_Type("Cloud name", Constant.CloudNameAWS);
        awsCloudPage.textfield_Type("Description", Constant.CloudDescriptionAWS);
        awsCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameAWS);
        awsCloudPage.textfield_Type("Cloud Provider/API", Constant.CloudProviderAWS);
        awsCloudPage.textfield_Type("Access Key", Constant.CloudAccessKeyAWS);
        //awsCloudPage.textfield_Type("Secret Access Key", Constant.CloudSecretAccessKeyAWS);
        awsCloudPage.radioButton_Select(Constant.AvailableZoneAWS);
        awsCloudPage.selectAWSRegion(Constant.CloudRegionAWS);

        String x4= awsCloudPage.getWarningMsgRequiredField("Secret Access Key");
        Assert.assertTrue(x4.equals(Constant.WarningMsgReqField), "verifying alert message");
        awsCloudPage.clickNewCloudDefButton("Cancel");
    }

    @Test(description="AWS - Create an AWS cloud definition.")
    public void clouds_creation_test8() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        cloudPage.createCloudDefAWS(Constant.CloudServiceProviderAWS,
                Constant.CloudNameAWS2, "AWS", "", Constant.CloudProviderAWS,
                Constant.CloudAccessKeyAWS,
                Constant.CloudSecretAccessKeyAWS,Constant.AvailableZoneAWS,"","",
                Constant.CloudRegionAWS);
        Assert.assertTrue((cloudPage.getCloudNameIndex("AWS") != -1), "We created AWS cloud definition so expecting to exist.");
    }
}