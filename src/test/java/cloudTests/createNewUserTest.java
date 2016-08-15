package cloudTests;

import com.actian.amc.pages.CreateNewUserPage;
import com.actian.amc.pages.InstancesHomePage;
import com.actian.amc.pages.LoginPage;
import com.actian.amc.pages.SecurityHomePage;
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
 * Created by manjunatha.n on 17-02-2016.
 */
public class createNewUserTest
{
    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softassert ;

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of CreateUser test");
        Select_Browser Browser = new Select_Browser() ;
        System.out.println("Browser Selection: " + Constant.Browser);
        driver = Browser.Define_Browser(Constant.Browser);
        baseUrl = Constant.http_protocol + "://" + Constant.hostNameOrIP + ":" + Constant.hostPort + Constant.amc1;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        softassert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("End of CreateUser test");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description="Checking warning message for First name property")
    public void create_user_test1 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        CreateNewUserPage newuserpage=newsecuritypage.createNewuserBttn("Create User");
        newuserpage.typeUserData("First Name", "");
        newuserpage.typeUserData("Last Name", Constant.NewUser_Lastname);
        newuserpage.typeUserData("Username", Constant.NewUser_Username);
        newuserpage.typeUserData("Email Address", Constant.NewUser_Emailid);
        newuserpage.typeUserData("Password", Constant.NewUser_Password);
        newuserpage.typeUserData("Confirm Password", Constant.NewUser_confirmpassword);
        newuserpage.getRadiobttnOption(Constant.NewUser_privilege_amc);
        String test1 =newuserpage.getAlertInfoMsg("First Name");
        softassert.assertEquals(test1,Constant.WarningMsgReqField,"verify First name warning message");
        newuserpage.clickButton("Cancel");
        softassert.assertAll();
    }

    @Test(description="Checking warning message for Last name property")
    public void create_user_test2() {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        CreateNewUserPage newuserpage=newsecuritypage.createNewuserBttn("Create User");
        newuserpage.typeUserData("First Name", Constant.NewUser_Firstname);
        newuserpage.typeUserData("Last Name", "");
        newuserpage.typeUserData("Username", Constant.NewUser_Username);
        newuserpage.typeUserData("Email Address", Constant.NewUser_Emailid);
        newuserpage.typeUserData("Password", Constant.NewUser_Password);
        newuserpage.typeUserData("Confirm Password", Constant.NewUser_confirmpassword);
        newuserpage.getRadiobttnOption(Constant.NewUser_privilege_no);
        String test1 =newuserpage.getAlertInfoMsg("Last Name");
        softassert.assertEquals(test1,Constant.WarningMsgReqField,"verify Last name warning message");
        newuserpage.clickButton("Cancel");
        softassert.assertAll();
    }

    @Test(description="Checking warning message for User name property")
    public void create_user_test3 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        CreateNewUserPage newuserpage=newsecuritypage.createNewuserBttn("Create User");
        newuserpage.typeUserData("First Name", Constant.NewUser_Firstname);
        newuserpage.typeUserData("Last Name", Constant.NewUser_Lastname);
        newuserpage.typeUserData("Username", "");
        newuserpage.typeUserData("Email Address", Constant.NewUser_Emailid);
        newuserpage.typeUserData("Password", Constant.NewUser_Password);
        newuserpage.typeUserData("Confirm Password", Constant.NewUser_confirmpassword);
        newuserpage.getRadiobttnOption(Constant.NewUser_privilege_amc);
        String test1 =newuserpage.getAlertInfoMsg("Username");
        softassert.assertEquals(test1,Constant.WarningMsgReqField,"verify Username warning message");
        newuserpage.clickButton("Cancel");
        softassert.assertAll();
    }

    @Test(description="Checking warning message for Email-Id property")
    public void create_user_test4 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        CreateNewUserPage newuserpage=newsecuritypage.createNewuserBttn("Create User");
        newuserpage.typeUserData("First Name", Constant.NewUser_Firstname);
        newuserpage.typeUserData("Last Name", Constant.NewUser_Lastname);
        newuserpage.typeUserData("Username", Constant.NewUser_Username);
        newuserpage.typeUserData("Email Address", "");
        newuserpage.typeUserData("Password", Constant.NewUser_Password);
        newuserpage.typeUserData("Confirm Password", Constant.NewUser_confirmpassword);
        newuserpage.getRadiobttnOption(Constant.NewUser_privilege_admin);
        String test1 =newuserpage.getAlertInfoMsg("Email Address");
        softassert.assertEquals(test1,Constant.WarningMsgReqField,"verify Email Address warning message");
        newuserpage.clickButton("Cancel");
        softassert.assertAll();
    }

    @Test(description="Checking warning message for Wrong Email-Id format")
    public void create_user_test5 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        CreateNewUserPage newuserpage=newsecuritypage.createNewuserBttn("Create User");
        newuserpage.typeUserData("First Name", Constant.NewUser_Firstname);
        newuserpage.typeUserData("Last Name", Constant.NewUser_Lastname);
        newuserpage.typeUserData("Username", Constant.NewUser_Username);
        newuserpage.typeUserData("Email Address", Constant.NewUser_Username); // passing username value for Email id field.
        newuserpage.typeUserData("Password", Constant.NewUser_Password);
        newuserpage.typeUserData("Confirm Password", Constant.NewUser_confirmpassword);
        newuserpage.getRadiobttnOption(Constant.NewUser_privilege_admin);
        String test1 =newuserpage.getAlertInfoMsg("Email Address");
        softassert.assertEquals(test1,Constant.WarningMsgEmailField,"verify Email Address warning message");
        newuserpage.clickButton("Cancel");
        softassert.assertAll();
    }

    @Test(description="Checking warning message for Password property")
    public void create_user_test6 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        CreateNewUserPage newuserpage=newsecuritypage.createNewuserBttn("Create User");
        newuserpage.typeUserData("First Name", Constant.NewUser_Firstname);
        newuserpage.typeUserData("Last Name", Constant.NewUser_Lastname);
        newuserpage.typeUserData("Username", Constant.NewUser_Username);
        newuserpage.typeUserData("Email Address", Constant.NewUser_Emailid);
        newuserpage.typeUserData("Password", "");
        newuserpage.typeUserData("Confirm Password", Constant.NewUser_confirmpassword);
        newuserpage.getRadiobttnOption(Constant.NewUser_privilege_amc);
        String test1 =newuserpage.getAlertInfoMsg("Password");
        softassert.assertEquals(test1,Constant.WarningMsgReqField,"verify Password warning message");
        newuserpage.clickButton("Cancel");
        softassert.assertAll();
    }

    @Test(description="Checking warning message for Confirm Password property")
    public void create_user_test7 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        CreateNewUserPage newuserpage=newsecuritypage.createNewuserBttn("Create User");
        newuserpage.typeUserData("First Name", Constant.NewUser_Firstname);
        newuserpage.typeUserData("Last Name", Constant.NewUser_Lastname);
        newuserpage.typeUserData("Username", Constant.NewUser_Username);
        newuserpage.typeUserData("Email Address", Constant.NewUser_Emailid);
        newuserpage.typeUserData("Confirm Password", "");
        newuserpage.typeUserData("Password", Constant.NewUser_Password);
        newuserpage.getRadiobttnOption(Constant.NewUser_privilege_no);
        String test1 =newuserpage.getAlertInfoMsg("Confirm Password");
        softassert.assertEquals(test1,Constant.WarningMsgReqField,"verify Confirm Password warning message");
        newuserpage.clickButton("Cancel");
        softassert.assertAll();
    }

    @Test(description="creating new user & testing cancel funcationlity with Access to AMC privilege")
    public void create_user_test8 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        if (newsecuritypage.getUserIndex(Constant.NewUser_Username)==-1) {
            CreateNewUserPage newuserpage = newsecuritypage.createNewuserBttn("Create User");
            newuserpage.typeUserData("First Name", Constant.NewUser_Firstname);
            newuserpage.typeUserData("Last Name", Constant.NewUser_Lastname);
            newuserpage.typeUserData("Username", Constant.NewUser_Username);
            newuserpage.typeUserData("Email Address", Constant.NewUser_Emailid);
            newuserpage.typeUserData("Password", Constant.NewUser_Password);
            newuserpage.typeUserData("Confirm Password", Constant.NewUser_confirmpassword);
            newuserpage.getRadiobttnOption(Constant.NewUser_privilege_amc);
            newuserpage.clickButton("Cancel");
        }Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)==-1),"user created sucessfully");
    }

    @Test(description="creating new user & testing Create funcationlity with Admin Access privileges ")
    public void create_user_test9 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        newsecuritypage.createNewUser
                (Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username,Constant.NewUser_Emailid,
                        Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_admin);
        Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1),"User fail to Create");
        newsecuritypage.signOut();
        signinpage.submitValidLogin(Constant.NewUser_Username,Constant.NewUser_Password);
        Assert.assertTrue(homepage.verifyTextvisible("SECURITY"),"Security tab is not visible");
        newsecuritypage.signOut();
        signinpage.submitValidLogin(Constant.Username,Constant.Password);
        newsecuritypage =homepage.navigateToSecurity();
        if (newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1) {
            newsecuritypage.selectUserAction(Constant.NewUser_Username,"Delete User");
        }
    }

    @Test(description="creating new user & testing Create funcationlity with No Access privileges ")
    public void create_user_test10 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        newsecuritypage.createNewUser
                (Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username,Constant.NewUser_Emailid,
                        Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_no);
        Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1), "User fail to Create");
        newsecuritypage.signOut();
        signinpage.submitInValidLogin(Constant.NewUser_Username,Constant.NewUser_Password);
        Assert.assertTrue(newsecuritypage.getPageUrl().contains("#LoginPlace:LoginPlace"),"User Sucessful login");
        newsecuritypage.reloadpage();
        signinpage.submitValidLogin(Constant.Username,Constant.Password);
        newsecuritypage =homepage.navigateToSecurity();
        if (newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1) {
            newsecuritypage.selectUserAction(Constant.NewUser_Username,"Delete User");
        }
    }

    @Test(description="creating new user & testing Create funcationlity ")
    public void create_user_test11 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        newsecuritypage.createNewUser
                (Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username,Constant.NewUser_Emailid,
                        Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1), "User fail to Create");
        newsecuritypage.signOut();
        signinpage.submitValidLogin(Constant.NewUser_Username,Constant.NewUser_Password);
        Assert.assertFalse(homepage.verifyTextvisible("SECURITY"),"Security Tab is visible");
        newsecuritypage.signOut();
        signinpage.submitValidLogin(Constant.Username,Constant.Password);
        newsecuritypage =homepage.navigateToSecurity();
        if (newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1) {
            newsecuritypage.selectUserAction(Constant.NewUser_Username,"Delete User");
        }
    }

    @Test(description="creating new user & Edit & save user profile ")
    public void create_user_test12 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        newsecuritypage.createNewUser
                (Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username,Constant.NewUser_Emailid,
                        Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1), "User fail to Create");
        CreateNewUserPage edituserpage = newsecuritypage.selectUserEditAction(Constant.NewUser_Username,"Edit User");
        edituserpage.typeUserData("First Name", Constant.EditUser_Firstname);
        edituserpage.typeUserData("Last Name", Constant.EditUser_Lastname);
        edituserpage.typeUserData("Username", Constant.EditUser_Username);
        edituserpage.typeUserData("Email Address", Constant.EditUser_Emailid);
        edituserpage.getRadiobttnOption("Change Password");
        edituserpage.typeUserData("Password", Constant.EditUser_Password);
        edituserpage.typeUserData("Confirm Password", Constant.EditUser_confirmpassword);
        edituserpage.getRadiobttnOption(Constant.NewUser_privilege_admin);
        edituserpage.clickButton("Save");
        Assert.assertTrue(newsecuritypage.getUserIndex(Constant.EditUser_Username)!=-1,"User data is not Edited");
        newsecuritypage.selectUserAction(Constant.EditUser_Username,"Delete User");
    }

    @Test(description="creating new user & Edit & Cancel user profile ")
    public void create_user_test13 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        newsecuritypage.createNewUser
                (Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username,Constant.NewUser_Emailid,
                        Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1), "User fail to Create");
        CreateNewUserPage edituserpage = newsecuritypage.selectUserEditAction(Constant.NewUser_Username,"Edit User");
        edituserpage.typeUserData("First Name", Constant.EditUser_Firstname);
        edituserpage.typeUserData("Last Name", Constant.EditUser_Lastname);
        edituserpage.typeUserData("Username", Constant.EditUser_Username);
        edituserpage.typeUserData("Email Address", Constant.EditUser_Emailid);
        edituserpage.getRadiobttnOption("Change Password");
        edituserpage.typeUserData("Password", Constant.EditUser_Password);
        edituserpage.typeUserData("Confirm Password", Constant.EditUser_confirmpassword);
        edituserpage.getRadiobttnOption(Constant.NewUser_privilege_admin);
        edituserpage.clickButton("Cancel");
        Assert.assertTrue(newsecuritypage.getUserIndex(Constant.EditUser_Username)==-1,"User data is Edited");
        newsecuritypage.selectUserAction(Constant.NewUser_Username,"Delete User");
    }

    @Test(description="creating new user & Edit & save user profile except password")
    public void create_user_test14 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        newsecuritypage.createNewUser
                (Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username,Constant.NewUser_Emailid,
                        Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1), "User fail to Create");
        CreateNewUserPage edituserpage = newsecuritypage.selectUserEditAction(Constant.NewUser_Username,"Edit User");
        edituserpage.typeUserData("First Name", Constant.EditUser_Firstname);
        edituserpage.typeUserData("Last Name", Constant.EditUser_Lastname);
        edituserpage.typeUserData("Username", Constant.EditUser_Username);
        edituserpage.typeUserData("Email Address", Constant.EditUser_Emailid);
        edituserpage.getRadiobttnOption(Constant.NewUser_privilege_admin);
        edituserpage.clickButton("Save");
        Assert.assertTrue(newsecuritypage.getUserIndex(Constant.EditUser_Username)!=-1,"User data is not Edited");
        newsecuritypage.selectUserAction(Constant.EditUser_Username,"Delete User");
    }

    @Test(description="creating new user & Edit and verify entered values saved while editing")
    public void create_user_test15 () {
        driver.get(baseUrl);
        LoginPage signinpage = new LoginPage(driver);
        InstancesHomePage homepage =signinpage.submitValidLogin(Constant.Username,Constant.Password);
        SecurityHomePage newsecuritypage =homepage.navigateToSecurity();
        newsecuritypage.createNewUser
                (Constant.NewUser_Firstname,Constant.NewUser_Lastname,Constant.NewUser_Username,Constant.NewUser_Emailid,
                        Constant.NewUser_Password,Constant.NewUser_confirmpassword,Constant.NewUser_privilege_amc);
        Assert.assertTrue((newsecuritypage.getUserIndex(Constant.NewUser_Username)!=-1), "User fail to Create");
        CreateNewUserPage edituserpage = newsecuritypage.selectUserEditAction(Constant.NewUser_Username,"Edit User");

        edituserpage.typeUserData("First Name", Constant.EditUser_Firstname);
        String value1= edituserpage.getTextFieldValue("First Name");
        softassert.assertTrue((value1.equals( Constant.EditUser_Firstname)), "verify the First name.");

        edituserpage.typeUserData("Last Name", Constant.EditUser_Lastname);
        String value2= edituserpage.getTextFieldValue("Last Name");
        softassert.assertTrue((value2.equals( Constant.EditUser_Lastname)), "verify the Last name.");

        edituserpage.typeUserData("Username", Constant.EditUser_Username);
        String value3= edituserpage.getTextFieldValue("Username");
        softassert.assertTrue((value3.equals( Constant.EditUser_Username)), "verify the Username.");

        edituserpage.typeUserData("Email Address", Constant.EditUser_Emailid);
        String value4= edituserpage.getTextFieldValue("Email Address");
        softassert.assertTrue((value4.equals( Constant.EditUser_Emailid)), "verify the Email Address.");
        edituserpage.getRadiobttnOption(Constant.NewUser_privilege_admin);
        edituserpage.clickButton("Cancel");
        softassert.assertTrue(newsecuritypage.getUserIndex(Constant.EditUser_Username)==-1,"User data is not Edited");
        softassert.assertAll();
        newsecuritypage.selectUserAction(Constant.NewUser_Username,"Delete User");
    }
}