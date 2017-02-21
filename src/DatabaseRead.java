//import com.mysql.jdbc.Driver;

//import com.mysql.jdbc.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by tuchang on 20/02/2017.
 */
public class DatabaseRead
{
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/JDBCTest";
    static String user = "root";
    static String pwd = "fortest";
    //static String sql = "select * from student_information";
    static String sql = null;

    static Connection conn =null;
    static Statement st = null;
    static ResultSet rs = null;

    private void init()
    {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next())
            {
                System.out.println(rs.toString());
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args)
    {
        new DatabaseRead().init();
    }


}
