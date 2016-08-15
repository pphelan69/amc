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
 * Created by pphelan on 12/4/2015.
 */
public class instanceAMCSmokeTest {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of instanceAMCSmokeTest ");
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
        System.out.println("End of instanceAMCSmokeTest ");
        driver.manage().deleteAllCookies();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) Assert.fail(verificationErrorString);
    }


    @Test(description="AWS - Test provisioning AMC on AWS  with nodeconfig=AMC_AWS_2CPU4GB ")
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

    @Test(description="AWS_Subnet - Test provisioning AMC on AWS-Subnet ID with nodeconfig=AMC_AWS_2CPU4GB ")
    public void instance_amc_test2 () {
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

    @Test(description="RS - Test provisioning AMC on RackSpace")
    public void instance_amc_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning AMC on AWS with nodeconfig=AMC_AWS_2CPU8GB ", enabled = false)
    public void instance_amc_test4 () {
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
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWS2), "RUNNING", "Failed to provision AMC on AWS.");
    }

    @Test(description="AWS - Test provisioning AMC on AWS with nodeconfig=AMC_AWS_4CPU16GB ", enabled = false)
    public void instance_amc_test5 () {
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
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWS3), "RUNNING", "Failed to provision AMC on AWS.");
    }

    @Test(description="AWS_Subnet - Test provisioning AMC on AWS-Subnet ID with nodeconfig=AMC_AWS_2CPU8GB ", enabled = false)
    public void instance_amc_test6 () {
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
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWSsub2), "RUNNING", "Failed to provision AMC on AWS Subnet.");
    }

    @Test(description="AWS_Subnet - Test provisioning AMC on AWS-Subnet ID with nodeconfig=AMC_AWS_4CPU16GB ", enabled = false)
    public void instance_amc_test7 () {
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
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_AWSsub3), "RUNNING", "Failed to provision AMC on AWS Subnet.");
    }
}
