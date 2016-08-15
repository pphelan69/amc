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
public class allProvisionMATRIXonAWS_Subnet {

    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionMATRIXonAWS_Subnet test");
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
        System.out.println("End of allProvisionMATRIXonAWS_Subnet test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with development Environment & placement group disabled).")
    public void instance_matrix_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub1 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment  & placement group disabled).")
    public void instance_matrix_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub2 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment & placement group disabled).")
    public void instance_matrix_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub3 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with development Environment & placement group disabled).")
    public void instance_matrix_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub4 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub5 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Production Environment & placement group disabled).")
    public void instance_matrix_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub6 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with development Environment & placement group disabled).")
    public void instance_matrix_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub7 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub8 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with Production Environment & placement group disabled).")
    public void instance_matrix_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub9 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with development Environment & placement group disabled).")
    public void instance_matrix_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub10 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub11 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Production Environment & placement group disabled).")
    public void instance_matrix_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub12 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment & placement group disabled).")
    public void instance_matrix_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub13), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub13 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub13), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub14), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub14 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub14), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Production Environment & placement group disabled).")
    public void instance_matrix_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub15), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub15 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub15), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with development Environment & placement group enabled).")
    public void instance_matrix_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub16), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub16 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub16), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment  & placement group enabled).")
    public void instance_matrix_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub17), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub17 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub17), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment & placement group enabled).")
    public void instance_matrix_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub18), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub18 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub18), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with development Environment & placement group enabled).")
    public void instance_matrix_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub19), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub19 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub19), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub20), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub20 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub20), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Production Environment & placement group enabled).")
    public void instance_matrix_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub21), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub21 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub21), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with development Environment & placement group enabled).")
    public void instance_matrix_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub22), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub22 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub22), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub23), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub23 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub23), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with Production Environment & placement group enabled).")
    public void instance_matrix_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub24), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub24 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub24), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with development Environment & placement group enabled).")
    public void instance_matrix_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub25), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub25 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub25), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub26), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub26 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub26), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Production Environment & placement group enabled).")
    public void instance_matrix_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub27), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub27 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub27), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment & placement group enabled).")
    public void instance_matrix_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub28), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub28 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub28), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub29), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub29 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub29), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Production Environment & placement group enabled).")
    public void instance_matrix_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub30), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub30 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub30), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with development Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub16), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub16 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub16), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment  & placement group enabled and enabled local storage")
    public void instance_matrix_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub17), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub17 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub17), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub18), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub18 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub18), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with development Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub19), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub19 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub19), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub20), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub20 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub20), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Production Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub21), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub21 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub21), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with development Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub22), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub22 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub22), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub23), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub23 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub23), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with Production Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub24), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub24 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub24), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with development Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub25), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub25 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub25), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub26), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub26 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub26), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Production Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub27), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub27 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub27), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub28), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub28 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub28), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub29), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub29 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub29), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Production Environment & placement group enabled and enabled local storage")
    public void instance_matrix_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub30), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub30 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub30), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with development Environment and enabled local storage")
    public void instance_matrix_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub16), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub16 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub16), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment  and enabled local storage")
    public void instance_matrix_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub17), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub17 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub17), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment and enabled local storage")
    public void instance_matrix_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub18), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub18 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub18), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with development Environment and enabled local storage")
    public void instance_matrix_test49 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub19), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub19 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub19), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment and enabled local storage")
    public void instance_matrix_test50 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub20), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub20 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub20), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (node 4) (with Production Environment and enabled local storage")
    public void instance_matrix_test51 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub21), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub21 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub21), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with development Environment and enabled local storage")
    public void instance_matrix_test52 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub22), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub22 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub22), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment and enabled local storage")
    public void instance_matrix_test53 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub23), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub23 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub23), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Medium cluster (node 6) (with Production Environment and enabled local storage")
    public void instance_matrix_test54 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub24), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub24 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub24), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with development Environment and enabled local storage")
    public void instance_matrix_test55 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub25), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub25 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub25), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment and enabled local storage")
    public void instance_matrix_test56 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub26), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub26 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub26), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Large cluster (node 11) (with Production Environment and enabled local storage")
    public void instance_matrix_test57 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub27), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub27 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub27), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment and enabled local storage")
    public void instance_matrix_test58 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub28), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub28 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub28), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment and enabled local storage")
    public void instance_matrix_test59 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub29), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub29 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub29), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning Matrix Custom cluster (custom node) (with Production Environment and enabled local storage")
    public void instance_matrix_test60 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub30), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub30 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub30), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}

