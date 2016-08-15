package cloudTests;

import com.actian.amc.pages.CloudHomePage;
import com.actian.amc.pages.EditCloudDefinitionPage;
import com.actian.amc.pages.InstancesHomePage;
import com.actian.amc.pages.LoginPage;
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
public class cloudEditionRSTest {
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of cloudEditionRSTest");
        Select_Browser Browser = new Select_Browser();
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
    }

    @Test(description="Edit AWS cloud definition and test the cancelling of its editing ")
    public void clouds_Edition_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        cloudPage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                Constant.TestCloudName,
                Constant.TestCloudDescription,
                Constant.CloudGroupNameRS,
                Constant.CloudProviderRS,
                Constant.CloudUserNameRS,
                Constant.CloudAPIKeyRS,
                Constant.CloudRegionRS);

        EditCloudDefinitionPage RSCloudPage = cloudPage.selectCloudAction2(Constant.TestCloudName, "Edit Cloud");
        RSCloudPage.textfield_Type("Cloud name", Constant.EditCloudName);
        RSCloudPage.textfield_Type("Description",Constant.EditCloudDescription);
        RSCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        RSCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderRS);
        RSCloudPage.textfield_Type("Username",Constant.CloudUserNameRS);
        RSCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        RSCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        RSCloudPage.clickNewCloudDefButton("Cancel");
        RSCloudPage.reloadpage();
        Assert.assertTrue((cloudPage.getCloudNameIndex(Constant.EditCloudName) == -1), "We cancelled editing so expecting cloud definition to not exist.");
        cloudPage.selectCloudAction(Constant.TestCloudName, "Delete Cloud");
    }

    @Test(description="Edit AWS cloud definition and verify entered values saved while editing cloud definition.")
    public void clouds_Edition_test2() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        cloudPage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                Constant.TestCloudName,
                Constant.TestCloudDescription,
                Constant.CloudGroupNameRS,
                Constant.CloudProviderRS,
                Constant.CloudUserNameRS,
                Constant.CloudAPIKeyRS,
                Constant.CloudRegionRS);

        EditCloudDefinitionPage awsCloudPage = cloudPage.selectCloudAction2(Constant.TestCloudName, "Edit Cloud");
        awsCloudPage.textfield_Type("Cloud name", Constant.EditCloudName);
        String value1= awsCloudPage.get_textfield_Value("Cloud name");
        softAssert.assertTrue((value1.equals( Constant.EditCloudName)), "verify the cloud name.");

        awsCloudPage.textfield_Type("Description", Constant.EditCloudDescription);
        String value2= awsCloudPage.get_textfield_Value("Description");
        softAssert.assertTrue((value2.equals(Constant.EditCloudDescription)), "verify the cloud Description.");

        awsCloudPage.textfield_Type("Cloud group name",Constant.CloudGroupNameRS);
        String value3= awsCloudPage.get_textfield_Value("Cloud group name");
        softAssert.assertTrue((value3.equals(Constant.CloudGroupNameRS)), "verify the  CloudGroupNameRS.");

        awsCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderRS);
        String value4= awsCloudPage.get_textfield_Value("Cloud Provider/API");
        softAssert.assertTrue((value4.equals(Constant.CloudProviderRS)), "verify the CloudProviderRS");

        awsCloudPage.textfield_Type("Username", Constant.CloudUserNameRS);
        String value5= awsCloudPage.get_textfield_Value("Username");
        softAssert.assertTrue((value5.equals(Constant.CloudUserNameRS)), "verify the CloudUserNameRS");

        awsCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        String value6= awsCloudPage.get_textfield_Value("API Key");
        softAssert.assertTrue((value6.equals(Constant.CloudAPIKeyRS)), "verify the CloudAPIKeyRS.");

        awsCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        String value7= awsCloudPage.get_textfield_Value("Region Name");
        softAssert.assertTrue((value7.equals(Constant.CloudRegionRS)), "verify the CloudRegionRS.");

        awsCloudPage.clickNewCloudDefButton("Cancel");
        softAssert.assertTrue((cloudPage.getCloudNameIndex(Constant.EditCloudName) == -1), "We cancelled editing so expecting cloud definition to not exist.");

        softAssert.assertAll();
        cloudPage.selectCloudAction(Constant.TestCloudName, "Delete Cloud");
    }

    @Test(description="Verify Edit cloud definition and save ")
    public void clouds_Edition_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage = homePage.navigateToClouds();
        cloudPage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                Constant.TestCloudName,
                Constant.TestCloudDescription,
                Constant.CloudGroupNameRS,
                Constant.CloudProviderRS,
                Constant.CloudUserNameRS,
                Constant.CloudAPIKeyRS,
                Constant.CloudRegionRS);

        EditCloudDefinitionPage RSCloudPage = cloudPage.selectCloudAction2(Constant.TestCloudName, "Edit Cloud");
        RSCloudPage.textfield_Type("Cloud name", Constant.EditCloudName);
        RSCloudPage.textfield_Type("Description",Constant.EditCloudDescription);
        RSCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        RSCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderRS);
        RSCloudPage.textfield_Type("Username",Constant.CloudUserNameRS);
        RSCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        RSCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        RSCloudPage.clickButton("Save");
        RSCloudPage.getDialogMessage();
        RSCloudPage.selectDialogButton("OK");
        RSCloudPage.reloadpage();
        Assert.assertTrue((cloudPage.getCloudNameIndex(Constant.EditCloudName) != -1), "We saved editing so expecting cloud definition to exist.");
        cloudPage.selectCloudAction(Constant.EditCloudName, "Delete Cloud");
    }
}
