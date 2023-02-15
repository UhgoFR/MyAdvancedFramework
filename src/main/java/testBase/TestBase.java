package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperations;

import java.util.concurrent.TimeUnit;

public class TestBase extends ActionEngine {
    //https://www.youtube.com/watch?v=diOPcwdGhmA&list=PL5fOKT7XR42OgLXmX8wYYhB7L0sN-uqpR&index=9

    BrowserFactory bf = new BrowserFactory();

    @BeforeMethod
    public void launchApplication(){

        String browser = PropertiesOperations.getPropertyValueByKey("browser");
        String url = PropertiesOperations.getPropertyValueByKey("url");

        WebDriver driverInstance = bf.createBrowserInstance(browser);
        DriverFactory.getInstance().setDriver(driverInstance);
        WebDriver driver = DriverFactory.getInstance().getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().closeBrowser();
    }
}
