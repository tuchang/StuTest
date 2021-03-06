package model;

import java.sql.*;
import java.util.Vector;

/**
 * Created by tuchang on 24/02/2017.
 */
public class UserDatabase {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/JDBCTest?useUnicode=true&characterEncoding=utf-8";
    String user = "root";
    String pwd = "fortest";
    String sql = null;
    Connection conn =null;
    Statement st = null;
    ResultSet rs = null;
    int type ;
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
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createUser(Vector inputTable)
    {
        init();
        for(int i=0;i<inputTable.size();i++)
        {
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("系统管理员"))
                type = 0;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("教务管理员"))
                type = 3;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("学院管理员"))
                type = 4;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("教师"))
                type = 1;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("学生"))
                type = 2;
            sql = "insert into user_table values(null,'"
                    +((Vector)inputTable.elementAt(i)).elementAt(0)+"','"
                    +((Vector)inputTable.elementAt(i)).elementAt(1)+"',"
                    +type+");";
            try {
                st.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
    public void changeUser(Vector inputTable)
    {
        init();

        for (int i=0;i<inputTable.size();i++)
        {
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("系统管理员"))
                type = 0;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("教务管理员"))
                type = 3;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("学院管理员"))
                type = 4;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("教师"))
                type = 1;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("学生"))
                type = 2;

            sql = "update user_table set user_pwd='"
                    +((Vector)inputTable.elementAt(i)).elementAt(1)
                    + "',"
                    + "user_type="+type
                    + " where user_name ='"+((Vector)inputTable.elementAt(i)).elementAt(0)+"';";
        }
        try {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }
    public void closeUser(Vector inputTable)
    {
        System.out.println("暂未实现，敬请期待");
        //将条目从系统用户数据库转入注销账户数据库
    }

    //彻底删除用户
    public boolean deleteUser(Vector inputTable)
    {
        boolean b=false;
        init();
        for (int i=0;i<inputTable.size();i++)
        {
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("系统管理员"))
                type = 0;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("教务管理员"))
                type = 3;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("学院管理员"))
                type = 4;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("教师"))
                type = 1;
            if((((Vector)inputTable.elementAt(i)).elementAt(2)).equals("学生"))
                type = 2;

            sql = "DELETE FROM user_table WHERE user_pwd='"
                    +((Vector)inputTable.elementAt(i)).elementAt(1) + "'and"
                    + " user_type="+type
                    + " and user_name ='"+((Vector)inputTable.elementAt(i)).elementAt(0)+"';";
        }
        try {
            //System.out.println(sql);
            st.execute(sql);
            b=true;
        } catch (SQLException e) {
            e.printStackTrace();
            return b;
        }
        close();
        return b;
    }
}
