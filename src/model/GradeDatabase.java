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
        //!!
        if(((String)((Vector) inputVector.elementAt(0)).elementAt(1)).isEmpty()
                ||((String)((Vector) inputVector.elementAt(0)).elementAt(1))==null||((String)((Vector) inputVector.elementAt(0)).elementAt(1)).equals("null"))
        {
            init();

            for (int i = 0; i < inputVector.size(); i++) {
                //当已存在时插入变修改
                //成绩id应该不用手动输入
                sql = "insert into grade (course_id,stu_id,grade_value) values(null,"
                        + ((Vector) inputVector.elementAt(i)).elementAt(1) + ","
                        + ((Vector) inputVector.elementAt(i)).elementAt(2) + ","
                        + ((Vector) inputVector.elementAt(i)).elementAt(3) + ");";
                System.out.println(sql);
                try {
                    st.execute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finally {
                    close();
                }
            }

        }
        else updateGrade(inputVector);


    }

    public void updateGrade(Vector inputVector)
    {
        init();

        for (int i=0;i<inputVector.size();i++)
        {
            //当已存在时插入变修改
//            sql = "update grade set grade_value ="
//                    +((Vector)inputVector.elementAt(i)).elementAt(3)
//                    +" where grade_id ="+((Vector)inputVector.elementAt(i)).elementAt(0)
//                    +"AND course_id ="+((Vector)inputVector.elementAt(i)).elementAt(1)
//                    +"AND stu_id ="+((Vector)inputVector.elementAt(i)).elementAt(2)
//                    +";";
            sql = "update grade set grade_value ="
                    +((Vector)inputVector.elementAt(i)).elementAt(3)
                    +" where course_id ="+((Vector)inputVector.elementAt(i)).elementAt(1)
                    +" AND stu_id ="+((Vector)inputVector.elementAt(i)).elementAt(2)
                    +";";
            System.out.println(sql);
            try {
                st.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        close();
    }

    public String[][] getGrade(int id)
    {
        init();
        String[][] rss = null;
        sql = "select * from grade where stu_id = "+id+";";

        System.out.println(sql);
        try {
            rs = st.executeQuery(sql);
            int rowCount=0;
            rs.last();
            rowCount = rs.getRow();
            rs.first();
            rss = new String[rowCount][3];
//            System.out.println("行数:"rowCount);

            for(int i=0;i<rowCount;i++)
            {
                rss[i][0] = rs.getString(1);//成绩id
                rss[i][1] = rs.getString(2);//课程id
                rss[i][2] = rs.getString(4);//成绩
//                System.out.println("i.id:"i+"."+rss[i][0]);
                rs.next();//!!
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }


        close();
        return rss;
    }
}
