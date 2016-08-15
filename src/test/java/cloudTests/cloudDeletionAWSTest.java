package cloudTests;

import com.actian.amc.pages.CloudHomePage;
import com.actian.amc.pages.InstancesHomePage;
import com.actian.amc.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.Constant;
import utility.Select_Browser;

import java.util.concurrent.TimeUnit;

/**
 * Created by pphelan on 9/30/2015.
 */
public class cloudDeletionAWSTest {
    private WebDriver driver;
    private String baseUrl;
    /*private String hostNameOrIP;
    private String hostPort;
    private boolean acceptNextAlert = true;*/
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of cloudDeletionAWSTest");
        Select_Browser Browser = new Select_Browser();
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

    @Test(description="AWS - Test deletion of a AWS cloud definition.")
    public void clouds_deletion_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage        = new LoginPage(driver);
        InstancesHomePage homePage  = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudPage     = homePage.navigateToClouds();
        CloudHomePage test1 = cloudPage.createCloudDefAWS(Constant.CloudServiceProviderAWS,
                Constant.CloudNameAWS,
                Constant.CloudDescriptionAWS,
                Constant.CloudGroupNameAWS,
                Constant.CloudProviderAWS,
                Constant.CloudAccessKeyAWS,
                Constant.CloudSecretAccessKeyAWS,Constant.AvailableZoneAWS,"","",
                Constant.CloudRegionAWS);

        cloudPage.selectCloudAction(Constant.CloudNameAWS, "Delete Cloud");
        test1.reloadpage();
        Assert.assertTrue((cloudPage.getCloudNameIndex(Constant.CloudNameAWS) == -1), "We deleted cloud 'PeterAWS' so expecting cloud definition to not exist.");
    }
}