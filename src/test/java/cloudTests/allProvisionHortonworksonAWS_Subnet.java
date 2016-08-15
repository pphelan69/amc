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
public class allProvisionHortonworksonAWS_Subnet {
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionHortonworksonAWS_Subnet test");
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
        System.out.println("End of allProvisionHortonworksonAWS_Subnet test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test49 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test50 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test51 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test52 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test53 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test54 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test55 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test56 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test57 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test58 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test59 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test60 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test61 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test62 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test63 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test64 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test65 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test66 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test67 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test68 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test69 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test70 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test71 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test72 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

             String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test73() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test74 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test75 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test76 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test77 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test78 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test79 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test80 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test81 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test82 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test83 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test84 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test85 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test86 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test87 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test88 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test89 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test90 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test91 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test92 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test93 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test94 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test95 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test96 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test97 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test98 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test99 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test100 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test101 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test102 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test103 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test104 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test105 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test106 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test107 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled & enabled LocalStorage")
    public void instance_Hortonworks_test108 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test109 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test110 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test111 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test112 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test113 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test114 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test115 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test116 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test117 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test118 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test119 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & enabled LocalStorage.")
    public void instance_Hortonworks_test120 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test121 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test122 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test123 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test124 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test125 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test126 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test127 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test128 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test129 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test130 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test131 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test132 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test133 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test134 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on small cluster (4 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test135 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test136 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test137 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS_Subnet on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test138 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test139 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test140 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test141 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Development instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test142 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test143 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS_Subnet on Production instance with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & enabled LocalStorage.")
    public void instance_Hortonworks_test144 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS_Sub36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS_Sub36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' is Failed to provision Hortonworks on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS_Sub36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS_Sub36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS_Sub36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

}