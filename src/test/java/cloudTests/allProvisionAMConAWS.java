package cloudTests;

import com.actian.amc.pages.InstanceNewPage;
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
 * Created by manjunatha.n on 24-02-2016.
 */
public class allProvisionAMConAWS
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionAMConAWS test");
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
        System.out.println("End of allProvisionAMConAWS test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    @Test(description="AWS - Test provisioning AMC on AWS on node_config=2CPU-4GB - For Regression Test")
    public void instance_amc_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_AWS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", Constant.AMC_AWS_Config1);
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWS1), "RUNNING", "'" + Constant.InstanceNameAMC_AWS1 + "' is Failed to provision AMC on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_AWS1), "NoInstance", "'" + Constant.InstanceNameAMC_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();

    }

    @Test(description="AWS - Test provisioning AMC on AWS on node_config=2CPU-8GB - For Regression Test")
    public void instance_amc_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_AWS2).contains("NoInstance"))
        {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_AWS2, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", Constant.AMC_AWS_Config2);
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWS2), "RUNNING", "'" + Constant.InstanceNameAMC_AWS2 + "' is Failed to provision AMC on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_AWS2), "NoInstance", "'" + Constant.InstanceNameAMC_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();

    }

    @Test(description="AWS - Test provisioning AMC on AWS on node_config=4CPU-16GB - For Regression Test")
    public void instance_amc_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_AWS3, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", Constant.AMC_AWS_Config3);
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWS3), "RUNNING", "'" + Constant.InstanceNameAMC_AWS3 + "' is Failed to provision AMC on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_AWS3), "NoInstance", "'" + Constant.InstanceNameAMC_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}