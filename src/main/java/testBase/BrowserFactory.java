package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory {

    //https://www.youtube.com/watch?v=pcVWuz8YEqQ&list=PL5fOKT7XR42OgLXmX8wYYhB7L0sN-uqpR&index=7
    //Create WebDriver object for given instance
    public WebDriver createBrowserInstance(String browser){
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            driver=new ChromeDriver(options);

        }else if(browser.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions foptions = new FirefoxOptions();
            foptions.addArguments("-private");
            driver=new FirefoxDriver(foptions);

        }else if(browser.equalsIgnoreCase("ie")){

            WebDriverManager.iedriver().setup();
            InternetExplorerOptions iOption = new InternetExplorerOptions();
            iOption.addCommandSwitches("-private");
            driver=new InternetExplorerDriver(iOption);
        }
        return driver;
    }
}
