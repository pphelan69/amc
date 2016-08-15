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
 * @Test : Vector in Hadoop Enterprise
 */
public class allProvisionVECTORHonAWS_Subnet {
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionVECTORHonAWS_Subnet test");
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
        System.out.println("End of allProvisionVECTORHonAWS_Subnet test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Development instance option & placement group disabled.")
    public void instance_vectorh_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option & placement group disabled.")
    public void instance_vectorh_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Production instance option & placement group disabled.")
    public void instance_vectorh_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Development instance option & placement group disabled.")
    public void instance_vectorh_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option & placement group disabled.")
    public void instance_vectorh_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Production instance option & placement group disabled.")
    public void instance_vectorh_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Development instance option & placement group disabled.")
    public void instance_vectorh_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with & placement group disabled.")
    public void instance_vectorh_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Production instance option & placement group disabled.")
    public void instance_vectorh_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Development instance option & placement group disabled.")
    public void instance_vectorh_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance option & placement group disabled.")
    public void instance_vectorh_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Production instance option & placement group disabled.")
    public void instance_vectorh_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Development instance option & placement group enabled.")
    public void instance_vectorh_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option & placement group enabled.")
    public void instance_vectorh_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Production instance option & placement group enabled.")
    public void instance_vectorh_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Development instance option & placement group enabled.")
    public void instance_vectorh_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option & placement group enabled.")
    public void instance_vectorh_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Production instance option & placement group enabled.")
    public void instance_vectorh_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Development instance option & placement group enabled.")
    public void instance_vectorh_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with & placement group enabled.")
    public void instance_vectorh_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Production instance option & placement group enabled.")
    public void instance_vectorh_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Development instance option & placement group enabled.")
    public void instance_vectorh_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance option & placement group enabled.")
    public void instance_vectorh_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Production instance option & placement group enabled.")
    public void instance_vectorh_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Development instance option & placement group and local storage enabled.")
    public void instance_vectorh_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option & placement group and local storage enabled.")
    public void instance_vectorh_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Production instance option & placement group and local storage enabled.")
    public void instance_vectorh_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Development instance option & placement group and local storage enabled.")
    public void instance_vectorh_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option & placement group and local storage enabled.")
    public void instance_vectorh_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Production instance option & placement group and local storage enabled.")
    public void instance_vectorh_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Development instance option & placement group and local storage enabled.")
    public void instance_vectorh_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with & placement group and local storage enabled.")
    public void instance_vectorh_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Production instance option & placement group and local storage enabled.")
    public void instance_vectorh_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Development instance option & placement group and local storage enabled.")
    public void instance_vectorh_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance option & placement group and local storage enabled.")
    public void instance_vectorh_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Production instance option & placement group and local storage enabled.")
    public void instance_vectorh_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Development instance option & local storage for data enabled.")
    public void instance_vectorh_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Balanced price and performance instance option & local storage for data enabled.")
    public void instance_vectorh_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on small cluster (4 nodes) on AWS_Subnet on Production instance option & local storage for data enabled.")
    public void instance_vectorh_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Development instance option & local storage for data enabled.")
    public void instance_vectorh_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Balanced price and performance instance option & local storage for data enabled.")
    public void instance_vectorh_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Medium cluster (6 nodes) on AWS_Subnet on Production instance option & local storage for data enabled.")
    public void instance_vectorh_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Development instance option & local storage for data enabled.")
    public void instance_vectorh_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Balanced price and performance instance option with & local storage for data enabled.")
    public void instance_vectorh_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Large cluster (11 nodes) on AWS_Subnet on Production instance option & local storage for data enabled.")
    public void instance_vectorh_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Development instance option & local storage for data enabled.")
    public void instance_vectorh_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Balanced price and performance instance option & local storage for data enabled.")
    public void instance_vectorh_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_Subnet - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS_Subnet on Production instance option & local storage for data enabled.")
    public void instance_vectorh_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS_Sub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS_Sub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' is Failed to provision VectorH on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS_Sub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS_Sub12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS_Sub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

}