package Tests;

import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import testBase.DriverFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class TestCase extends TestBase {

    LoginPageObjects logginPage = new LoginPageObjects();

    @Test
    public void TestCase1(){

        System.out.println("First Test Case");
        //pass current method name
        //MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        //MyLogger.info("test1 jhfkjsdahfksdaflksad");
        logginPage.login("administrator@localhost.com", "administrator");
    }

    @Test
    public void TestCase2(){
        logginPage.login("client@localhost.com", "client");
    }

    @Test
    public void TestCase3(){
        logginPage.login("developer@localhost.com", "developer");
    }

}
