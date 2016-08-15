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
 * Created by pphelan on 10/21/2015.
 */
public class instanceMatrixSmokeTest {

    private WebDriver driver;
    private String baseUrl;
    private SoftAssert softAssert;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setup(){
        System.out.println("Begin of test");
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
        driver.manage().deleteAllCookies();
        driver.quit();
        System.out.println("End of test");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) Assert.fail(verificationErrorString);
    }


    @Test(description="RS - Test provisioning Matrix small cluster (4 nodes) on RackSpace virtual hardware")
    public void instance_matrix_test1 () {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_RS1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};
            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_RS1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameRS2, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Virtual");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_RS1), "RUNNING", "'" + Constant.InstanceNameMatrix_RS1 + "' is Failed to provision Matrix on RackSpace.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_RS1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_RS1), "NoInstance", "'" + Constant.InstanceNameMatrix_RS1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }

    @Test(description="AWS - Test provisioning Matrix small cluster (4 nodes) on AWS.")
    public void instance_matrix_test2 () {
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

    @Test(description="AWS_Subnet - Test provisioning Matrix small cluster (4 nodes) on AWS_Subnet.")
    public void instance_matrix_test3() {
        driver.get(baseUrl);
        LoginPage signInPage = new LoginPage(driver);
        InstancesHomePage homePage = signInPage.submitValidLogin(Constant.Username, Constant.Password);

        if (homePage.getProvisionStatus(Constant.InstanceNameMatrix_AWS_Sub1).contains("NoInstance")) {
            InstanceNewPage newInstancePage = homePage.provisionNewInstance();

            String[] additionalSW = {"Matrix Console"};

            newInstancePage.selectPlatformProduct(Constant.Matrix_Product);
            newInstancePage.instanceCreationWizardScreen1(Constant.InstanceNameMatrix_AWS_Sub1, "AutoGrp1", "New");
            newInstancePage.instanceCreationWizardScreen2(Constant.CloudNameAWS3, additionalSW);
            newInstancePage.instanceCreationWizardScreen3("Extra Small", "", "Development");
            newInstancePage.instanceCreationWizardScreen4();
        }
        softAssert.assertEquals(homePage.getProvisionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub1), "RUNNING", "'" + Constant.InstanceNameMatrix_AWS_Sub1 + "' is Failed to provision Matrix on AWS_Subnet.");
        homePage.selectInstanceAction(Constant.InstanceNameMatrix_AWS_Sub1, "Delete Instance");
        Assert.assertEquals(homePage.getDeletionStatusDetails(Constant.InstanceNameMatrix_AWS_Sub1), "NoInstance", "'" + Constant.InstanceNameMatrix_AWS_Sub1 + "' Instance is still Exists even-after Deletion");
        softAssert.assertAll();
    }
}
