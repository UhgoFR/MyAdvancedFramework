package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    // https://www.youtube.com/watch?v=5wgusEV4uSQ&list=PL5fOKT7XR42OgLXmX8wYYhB7L0sN-uqpR&index=8
    //ThreadLocal --> java.lang --> threading

    //design pattern --> represents best practices
    //---------------------------------------------------------------
    //singleton design pattern --> only on instance exist ever, provide global access to that instance by getInstance method
    //private constructor so that no one else can crete object of this class
    private DriverFactory(){

    }

    //method to provide global access creating a static reference
    private static DriverFactory instance = new DriverFactory();

    //return the instance of teh current class
    public static DriverFactory getInstance(){
        return instance;
    }
    //---------------------------------------------------------------
    //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driverParam){
        driver.set(driverParam);
    }

    public void closeBrowser(){
        driver.get().quit();
        driver.remove();
    }


}
