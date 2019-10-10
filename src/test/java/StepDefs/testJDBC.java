package StepDefs;

import Utilities.DBType;
import Utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class testJDBC {
    public static void main(String[]args) throws SQLException {
        DBUtils.establishConnection(DBType.ORACLE);
        System.out.println(DBUtils.countRows("select min(salary)\n" +
                "from (select salary\n" +
                "from (select distinct(salary)\n" +
                "from employees\n" +
                "order by salary desc)\n" +
                "where rownum<=5)"));

        System.out.println(DBUtils.runSQLquery("select min(salary) as salary\n" +
                "from (select salary\n" +
                "from (select distinct(salary)\n" +
                "from employees\n" +
                "order by salary desc)\n" +
                "where rownum<=5)").get(0).get("SALARY"));
        System.out.println(DBUtils.runSQLquery("select last_name, replace(last_name,'e', '***')\n"+
                "from employees"));

        System.out.println(DBUtils.runSQLquery("select first_name," +
                " salary from employees where rownum <5").get(2).get("FIRST_NAME"));

        List<Map<String, Object>> queryResult=DBUtils.runSQLquery("select first_name," +
                " salary from employees where rownum <5");
        System.out.println("-------------------");
        for(int i=0; i<queryResult.size(); i++){
            for(String key: queryResult.get(i).keySet()){
                System.out.print(queryResult.get(i).get(key));
            }
            System.out.println();
        }
    }

}
