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
            System.out.println("init.st:"+st);
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


    public String[][] createStu(Vector inputTables)
    {
        init();
//        System.out.println("hehe.");
        try {
            for(int i=0;i<inputTables.size();i++)
            sql = "insert into student_information values('"
                    + ((Vector) inputTables.get(i)).get(0) +"',"
                    + ((Vector) inputTables.get(i)).get(1) +",'"
                    + ((Vector) inputTables.get(i)).get(2) +"',"
                    + ((Vector) inputTables.get(i)).get(3) +",'"
                    + ((Vector) inputTables.get(i)).get(4) +"','"
                    + ((Vector) inputTables.get(i)).get(5) +"','"
                    + ((Vector) inputTables.get(i)).get(6) +"','"
                    + ((Vector) inputTables.get(i)).get(7) +"','"
                    + ((Vector) inputTables.get(i)).get(8) +"','"
                    + ((Vector) inputTables.get(i)).get(9) +"',"
                    + ((Vector) inputTables.get(i)).get(10) +","
                    + ((Vector) inputTables.get(i)).get(11) +",'"
                    + ((Vector) inputTables.get(i)).get(12) +"');";

            System.out.println(sql);

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
                    + ((Vector) inputTables.get(i)).get(0) +"',set sex='"
                    + ((Vector) inputTables.get(i)).get(2) +"',set phone="
                    + ((Vector) inputTables.get(i)).get(3) +",set email='"
                    + ((Vector) inputTables.get(i)).get(4) +"',set school='"
                    + ((Vector) inputTables.get(i)).get(5) +"',set major='"
                    + ((Vector) inputTables.get(i)).get(6) +"',set class='"
                    + ((Vector) inputTables.get(i)).get(7) +"',set identity='"
                    + ((Vector) inputTables.get(i)).get(8) +"',set direction='"
                    + ((Vector) inputTables.get(i)).get(9) +"',set year="
                    + ((Vector) inputTables.get(i)).get(10) +",set admission="
                    + ((Vector) inputTables.get(i)).get(11) +",set notes='"
                    + ((Vector) inputTables.get(i)).get(12)+"' where stu_id="+((Vector) inputTables.get(i)).get(1)+";";
        }

        System.out.println(sql);
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
        //System.out.println("进入queryStu");
        init();
        System.out.println("st:"+st);

        String[][] rss = new String[1][13];
        //String[][] rss = null;
        String type = null;
        switch (itemType)
        {
            case 0: type = "stu_Name";
                break;
            case 1: type ="stu_id";
                break;
            case 2: type ="sex";
                break;
            case 3: type ="phone";
                break;
            case 4: type ="email";
                break;
            case 5: type ="school";
                break;
            case 6: type ="major";
                break;
            case 7: type ="class";
                break;
            case 8: type ="identity";
                break;
            case 9: type ="direction";
                break;
            case 10: type ="year";
                break;
            case 11: type ="admission";
                break;
            case 12: type ="notes";
                break;
        }

        sql = "select * from student_information where "+type+"='"+queryText+"';";
        //sql = "select * from student_information;";

        //System.out.println(sql);


        try {
            //sql = "select * from student_information where "+type+"='"+queryText+"';";
            System.out.println(sql);
            rs = st.executeQuery(sql);



            //System.out.println("rs.1:"+rs.getString(1));

            for(int i=0;rs.next();i++)
            {
                //System.out.println("rs.0:"+rs.getString(1));
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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(rss);

        close();
        return rss;
    }
}
