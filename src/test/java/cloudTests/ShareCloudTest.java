package cloudTests;

import com.actian.amc.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.Constant;
import utility.Select_Browser;

/**
 * Created by manjunatha.n on 04-05-2016.
 */
public class ShareCloudTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setup()
    {
        System.out.println("Begin of ShareCloudTest");
        Select_Browser browser = new Select_Browser();
        driver=browser.Define_Browser(Constant.Browser);
        System.out.println("Browser Selection: " + Constant.Browser);
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        browser.implicitly_Wait();
        browser.browser_Maximize();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("End of ShareCloudTest");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="Share Cloud with MASTER User role :RackSpace Cloud")
    public void share_Cloud_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Shared RackSpace cloud definition so expecting to exist.");
        System.out.println("Sucessfully '" + Constant.CloudNameRS2 + "' Cloud is Shared with " + Constant.NewUser_Username2);
    }

    @Test(description="Share Cloud with ADMINISTRATOR user role :RackSpace Cloud")
    public void share_Cloud_test2 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Shared RackSpace cloud definition so expecting to exist.");
        System.out.println("Sucessfully '" + Constant.CloudNameRS2 + "' Cloud is Shared with " + Constant.NewUser_Username1);
    }

    @Test(description="Share Cloud with USER role :RackSpace Cloud")
    public void share_Cloud_test3 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Shared RackSpace cloud definition so expecting to exist.");
        System.out.println("Sucessfully '" + Constant.CloudNameRS2 + "' Cloud is Shared with " + Constant.NewUser_Username4);
    }

    @Test(description="Share Cloud with NO ACCESS User role :RackSpace Cloud")
    public void share_Cloud_test4 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username3,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username3)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username3,"NO ACCESS");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username3,"NO ACCESS"),"Fail to Share Cluster with '" + Constant.NewUser_Username3 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username3, Constant.NewUser_Password).navigateToClouds();
        Assert.assertEquals(cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2), -1, "'" + Constant.CloudNameRS2 + "' cloud is visible for Shared user");
        System.out.println(Constant.CloudNameRS2 + "' Cloud is Not Visible in Shared user " + Constant.NewUser_Username3);
    }


    @Test(description="Check privileges of MASTER role in Shared Cloud: RackSpace Cloud")
    public void share_Cloud_test5 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password).navigateToClouds();
        String[] cloudoptions={"Test Cloud","Edit Cloud","Delete Cloud","Share Cloud"};
        Assert.assertTrue(sharecloud.checkAvailableOptions(Constant.CloudNameRS2,cloudoptions),"MASTER Previliage options on Cluster are Invalid");
        System.out.println(Constant.NewUser_Username2 +" User has valid privileges to control Shared Cluster");
    }

    @Test(description="Check privileges of USER role in Shared Cloud: RackSpace Cloud")
    public void share_Cloud_test6 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password).navigateToClouds();
        String[] cloudoptions={"Test Cloud"};
        Assert.assertTrue(sharecloud.checkAvailableOptions(Constant.CloudNameRS2,cloudoptions),"MASTER Previliage options on Cluster are Invalid");
        System.out.println(Constant.NewUser_Username4 +" User has valid privileges to control Shared Cluster");
    }

    @Test(description="Check privileges of ADMINISTRATOR role in Shared Cloud: RackSpace Cloud")
    public void share_Cloud_test7 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password).navigateToClouds();
        String[] cloudoptions={"Test Cloud"};
        Assert.assertTrue(sharecloud.checkAvailableOptions(Constant.CloudNameRS2,cloudoptions),"MASTER Previliage options on Cluster are Invalid");
        System.out.println(Constant.NewUser_Username1 +" User has valid privileges to control Shared Cluster");
    }

    @Test(description="Performing Test Cloud action in Shared user account (MASTER role): RackSpace Cloud")
    public void share_Cloud_test8 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        cloudhomepage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Test Cloud");;
        Assert.assertTrue((cloudhomepage.getDialogMessage().equals("Cloud test successful!")), "Expected Valid Shared Test Cloud operation.");
        System.out.println("Test Cloud is Passed in Shared user account "+ Constant.NewUser_Username2 +"");
    }

    @Test(description="Performing Test Cloud action in Shared user account (ADMINISTRATOR role): RackSpace Cloud")
    public void share_Cloud_test9 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        cloudhomepage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Test Cloud");;
        Assert.assertTrue((cloudhomepage.getDialogMessage().equals("Cloud test successful!")), "Expected Valid Shared Test Cloud operation.");
        System.out.println("Test Cloud is Passed in Shared user account "+ Constant.NewUser_Username1 +"");
    }

    @Test(description="Performing Test Cloud action in Shared user account (USER role): RackSpace Cloud")
    public void share_Cloud_test10 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity().createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        cloudhomepage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Test Cloud");;
        Assert.assertTrue((cloudhomepage.getDialogMessage().equals("Cloud test successful!")), "Expected Valid Shared Test Cloud operation.");
        System.out.println("Test Cloud is Passed in Shared user account "+ Constant.NewUser_Username4 +"");
    }

    @Test(description="Performing Delete Cloud action in Shared user account (MASTER role): RackSpace Cloud")
    public void share_Cloud_test11 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password);
        cloudhomepage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Delete Cloud").reloadpage();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1), "Expected Shared Cloud should get delete.");
        System.out.println("Test Cloud is Passed in Shared user account "+ Constant.NewUser_Username2 +"");
    }

    @Test(description="Performing Delete Cloud action in Shared user account (USER role): RackSpace Cloud")
    public void share_Cloud_test12 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password);
        cloudhomepage.navigateToClouds();
        String[] cloudoptions={"Test Cloud","Edit Cloud","Delete Cloud","Share Cloud"};
        Assert.assertFalse(sharecloud.checkAvailableOptions(Constant.CloudNameRS2,cloudoptions),"USER Previliage options on cloud are valid");
        System.out.println(Constant.NewUser_Username4 +" Role doesn't have Previliage to Delete Shared Cloud");
    }


    @Test(description="Performing Delete Cloud action in Shared user account (ADMINISTRATOR role): RackSpace Cloud")
    public void share_Cloud_test13 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password);
        cloudhomepage.navigateToClouds();
        String[] cloudoptions={"Test Cloud","Edit Cloud","Delete Cloud","Share Cloud"};
        Assert.assertFalse(sharecloud.checkAvailableOptions(Constant.CloudNameRS2,cloudoptions),"ADMINISTRATOR Previliage options on cloud are valid");
        System.out.println(Constant.NewUser_Username1 +" Role doesn't have Previliage to Delete Shared Cloud");
    }

    @Test(description="Performing Delete Cloud action and checking in Shared user account (MASTER role): RackSpace Cloud")
    public void share_Cloud_test14 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)!=-1), "Expected Shared Cloud should visible.");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password).navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Delete Cloud");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1), "Expected Shared Cloud should get delete.");
        System.out.println("Shared Cloud Deleted in Shared user account "+ Constant.NewUser_Username2 +"");
    }

    @Test(description="Performing Delete Cloud action and checking in Shared user account (USER role): RackSpace Cloud")
    public void share_Cloud_test15 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)!=-1), "Expected Shared Cloud should visible.");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password).navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Delete Cloud");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1), "Expected Shared Cloud should get delete.");
        System.out.println("Shared Cloud Deleted in Shared user account "+ Constant.NewUser_Username4 +"");
    }

    @Test(description="Performing Delete Cloud action and checking in Shared user account(ADMINISTRATOR role): RackSpace Cloud")
    public void share_Cloud_test16 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)!=-1), "Expected Shared Cloud should visible.");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password).navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Delete Cloud");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1), "Expected Shared Cloud should get delete.");
        System.out.println("Shared Cloud Deleted in Shared user account "+ Constant.NewUser_Username1 +"");
    }

    @Test(description="Performing Edit Cloud action in Shared user account (MASTER role): RackSpace Cloud")
    public void share_Cloud_test17 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        if (cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1)
        {
            cloudhomepage.selectCloudAction(Constant.EditCloudName,"Delete Cloud");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.NewUser_Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)!=-1), "Expected Shared Cloud should visible.");
        EditCloudDefinitionPage RSCloudPage = cloudhomepage.selectCloudAction2(Constant.CloudNameRS2, "Edit Cloud");
        RSCloudPage.textfield_Type("Cloud name", Constant.EditCloudName);
        RSCloudPage.textfield_Type("Description",Constant.EditCloudDescription);
        RSCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        RSCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderRS);
        RSCloudPage.textfield_Type("Username",Constant.CloudUserNameRS);
        RSCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        RSCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        RSCloudPage.clickButton("Save");
        RSCloudPage.selectDialogButton("OK");
        RSCloudPage.reloadpage();
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.Username, Constant.Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1), "Edited Shared Cloud should visible.");
        cloudhomepage.selectCloudAction(Constant.EditCloudName,"Delete Cloud");
        System.out.println("Edited Shared Cloud is visible in Shared user account "+ Constant.NewUser_Username2 +"");
    }

    @Test(description="Performing Edit Cloud action in Shared user account (ADMINISTRATOR role): RackSpace Cloud")
    public void share_Cloud_test18 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.NewUser_Password).navigateToClouds();

        String[] cloudoptions={"Test Cloud","Edit Cloud","Delete Cloud","Share Cloud"};
        Assert.assertFalse(sharecloud.checkAvailableOptions(Constant.CloudNameRS2,cloudoptions),"ADMINISTRATOR Previliage options on cloud are valid");
        System.out.println(Constant.NewUser_Username1 +" Role doesn't have Previliage to Edit Shared Cloud definition");
    }

    @Test(description="Performing Edit Cloud action in Shared user account (USER role): RackSpace Cloud")
    public void share_Cloud_test19 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.NewUser_Password).navigateToClouds();
        String[] cloudoptions={"Test Cloud","Edit Cloud","Delete Cloud","Share Cloud"};
        Assert.assertFalse(sharecloud.checkAvailableOptions(Constant.CloudNameRS2,cloudoptions),"USER Previliage options on cloud are valid");
        System.out.println(Constant.NewUser_Username4 +" Role doesn't have Previliage to Edit Shared Cloud definition");
    }

    @Test(description="Performing Edit Cloud action and checking in Shared user account (MASTER role): RackSpace Cloud")
    public void share_Cloud_test20 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        if (cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1)
        {
            cloudhomepage.selectCloudAction(Constant.EditCloudName,"Delete Cloud");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username2,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username2)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username2,"MASTER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username2,"MASTER"),"Fail to Share Cluster with '" + Constant.NewUser_Username2 +"'");
        EditCloudDefinitionPage RSCloudPage = cloudhomepage.selectCloudAction2(Constant.CloudNameRS2, "Edit Cloud");
        RSCloudPage.textfield_Type("Cloud name", Constant.EditCloudName);
        RSCloudPage.textfield_Type("Description",Constant.EditCloudDescription);
        RSCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        RSCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderRS);
        RSCloudPage.textfield_Type("Username",Constant.CloudUserNameRS);
        RSCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        RSCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        RSCloudPage.clickButton("Save");
        RSCloudPage.selectDialogButton("OK");
        RSCloudPage.reloadpage();
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username2, Constant.Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1), "Edited Shared Cloud should visible.");
        System.out.println("Edited cloud is visible in Shared user account "+ Constant.NewUser_Username2 +"");
    }

    @Test(description="Performing Edit Cloud action and checking in Shared user account (ADMINISTRATOR role): RackSpace Cloud")
    public void share_Cloud_test21 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        if (cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1)
        {
            cloudhomepage.selectCloudAction(Constant.EditCloudName,"Delete Cloud");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username1,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username1)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username1,"ADMINISTRATOR");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username1,"ADMINISTRATOR"),"Fail to Share Cluster with '" + Constant.NewUser_Username1 +"'");
        EditCloudDefinitionPage RSCloudPage = cloudhomepage.selectCloudAction2(Constant.CloudNameRS2, "Edit Cloud");
        RSCloudPage.textfield_Type("Cloud name", Constant.EditCloudName);
        RSCloudPage.textfield_Type("Description",Constant.EditCloudDescription);
        RSCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        RSCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderRS);
        RSCloudPage.textfield_Type("Username",Constant.CloudUserNameRS);
        RSCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        RSCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        RSCloudPage.clickButton("Save");
        RSCloudPage.selectDialogButton("OK");
        RSCloudPage.reloadpage();
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username1, Constant.Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1), "Edited Shared Cloud should visible.");
        System.out.println("Edited cloud is visible in Shared user account "+ Constant.NewUser_Username1 +"");
    }

    @Test(description="Performing Edit Cloud action and checking in Shared user account (USER role): RackSpace Cloud")
    public void share_Cloud_test22 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage=homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2)==-1)
        {
            CloudHomePage createcloud =cloudhomepage.createCloudDefRackSpace(Constant.CloudServiceProviderRackSpace,
                    Constant.CloudNameRS2,
                    Constant.CloudDescriptionRS,
                    Constant.CloudGroupNameRS,
                    Constant.CloudProviderRS,
                    Constant.CloudUserNameRS,
                    Constant.CloudAPIKeyRS,
                    Constant.CloudRegionRS);
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1), "Created RackSpace cloud definition so expecting to exist.");
        }
        if (cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1)
        {
            cloudhomepage.selectCloudAction(Constant.EditCloudName,"Delete Cloud");
        }
        SecurityHomePage securityPage =homePage.navigateToSecurity();
        securityPage.createNewUser(Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username4,Constant.NewUser_Emailid,
                Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((securityPage.getUserIndex(Constant.NewUser_Username4)!=-1), "User fail to Create");
        securityPage.navigateToClouds().selectCloudAction(Constant.CloudNameRS2,"Share Cloud");
        CloudHomePage sharecloud= cloudhomepage.addUser(Constant.NewUser_Username4,"USER");
        Assert.assertTrue(sharecloud.getCloudUser(Constant.NewUser_Username4,"USER"),"Fail to Share Cluster with '" + Constant.NewUser_Username4 +"'");
        EditCloudDefinitionPage RSCloudPage = cloudhomepage.selectCloudAction2(Constant.CloudNameRS2, "Edit Cloud");
        RSCloudPage.textfield_Type("Cloud name", Constant.EditCloudName);
        RSCloudPage.textfield_Type("Description",Constant.EditCloudDescription);
        RSCloudPage.textfield_Type("Cloud group name", Constant.CloudGroupNameRS);
        RSCloudPage.textfield_Type("Cloud Provider/API",Constant.CloudProviderRS);
        RSCloudPage.textfield_Type("Username",Constant.CloudUserNameRS);
        RSCloudPage.textfield_Type("API Key", Constant.CloudAPIKeyRS);
        RSCloudPage.textfield_Type("Region Name", Constant.CloudRegionRS);
        RSCloudPage.clickButton("Save");
        RSCloudPage.selectDialogButton("OK");
        RSCloudPage.reloadpage();
        sharecloud.signOut();
        signInPage.submitValidLogin(Constant.NewUser_Username4, Constant.Password).navigateToClouds();
        Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.EditCloudName)!=-1), "Edited Shared Cloud should visible.");
        System.out.println("Edited cloud is visible in Shared user account "+ Constant.NewUser_Username4 +"");
    }

    @Test(description="HouseKeeping Test to Delete cloud and Users: RackSpace Cloud")
    public void share_Cloud_test23 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);
        CloudHomePage cloudhomepage = homePage.navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) != -1)
        {   cloudhomepage.selectCloudAction(Constant.CloudNameRS2,"Delete Cloud");
            cloudhomepage.reloadpage();
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.CloudNameRS2) == -1), "Deleted cloud '"+Constant.CloudNameRS2 +"' so expecting cloud definition to not exist.");
        }SecurityHomePage securitypage =cloudhomepage.navigateToSecurity();
        securitypage.selectUserAction(Constant.NewUser_Username1, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username2, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username3, "Delete User");
        securitypage.selectUserAction(Constant.NewUser_Username4, "Delete User").navigateToClouds();
        if (cloudhomepage.getCloudNameIndex(Constant.EditCloudName) != -1)
        {  cloudhomepage.selectCloudAction(Constant.EditCloudName,"Delete Cloud");
            cloudhomepage.reloadpage();
            Assert.assertTrue((cloudhomepage.getCloudNameIndex(Constant.EditCloudName) == -1), "Deleted cloud '"+Constant.EditCloudName +"' so expecting cloud definition to not exist.");
        }System.out.println("Completed removing shared Cloud and Users.");
    }
}
