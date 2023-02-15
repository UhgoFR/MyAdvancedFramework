package testBase;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentFactory {

    //https://www.youtube.com/watch?v=N4JKX7qNw_s&list=PL5fOKT7XR42OgLXmX8wYYhB7L0sN-uqpR&index=10

    //design pattern --> represents best practices
    //---------------------------------------------------------------
    //singleton design pattern --> only on instance exist ever, provide global access to that instance by getInstance method
    //private constructor so that no one else can crete object of this class
    private ExtentFactory(){

    }

    //method to provide global access creating a static reference
    private static ExtentFactory instance = new ExtentFactory();

    //return the instance of teh current class
    public static ExtentFactory getInstance(){

        return instance;
    }
    //---------------------------------------------------------------
    //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent(){

        return extent.get();
    }

    public void setExtent(ExtentTest extentTestObject){

        extent.set(extentTestObject);
    }

    public void removeExtentObject(){
        extent.remove();
    }

}
