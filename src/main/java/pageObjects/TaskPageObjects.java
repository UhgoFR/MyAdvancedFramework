package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPageObjects {

    @FindBy(xpath = "//button[text()='Add Task']")
    WebElement btn_AddTask;

    //Initialize all page objects for given driver instance
    public TaskPageObjects(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
