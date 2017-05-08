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
        {
            sql = "insert into course values(null,'"
                    +((Vector)inputVector.elementAt(i)).elementAt(1)+"',"
                    +((Vector)inputVector.elementAt(i)).elementAt(2)+",'"
                    +((Vector)inputVector.elementAt(i)).elementAt(3)+"','"
                    +((Vector)inputVector.elementAt(i)).elementAt(4)+"','"
                    +((Vector)inputVector.elementAt(i)).elementAt(5)+"',"
                    +((Vector)inputVector.elementAt(i)).elementAt(6)+",'"
                    +((Vector)inputVector.elementAt(i)).elementAt(7)+"');";

        System.out.println(sql);
        try {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        close();
    }

    public void changeCourse(Vector inputVector) {
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
            System.out.println(sql);
            try {
                st.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        close();
    }

    public String[][] queryCourse(int id,int type)
    {
        init();
        String[][] resultCourse =null;
        if(type==1)//教师
        {
            sql = "select * from course where faculty_id="+id+";";


            System.out.println(sql);
            try {
                rs = st.executeQuery(sql);

                int rowCount=0;
                rs.last();
                rowCount = rs.getRow();
                rs.first();
                resultCourse = new String[rowCount][8];
//            System.out.println("行数:"+rowCount);

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
            sql = "select * from course;";
            try {
                rs = st.executeQuery(sql);

                int rowCount=0;
                rs.last();
                rowCount = rs.getRow();
                rs.first();
                resultCourse = new String[rowCount][8];
//            System.out.println("行数:"+rowCount);

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

           /* String[] temp=null;
            sql = "select * from grade where stu_id="+id+";";
            System.out.println(sql);
            try {
                rs = st.executeQuery(sql);
                int rowCount=0;
                rs.last();
                rowCount = rs.getRow();
                rs.first();
                temp = new String[rowCount];
//                System.out.println("行数:"+rowCount);
                for(int i=0;i<rowCount;i++)
                {
                    temp[i] = rs.getString(2);//课程id
                    rs.next();//!!
                }
                resultCourse = new String[rowCount][8];
                for(int i=0;i<rowCount;i++)
                {
                    sql = "select * from course where course_id="+temp[i]+";";
                    System.out.println(i+":"+sql);
                    rs = st.executeQuery(sql);
                    if (rs.first())
                    {
                        resultCourse[i][0] = rs.getString(1);//课程id
                        resultCourse[i][1] = rs.getString(2);//课程名字
                        resultCourse[i][2] = rs.getString(3);//教师id
                        resultCourse[i][3] = rs.getString(4);//教师名称
                        resultCourse[i][4] = rs.getString(5);//时间
                        resultCourse[i][5] = rs.getString(6);//地点
                        resultCourse[i][6] = rs.getString(7);//学期
                        resultCourse[i][7] = rs.getString(8);//描述
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

            }*/
        }

        else if(type == 0)//课程id
        {
            resultCourse = new String[1][8];
            sql = "select * from course where course_id="+id+";";
            System.out.println(sql);
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
                    System.out.println("查询课程id结果为空");
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
        System.out.println(sql);
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
            System.out.println(sql);
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
                }
            }else {
                System.out.println("查询选课学生结果为空");
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
