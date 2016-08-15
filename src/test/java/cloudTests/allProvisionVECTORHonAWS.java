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
 * @Test : Vector in Hadoop Enterprise
 */
public class allProvisionVECTORHonAWS
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of allProvision Vector in Hadoop Enterprise on AWS test");
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
        System.out.println("End of allProvision Vector in Hadoop Enterprise on AWS test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Development instance option  & placement group disabled.")
    public void instance_vectorh_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS1 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Balanced price and performance instance option  & placement group disabled.")
    public void instance_vectorh_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS2 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Production instance option  & placement group disabled.")
    public void instance_vectorh_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS3 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Development instance option  & placement group disabled.")
    public void instance_vectorh_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS4 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option  & placement group disabled.")
    public void instance_vectorh_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS5 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Production instance option  & placement group disabled.")
    public void instance_vectorh_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS6 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Development instance option  & placement group disabled.")
    public void instance_vectorh_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS7 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Balanced price and performance instance  & placement group disabled.")
    public void instance_vectorh_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS8 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Production instance option  & placement group disabled.")
    public void instance_vectorh_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS9 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Development instance option  & placement group disabled.")
    public void instance_vectorh_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS10 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option  & placement group disabled.")
    public void instance_vectorh_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS11 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Production instance option  & placement group disabled.")
    public void instance_vectorh_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS12 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Development instance option  & placement group enabled.")
    public void instance_vectorh_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS1 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Balanced price and performance instance option  & placement group enabled.")
    public void instance_vectorh_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS2 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Production instance option  & placement group enabled.")
    public void instance_vectorh_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS3 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Development instance option  & placement group enabled.")
    public void instance_vectorh_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS4 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option  & placement group enabled.")
    public void instance_vectorh_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS5 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Production instance option  & placement group enabled.")
    public void instance_vectorh_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS6 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Development instance option  & placement group enabled.")
    public void instance_vectorh_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS7 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Balanced price and performance instance  & placement group enabled.")
    public void instance_vectorh_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS8 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Production instance option  & placement group enabled.")
    public void instance_vectorh_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS9 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Development instance option  & placement group enabled.")
    public void instance_vectorh_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS10 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option  & placement group enabled.")
    public void instance_vectorh_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS11 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Production instance option  & placement group enabled.")
    public void instance_vectorh_test24 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS12 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Development instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test25 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS1 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Balanced price and performance instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test26 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS2 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Production instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test27 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS3 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Development instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test28 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS4 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test29 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS5 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Production instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test30 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS6 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Development instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test31 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS7 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Balanced price and performance instance  & placement group enabled and local storage for data .")
    public void instance_vectorh_test32 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS8 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Production instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test33 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS9 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Development instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test34 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS10 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test35 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS11 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Production instance option  & placement group enabled and local storage for data .")
    public void instance_vectorh_test36 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.placementgrpcheckbox);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS12 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Development instance option  enabled local storage for data .")
    public void instance_vectorh_test37 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS1), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS1 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS1), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Balanced price and performance instance option local storage for data .")
    public void instance_vectorh_test38 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS2).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS2, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS2), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS2 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS2, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS2), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS2 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on small cluster (4 nodes) on AWS on Production instance option  enabled local storage for data .")
    public void instance_vectorh_test39 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS3).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS3, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Small", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS3), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS3 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS3, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS3), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS3 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Development instance option  enabled local storage for data .")
    public void instance_vectorh_test40 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS4).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS4, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS4), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS4 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS4, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS4), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS4 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Balanced price and performance instance option  enabled local storage for data .")
    public void instance_vectorh_test41 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS5).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS5, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS5), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS5 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS5, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS5), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS5 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Medium cluster (6 nodes) on AWS on Production instance option enabled local storage for data .")
    public void instance_vectorh_test42 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS6).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS6, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Medium", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS6), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS6 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS6, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS6), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS6 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Development instance option  enabled local storage for data .")
    public void instance_vectorh_test43 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS7).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS7, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS7), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS7 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS7, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS7), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS7 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Balanced price and performance instance  enabled local storage for data .")
    public void instance_vectorh_test44 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS8).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS8, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS8), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS8 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS8, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS8), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS8 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Large cluster (11 nodes) on AWS on Production instance option  enabled local storage for data .")
    public void instance_vectorh_test45 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS9).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS9, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Large", "", "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS9), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS9 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS9, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS9), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS9 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Development instance option  & enabled local storage for data .")
    public void instance_vectorh_test46 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS10).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS10, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS10), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS10 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS10, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS10), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS10 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Balanced price and performance instance option  &enabled local storage for data .")
    public void instance_vectorh_test47 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS11).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS11, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Balanced price and performance");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS11), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS11 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS11, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS11), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS11 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning VectorH on Custom cluster (Custom nodes) on AWS on Production instance option  & enabled local storage for data .")
    public void instance_vectorh_test48 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameVectorH_AWS12).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Actian Director"};
            String[] Product_Options = {"Enable DataFlow YARN jobs","Hortonworks Data Platform 2.4"};

            newInstancePage.selectPlatformProduct(Constant.VectorH_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameVectorH_AWS12, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2_1(Product_Options);
            //newInstancePage.instanceCreationWizardScreen2_2(Constant.Ambariversion1,Constant.hdpversion1);
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3_1(Constant.localStoragecheckbox);
            newInstancePage.instanceCreationWizardScreen3("Custom", Constant.custom_Value, "Production");
            newInstancePage.instanceCreationWizardScreen4();
        }

        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameVectorH_AWS12), "RUNNING", "'" + Constant.InstanceNameVectorH_AWS12 + "' is Failed to provision VectorH on AWS.");
        homePage.selectInstanceAction(Constant.InstanceNameVectorH_AWS12, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameVectorH_AWS12), "NoInstance", "'" + Constant.InstanceNameVectorH_AWS12 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}
