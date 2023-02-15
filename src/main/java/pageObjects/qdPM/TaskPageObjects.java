package pageObjects.qdPM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.DriverFactory;
import testBase.TestBase;

import java.util.HashMap;

public class TaskPageObjects extends TestBase {

    By btn_addTask = By.xpath("//button[text()='Add Task']");
    By field_Search = By.id("search_menu");
    By txt_Search = By.xpath("//*[@id='search_menu']//input[@name='search[keywords]']");
    By btn_Search = By.xpath("//*[@id='search_menu']//input[@type='submit']");
    By dd_SelectProjectForNewTaskCreation = By.id("form_projects_id");
    By dd_taskType = By.id("tasks_tasks_type_id");
    By txt_taskName = By.id("tasks_name");
    By dd_taskStatus = By.id("tasks_tasks_status_id");
    By dd_taskPriority = By.id("tasks_tasks_priority_id");
    By dd_taskLabel = By.id("tasks_tasks_label_id");
    By dd_taskCreatedBy = By.id("tasks_created_by");
    By btn_save = By.xpath("//button[@type='submit' and text()='Save']");


    public void createTask(HashMap<String, String> testData) throws Throwable {
        Thread.sleep(2000);
        WebDriver driver = DriverFactory.getInstance().getDriver();
        selectDropDownByVisibleText_ctm(driver.findElement(dd_SelectProjectForNewTaskCreation), "NewTaskProjectDropDown", testData.get("ProjectToCreateTaskUnder"));
        selectDropDownByVisibleText_ctm(driver.findElement(dd_taskType), "NewTaskType", testData.get("TaskType"));
        sendKeys_ctm(driver.findElement(txt_taskName), "newTaskName", testData.get("TaskName"));
        selectDropDownByVisibleText_ctm(driver.findElement(dd_taskStatus), "NewTaskStatus", testData.get("TaskStatus"));
        selectDropDownByVisibleText_ctm(driver.findElement(dd_taskPriority), "NewTaskPriority", testData.get("TaskPriority"));
        selectDropDownByVisibleText_ctm(driver.findElement(dd_taskLabel), "NewTaskLabel", testData.get("Label"));
        click_ctm(driver.findElement(btn_save), "NewTaskSaveButton");

    }

    public void Search_Verify_TaskCreationOnUI(HashMap<String, String> testData) throws Throwable {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        moveToElement_ctm(driver.findElement(field_Search), "TaskSearchOption");
        sendKeys_ctm(driver.findElement(txt_Search), "TaskSearchBox", testData.get("TaskName"));
        click_ctm(driver.findElement(btn_Search), "SearchButton");

        //table verification
        assertEqualsString_ctm(testData.get("TaskName"), getTaskTableCellValueByColumnName("Name"), "TaskNameInTable");

    }

    private String getTaskTableCellValueByColumnName(String columnName) {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        String valueXpath = "//table[starts-with(@id, 'itmes_listing')]/tbody/tr/td[count(//table[starts-with(@id, 'itmes_listing')]/thead/tr/th/div[text()='"+columnName+"']/parent::th/preceding-sibling::th)+1]";
        String value = driver.findElement(By.xpath(valueXpath)).getText();
        return value;
    }
}
