package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by uttam.kumar on 14-10-2015.
 */


public class Select_Browser {

    public WebDriver driver;

     public  WebDriver Define_Browser(Object Browser) {

        if (Browser.equals("Chrome"))
        {
            File file = new File("src/main/resources/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
        }
        else if(Browser.equals("FireFox"))
        {
            driver = new FirefoxDriver();
        }
        else if(Browser.equals("IE"))
        {
            File file = new File("src/main/resources/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(ieCapabilities);
        }
        return driver;
    }

    public void implicitly_Wait() { driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }

    public void browser_Maximize() { driver.manage().window().maximize(); }
}











