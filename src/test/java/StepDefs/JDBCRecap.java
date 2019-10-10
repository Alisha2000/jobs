package StepDefs;

import Utilities.Configuration;
import Utilities.DBType;
import Utilities.DBUtils;

import java.sql.*;
import java.util.TimeZone;

public class JDBCRecap {
    public static void main(String[] args) throws SQLException {
        ResultSet set;
        Connection connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exampleDBciw1z?serverTimezone="+ TimeZone.getDefault().getID(),
                "exampleDBciw1z","E8dSMPMrp");
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
//        set=statement.executeQuery("select * from wp_posts");
//
//        while (set.next()){
//            if(Integer.valueOf(set.getString("id"))>=1&&Integer.valueOf(set.getString("id"))<=7);
//            System.out.println(set.getString("id")+set.getString("post_title")+
//                    ""+set.getString("post_content"));
//        }
//        DBUtils.establishConnection(DBType.MySQL);
//        System.out.println(DBUtils.runSQLquery("select * from wp_posts"));

    }
}
