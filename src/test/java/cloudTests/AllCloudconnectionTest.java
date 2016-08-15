package cloudTests;

import com.actian.amc.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utility.Constant;
import utility.Select_Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha.n on 01-06-2016.
 */
public class AllCloudconnectionTest
{
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private SoftAssert softAssert;

    @BeforeTest
    public void setup(){
        System.out.println("Begin of test");
        Select_Browser Browser = new Select_Browser() ;
        System.out.println("Browser Selection: " + Constant.Browser);
        driver = Browser.Define_Browser(Constant.Browser);
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) Assert.fail(verificationErrorString);
    }

    @Test(dataProvider="Cloud zone name",description="AWS - Test All Availability Zone of AWS Cloud definition connection")
    public void aws_clouds_connection_test1 (String zone) {
        driver.get(baseUrl);
        softAssert = new SoftAssert();
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
        awsCloudPage.selectAWSRegion(zone);
        softAssert.assertTrue((awsCloudPage.clickNewCloudDefButton("Test Cloud") == "PASS"), "We expected a valid Test Cloud operation.");
        newCloudPage.signOut();
        softAssert.assertAll();
    }

    @DataProvider(name="Cloud zone name")
    public Object[][] getDataFromDataprovider()
    { return new Object[][] {
            {"Asia Pacific (Singapore) Zone A" }, {"Asia Pacific (Singapore) Zone B" },
            {"Asia Pacific (Sydney) Zone A" }, {"Asia Pacific (Sydney) Zone B" },
            {"Asia Pacific (Sydney) Zone C" }, {"Asia Pacific (Tokyo) Zone A" },
            {"Asia Pacific (Tokyo) Zone C" },  {"EU (Frankfurt) Zone A" },
            {"EU (Frankfurt) Zone B" },{"EU (Ireland) Zone A" },
            {"EU (Ireland) Zone B" },  {"EU (Ireland) Zone C" },
            {"US East (N. Virginia) Zone A" },{"US East (N. Virginia) Zone C" },
            {"US East (N. Virginia) Zone D" },{"US East (N. Virginia) Zone E" },
            {"US West (N. California) Zone A" },{"US West (N. California) Zone C" },
            {"US West (Oregon) Zone A" }, {"US West (Oregon) Zone B" },
            {"US West (Oregon) Zone C" }  };
    }

    @Test(description="AWS_Subnet - Test All Availability Zone of AWS Cloud definition connection", enabled=false)
    public void aws_subnet_clouds_connection_test1 (String zone) {
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
        awsCloudPage.radioButton_Select(Constant.SubnetIdZoneAWS);
        awsCloudPage.textfield_Type("Subnet ID", Constant.SubnetIdAWS);
        //awsCloudPage.textfield_Type("Security Group ID", Constant.SecurityGroupIdAWS);
       // awsCloudPage.selectAWSRegion(zone);
        Assert.assertTrue((awsCloudPage.clickNewCloudDefButton("Test Cloud") == "PASS"), "We expected a valid Test Cloud operation.");
    }
}
