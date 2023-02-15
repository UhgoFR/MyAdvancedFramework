package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

    WebDriver driver= null;
    @FindBy(xpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']")
    WebElement sideMenu_Dashboard;

    @FindBy(xpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Tasks']")
    WebElement sideMenu_Task;

    //Initialize all page objects for given driver instance
    public HomePageObjects(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    //click on menu bar - by passing name of menu
    public void clickOnSideMenu(String menu){
       String Xpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
       driver.findElement(By.xpath(Xpath)).click();
    }

    //click on sub menu bar - by passing name of menu
    public void clickOnSubMenu(String menu, String submenu){
        String MenuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
        driver.findElement(By.xpath(MenuXpath)).click();
        String submenuXpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']/ancestor::a/following-sibling::ul//span[text()='"+submenu+"']";
        driver.findElement(By.xpath(submenuXpath)).click();
    }
}
