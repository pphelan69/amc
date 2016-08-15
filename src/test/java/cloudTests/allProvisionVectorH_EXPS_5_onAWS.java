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
public class allProvisionVectorH_EXPS_5_onAWS
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvisionVectorH_EXPS_5_onAWS test");
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
        System.out.println("End of allProvisionVectorH_EXPS_5_onAWS test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Enviroment with HDP 2.4 ")
    public void instance_VectorhEXPS_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Enviroment with Demo addition Software config")
    public void instance_VectorhEXPS_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Enviroment with Dataflow Addition software config")
    public void instance_VectorhEXPS_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Enviroment with DataFlow, Demo addition software config")
    public void instance_VectorhEXPS_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with enabled User Placement group")
    public void instance_VectorhEXPS_GRP_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with Demo, Enabled UserGroup")
    public void instance_VectorhEXPS_GRP_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with DataFlow Addition software config with Enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with DataFlow, Demo and enabled UsePlacement Group")
    public void instance_VectorhEXPS_GRP_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with Dataflow Addition software config with Enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with DataFlow, Demo and enabled Use instance store for data")
    public void inst_VectorhEXPS_Storage_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with Demo, Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with Dataflow Addition software config and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Development Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on small cluster (4 nodes) on AWS on Production Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Development Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Medium cluster (6 nodes) on AWS on Production Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Development Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Large cluster (11 nodes) on AWS on Production Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Development Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Balanced price and performance Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorhEXPS on Custom cluster (Custom nodes) on AWS on Production Environment with DataFlow, Demo and Enabled Use instance store for data & Use Placement Group")
    public void inst_VectorhEXPS_Storage_place_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorhEXP_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4","DataFlow","Demo"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Exp_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorhEXP_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' is Failed to provision VectorhEXPS on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorhEXP_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorhEXP_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorhEXP_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}
