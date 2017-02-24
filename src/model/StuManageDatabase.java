package model;

import java.sql.*;
import java.util.Vector;

/**
 * Created by tuchang on 23/02/2017.
 */
public class StuManageDatabase {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/JDBCTest";
    String user = "root";
    String pwd = "fortest";

    String sql = null;
    Connection conn =null;
    Statement st = null;
    ResultSet rs = null;



    void init()
    {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void close()
    {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String[][] createStu(Vector inputTables)
    {
        init();

        //try {
            for(int i=0;i<inputTables.size();i++)
            sql = "insert into student_information values("
                    + ((Vector) inputTables.get(i)).get(0) +','
                    + ((Vector) inputTables.get(i)).get(1) +','
                    + ((Vector) inputTables.get(i)).get(2) +','
                    + ((Vector) inputTables.get(i)).get(3) +','
                    + ((Vector) inputTables.get(i)).get(4) +','
                    + ((Vector) inputTables.get(i)).get(5) +','
                    + ((Vector) inputTables.get(i)).get(6) +','
                    + ((Vector) inputTables.get(i)).get(7) +','
                    + ((Vector) inputTables.get(i)).get(8) +','
                    + ((Vector) inputTables.get(i)).get(9) +','
                    + ((Vector) inputTables.get(i)).get(10) +','
                    + ((Vector) inputTables.get(i)).get(11) +','
                    + ((Vector) inputTables.get(i)).get(11)+");";

            //st.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        close();

        return new String[1][13];
    }

    public String[][] changeStu(Vector inputTables)
    {
        init();



        close();
        return new String[0][];
    }

    public String[][] queryStu(int itemType, String queryText)
    {
        init();



        close();
        return new String[0][];
    }
}
