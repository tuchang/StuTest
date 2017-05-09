package model;

import Test.FileTest;
import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Blank;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;

/**
 * Created by tuchang on 15/04/2017.
 */
public class Roster {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/JDBCTest?useUnicode=true&characterEncoding=utf-8";
    String user = "root";
    String pwd = "fortest";
    String sql = null;
    Connection conn =null;
    Statement st = null;
    ResultSet rs = null;
    Workbook readwb = null;
    InputStream instream = null;
    jxl.write.WritableSheet ws = null;
    public boolean output(int course_id)
    {
        initDatabase();
        String[][] temp_course;
        temp_course = new CourseDatabase().queryCourse(course_id,0);
        String course_name = temp_course[0][1];
        String faculty_name = temp_course[0][3];
        int[] stu_id;
        int numOfStu;
        String stu_name;
        String stu_college;
        String stu_class;
        stu_id = new CourseDatabase().queryStu(course_id);
        numOfStu = stu_id.length;
        String[][] temp_stu;
        try {
            //Mac版本
            //String path ="/Users/tuchang/IdeaProjects/StuTest/RosterArchive/";
            //Windows Path
            String path=Thread.currentThread().getContextClassLoader().getResource("")+"..\\..\\..\\RosterArchive\\名册模板.xls";
            if(path.contains("file:"))
            {
                URL url = FileTest.class.getResource("");
                try {
                    path = new File(url.toURI()).getAbsolutePath()+"/../../../../RosterArchive/";
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            instream = new FileInputStream(path+"名册模板.xls");
            readwb = Workbook.getWorkbook(instream);
            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄
            String xlsName = path + course_id+"-"+course_name+"-"+faculty_name+".xls";
//            System.out.println(xlsName);
            jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(
                    xlsName), readwb);
            //读取第一张工作表
            ws = wwb.getSheet(0);
            jxl.write.WritableCell wc = null;
            Blank blank = null;
            Label label = null;
            wc = ws.getWritableCell(0, 0);
            if (wc.getType() == CellType.LABEL)
            {
                ((Label)wc).setString(course_id+"-"+course_name+"-任课老师:"+faculty_name);
            }
        for (int i=0;i<numOfStu;i++)
        {
            temp_stu = new StuManageDatabase().queryStu(1, String.valueOf(stu_id[i]));
            stu_name = temp_stu[0][0];
            stu_college = temp_stu[0][10];
            stu_class = temp_stu[0][13];
            ws.addCell(new Label(0,i+2,String.valueOf(stu_id[i])));
            ws.addCell(new Label(1,i+2,stu_name));
            ws.addCell(new Label(2,i+2,stu_college));
            ws.addCell(new Label(3,i+2,stu_class));
            wwb.write();
            wwb.close();
            return true;
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
        closeDatabase();
        return false;
    }
    void initDatabase()
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
    void closeDatabase()
    {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//            wc =ws.getWritableCell(0, i+2);
//            label = (Label)wc;
//            blank = (Blank)wc;
//            label.setString(String.valueOf(stu_id[i]));


//            wc =ws.getWritableCell(1, i+2);
//            label = (Label)wc;
//            label.setString();

//            wc =ws.getWritableCell(2, i+2);
//            label = (Label)wc;
//            label.setString(stu_college);

//            wc =ws.getWritableCell(3, i+2);
//            label = (Label)wc;
//            label.setString(stu_class);