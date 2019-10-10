package StepDefs;

import Pages.MyAppPage;
import Utilities.Configuration;
import Utilities.DBType;
import Utilities.DBUtils;
import Utilities.Driver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAppSteps {
    WebDriver driver= Driver.getDriver();
    MyAppPage myAppPage=new MyAppPage();
    static List<Map<String,Object>> UIListOfMaps;

    @Given("^User navigates to My Application homepage$")
    public void user_navigates_to_My_Application_homepage() throws Throwable {
        driver.get(Configuration.getProperty("MyApplicationURL"));


    }

    @Given("^User gets the data from UI table$")
    public void user_gets_the_data_from_UI_table() throws Throwable {
        UIListOfMaps=new ArrayList<Map<String, Object>>();
        Map<String, Object> UIMap1=new HashMap<String, Object>();


        for(int i=0; i< myAppPage.columnNames.size(); i++){
            UIMap1.put(myAppPage.columnNames.get(i).getText(), myAppPage.FirstRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap1);
        System.out.println(UIListOfMaps.get(0).get("Employee ID"));

        Map<String, Object> UIMap2=new HashMap<String, Object>();
        for(int i=0; i< myAppPage.columnNames.size(); i++){
            UIMap2.put(myAppPage.columnNames.get(i).getText(), myAppPage.SecondRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap2);
        System.out.println(UIListOfMaps.get(0).get("Employee ID"));

        Map<String, Object> UIMap3=new HashMap<String, Object>();
        for(int i=0; i< myAppPage.columnNames.size(); i++){
            UIMap3.put(myAppPage.columnNames.get(i).getText(), myAppPage.ThirdRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap3);

        Map<String, Object> UIMap4=new HashMap<String, Object>();
        for(int i=0; i< myAppPage.columnNames.size(); i++){
            UIMap4.put(myAppPage.columnNames.get(i).getText(), myAppPage.FourthRowData.get(i).getText());
        }
        UIListOfMaps.add(UIMap4);

    }

    @Then("^verify UI data is matched with DB$")
    public void verify_UI_data_is_matched_with_DB() throws Throwable {
        DBUtils.establishConnection(DBType.ORACLE);

        System.out.println(UIListOfMaps);

        for(WebElement element: myAppPage.columnNames){
            System.out.println(element.getText());
            System.out.println(UIListOfMaps.get(0).get("Employee ID"));
        }

        for (int i = 0; i < UIListOfMaps.size(); i++) {
            String query = "select e.first_name, e.last_name, e.employee_id, j.job_title \n" +
                    "from employees e join jobs j \n" +
                    "using(job_id)\n" +
                    "where employee_id="+UIListOfMaps.get(i).get("Employee ID");

            List<Map<String, Object>> DBListOfMaps = DBUtils.runSQLquery(query);

            for(int i2=0; i2< DBListOfMaps.get(0).size(); i2++){
                Assert.assertEquals(DBListOfMaps.get(0).get(DBUtils.getColumnNames().get(i2)).toString(),
                        UIListOfMaps.get(i).get(myAppPage.columnNames.get(i2).getText()).toString());
            }

        }

    }
}