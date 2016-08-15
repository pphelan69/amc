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
public class allProvisionMATRIXonAWS
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionMATRIXonAWS test");
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
        System.out.println("End of allProvisionMATRIXonAWS test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with development Environment & placement group disabled).")
    public void instance_matrix_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS1), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS1 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS1), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS2), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS2 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS2), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment & placement group disabled).")
    public void instance_matrix_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS3), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS3 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS3), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with development Environment & placement group disabled).")
    public void instance_matrix_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS4), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS4 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS4), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS5), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS5 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS5), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Production Environment & placement group disabled).")
    public void instance_matrix_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS6), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS6 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS6), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with development Environment & placement group disabled).")
    public void instance_matrix_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS7), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS7 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS7), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS8), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS8 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS8), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with Production Environment & placement group disabled).")
    public void instance_matrix_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS9), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS9 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS9), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with development Environment & placement group disabled).")
    public void instance_matrix_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS10), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS10 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS10), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS11), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS11 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS11), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Production Environment & placement group disabled).")
    public void instance_matrix_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS12), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS12 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS12), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment & placement group disabled).")
    public void instance_matrix_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS13).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS13, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS13), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS13 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS13, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS13), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS13 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment & placement group disabled).")
    public void instance_matrix_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS14).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS14, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS14), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS14 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS14, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS14), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS14 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Production Environment & placement group disabled).")
    public void instance_matrix_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS15).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS15, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS15), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS15 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS15, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS15), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS15 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with development Environment & placement group enabled).")
    public void instance_matrix_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS16), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS16 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS16), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS17), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS17 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS17), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment & placement group enabled).")
    public void instance_matrix_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS18), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS18 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS18), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with development Environment & placement group enabled).")
    public void instance_matrix_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS19), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS19 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS19), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS20), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS20 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS20), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Production Environment & placement group enabled).")
    public void instance_matrix_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS21), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS21 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS21), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with development Environment & placement group enabled).")
    public void instance_matrix_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS22), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS22 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS22), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS23), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS23 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS23), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with Production Environment & placement group enabled).")
    public void instance_matrix_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS24), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS24 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS24), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with development Environment & placement group enabled).")
    public void instance_matrix_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS25), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS25 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS25), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS26), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS26 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS26), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Production Environment & placement group enabled).")
    public void instance_matrix_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS27), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS27 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS27), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment & placement group enabled).")
    public void instance_matrix_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS28), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS28 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS28), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment & placement group enabled).")
    public void instance_matrix_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS29), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS29 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS29), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Production Environment & placement group enabled).")
    public void instance_matrix_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS30), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS30 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS30), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with development Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS16), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS16 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS16), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS17), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS17 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS17), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS18), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS18 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS18), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with development Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS19), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS19 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS19), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS20), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS20 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS20), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Production Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS21), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS21 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS21), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with development Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS22), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS22 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS22), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS23), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS23 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS23), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with Production Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS24), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS24 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS24), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with development Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS25), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS25 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS25), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS26), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS26 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS26), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Production Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS27), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS27 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS27), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS28), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS28 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS28), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS29), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS29 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS29), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Production Environment & placement group enabled) and use local drive storage")
    public void instance_matrix_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS30), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS30 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS30), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with development Environment and use local drive storage")
    public void instance_matrix_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS16).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS16, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS16), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS16 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS16, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS16), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS16 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2)(with Balanced price and performance Environment and use local drive storage")
    public void instance_matrix_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS17).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS17, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS17), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS17 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS17, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS17), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS17 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Extra small cluster (node 2) (with Production Environment and use local drive storage")
    public void instance_matrix_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS18).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS18, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS18), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS18 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS18, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS18), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS18 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with development Environment and use local drive storage")
    public void instance_matrix_test49 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS19).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS19, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS19), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS19 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS19, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS19), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS19 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Balanced price and performance Environment and use local drive storage")
    public void instance_matrix_test50 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS20).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS20, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS20), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS20 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS20, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS20), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS20 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (node 4) (with Production Environment and use local drive storage")
    public void instance_matrix_test51 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS21).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS21, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS21), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS21 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS21, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS21), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS21 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with development Environment and use local drive storage")
    public void instance_matrix_test52 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS22).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS22, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS22), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS22 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS22, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS22), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS22 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6)(with Balanced price and performance Environment and use local drive storage")
    public void instance_matrix_test53 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS23).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS23, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS23), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS23 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS23, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS23), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS23 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Medium cluster (node 6) (with Production Environment and use local drive storage")
    public void instance_matrix_test54 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS24).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS24, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS24), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS24 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS24, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS24), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS24 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with development Environment and use local drive storage")
    public void instance_matrix_test55 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS25).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS25, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS25), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS25 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS25, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS25), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS25 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Balanced price and performance Environment and use local drive storage")
    public void instance_matrix_test56 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS26).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS26, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS26), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS26 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS26, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS26), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS26 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Large cluster (node 11) (with Production Environment and use local drive storage")
    public void instance_matrix_test57 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS27).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS27, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS27), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS27 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS27, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS27), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS27 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }


    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node 12) (with development Environment and use local drive storage")
    public void instance_matrix_test58 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS28).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS28, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS28), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS28 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS28, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS28), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS28 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Balanced price and performance Environment and use local drive storage")
    public void instance_matrix_test59 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS29).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS29, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS29), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS29 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS29, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS29), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS29 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix Custom cluster (custom node) (with Production Environment and use local drive storage")
    public void instance_matrix_test60 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS30).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS30, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS30), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS30 + "' is Failed to provision Matrix on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS30, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS30), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS30 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}
