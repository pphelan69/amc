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
public class allProvisionHortonworksonAWS
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionHortonworksonAWS test");
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
        System.out.println("End of allProvisionHortonworksonAWS test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS1 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS2 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS3 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS4 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS5 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS6 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS7 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS8 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS9 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS10 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS11 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group disabled.")
    public void instance_Hortonworks_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS12 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS13 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS14 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS15 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS16 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS17 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS18 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS19 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS20 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS21 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS22 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS23 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS24 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option  with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS25 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS26 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS27 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS28 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS29 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS30 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS31 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS32 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS33 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS34 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS35 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group disabled.")
    public void instance_Hortonworks_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS36 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS1 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS2 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS3 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS4 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS5 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS6 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS7 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS8 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS9 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS10 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS11 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled.")
    public void instance_Hortonworks_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS12 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test49 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS13 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test50 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS14 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test51 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS15 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test52 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS16 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test53 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS17 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test54 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS18 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test55 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS19 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test56 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS20 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test57 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS21 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test58 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS22 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test59 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS23 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test60 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS24 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option  with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test61 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS25 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test62 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS26 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test63 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS27 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test64 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS28 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test65 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS29 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test66 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS30 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test67 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS31 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test68 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS32 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test69 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS33 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test70 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS34 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test71 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS35 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled.")
    public void instance_Hortonworks_test72 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS36 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test73 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS1 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test74 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS2 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test75 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS3 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test76 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS4 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test77 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS5 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test78 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS6 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test79 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS7 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test80 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS8 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test81 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS9 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test82 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS10 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test83 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS11 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test84 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS12 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test85 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS13 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test86 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS14 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test87 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS15 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test88 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS16 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test89 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS17 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test90 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS18 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test91 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS19 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test92 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS20 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test93 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS21 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test94 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS22 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test95 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS23 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test96 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS24 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option  with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test97 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS25 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test98 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS26 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test99 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS27 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test100 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS28 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test101 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS29 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test102 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS30 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test103 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS31 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test104 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS32 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test105 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS33 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test106 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS34 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test107 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS35 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" & placement group enabled and enabled local storage")
    public void instance_Hortonworks_test108 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS36 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test109 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS1 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS1), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test110 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS2 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS2), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test111 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS3 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS3), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test112 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS4 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS4), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test113 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS5 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS5), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test114 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS6 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS6), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test115 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS7 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS7), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test116 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS8 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS8), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test117 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS9 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS9), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test118 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS10 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS10), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test119 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS11 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS11), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion1+" and enabled local storage")
    public void instance_Hortonworks_test120 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS12 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS12), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test121 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS13 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS13), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test122 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS14 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS14), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test123 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS15 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS15), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test124 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS16 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS16), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test125 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS17 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS17), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test126 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS18 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS18), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test127 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS19 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS19), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test128 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS20 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS20), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test129 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS21 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS21), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test130 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS22 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS22), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test131 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS23 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS23), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with with Ambari version "+Constant.Ambariversion2 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test132 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion2,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS24 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS24), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Development instance option  with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test133 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS25 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS25), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test134 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS26 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS26), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on small cluster (4 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test135 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS27 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS27), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test136 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS28 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS28), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test137 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS29 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS29), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Medium cluster (6 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test138 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS30 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS30), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test139 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS31).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS31, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS31 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS31, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS31), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS31 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test140 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS32).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS32, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS32 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS32, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS32), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS32 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Large cluster (11 nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test141 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS33).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS33, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS33 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS33, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS33), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS33 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Development instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test142 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS34).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS34, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS34 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS34, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS34), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS34 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test143 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS35).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS35, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS35 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS35, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS35), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS35 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Hortonworks on Custom cluster (Custom nodes) on AWS on Production instance option with Ambari version "+Constant.Ambariversion1 +" HDP version " + Constant.hdpversion2+" and enabled local storage")
    public void instance_Hortonworks_test144 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameHortonworks_AWS36).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {};

            newInstancePage.selectPlatformProduct(Constant.Hortonworks_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameHortonworks_AWS36, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion2);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "RUNNING", "'" + Constant.InstanceNameHortonworks_AWS36 + "' is Failed to provision Hortonworks on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameHortonworks_AWS36, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameHortonworks_AWS36), "NoInstance", "'" + Constant.InstanceNameHortonworks_AWS36 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}