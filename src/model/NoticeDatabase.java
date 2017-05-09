package model;

import java.sql.*;

/**
 * Created by tuchang on 27/02/2017.
 */
public class NoticeDatabase {
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
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String[][] showNotice()
    {
        init();
        String[][] rss = null;
        sql = "select * from notice_table;";
        try {
            rs = st.executeQuery(sql);
            int rowCount=0;
            rs.last();
            rowCount = rs.getRow();
            rs.first();
            rss = new String[rowCount][5];
            for(int i=0;i<rowCount;i++)
            {
                rss[i][0] = rs.getString(1);
                rss[i][1] = rs.getString(2);
                rss[i][2] = rs.getString(3);
                rss[i][3] = rs.getString(4);
                rss[i][4] = rs.getString(5);
                rs.next();//!!
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return rss;
    }
    public void createNotice(String[] input)
    {
        init();
        //!!Windows处理
        input[4]=input[4].replaceAll("\\\\","\\\\\\\\");
        sql = "insert into notice_table values(null,'"
                +input[0]+"','"
                +input[1]+"','"
                +input[2]+"','"
                +input[3]+"','"
                +input[4]+"');";
        try {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }
    public void changeNotice(String[] input,int id)
    {
        init();
        sql = "update notice_table set title='" +input[0]
                    +"',abstract='" +input[1]
                    +"',modify_time='" +input[2]
                    +"' where id="+id+";";
        try {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
    }
    public String watchNotice(int id)
    {
        init();
        sql = "select address from notice_table where id="+id+";";
        try {
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                return rs.getString(1);
            }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return null;
    }
    public int getMaxId()
    {
        init();
        sql="select max(id) from notice_table;";
        try {
            rs = st.executeQuery(sql);
            //System.out.println(rs.next());
            if (rs.next()&&rs.getString(1) != null)
            {
                return Integer.parseInt(rs.getString(1));
            }
            else return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return 0;
    }
    public String getPath(int id)
    {
        init();
        sql="select address from notice_table where id="+id+";";
        try {
            rs = st.executeQuery(sql);
            if (rs.next())
            {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return null;
    }
}
