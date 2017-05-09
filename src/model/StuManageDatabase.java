package model;

import java.sql.*;
import java.util.Vector;

/**
 * Created by tuchang on 23/02/2017.
 */
public class StuManageDatabase {
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
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String[][] createStu(Vector inputTables)
    {
        init();
        try {
            for(int i=0;i<inputTables.size();i++)
            sql = "insert into student_information values('"
                    + ((Vector) inputTables.get(i)).get(0) +"',"
                    + ((Vector) inputTables.get(i)).get(1) +",'"
                    + ((Vector) inputTables.get(i)).get(2) +"','"
                    + ((Vector) inputTables.get(i)).get(3) +"','"
                    + ((Vector) inputTables.get(i)).get(4) +"','"
                    + ((Vector) inputTables.get(i)).get(5) +"','"
                    + ((Vector) inputTables.get(i)).get(6) +"','"
                    + ((Vector) inputTables.get(i)).get(7) +"',"
                    + ((Vector) inputTables.get(i)).get(8) +",'"
                    + ((Vector) inputTables.get(i)).get(9) +"','"
                    + ((Vector) inputTables.get(i)).get(10) +"',"
                    + ((Vector) inputTables.get(i)).get(11) +"','"
                    + ((Vector) inputTables.get(i)).get(12) +"','"
                    + ((Vector) inputTables.get(i)).get(13) +"','"
                    + ((Vector) inputTables.get(i)).get(14) +"','"
                    + ((Vector) inputTables.get(i)).get(15) +"',"
                    + ((Vector) inputTables.get(i)).get(16) +","
                    + ((Vector) inputTables.get(i)).get(17) +","
                    + ((Vector) inputTables.get(i)).get(18) +",'"
                    + ((Vector) inputTables.get(i)).get(19) +"','"
                    + ((Vector) inputTables.get(i)).get(20) +"');";
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return new String[1][13];
    }
    public String[][] changeStu(Vector inputTables)
    {
        init();
        for (int i=0;i<inputTables.size();i++)
        {
            sql = "update student_information set stu_name='"
                    + ((Vector) inputTables.get(i)).get(0)
                    +"', sex='" + ((Vector) inputTables.get(i)).get(2)
                    +"', birth='" + ((Vector) inputTables.get(i)).get(3)
                    +"', nation='" + ((Vector) inputTables.get(i)).get(4)
                    +"', level='" + ((Vector) inputTables.get(i)).get(5)
                    +"', type='" + ((Vector) inputTables.get(i)).get(6)
                    +"', mode='" + ((Vector) inputTables.get(i)).get(7)
                    +"', phone=" + ((Vector) inputTables.get(i)).get(8)
                    +", email='" + ((Vector) inputTables.get(i)).get(9)
                    +"', college='" + ((Vector) inputTables.get(i)).get(10)
                    +"', school='" + ((Vector) inputTables.get(i)).get(11)
                    +"', major='" + ((Vector) inputTables.get(i)).get(12)
                    +"', class='" + ((Vector) inputTables.get(i)).get(13)
                    +"', identity='" + ((Vector) inputTables.get(i)).get(14)
                    +"', direction='" + ((Vector) inputTables.get(i)).get(15)
                    +"', duration=" + ((Vector) inputTables.get(i)).get(16)
                    +", admission=" + ((Vector) inputTables.get(i)).get(17)
                    +", graduation=" + ((Vector) inputTables.get(i)).get(18)
                    +", status='" + ((Vector) inputTables.get(i)).get(19)
                    +"', notes='" + ((Vector) inputTables.get(i)).get(20)
                    +"' where stu_id="+((Vector) inputTables.get(i)).get(1)+";";
        }
        try {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return new String[0][];
    }
    public String[][] queryStu(int itemType, String queryText)
    {
        init();
        String[][] rss = new String[1][21];
        String type = null;
        switch (itemType)
        {
            case 0: type = "stu_Name";
                queryText = "'"+queryText+"'";
                break;
            case 1: type ="stu_id";
                break;
            case 2: type ="sex";
                queryText = "'"+queryText+"'";
                break;
            case 3: type ="birth";
                queryText = "'"+queryText+"'";
                break;
            case 4: type ="nation";
                queryText = "'"+queryText+"'";
                break;
            case 5: type ="level";
                queryText = "'"+queryText+"'";
                break;
            case 6: type ="type";
                queryText = "'"+queryText+"'";
                break;
            case 7: type ="mode";
                queryText = "'"+queryText+"'";
                break;
            case 8: type ="phone";
                break;
            case 9: type ="email";
                queryText = "'"+queryText+"'";
                break;
            case 10: type ="college";
                queryText = "'"+queryText+"'";
                break;
            case 11: type ="school";
                queryText = "'"+queryText+"'";
                break;
            case 12: type ="major";
                queryText = "'"+queryText+"'";
                break;
            case 13: type ="class";
                queryText = "'"+queryText+"'";
                break;
            case 14: type ="identity";
                queryText = "'"+queryText+"'";
                break;
            case 15: type ="direction";
                queryText = "'"+queryText+"'";
                break;
            case 16: type ="duration";
                break;
            case 17: type ="admission";
                break;
            case 18: type ="graduation";
                break;
            case 19: type ="status";
                queryText = "'"+queryText+"'";
                break;
            case 20: type ="notes";
                queryText = "'"+queryText+"'";
                break;
        }
        sql = "select * from student_information where "+type+"="+queryText+";";
        try {
            rs = st.executeQuery(sql);
            for(int i=0;rs.next();i++)
            {
                rss[i][0]=rs.getString(1);
                rss[i][1]=rs.getString(2);
                rss[i][2]=rs.getString(3);
                rss[i][3]=rs.getString(4);
                rss[i][4]=rs.getString(5);
                rss[i][5]=rs.getString(6);
                rss[i][6]=rs.getString(7);
                rss[i][7]=rs.getString(8);
                rss[i][8]=rs.getString(9);
                rss[i][9]=rs.getString(10);
                rss[i][10]=rs.getString(11);
                rss[i][11]=rs.getString(12);
                rss[i][12]=rs.getString(13);
                rss[i][13]=rs.getString(14);
                rss[i][14]=rs.getString(15);
                rss[i][15]=rs.getString(16);
                rss[i][16]=rs.getString(17);
                rss[i][17]=rs.getString(18);
                rss[i][18]=rs.getString(19);
                rss[i][19]=rs.getString(20);
                rss[i][20]=rs.getString(21);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return rss;
    }
}
