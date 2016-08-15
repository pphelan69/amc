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
 * Created by manjunatha.n on 25-02-2016.
 */
public class allProvisionVectorH_Exps_5_onRackSpace {

    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionVectorH_Exps_5_onRackSpace test");
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
        System.out.println("End of allProvisionVectorH_Exps_5_onRackSpace test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Virtual hardware ")
    public void instance_VectorhEXPS_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Mixed hardware ")
    public void instance_VectorhEXPS_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on OnMetal hardware ")
    public void instance_VectorhEXPS_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Virtual hardware ")
    public void instance_VectorhEXPS_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Mixed hardware ")
    public void instance_VectorhEXPS_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on OnMetal hardware ")
    public void instance_VectorhEXPS_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Virtual hardware ")
    public void instance_VectorhEXPS_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Mixed hardware ")
    public void instance_VectorhEXPS_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on OnMetal hardware ")
    public void instance_VectorhEXPS_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
  
    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Virtual hardware with DataFlow")
    public void instance_VectorhEXPS_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Mixed hardware with DataFlow")
    public void instance_VectorhEXPS_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on OnMetal hardware with DataFlow")
    public void instance_VectorhEXPS_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Virtual hardware with DataFlow")
    public void instance_VectorhEXPS_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Mixed hardware with DataFlow")
    public void instance_VectorhEXPS_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on OnMetal hardware with DataFlow")
    public void instance_VectorhEXPS_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Virtual hardware with DataFlow")
    public void instance_VectorhEXPS_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Mixed hardware with DataFlow")
    public void instance_VectorhEXPS_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on OnMetal hardware with DataFlow")
    public void instance_VectorhEXPS_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
    
    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Virtual hardware with Demo")
    public void instance_VectorhEXPS_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Mixed hardware with Demo")
    public void instance_VectorhEXPS_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on OnMetal hardware with Demo")
    public void instance_VectorhEXPS_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Virtual hardware with Demo")
    public void instance_VectorhEXPS_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Mixed hardware with Demo")
    public void instance_VectorhEXPS_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on OnMetal hardware with Demo")
    public void instance_VectorhEXPS_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Virtual hardware with Demo")
    public void instance_VectorhEXPS_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Mixed hardware with Demo")
    public void instance_VectorhEXPS_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on OnMetal hardware with Demo")
    public void instance_VectorhEXPS_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }   

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Virtual hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on Mixed hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on small cluster (4 nodes) on RackSpace on OnMetal hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Virtual hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on Mixed hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on RackSpace on OnMetal hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Virtual hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on Mixed hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Mixed");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="RackSpace - Test provisioning VectorhEXPS on Large cluster (11 nodes) on RackSpace on OnMetal hardware with DataFlow, Demo")
    public void instance_VectorhEXPS_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXPS_RS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXPS_RS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "OnMetal");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' is Failed to provision VectorhEXPS on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXPS_RS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXPS_RS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXPS_RS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}
