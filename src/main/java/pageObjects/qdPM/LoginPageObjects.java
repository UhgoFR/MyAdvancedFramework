package pageObjects.qdPM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.DriverFactory;
import testBase.TestBase;

public class LoginPageObjects extends TestBase {

    By EMAIL = By.name("login[email]");
    By PASSWORD = By.name("login[password]");
    By LOGIN_BTN = By.xpath("//button[@type='submit' and text()='Login ']");


    //login to App
    public void login(String email, String password) {
        //get the driver instance
        WebDriver driver = DriverFactory.getInstance().getDriver();

        sendKeys_ctm(driver.findElement(EMAIL), "LoginEmailFIeld", email);
        sendKeys_ctm(driver.findElement(PASSWORD), "LoginPasswordFIeld", password);

        click_ctm(driver.findElement(LOGIN_BTN), "LoginButton");

    }

}
