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
public class allProvisionVectorH_EXPS_5_onAWS_Subnet {
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionVectorH_EXPS_5_onAWS_Subnet test");
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
        System.out.println("End of allProvisionVectorH_EXPS_5_onAWS_Subnet test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Enviroment ")
    public void instance_VectorhEXPS_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Enviroment ")
    public void instance_VectorhEXPS_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Enviroment ")
    public void instance_VectorhEXPS_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Enviroment ")
    public void instance_VectorhEXPS_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Enviroment ")
    public void instance_VectorhEXPS_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Enviroment ")
    public void instance_VectorhEXPS_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Enviroment ")
    public void instance_VectorhEXPS_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Enviroment ")
    public void instance_VectorhEXPS_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Enviroment ")
    public void instance_VectorhEXPS_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Enviroment ")
    public void instance_VectorhEXPS_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Enviroment ")
    public void instance_VectorhEXPS_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Enviroment ")
    public void instance_VectorhEXPS_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Enviroment with Demo")
    public void instance_VectorhEXPS_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Enviroment with Demo")
    public void instance_VectorhEXPS_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Enviroment with Demo")
    public void instance_VectorhEXPS_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Enviroment with Demo")
    public void instance_VectorhEXPS_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Enviroment with Demo")
    public void instance_VectorhEXPS_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Enviroment with Demo")
    public void instance_VectorhEXPS_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Enviroment with Demo")
    public void instance_VectorhEXPS_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Enviroment with Demo")
    public void instance_VectorhEXPS_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Enviroment with Demo")
    public void instance_VectorhEXPS_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Enviroment with Demo")
    public void instance_VectorhEXPS_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Enviroment with Demo")
    public void instance_VectorhEXPS_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Enviroment with Demo")
    public void instance_VectorhEXPS_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Enviroment with DataFlow")
    public void instance_VectorhEXPS_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow")
    public void instance_VectorhEXPS_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Enviroment with DataFlow")
    public void instance_VectorhEXPS_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Enviroment with DataFlow")
    public void instance_VectorhEXPS_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow")
    public void instance_VectorhEXPS_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Enviroment with DataFlow")
    public void instance_VectorhEXPS_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Enviroment with DataFlow")
    public void instance_VectorhEXPS_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow")
    public void instance_VectorhEXPS_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Enviroment with DataFlow")
    public void instance_VectorhEXPS_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Enviroment with DataFlow")
    public void instance_VectorhEXPS_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow")
    public void instance_VectorhEXPS_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Enviroment with DataFlow")
    public void instance_VectorhEXPS_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Enviroment with DataFlow, Demo")
    public void instance_VectorhEXPS_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with DataFlow with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled UserPlacement Group")
    public void instance_VectorhEXPS_GRP_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with DataFlow with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Development Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub10), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Balanced price and performance Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub11), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS_subnet - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS_subnet on Production Environment with DataFlow, Demo with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_AWSsub12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_AWSsub12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' is Failed to provision VectorhEXPS on AWS_subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_AWSsub12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_AWSsub12), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_AWSsub12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}
