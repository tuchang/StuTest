package model;

import javax.swing.*;
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
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean createCourse(Vector inputVector)
    {
        boolean b=false;
        init();

        for (int i=0;i<inputVector.size();i++)
        {
            sql = "insert into course values(null,'"
                    +((Vector)inputVector.elementAt(i)).elementAt(1)+"',"
                    +((Vector)inputVector.elementAt(i)).elementAt(2)+",'"
                    +((Vector)inputVector.elementAt(i)).elementAt(3)+"','"
                    +((Vector)inputVector.elementAt(i)).elementAt(4)+"','"
                    +((Vector)inputVector.elementAt(i)).elementAt(5)+"',"
                    +((Vector)inputVector.elementAt(i)).elementAt(6)+",'"
                    +((Vector)inputVector.elementAt(i)).elementAt(7)+"');";
            try {
                st.execute(sql);
                b=true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
        return b;
    }
    public boolean changeCourse(Vector inputVector) {
        boolean b= false;
        init();
        for (int i = 0; i < inputVector.size(); i++)
        {
            sql = "update course set "
                    + "course_name='" + ((Vector) inputVector.elementAt(i)).elementAt(1)
                    + "',faculty_id=" + ((Vector) inputVector.elementAt(i)).elementAt(2)
                    + ",faculty_name='" + ((Vector) inputVector.elementAt(i)).elementAt(3)
                    + "',time='" + ((Vector) inputVector.elementAt(i)).elementAt(4)
                    + "',place='" + ((Vector) inputVector.elementAt(i)).elementAt(5)
                    + "',session=" + ((Vector) inputVector.elementAt(i)).elementAt(6)
                    + ",description='" + ((Vector) inputVector.elementAt(i)).elementAt(7)
                    + "' where course_id=" + ((Vector) inputVector.elementAt(i)).elementAt(0) + ";";
            try {
                st.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                return b;
            }
        }
        b=true;
        close();
        return b;
    }
    public String[][] queryCourse(int id,int type)
    {
        init();
        String[][] resultCourse =null;
        if(type==1)//教师
        {
            sql = "select * from course where faculty_id="+id+";";
            try {
                rs = st.executeQuery(sql);
                int rowCount=0;
                rs.last();
                rowCount = rs.getRow();
                rs.first();
                resultCourse = new String[rowCount][8];
                for(int i=0;i<rowCount;i++)
                {
                    resultCourse[i][0] = rs.getString(1);//课程id
                    resultCourse[i][1] = rs.getString(2);//课程名字
                    resultCourse[i][2] = rs.getString(3);//教师id
                    resultCourse[i][3] = rs.getString(4);//教师名称
                    resultCourse[i][4] = rs.getString(5);//时间
                    resultCourse[i][5] = rs.getString(6);//地点
                    resultCourse[i][6] = rs.getString(7);//学期
                    resultCourse[i][7] = rs.getString(8);//描述
                    rs.next();//!!
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(type==2)//学生
        {
            String temp[][];
            try
            {
                sql = "select course_id from grade where stu_id="+id+";";
                rs=st.executeQuery(sql);
                if(rs.next())
                {
                    int rowCount=0;
                    rs.last();
                    rowCount = rs.getRow();
                    rs.first();
                    resultCourse = new String[rowCount][8];
                    for (int i =0;i<rowCount;i++)
                    {
                        resultCourse[i][0] = rs.getString(1);
                        rs.next();
                    }
                    for (int i =0;i<rowCount;i++)
                    {
                        temp = queryCourse(Integer.parseInt(resultCourse[i][0]),0);
                        //resultCourse[i][0] = temp[i][0];//课程id
                        resultCourse[i][1] = temp[i][1];//课程名字
                        resultCourse[i][2] = temp[i][2];//教师id
                        resultCourse[i][3] = temp[i][3];//教师名称
                        resultCourse[i][4] = temp[i][4];//时间
                        resultCourse[i][5] = temp[i][5];//地点
                        resultCourse[i][6] = temp[i][6];//学期
                        resultCourse[i][7] = temp[i][7];//描述
                    }

                }else {
                    JOptionPane.showMessageDialog(new JFrame(), "查询选课学生结果为空", "提示", JOptionPane.WARNING_MESSAGE);
                    return null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }

            sql = "select * from course WHERE stu_id = ;";
            try {
                rs = st.executeQuery(sql);
                int rowCount=0;
                rs.last();
                rowCount = rs.getRow();
                rs.first();
                resultCourse = new String[rowCount][8];
                for(int i=0;i<rowCount;i++)
                {
                    resultCourse[i][0] = rs.getString(1);//课程id
                    resultCourse[i][1] = rs.getString(2);//课程名字
                    resultCourse[i][2] = rs.getString(3);//教师id
                    resultCourse[i][3] = rs.getString(4);//教师名称
                    resultCourse[i][4] = rs.getString(5);//时间
                    resultCourse[i][5] = rs.getString(6);//地点
                    resultCourse[i][6] = rs.getString(7);//学期
                    resultCourse[i][7] = rs.getString(8);//描述
                    rs.next();//!!
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(type == 0)//课程id
        {
            resultCourse = new String[1][8];
            sql = "select * from course where course_id="+id+";";
            try {
                rs = st.executeQuery(sql);
                if (rs.next())
                {
                    resultCourse[0][0] = rs.getString(1);//课程id
                    resultCourse[0][1] = rs.getString(2);//课程名字
                    resultCourse[0][2] = rs.getString(3);//教师id
                    resultCourse[0][3] = rs.getString(4);//教师名称
                    resultCourse[0][4] = rs.getString(5);//时间
                    resultCourse[0][5] = rs.getString(6);//地点
                    resultCourse[0][6] = rs.getString(7);//学期
                    resultCourse[0][7] = rs.getString(8);//描述
                }else{
                    JOptionPane.showMessageDialog(new JFrame(), "查询课程id结果为空", "提示", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            close();
        return resultCourse;
    }
    public boolean addCourse(int stu_id,int course_id)
    {
        init();
            sql = "insert into grade values(null,"+course_id
                    +","+stu_id
                    +",null);";
        try {
            st.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            close();
        }
    }
    public int[] queryStu(int course_id)
    {
        init();
        int[] stu_id = null;
        try
        {
            sql = "select stu_id from grade where course_id="+course_id+";";
            rs=st.executeQuery(sql);
            if(rs.next())
            {
                int rowCount=0;
                rs.last();
                rowCount = rs.getRow();
                rs.first();
                stu_id = new int[rowCount];
                for (int i =0;i<rowCount;i++)
                {
                    stu_id[i] = Integer.parseInt(rs.getString(1));
                    rs.next();
                }
            }else {
                JOptionPane.showMessageDialog(new JFrame(), "查询选课学生结果为空", "提示", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return stu_id;
    }
}
