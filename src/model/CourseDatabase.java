package model;

import java.sql.*;
import java.util.Vector;

/**
 * Created by tuchang on 27/02/2017.
 */
public class CourseDatabase {
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

    public void createCourse(Vector inputVector)
    {
        init();

        for (int i=0;i<inputVector.size();i++)
            sql = "insert into course values("
                    +((Vector)inputVector.elementAt(i)).elementAt(0)+","
                    +((Vector)inputVector.elementAt(i)).elementAt(1)+","
                    +((Vector)inputVector.elementAt(i)).elementAt(2)+","
                    +((Vector)inputVector.elementAt(i)).elementAt(3)+","
                    +((Vector)inputVector.elementAt(i)).elementAt(4)+","
                    +((Vector)inputVector.elementAt(i)).elementAt(5)+","
                    +((Vector)inputVector.elementAt(i)).elementAt(6)+","
                    +((Vector)inputVector.elementAt(i)).elementAt(7)+");";
        close();
    }

    public void changeCourse(Vector inputVector) {
        init();

        for (int i = 0; i < inputVector.size(); i++)
        {
            sql = "update course set "
                    + ",grade_name=" + ((Vector) inputVector.elementAt(i)).elementAt(1)
                    + ",faculty_id=" + ((Vector) inputVector.elementAt(i)).elementAt(2)
                    + ",faculty_name=" + ((Vector) inputVector.elementAt(i)).elementAt(3)
                    + ",time=" + ((Vector) inputVector.elementAt(i)).elementAt(4)
                    + ",place=" + ((Vector) inputVector.elementAt(i)).elementAt(5)
                    + ",session=" + ((Vector) inputVector.elementAt(i)).elementAt(6)
                    + ",description=" + ((Vector) inputVector.elementAt(i)).elementAt(7)
                    + " where grade_id=" + ((Vector) inputVector.elementAt(i)).elementAt(0) + ";";
            System.out.println(sql);
//            try {
//                st.execute(sql);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }


        close();
    }
}
