package cloudTests;

import com.actian.amc.pages.*;
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
 * Created by manjunatha.n on 22-04-2016.
 */
public class shareClusterTest {

    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of shareClusterTest");
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
        System.out.println("End of shareClusterTest");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="Share Provisioned Cluster with MASTER User role :provisioned in RS")
    public void share_Cluster_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Cluster is Shared with " + Constant.NewUser_Username2);
    }

    @Test(description="Share Provisioned Cluster with ADMINISTRATOR User role :provisioned in RS")
    public void share_Cluster_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Cluster is Shared with " + Constant.NewUser_Username1);
    }


    @Test(description="Share Provisioned Cluster with USER role :provisioned in RS")
    public void share_Cluster_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Cluster is Shared with " + Constant.NewUser_Username4);
    }

    @Test(description="Share Provisioned Cluster with NOAccess User role :provisioned in RS")
    public void share_Cluster_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username3,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username3)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username3,"NO ACCESS");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username3,"NO ACCESS"),"Fail to Share Cluster with '" + Constant.NewUser_Username3 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username3, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getClusterIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is visible for Shared user");
        System.out.println("Not Visible '" + Constant.InstanceNameAMC_RS1 + "' Cluster Shared with " + Constant.NewUser_Username3);
    }

    @Test(description="Checking Node info with Shared Cluster with MASTER role :provisioned in RS")
    public void share_Cluster_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.clickElement();
        clusterhomepage.getPrimaryClusterNodeInfo();
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.clickElement();
        softAssert.assertTrue(clusterhomepage.checkAvailableNodes(),"Node values are mismatched in Shared Cluster");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Cluster is Shared with " + Constant.NewUser_Username2 +" and Nodes are Matching");
        softAssert.assertAll();
    }

    @Test(description="Checking Node info with Shared Cluster with ADMINISTRATOR User role :provisioned in RS")
    public void share_Cluster_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.clickElement();
        clusterhomepage.getPrimaryClusterNodeInfo();
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.clickElement();
        softAssert.assertTrue(clusterhomepage.checkAvailableNodes(),"Node values are mismatched in Shared Cluster");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Cluster is Shared with " + Constant.NewUser_Username1 +" and Nodes are Matching");
        softAssert.assertAll();
    }

    @Test(description="Checking Node info with Shared Cluster with USER role :provisioned in RS")
    public void share_Cluster_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.clickElement();
        clusterhomepage.getPrimaryClusterNodeInfo();
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.clickElement();
        softAssert.assertTrue(clusterhomepage.checkAvailableNodes(),"Node values are mismatched in Shared Cluster");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Cluster is Shared with " + Constant.NewUser_Username4 +" and Nodes are Matching");
        softAssert.assertAll();
    }

    @Test(description="Checking cloud access with Shared Cluster with MASTER role :provisioned in RS")
    public void share_Cluster_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.selectClusterActionButton(Constant.InstanceNameAMC_RS1);
        softAssert.assertEquals(clusterhomepage.getDialogMessage(),"No access to cloud");
        System.out.println("Cloud is not Accessible in " + Constant.NewUser_Username2 +" User");
        softAssert.assertAll();
    }

    @Test(description="Checking cloud access with Shared Cluster with ADMINISTRATOR role :provisioned in RS")
    public void share_Cluster_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.selectClusterActionButton(Constant.InstanceNameAMC_RS1);
        softAssert.assertEquals(clusterhomepage.getDialogMessage(),"No access to cloud");
        System.out.println("Cloud is not Accessible in " + Constant.NewUser_Username1 +" User");
        softAssert.assertAll();
    }

    @Test(description="Checking cloud access with Shared Cluster with USERs role :provisioned in RS")
    public void share_Cluster_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getClusterUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        clusterhomepage.selectClusterActionButton(Constant.InstanceNameAMC_RS1);
        softAssert.assertEquals(clusterhomepage.getDialogMessage(),"No access to cloud");
        System.out.println("Cloud is not Accessible in " + Constant.NewUser_Username4 +" User");
        softAssert.assertAll();
    }

    @Test(description="Checking ReBoot funtionality in Cluster and verify whether Instance is Stopped")
    public void share_Cluster_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Reboot");
        shareinstance.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"STOPPED","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
    }

    @Test(description="Delete Shared Cluster with USERs role :provisioned in RS")
    public void share_Cluster_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        clusterhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(clusterhomepage.getClusterUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        clusterhomepage.clickCancelElement();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        shareinstance.selectClusterAction(Constant.InstanceNameAMC_RS1, "Delete Cluster");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1),"NoCluster","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        System.out.println("Shared Cluster is Deleted in " + Constant.NewUser_Username4 +" User account");
    }

    @Test(description="Delete Shared Cluster with MASTER role :provisioned in RS")
    public void share_Cluster_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        clusterhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(clusterhomepage.getClusterUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        clusterhomepage.clickCancelElement();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        shareinstance.selectClusterAction(Constant.InstanceNameAMC_RS1, "Delete Cluster");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1),"NoCluster","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        System.out.println("Shared Cluster is Deleted in " + Constant.NewUser_Username2 +" User account");
    }

    @Test(description="Delete Shared Cluster with ADMINISTRATOR role :provisioned in RS")
    public void share_Cluster_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        ClustersHomePage shareinstance= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        clusterhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(clusterhomepage.getClusterUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        clusterhomepage.clickCancelElement();
        Assert.assertEquals(clusterhomepage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        shareinstance.selectClusterAction(Constant.InstanceNameAMC_RS1, "Delete Cluster");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        securityPage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1),"NoCluster","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        System.out.println("Shared Cluster is Deleted in " + Constant.NewUser_Username1 +" User account");
    }

    @Test(description="Checking ADMINISTRATOR privileges in Shared Cluster :provisioned in RS")
    public void share_Cluster_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");

        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        ClustersHomePage sharecluster= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        sharecluster.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecluster.getClusterUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        CloudHomePage cloudhomepage =sharecluster.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(cloudhomepage.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        sharecluster.signOut();

        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        ClustersHomePage homepage =sharecluster.navigateToClusters();

        String[] clusteroptions={"Reboot","Manage Cluster"};

        Assert.assertTrue(homepage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,clusteroptions),"ADMINISTRATOR Previliage options on Cluster are Invalid");
        System.out.println(Constant.NewUser_Username1 +" User has valid privileges to control Shared Cluster");
    }

    @Test(description="Checking USER privileges in Shared Cluster :provisioned in RS")
    public void share_Cluster_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        ClustersHomePage sharecluster= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        sharecluster.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecluster.getClusterUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        CloudHomePage cloudhomepage =sharecluster.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(cloudhomepage.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        sharecluster.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        ClustersHomePage homepage =sharecluster.navigateToClusters();
        String[] clusteroptions={"Reboot","Manage Cluster"};
        Assert.assertTrue(homepage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,clusteroptions),"USER Previliage options on Cluster are Invalid");
        System.out.println(Constant.NewUser_Username4 +" User has valid privileges to control Shared Cluster");
    }

    @Test(description="Checking MASTER privileges in Shared Cluster :provisioned in RS")
    public void share_Cluster_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        ClustersHomePage clusterhomepage =securityPage.navigateToClusters();
        ClustersHomePage sharecluster= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        sharecluster.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecluster.getClusterUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        CloudHomePage cloudhomepage =sharecluster.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(cloudhomepage.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        sharecluster.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        ClustersHomePage homepage =sharecluster.navigateToClusters();
        String[] clusteroptions={"Reboot","Manage Cluster","Delete Cluster","Share Cluster","Update Cluster"};
        Assert.assertTrue(homepage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,clusteroptions),"MASTER Previliage options on Cluster are Invalid");
        System.out.println(Constant.NewUser_Username2 +" User has valid privileges to control Shared Cluster");
    }

    @Test(description="Shared Cloud and Controling Cluster Reboot actions from ADMINISTRATOR role :provisioned in RS")
    public void share_Cluster_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("STOPPED")|| homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("ERROR"))
        {homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start"); }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        InstancesHomePage instnancehomepage = securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= instnancehomepage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share instance with '" + Constant.NewUser_Username1 +"'");
        ClustersHomePage clusterhomepage =shareinstance.navigateToClusters();
        ClustersHomePage sharecluster= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        sharecluster.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecluster.getClusterUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        CloudHomePage cloudhomepage =sharecluster.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(cloudhomepage.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        shareinstance.signOut();

        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        ClustersHomePage homepage =cloudhomepage.navigateToClusters();
        clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Reboot");
        instnancehomepage = homepage.navigateToInstances();
        homePage.clickUngroupedInstance();
        Assert.assertEquals(instnancehomepage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"STOPPED","'" + Constant.InstanceNameAMC_RS1 + "' is not Stopped ");
        System.out.println("Shared Cluster is Rebooted in " + Constant.NewUser_Username1 +" User account");
    }

    @Test(description="Shared Cloud and Controling Cluster Reboot actions from USER role :provisioned in RS")
    public void share_Cluster_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("STOPPED")|| homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("ERROR"))
        {homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start"); }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        InstancesHomePage instnancehomepage = securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= instnancehomepage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username4,"USER"),"Fail to Share instance with '" + Constant.NewUser_Username4 +"'");
        ClustersHomePage clusterhomepage =shareinstance.navigateToClusters();
        ClustersHomePage sharecluster= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        sharecluster.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecluster.getClusterUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        CloudHomePage cloudhomepage =sharecluster.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(cloudhomepage.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        ClustersHomePage homepage =cloudhomepage.navigateToClusters();
        clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Reboot");
        instnancehomepage = homepage.navigateToInstances();
        homePage.clickUngroupedInstance();
        Assert.assertEquals(instnancehomepage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"STOPPED","'" + Constant.InstanceNameAMC_RS1 + "' is not Stopped ");
        System.out.println("Shared Cluster is Rebooted in " + Constant.NewUser_Username4 +" User account");
    }

    @Test(description="Shared Cloud and Controlling Cluster Reboot actions from MASTER role :provisioned in RS")
    public void share_Cluster_test20() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("STOPPED")|| homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("ERROR"))
        {homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start"); }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        InstancesHomePage instnancehomepage = securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= instnancehomepage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share instance with '" + Constant.NewUser_Username2 +"'");
        ClustersHomePage clusterhomepage =shareinstance.navigateToClusters();
        ClustersHomePage sharecluster= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        sharecluster.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecluster.getClusterUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        CloudHomePage cloudhomepage =sharecluster.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(cloudhomepage.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        ClustersHomePage homepage =cloudhomepage.navigateToClusters();
        clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Reboot");
        instnancehomepage = homepage.navigateToInstances();
        homePage.clickUngroupedInstance();
        Assert.assertEquals(instnancehomepage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"STOPPED","'" + Constant.InstanceNameAMC_RS1 + "' is not Stopped ");
        System.out.println("Shared Cluster is Rebooted in " + Constant.NewUser_Username2 +" User account");
    }

    @Test(description="Shared Cloud and Controlling Cluster Delete actions from MASTER role :provisioned in RS")
    public void share_Cluster_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();
            String[] additionalSW = {};
            newInstancePage.selectPlatformProduct(Constant.AMC_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameAMC_RS1, "AutoGrp1", "");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("", "", "");
            newInstancePage.instanceCreationWizardScreen4();
        }
        if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("STOPPED")|| homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).equals("ERROR"))
        {homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start"); }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        InstancesHomePage instnancehomepage = securityPage.navigateToInstances();
        ClustersHomePage clusterhomepage =instnancehomepage.navigateToClusters();
        ClustersHomePage sharecluster= clusterhomepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Share Cluster");
        sharecluster.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecluster.getClusterUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        CloudHomePage cloudhomepage =sharecluster.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(cloudhomepage.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        cloudhomepage.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        ClustersHomePage homepage =cloudhomepage.navigateToClusters();
        Assert.assertEquals(sharecluster.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' Status is Failed");
        homepage.selectClusterAction(Constant.InstanceNameAMC_RS1, "Delete Cluster");
        Assert.assertEquals(clusterhomepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "NoCluster", "'" + Constant.InstanceNameAMC_RS1 + "' Cluster is still Exists even after Deletion");
        System.out.println("Shared Cluster is Deleted in " + Constant.NewUser_Username2 +" User account");
        clusterhomepage.signOut();
        signInPage.submitValidLogin(Constant.Username,Constant.Password);
        instnancehomepage = homepage.navigateToInstances();
        Assert.assertEquals(instnancehomepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1),"NoInstance","'" + Constant.InstanceNameAMC_RS1 + "' is not Stopped ");
        System.out.println("Shared Cluster is Deleted in " + Constant.NewUser_Username4 +" User account");
    }

    @Test(description="House keeping test to Remove Shared Delete Clusters, Cloud & Delete Created Users.")
    public void share_Cluster_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (!homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance"))
        {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
            Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still Exists even-after Deletion");
        }
        ClustersHomePage clusterhomepage =homePage.navigateToClusters();
        Assert.assertEquals(clusterhomepage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "NoCluster", "'" + Constant.InstanceNameAMC_RS1 + "' Cluster is still Exists even after Deletion");
        SecurityHomePage securitypage =clusterhomepage.navigateToSecurity();
        securitypage.selectUserAction(Constant.NewUser_Username1, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username2, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username3, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username4, "Delete User");
        CloudHomePage cloudhomepage =securitypage.navigateToClouds();
        cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Delete Cloud");
        cloudhomepage.reloadpage();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) == -1), "We deleted cloud '"+Constant.CloudNameRS2 +"' so expecting cloud definition to not exist.");
        System.out.println("Completed removing shared clusters, Users and Deleting Instances");
    }
}
