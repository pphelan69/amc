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
 * Created by manjunatha.n on 06-06-2016.
 */
public class allProvisionHortonworksonRackSpace
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionHortonworksonRackSpace test");
        Select_Browser Browser = new Select_Browser() ;
        System.out.println("Browser Selection: " + Constant.Browser);
        driver = Browser.Define_Browser(Constant.Browser );
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("End of allProvisionHortonworksonRackSpace test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS1), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS1 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS1), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS2), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS2 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS2), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);;
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS3), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS3 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS3), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS4), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS4 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS4), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS5), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS5 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS5), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS6), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS6 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS6), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS7), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS7 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS7), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS8), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS8 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS8), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1)
    public void instance_Hortonworks_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS9), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS9 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS9), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS1), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS1 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS1), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS2), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS2 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS2), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS3), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS3 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS3), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS4), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS4 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS4), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS5), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS5 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS5), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS6), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS6 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS6), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS7), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS7 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS7), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS8), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS8 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS8), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS9), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS9 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS9), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS1), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS1 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS1), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS2), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS2 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS2), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks small (4 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);;
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS3), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS3 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS3), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS4), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS4 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS4), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS5), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS5 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS5), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Medium (6 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS6), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS6 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS6), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on virtual hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS7), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS7 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS7), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on mixed hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS8), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS8 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS8), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning Hortonworks Large (11 nodes) cluster on RackSpace on OnMetal hardware with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2)
    public void instance_Hortonworks_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_RS9), "RUNNING", "'" + Constant.InstanceNameHortonworks_RS9 + "' is Failed to provision Hortonworks on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_RS9), "NoInstance", "'" + Constant.InstanceNameHortonworks_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}