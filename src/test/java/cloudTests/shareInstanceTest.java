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
 * Created by manjunatha.n on 20-04-2016.
 */
public class shareInstanceTest {

    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of shareInstanceTest");
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
        System.out.println("End of shareInstanceTest");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="Share Provisioned Instance with MASTER User role :provisioned in RS")
    public void share_instance_test1 () {
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
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share instance with '" + Constant.NewUser_Username2 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username2);
    }

    @Test(description="Share Provisioned Instance with ADMIN User role :provisioned in RS")
    public void share_instance_test2 () {
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
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share instance with '" + Constant.NewUser_Username1 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username1);
    }

    @Test(description="Share Provisioned Instance with NO ACCESS User role :provisioned in RS")
    public void share_instance_test3 () {
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
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username3,"NO ACCESS");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username3,"NO ACCESS"),"Fail to Share instance with '" + Constant.NewUser_Username3 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username3, Constant.NewUser_Password);
        Assert.assertEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is visible for Shared user");
        System.out.println("Not Visible '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username3);
    }

    @Test(description="Share Provisioned Instance with USER role :provisioned in RS")
    public void share_instance_test4 () {
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
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username4,"USER"),"Fail to Share instance with '" + Constant.NewUser_Username4 +"'");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username4);
    }

    @Test(description="Check instance options specific MASTER Role and Stopping shared instance")
    public void share_instance_test5 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("STOPPED")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        } SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username2, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username2, "MASTER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username2, "MASTER"), "Fail to Share instance with '" + Constant.NewUser_Username2 + "'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        homePage = homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username2);

        String[] instanceoptions = {"Start", "Stop", "Instance Details", "Delete Instance", "Manage Instance", "Share Instance", "Update Instance"};

        Assert.assertTrue(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1, instanceoptions), "User Previliage options on Instance are Invalid");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still running even-after Stopped");
    }

    @Test(description="Check instance options specific USER Role and Stopping shared instance")
    public void share_instance_test6 () {
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
        }  if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("STOPPED")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        }  SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username4,"USER"),"Fail to Share instance with '" + Constant.NewUser_Username4 +"'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username4);

        String[] instanceoptions={"Start","Stop","Instance Details","Manage Instance"};

        Assert.assertTrue(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are Invalid");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still running even-after Stopped");
    }

    @Test(description="Check instance options specific ADMINISTRATOR Role and Stopping shared instance")
    public void share_instance_test7 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("STOPPED")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        }SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share instance with '" + Constant.NewUser_Username1 +"'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username1);

        String[] instanceoptions={"Start","Stop","Instance Details","Manage Instance"};

        Assert.assertTrue(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are Invalid");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still running even-after Stopped");
    }

    @Test(description="Check instance options specific ADMINISTRATOR Role and Starting shared instance")
    public void share_instance_test8 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("RUNNING")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        }SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share instance with '" + Constant.NewUser_Username1 +"'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username1);

        String[] instanceoptions={"Start","Stop","Instance Details","Manage Instance"};

        Assert.assertTrue(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are Invalid");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still stopped even-after Start");
    }

    @Test(description="Check instance options specific USER Role and Starting shared instance")
    public void share_instance_test9 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("RUNNING")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        } SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username4,"USER"),"Fail to Share instance with '" + Constant.NewUser_Username4 +"'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username4);

        String[] instanceoptions={"Start","Stop","Instance Details","Manage Instance"};

        Assert.assertTrue(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are Invalid");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "'Instance is still stopped even-after Start");
    }

    @Test(description="Check instance options specific MASTER Role and Starting shared instance")
    public void share_instance_test10 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("RUNNING")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        } SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share instance with '" + Constant.NewUser_Username2 +"'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username2);

        String[] instanceoptions={"Start","Stop","Instance Details","Delete Instance","Manage Instance","Share Instance","Update Instance"};

        Assert.assertTrue(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are Invalid");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still stopped even-after Start");
    }

    @Test(description="Check instance options specific MASTER Role and Delete shared instance")
    public void share_instance_test13 () {
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
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share instance with '" + Constant.NewUser_Username2 +"'");
        securityPage.navigateToInstances();
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username2);

        String[] instanceoptions={"Start","Stop","Instance Details","Delete Instance","Manage Instance","Share Instance","Update Instance"};

        Assert.assertTrue(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are Invalid");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "FAILED", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still Exists even-after Delete.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still Exists even-after Delete...");
        softAssert.assertAll();
    }

    @Test(description="Check instance options specific USER Role and Delete shared instance")
    public void share_instance_test11 () {
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
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username4,"USER"),"Fail to Share instance with '" + Constant.NewUser_Username4 +"'");
        securityPage.navigateToInstances();
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username4);

        String[] instanceoptions={"Start","Stop","Instance Details","Delete Instance","Manage Instance"};

        Assert.assertFalse(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are valid");
        System.out.println(Constant.NewUser_Username4 + " Role doesn't have Previliage to Delete Shared Instance");
        softAssert.assertAll();
    }

    @Test(description="Check instance options specific ADMINISTRATOR Role and Delete shared instance")
    public void share_instance_test12 () {
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
        securityPage.navigateToInstances();
        InstanceDetailsPage shareinstance= homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareinstance.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(shareinstance.getInstanceUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share instance with '" + Constant.NewUser_Username1 +"'");
        securityPage.navigateToInstances();
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareinstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        homePage =homePage.clickUngroupedInstance();
        Assert.assertNotEquals(homePage.getInstanceIndex(Constant.InstanceNameAMC_RS1), -1, "'" + Constant.InstanceNameAMC_RS1 + "'is fail to Share with user");
        System.out.println("Sucessfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared with " + Constant.NewUser_Username1);

        String[] instanceoptions={"Start","Stop","Instance Details","Delete Instance","Manage Instance"};

        Assert.assertFalse(homePage.checkAvailableOptions(Constant.InstanceNameAMC_RS1,instanceoptions),"User Previliage options on Instance are valid");
        System.out.println(Constant.NewUser_Username1 + " Role doesn't have Previliage to Delete Shared Instance");
        softAssert.assertAll();
    }

    @Test(description = "Stop the shared provisioned instance with MASTER User role")
    public void share_instance_test14 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("STOPPED")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        } SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username2, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username2, "MASTER");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username2, "MASTER"), "Fail to Share instance with '" + Constant.NewUser_Username2 + "'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"STOPPED","'" + Constant.InstanceNameAMC_RS1 + "' is Failed to Stop on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared in Stopped state with " + Constant.NewUser_Username2);
    }

    @Test(description = "Stop the shared provisioned instance with ADMINISTRATOR User role")
    public void share_instance_test15 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("STOPPED")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        } SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username1, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username1, "ADMINISTRATOR");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username1, "ADMINISTRATOR"), "Fail to Share instance with '" + Constant.NewUser_Username1 + "'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        homePage.reloadpage();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1), "STOPPED", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to Stop on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared in Stopped state with " + Constant.NewUser_Username1);
    }

    @Test(description = "Stop the shared provisioned instance with USER User role")
    public void share_instance_test16 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("STOPPED")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        } SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username4, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username4, "USER");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username4, "USER"), "Fail to Share instance with '" + Constant.NewUser_Username4 + "'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        homePage.reloadpage();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"STOPPED","'"+ Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"STOPPED","'" + Constant.InstanceNameAMC_RS1 + "' is Failed to Stop on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared in Stopped state with " + Constant.NewUser_Username4);
    }

    @Test(description = "Start the shared provisioned instance with ADMINISTRATOR User role")
    public void share_instance_test17 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("RUNNING")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        } SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username1, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username1, "ADMINISTRATOR");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username1, "ADMINISTRATOR"), "Fail to Share instance with '" + Constant.NewUser_Username1 + "'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"STOPPED","'"+ Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        homePage.reloadpage();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' is Failed to Start on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared in Running state with " + Constant.NewUser_Username1);
    }

    @Test(description = "Start the shared provisioned instance with USER User role")
    public void share_instance_test18 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("RUNNING")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        } SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username4, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username4, "USER");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username4, "USER"), "Fail to Share instance with '" + Constant.NewUser_Username4 + "'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"STOPPED","'"+ Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        homePage.reloadpage();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' is Failed to Start on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared in Running state with " + Constant.NewUser_Username4);
    }

    @Test(description = "Start the shared provisioned instance with MASTER User role")
    public void share_instance_test19 () {
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
        } if (homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("RUNNING")) {
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Stop");
        } SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username2, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username2, "MASTER");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username2, "MASTER"), "Fail to Share instance with '" + Constant.NewUser_Username2 + "'");
        securityPage.navigateToInstances();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1),"STOPPED","'"+ Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Start");
        homePage.reloadpage();
        Assert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getSharedInstanceStatus(Constant.InstanceNameAMC_RS1),"RUNNING","'" + Constant.InstanceNameAMC_RS1 + "' is Failed to Start on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Shared in Running state with " + Constant.NewUser_Username2);
    }

    @Test(description = "Delete the shared provisioned instance with MASTER User role")
    public void share_instance_test20 () {
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
        SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username2, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username2, "MASTER");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username2, "MASTER"), "Fail to Share instance with '" + Constant.NewUser_Username2 + "'");
        securityPage.navigateToInstances();
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1),"NoInstance","'"+ Constant.InstanceNameAMC_RS1 + "' is Failed to Delete AMC on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Deleted and share removed with user " + Constant.NewUser_Username2);
        softAssert.assertAll();
    }

    @Test(description = "Delete the shared provisioned instance with ADMINISTRATOR User role")
    public void share_instance_test21 () {
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
        SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username1, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username1, "ADMINISTRATOR");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username1, "ADMINISTRATOR"), "Fail to Share instance with '" + Constant.NewUser_Username1 + "'");
        securityPage.navigateToInstances();
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1),"NoInstance","'"+ Constant.InstanceNameAMC_RS1 + "' is Failed to Delete AMC on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Deleted and share removed with user " + Constant.NewUser_Username1);
        softAssert.assertAll();
    }

    @Test(description = "Delete the shared provisioned instance with USER User role")
    public void share_instance_test22 () {
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
        SecurityHomePage securityPage = homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname, Constant.NewUser_Lastname, Constant.NewUser_Username4, Constant.NewUser_Emailid,
                Constant.NewUser_Password, Constant.NewUser_confirmpassword, Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4) != -1), "User fail to Create");
        securityPage.navigateToInstances();
        InstanceDetailsPage shareInstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
        shareInstance.addUser(Constant.NewUser_Username4, "USER");
        Assert.assertTrue(shareInstance.getInstanceUser(Constant.NewUser_Username4, "USER"), "Fail to Share instance with '" + Constant.NewUser_Username4 + "'");
        securityPage.navigateToInstances();
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameAMC_RS1), "RUNNING", "'" + Constant.InstanceNameAMC_RS1 + "' is Failed to provision AMC on RS.");
        homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
        shareInstance.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4,Constant.NewUser_Password);
        homePage.clickUngroupedInstance();
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1),"NoInstance","'"+ Constant.InstanceNameAMC_RS1 + "' is Failed to Delete AMC on RS.");
        System.out.println("Successfully '" + Constant.InstanceNameAMC_RS1 + "' Instance is Deleted and share removed with user " + Constant.NewUser_Username4);
        softAssert.assertAll();
    }

    @Test(description="House keeping test to Remove Share and Delete instance.")
    public void share_instance_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        if (!homePage.getProvisionStatus(Constant.InstanceNameAMC_RS1).contains("NoInstance"))
        {
            InstanceDetailsPage shareinstance = homePage.selectInstanceDetails(Constant.InstanceNameAMC_RS1, "Share Instance");
            shareinstance.removeShareuser();
            shareinstance.navigateToInstances();
            homePage.selectInstanceAction(Constant.InstanceNameAMC_RS1, "Delete Instance");
            Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameAMC_RS1), "NoInstance", "'" + Constant.InstanceNameAMC_RS1 + "' Instance is still Exists even-after Deletion");
        }
        SecurityHomePage securitypage =homePage.navigateToSecurity();
        securitypage.selectUserAction(Constant.NewUser_Username1, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username2, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username3, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username4, "Delete User");
        System.out.println("Completed removing sharing, removed Users and Deleting Instances");
    }
}