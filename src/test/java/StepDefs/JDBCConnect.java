package StepDefs;

import Utilities.Configuration;

import java.sql.*;

public class JDBCConnect {
    public static void main (String []args) throws SQLException {
        //connection
        //statement
        //resultset

        Connection connection= DriverManager.getConnection(Configuration.getProperty("DBURL"),
                Configuration.getProperty("DBUsername"),
                Configuration.getProperty("DBPassword"));
        Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.
                CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from employees");
//        resultSet.last();
//        System.out.println(resultSet.getRow());

//        while (resultSet.next()){
//            System.out.println(resultSet.getString("first_name")+resultSet.getString("salary"));
//        }

        ResultSetMetaData rsMetaData=resultSet.getMetaData();
        System.out.println(rsMetaData.getColumnCount());
        System.out.println(rsMetaData.getColumnName(1));

        for(int i=1; i<=rsMetaData.getColumnCount();i++){
            System.out.println(rsMetaData.getColumnName(i));
        }
        while(resultSet.next()){
            for(int i=1; i<=rsMetaData.getColumnCount();i++){
                System.out.print(resultSet.getString(rsMetaData.getColumnName(i))+" ");
            }
            System.out.println();
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
