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
 * Created by manjunatha.n on 29-03-2016.
 */
public class allProvisionAMConAWS_Subnet {
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionAMConAWS_Subnet test");
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
        System.out.println("End of allProvisionAMConAWS_Subnet test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS_Subnet - Test provisioning AMC on AWS_Subnet on node_config=2CPU-4GB - For Regression Test")
    public void instance_amc_test1() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_AWSsub1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", Constant.AMC_AWS_Config1);
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWSsub1), "RUNNING", "'" + Constant.InstanceNameAMC_AWSsub1 + "' is Failed to provision AMC on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_AWSsub1), "NoInstance", "'" + Constant.InstanceNameAMC_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning AMC on AWS_Subnet on node_config=2CPU-8GB - For Regression Test")
    public void instance_amc_test2() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_AWSsub2).contains("NoInstance"))
        {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_AWSsub2, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", Constant.AMC_AWS_Config2);
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWSsub2), "RUNNING", "'" + Constant.InstanceNameAMC_AWSsub2 + "' is Failed to provision AMC on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_AWSsub2), "NoInstance", "'" + Constant.InstanceNameAMC_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning AMC on AWS_Subnet on node_config=4CPU-16GB - For Regression Test")
    public void instance_amc_test3() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_AWSsub3, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", Constant.AMC_AWS_Config3);
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWSsub3), "RUNNING", "'" + Constant.InstanceNameAMC_AWSsub3 + "' is Failed to provision AMC on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_AWSsub3), "NoInstance", "'" + Constant.InstanceNameAMC_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}
