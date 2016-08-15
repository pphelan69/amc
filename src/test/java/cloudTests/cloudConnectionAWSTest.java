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
 * Created by pphelan on 10/1/2015.
 */
public class cloudConnectionAWSTest {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of test");
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

    @Test(description="AWS - Test a valid AWS Cloud definition connection with Locate by Availability Zone")
    public void clouds_connection_test1 () {
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
        Assert.assertTrue((awsCloudPage.clickNewCloudDefButton("Test Cloud") == "PASS"), "We expected a valid Test Cloud operation.");
    }
}
