package model;

import control.SignInListener;

import java.sql.*;

/**
 * Created by tuchang on 22/02/2017.
 */
public class LoginDatabase {

    public SignInListener.LoginData getLoginData(String username)
    {
         String driver = "com.mysql.jdbc.Driver";
         String url = "jdbc:mysql://localhost:3306/JDBCTest";
         String user = "root";
         String pwd = "fortest";
        //static String sql = "select * from student_information";

         String sql = null;
         Connection conn =null;
         Statement st = null;
         ResultSet rs = null;


        SignInListener.LoginData lg = new SignInListener.LoginData();
        try {

            //SignInListener.LoginData lg = new SignInListener.LoginData();


            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
            st = conn.createStatement();

            sql = "select * from user_table where user_name='"+username+"';";

//            System.out.println(sql);
            rs = st.executeQuery(sql);


//            判断是不是只有一条
            while (rs.next()) {
                lg.setUsr(rs.getString(2));
                lg.setPwd(rs.getString(3));
                lg.setTpye(rs.getString(4));
            }

            rs.close();
            st.close();
            conn.close();

            return lg;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
