package Tests.qdPM;

import lombok.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.qdPM.HomePageObjects;
import pageObjects.qdPM.LoginPageObjects;
import pageObjects.qdPM.TaskPageObjects;
import reusableComponents.DB_Operations;
import reusableComponents.ExcelOperations;
import testBase.ExtentFactory;
import testBase.TestBase;

import java.util.HashMap;

public class TestCase extends TestBase {

    LoginPageObjects logginPage = new LoginPageObjects();
    HomePageObjects homePage = new HomePageObjects();
    TaskPageObjects taskPage = new TaskPageObjects();
    DB_Operations dbOps = new DB_Operations();

    ExcelOperations excel = new ExcelOperations("TaskCreationData");

    @Test(dataProvider = "taskCreationData")
    public void TestCase1(Object obj1) throws Throwable {

        HashMap<String, String> testData = (HashMap<String, String>) obj1;

        ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: "+ testData);
        System.out.println("First Test Case");
        //pass current method name
        //MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        //MyLogger.info("test1 jhfkjsdahfksdaflksad");
        logginPage.login(testData.get("UserName"), testData.get("Password"));
        //check dashboard page opens
        homePage.checkIfDashBoardPageIsOpened();
        //Add task
        homePage.clickOnSideSubMenu("Tasks","Add Task");
        taskPage.createTask(testData);
        //verify task on UI
        taskPage.Search_Verify_TaskCreationOnUI(testData);
        /*
        //Verify Db
        String sql = "";
        HashMap<String, String> dbData = dbOps.getSqlResultInMap(sql);
        String TaskName = dbData.get("name");
        assertEqualsString_ctm("Demo",TaskName, "DB_Task_name" );
         */
    }



/*
    @Test
    public void TestCase2(){
        logginPage.login("client@localhost.com", "client");
    }

    @Test
    public void TestCase3(){
        logginPage.login("developer@localhost.com", "developer");
    }
*/

    @DataProvider (name = "taskCreationData")
    public Object[][] testDataSupplier() throws Exception {
        Object[][] obj = new Object[excel.getRowCount()][1];
        for (int i = 1; i <= excel.getRowCount(); i++) {
            HashMap<String, String> testData = excel.getTestDataInMap(i);
            obj[i-1][0] = testData;
        }
        return obj;
    }

}
