package model;

import java.sql.*;
import java.util.Vector;

/**
 * Created by tuchang on 27/02/2017.
 */
public class GradeDatabase {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/JDBCTest?useUnicode=true&characterEncoding=utf-8";
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
            //rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGrade(Vector inputVector)
    {
        init();

        for (int i=0;i<inputVector.size();i++)
        sql = "insert into grade values("
                +((Vector)inputVector.elementAt(i)).elementAt(0)+","
                +((Vector)inputVector.elementAt(i)).elementAt(1)+","
                +((Vector)inputVector.elementAt(i)).elementAt(2)+","
                +((Vector)inputVector.elementAt(i)).elementAt(3)+");";
        close();
    }
}
