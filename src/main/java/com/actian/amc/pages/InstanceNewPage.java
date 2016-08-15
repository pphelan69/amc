package com.actian.amc.pages;

import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pphelan on 10/21/2015.
 */
public class InstanceNewPage extends AMCPage{

    By platformProductDropDown      = By.cssSelector(".GEG-4-BBS");

    // Wizard - Screen 1
    By instanceNameField            = By.id("instanceNameFieldId-input");
    By instanceGroupField           = By.id("groupNameDropdown-input");
    By instanceNewExistingRadioList = By.name("create.what");

    // Wizard - Screen 3
    By numDataNodes                 = By.name("provider.aws.nodeconfig_custom_id");
    By nodeSizeDropDown             = By.cssSelector(".GEG-4-BKR.GEG-4-BBS.GEG-4-BOR");

    By AMC_AWS_2CPU4GB =By.xpath("//div[contains(text(),'$: 2 CPU, 4GB')]");
    By AMC_AWS_2CPU8GB =By.xpath("//div[contains(text(),'$$: 2 CPU, 8GB')]");
    By AMC_AWS_4CPU16GB =By.xpath("//div[contains(text(),'$$$$: 4 CPU')]");

    By licensebrowserbutton = By.name("product.dataflow.license");
    String licensepath;

    public InstanceNewPage(WebDriver driver) {
        super(driver);
        // Check that we're on the right page.
        if (!driver.getCurrentUrl().contains("#ProvisionPlace:ProvisionPlace")){
            throw new IllegalStateException("This is not a valid new instance page");
        }
    }

