package cloudTests;

import com.actian.amc.pages.InstanceDetailsPage;
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
 * Created by manjunatha.n on 18-02-2016.
 */
public class instanceAMCRSFeaturesTest {
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;


    @BeforeMethod
    public void setup() {
        System.out.println("Begin of AMC Feature Instance test");
        Select_Browser Browser = new Select_Browser();
        System.out.println("Browser Selection: " + Constant.Browser);
        driver = Browser.Define_Browser(Constant.Browser);
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("End of AMC Feature Instance test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    @Test(description = "RS - Test provisioning and Checking Instnace Details in AMC on RackSpace")
    public void instance_amc_test1() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();

        }
        String provStaus = homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1);
        softAssert.assertEquals(provStaus, "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is not under Running status");
        InstanceDetailsPage instancedetailspage = homepage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Instance Details");
        instancedetailspage.selectTabLinks("Details");
        Assert.assertEquals(instancedetailspage.getInstanceStatusfromDetailspage(), provStaus, "conflict in Instance status in details page");
        softAssert.assertAll();
    }

    @Test(description = "RS - Test provisioning and Stop Running Instnace in AMC on RackSpace")
    public void instance_amc_test2() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();

        }
        Assert.assertEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is not under Running status so cannot perform Stop");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        Assert.assertEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "conflict in Instance status");
    }

    @Test(description = "RS - Test provisioning and Start stopped Instnace in AMC on RackSpace")
    public void instance_amc_test3() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();

        }
        Assert.assertEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is not under Running status so cannot perform Stop");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        Assert.assertEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "conflict in Instance status");
    }

    @Test(description = "RS - Test provisioning and Deleting instance in AMC on RackSpace")
    public void instance_amc_test4() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();

        }
        softAssert.assertEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is not under Running status");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
        Assert.assertEquals(homepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still Exists");
        softAssert.assertAll();
    }

    @Test(description = "RS - Test provisioning and Share Instnace in AMC on RackSpace")
    public void instance_amc_test5() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();

        }
        String provStaus = homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1);
        softAssert.assertEquals(provStaus, "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is not under Running status");
        InstanceDetailsPage instancedetailspage = homepage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        Assert.assertTrue(instancedetailspage.getPageUrl().contains("#InstanceDetailsPlace:InstanceDetailsPlace"), "fail open share instance page ");
        softAssert.assertAll();
    }

    @Test(description = "RS - Test provisioning and Recover Instance in AMC on RackSpace")
    public void instance_amc_test6() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        Assert.assertEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "FAILED", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is not in failed status");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Recover Instance");
        Assert.assertEquals(homepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' After Recover Instance still in failed status");

    }

    @Test(description = "RS - Test provisioning and Cancel Update Instance (wizard1) in AMC on RackSpace")
    public void instance_amc_test7() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        Assert.assertNotEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' No Instance found to update");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Update Instance");
        homepage.updateInstancewiz1(Constant.InstanceNameAMC_RS1+"_new","AMC on RackSpace","Label1","https://104.130.169.8:8443","cancel");
        Assert.assertEquals(homepage.getUpdatedInstancename(Constant.InstanceNameAMC_RS1),Constant.InstanceNameAMC_RS1,"Sucessfully Instance Updated ");

    }

    @Test(description = "RS - Test provisioning and Cancel Update Instance (wizard2) in AMC on RackSpace")
    public void instance_amc_test8() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        Assert.assertNotEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' No Instance found to update");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Update Instance");
        homepage.updateInstancewiz1(Constant.InstanceNameAMC_RS1+"_new","AMC on RackSpace","Label1","https://104.130.169.8:8443","Next");
        homepage.updateInstancewiz2("104.130.169.8","amc","root","root","","Cancel");
        Assert.assertEquals(homepage.getUpdatedInstancename(Constant.InstanceNameAMC_RS1),Constant.InstanceNameAMC_RS1,"sucessful Instance updated");

    }

    @Test(description = "RS - Test provisioning and Saving data and Update Instance in AMC on RackSpace")
    public void instance_amc_test9() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        Assert.assertNotEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' No Instance found to update");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Update Instance");
        homepage.updateInstancewiz1(Constant.InstanceNameAMC_RS1+"_new","AMC on RackSpace","Label1","https://104.130.169.8:8443","Next");
        homepage.updateInstancewiz2("104.130.169.8","amc","root","root","","Save");
        Assert.assertEquals(homepage.getUpdatedInstancename(Constant.InstanceNameAMC_RS1+"_new"),Constant.InstanceNameAMC_RS1+"_new","fail to update Instance");
    }

    @Test(description = "RS - Test provisioning and Saving (empty) data and Update Instance in AMC on RackSpace")
    public void instance_amc_test10() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        Assert.assertNotEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' No Instance found to update");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Update Instance");
        homepage.updateInstancewiz1("","","","","Next");
        homepage.updateInstancewiz2("","","","","","Save");
        Assert.assertEquals(homepage.getUpdatedInstancename(Constant.InstanceNameAMC_RS1),Constant.InstanceNameAMC_RS1,"fail to update Instance");
    }

    @Test(description = "RS - Test provisioning and Manage Instance in AMC on RackSpace")
    public void instance_amc_test11() {
        driver.get(baseUrl);
        LoginPage signInpage = new LoginPage(driver);
        InstancesHomePage homepage = signInpage.submitValidLogin(Constant.Username, Constant.Password);
        if (homepage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            String[] additionalSW = {};
            InstanceNewPage newInstancePage = homepage.provisionNewInstance();
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        Assert.assertEquals(homepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' Instance found to FAILED status, Cannot perform Manage Instance");
        homepage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Manage Instance");
        Assert.assertTrue(homepage.getInstanceWindowcount().matches("((http|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})):8443/amc/"),"This is not a valid landing page");
    }

}



