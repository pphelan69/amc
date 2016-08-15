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
 * @Test : Vector in Hadoop Enterprise
 */
public class allProvisionVECTORHonRackSpace
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvision Vector in Hadoop Enterprise on RackSpace test");
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
        System.out.println("End of allProvision Vector in Hadoop Enterprise on RackSpace test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="RS - Test provisioning VectorH small (4 nodes) cluster on RackSpace on virtual hardware ")
    public void instance_vectorh_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS1), "RUNNING", "'" + Constant.InstanceNameVectorH_RS1 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS1), "NoInstance", "'" + Constant.InstanceNameVectorH_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH small (4 nodes) cluster on RackSpace on mixed hardware ")
    public void instance_vectorh_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS2), "RUNNING", "'" + Constant.InstanceNameVectorH_RS2 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS2), "NoInstance", "'" + Constant.InstanceNameVectorH_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH small (4 nodes) cluster on RackSpace on OnMetal hardware ")
    public void instance_vectorh_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);;
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS3), "RUNNING", "'" + Constant.InstanceNameVectorH_RS3 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS3), "NoInstance", "'" + Constant.InstanceNameVectorH_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH Medium (6 nodes) cluster on RackSpace on virtual hardware ")
    public void instance_vectorh_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS4), "RUNNING", "'" + Constant.InstanceNameVectorH_RS4 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS4), "NoInstance", "'" + Constant.InstanceNameVectorH_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH Medium (6 nodes) cluster on RackSpace on mixed hardware ")
    public void instance_vectorh_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS5), "RUNNING", "'" + Constant.InstanceNameVectorH_RS5 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS5), "NoInstance", "'" + Constant.InstanceNameVectorH_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH Medium (6 nodes) cluster on RackSpace on OnMetal hardware ")
    public void instance_vectorh_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS6), "RUNNING", "'" + Constant.InstanceNameVectorH_RS6 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS6), "NoInstance", "'" + Constant.InstanceNameVectorH_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH Large (11 nodes) cluster on RackSpace on virtual hardware ")
    public void instance_vectorh_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS7), "RUNNING", "'" + Constant.InstanceNameVectorH_RS7 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS7), "NoInstance", "'" + Constant.InstanceNameVectorH_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH Large (11 nodes) cluster on RackSpace on mixed hardware ")
    public void instance_vectorh_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS8), "RUNNING", "'" + Constant.InstanceNameVectorH_RS8 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS8), "NoInstance", "'" + Constant.InstanceNameVectorH_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RS - Test provisioning VectorH Large (11 nodes) cluster on RackSpace on OnMetal hardware ")
    public void instance_vectorh_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs", "Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            // newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_RS9), "RUNNING", "'" + Constant.InstanceNameVectorH_RS9 + "' is Failed to provision VectorH on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_RS9), "NoInstance", "'" + Constant.InstanceNameVectorH_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}