    public InstanceNewPage selectPlatformProduct(String actianProduct)
    {   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4){
            try {
                driver.findElement(platformProductDropDown).click();
                List<WebElement> products = driver.findElements(itemsInDropdown);
                boolean foundProduct = false;
                for (WebElement product : products) {
                    System.out.println(product.getText());
                    if (product.getText().contains(actianProduct)){
                        product.click();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }foundProduct = true;
                        break;}                }
                if (foundProduct != true) {
                    System.out.println("Product is not Select OR Not a valid product:" + actianProduct);
                    count = count + 1;continue;  }
            }catch (StaleElementReferenceException e)
            {   System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;}count = count + 4;
        }return new InstanceNewPage(driver);
    }


    public InstanceNewPage selectNodeSize(String nodeSizeChoice) {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                driver.findElement(nodeSizeDropDown).click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (nodeSizeChoice) {
                    case "$: 2 CPU, 4GB, 1 x 8GB + 1 x 25GB":
                        driver.findElement(AMC_AWS_2CPU4GB).click();
                        break;
                    case "$$: 2 CPU, 8GB, 1 x 8GB + 1 x 25GB":
                        driver.findElement(AMC_AWS_2CPU8GB).click();
                        break;
                    case "$$$$: 4 CPU, 16GB, 1 x 8GB + 1 x 25GB, High Performance Network":
                        driver.findElement(AMC_AWS_4CPU16GB).click();
                        break;
                    default:
                        System.out.println("Not a valid node size:" + nodeSizeChoice);
                        break;
                }
            }catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException :-" );
                count = count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        }return new InstanceNewPage(driver);
    }

    public InstanceNewPage instanceCreationWizardScreen1(String instanceName, String instanceGrp,String instanceType)
    {   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                driver.findElement(instanceNameField).clear();
                driver.findElement(instanceNameField).sendKeys(instanceName);
                driver.findElement(instanceNameField).sendKeys(Keys.ENTER);
                driver.findElement(instanceGroupField).clear();
                driver.findElement(instanceGroupField).sendKeys(instanceGrp);
                driver.findElement(instanceNameField).sendKeys(Keys.ENTER);
                if (driver.findElements(instanceNewExistingRadioList).size() > 0) {  // Won't Exist for Matrix or AMC
                    if (instanceType == "New") {
                        List<WebElement> instanceTypes = driver.findElements(instanceNewExistingRadioList);
                        instanceTypes.get(0).click();
                    } else if (instanceType == "Existing") {
                        List<WebElement> instanceTypes = driver.findElements(instanceNewExistingRadioList);
                        instanceTypes.get(1).click();
                    } else {
                        System.out.println("The valid options are New and Existing");
                    }
                }clickWizardButton("Wizard 1: ","Next");
                if(!getDialogMessage().equals(""))
                {selectDialogButton("OK");
                    count = count + 1;
                    continue; }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException :-");
                count = count + 1; screenShot(driver);
                continue;
            }count = count + 4;
        }return new InstanceNewPage(driver);
    }

    public InstanceNewPage instanceCreationWizardScreen2(String cloud,String[] additionalSW)
    {        //added wait statement to check object is avaialable to click
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                String x = "//input[@name='" + cloud + "']";
                if (driver.findElement(By.xpath(x)).isSelected()!=true)
                { driver.findElement(By.xpath(x)).click(); }
                // Choose additional software to provision.
                System.out.println("addition settings="+additionalSW.length);
                for (int i = 0; i < additionalSW.length; i++) {
                    String z = "input[name='" + additionalSW[i] + "']";
                    if (driver.findElement(By.cssSelector(z)).isSelected() != true) {
                        driver.findElement(By.cssSelector(z)).click();              }
                }clickWizardButton("Wizard 2: ","Next");
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException :-");
                count = count + 1; screenShot(driver);
                continue;
            }count = count + 4;
        } return new InstanceNewPage(driver);
    }

    public InstanceNewPage instanceCreationWizardScreen2_1(String[] hadoopDistribution)
    {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println("addition settings="+hadoopDistribution.length);
        int count = 0;
        while (count < 4) {
            try {
                for (int i = 0; i < hadoopDistribution.length; i++) {
                    String z = "input[name='" + hadoopDistribution[i] + "']";
                    if (driver.findElement(By.cssSelector(z)).isSelected() != true)
                    {   driver.findElement(By.cssSelector(z)).click();

                        if (hadoopDistribution[i].equals("DataFlow"))
                        { if(System.getProperty("os.name").contains("Windows"))
                        {
                            licensepath = "D:\\Actian\\selenium\\amcAuto\\src\\main\\resources\\drivers\\DataFlow_Unlimited_Internal_20161231.slc";
                            driver.findElement(licensebrowserbutton).sendKeys(licensepath);
                        }else {
                            licensepath ="/root/scripts_copy/license/DataFlow_Unlimited_Internal_20161231.slc";
                            driver.findElement(licensebrowserbutton).sendKeys(licensepath);
                        }   }
                    }                                                   }
            } catch (NoSuchElementException | StaleElementReferenceException  e) {
                System.out.println("Trying to recover from a NoSuchElementException :-" );
                count = count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        } return new InstanceNewPage(driver);
    }

    public InstanceNewPage instanceCreationWizardScreen2_2(String ambariVersion, String HDPversion)
    {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println("hadoopDistribution version :="+ambariVersion);
        System.out.println("HDPverssion :"+ HDPversion);
        int count = 0;
        while (count < 4) {
            try {
                String z = "input[name='" + ambariVersion + "']";
                if (driver.findElement(By.cssSelector(z)).isSelected() != true) {
                    driver.findElement(By.cssSelector(z)).click();
                }By dropdown= By.xpath("//input[@name='"+ ambariVersion+ "']/following::div[4]/div[1]/div[1]");
                driver.findElement(dropdown).click();
                List<WebElement> versions = driver.findElements(itemsInDropdown);
                { for (int i = 0; i < versions.size(); i++)
                { if (versions.get(i).getText().equals(HDPversion))
                { versions.get(i).click(); break; }
                }
                }//screenShot(driver);// added to verify ambari versions selection
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException 2.2:-");
                count = count + 1; screenShot(driver);
                continue;
            }count = count + 4;
        } return new InstanceNewPage(driver);
    }

    public InstanceNewPage instanceCreationWizardScreen3(String nodeConfig,String numNodes,String instanceOption)  {
        int count = 0;
        while (count < 4) {
            try {
                // Node Configuration choice
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                List<String> nodeConfigList = Arrays.asList("Extra Small","Small","Medium","Large","Custom");
                if (nodeConfigList.contains(nodeConfig)) {
                    String nodeConfigChoice = "input[name='" + nodeConfig + "']";
                    driver.findElement(By.cssSelector(nodeConfigChoice)).click();
                }
                // If the Node Configuration is custom
                if (nodeConfig == "Custom") {
                    driver.findElement(numDataNodes).clear();
                    driver.findElement(numDataNodes).sendKeys(numNodes);
                }
                // added instnace option for Vector H
                List<String> instanceOptions = Arrays.asList("Development","Balanced price and performance","Production");
                if (instanceOptions.contains(instanceOption)) {
                    String instanceChoice = "input[name='" + instanceOption + "']";
                    driver.findElement(By.cssSelector(instanceChoice)).click();
                }
                // Node size choices for AWS when deploying AMC
                List<String> nodeSizeList = Arrays.asList(
                        "$$$$: 4 CPU, 16GB, 1 x 8GB + 1 x 25GB, High Performance Network",
                        "$$: 2 CPU, 8GB, 1 x 8GB + 1 x 25GB",
                        "$: 2 CPU, 4GB, 1 x 8GB + 1 x 25GB");

                if (nodeSizeList.contains(instanceOption))
                {
                    if (driver.findElements(nodeSizeDropDown).size() > 0)
                    { selectNodeSize(instanceOption); }
                }
                // Instance Options
                if ((instanceOption.contains("Virtual")) || (instanceOption.contains("Mixed")) || (instanceOption.contains("OnMetal"))){
                    String instOption = "input[name='" + instanceOption + "']";
                    driver.findElement(By.cssSelector(instOption)).click();
                } clickWizardButton("Wizard 3: ","Next");
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException :-");
                count= count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        }return new InstanceNewPage(driver);
    }

    public InstanceNewPage instanceCreationWizardScreen3_1(String group)  {
        int count = 0;
        By groupcheckbox = By.name(group);
        while (count < 4) {
            try {
                if (driver.findElement(groupcheckbox).isSelected() != true) {
                    driver.findElement(groupcheckbox).click();               }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a NoSuchElementException :-");
                count= count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        }return new InstanceNewPage(driver);
    }

    public InstancesHomePage instanceCreationWizardScreen4()  {
        screenShot(driver);
        clickWizardButton("Wizard 4: ","Create");
        return new InstancesHomePage(driver);
    }


    private void clickWizardButton(String wizardname, String buttonname) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        while (count < 4) {
            try {
                List<WebElement> wizardBtns = driver.findElements(buttonNames);
                for (int i = 0; i < wizardBtns.size(); i++) {
                    if (wizardBtns.get(i).getText().contains(buttonname)) {
                        System.out.println(wizardname + wizardBtns.get(i).getText());
                        wizardBtns.get(i).click();
                        break;}
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1;
                screenShot(driver);
                continue;
            } count = count + 4;
        }
    }

    public List<WebElement> listAllProduct() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int count = 0;
        List<WebElement> products = null;
        while (count < 4) {
            try {
                driver.findElement(platformProductDropDown).click();
                products = driver.findElements(itemsInDropdown);
            } catch (StaleElementReferenceException e) {
                System.out.println("Trying to recover from a StaleElementReferenceException :-");
                count = count + 1; screenShot(driver);
                continue;
            } count = count + 4;
        } return products;
    }
}