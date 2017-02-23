package model;

import java.sql.*;

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

    String rss = null;

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


    public String[][] createStu()
    {
        init();




        close();

        return new String[0][];
    }

    public String[][] changeStu()
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
