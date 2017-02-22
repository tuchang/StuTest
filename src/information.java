//import com.mysql.jdbc.Driver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

/**
 * Created by tuchang on 21/02/2017.
 */
public class information {


    static String text = "heihei";
    static JButton jb1 = new JButton("添加");
    static JButton jb2 = new JButton("修改");
    static JButton jb3 = new JButton("删除");
    static JButton jb4 = new JButton("查询");
    static JTextArea jta = new JTextArea("默认");
//    static Object[][] cellData = {"姓名", "性别", "学号", "手机", "邮箱",
//            "学院", "专业", "班级", "身份证", "培养方向", "入学年份", "学制", "备注"};
    static  Object[][] cellData = new Object[1][13];
    static String[] tableColumnName = {"姓名","学号", "性别", "手机", "邮箱",
            "学院", "专业", "班级", "身份证", "培养方向", "学制", "入学年份", "备注"};
    //static JTable jt = new JTable(cellData,tableColumnName);
    static DefaultTableModel dtm = new DefaultTableModel(cellData,tableColumnName);
    static JTable jt = new JTable(dtm);



    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/JDBCTest";
    static String user = "root";
    static String pwd = "fortest";
    //static String sql = "select * from student_information";
    static String sql = null;
    static Connection conn =null;
    static Statement st = null;
    static ResultSet rs = null;

    static String rss = null;


    private static String name;
    private static String stu_id;
    private static String gender;
    private static String phone;
    private static String email;
    private static String school;
    private static String major;
    private static String stu_class;
    private static String id;
    private static String direction;
    private static String year;
    private static String admission;
    private static String notes;

    public static void main(String[] args)
    {


        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(jb4);
        jf.add(Box.createHorizontalStrut(1000)); //换行
        jf.add(jta);
        jf.add(Box.createHorizontalStrut(1000)); //换行
        jf.add(jt.getTableHeader());
        jf.add(Box.createHorizontalStrut(1000)); //换行
        jf.add(jt);
        jf.setSize(1000,600);
        jf.setVisible(true);



        jb1.addActionListener(new AddButtonListener());
        jb4.addActionListener(new SelectButtonListener());

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                System.exit(0);
            }
        });
    }


    static void printTable()
    {


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
            st = conn.createStatement();

            sql = "select * from student_information";

            rs = st.executeQuery(sql);

            //System.out.println(rs.toString());
            rss = "";
            for (int i = 0; rs.next();i++)
            {
//            rss=rs.getString(1)+' '
//            +rs.getString(2)+' '
//            +rs.getString(3)+' '
//            +rs.getString(4)+' '
//            +rs.getString(5)+' '
//            +rs.getString(6)+' '
//            +rs.getString(7)+' '
//            +rs.getString(8)+' '
//            +rs.getString(9)+' '
//            +rs.getString(10)+' '
//            +rs.getString(11)+' '
//            +rs.getString(12);
//
//

                dtm.setValueAt(rs.getString(1), i, 0);
                dtm.setValueAt(rs.getString(2), i, 1);
                dtm.setValueAt(rs.getString(3), i, 2);
                dtm.setValueAt(rs.getString(4), i, 3);
                dtm.setValueAt(rs.getString(5), i, 4);
                dtm.setValueAt(rs.getString(6), i, 5);
                dtm.setValueAt(rs.getString(7), i, 6);
                dtm.setValueAt(rs.getString(8), i, 7);
                dtm.setValueAt(rs.getString(9), i, 8);
                dtm.setValueAt(rs.getString(10), i, 9);
                dtm.setValueAt(rs.getString(11), i, 10);
                dtm.setValueAt(rs.getString(12), i, 11);
                dtm.setValueAt(rs.getString(13), i, 12);

            }
//            Member m = new Member();
//
//            m.setName(rs.getString(1));
//            m.setStu_id(rs.getString(2));
//            m.setGender(rs.getString(3));
//            m.setPhone(rs.getString(4));
//            m.setEmail(rs.getString(5));
//            m.setSchool (rs.getString(6));
//            m.setMajor( rs.getString(7));
//            m.setStu_class(rs.getString(8));
//            m.setId( rs.getString(9));
//            m.setDirection(rs.getString(10));
//            m.setYear(rs.getString(11));
//            m.setAdmission(rs.getString(12));
//            m.setNotes(rs.getString(13));

//            dtm.setValueAt(rs.getString(1),0,0);
//            dtm.setValueAt(rs.getString(2),0,1);
//            dtm.setValueAt(rs.getString(3),0,2);
//            dtm.setValueAt(rs.getString(4),0,3);
//            dtm.setValueAt(rs.getString(5),0,4);
//            dtm.setValueAt(rs.getString(6),0,5);
//            dtm.setValueAt(rs.getString(7),0,6);
//            dtm.setValueAt(rs.getString(8),0,7);
//            dtm.setValueAt(rs.getString(9),0,8);
//            dtm.setValueAt(rs.getString(10),0,9);
//            dtm.setValueAt(rs.getString(11),0,10);
//            dtm.setValueAt(rs.getString(12),0,11);
//            dtm.setValueAt(rs.getString(13),0,12);


            rs.close();
            st.close();
            conn.close();

            //return m;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return null;
    }

    static void write(Member input)
    {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();


            name = input.getName();
            stu_id = input.getStu_id();
            gender = input.getGender();
            phone = input.getPhone();
            email = input.getEmail();
            school = input.getSchool();
            major = input.getMajor();
            stu_class = input.getStu_class();
            id = input.getId();
            direction = input.getDirection();
            year = input.getYear();
            admission = input.getAdmission();
            notes = input.getNotes();

            sql = "insert into student_information values('"
                    +name+"','"
                    +stu_id+"','"
                    +gender+","
                    +phone+",'"
                    +email+"','"
                    +school+"','"
                    +major+"','"
                    +stu_class+"','"
                    +id+"','"
                    +direction+"','"
                    +year+","
                    +admission+"','"
                    +notes
                    +")"+";";

            //!!!邮箱需要转义 字符串需要添加/' /'
            //rs = st.executeQuery(sql);
            System.out.println(sql);
            //st.execute(sql);


            //rs.close();
            st.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static class AddButtonListener implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            //jta.setText(text);
            write(getMember());

        }
    }

    private static class SelectButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            //jta.setText(getTest());
            //
            printTable();

        }
    }

    //private static class Add


    private static Member getMember()
    {
        Member m = new Member();
        //DefaultTableModel dtm = (DefaultTableModel)jt.getModel();

        //dtm.getRowCount();



        m.setName((String)dtm.getValueAt(0, 0));// 取得第i行第一列的数据
        m.setStu_id((String)dtm.getValueAt(0, 1));// 取得第i行第二列的数据
        m.setGender((String)dtm.getValueAt(0, 2));// 取得第i行第三列的数据
        m.setPhone((String)dtm.getValueAt(0, 3));
        m.setEmail((String)dtm.getValueAt(0, 4));
        m.setSchool((String)dtm.getValueAt(0, 5));
        m.setMajor((String)dtm.getValueAt(0, 6));
        m.setStu_class((String)dtm.getValueAt(0, 7));
        m.setId((String)dtm.getValueAt(0, 8));
        m.setDirection((String)dtm.getValueAt(0, 9));
        m.setAdmission((String)dtm.getValueAt(0, 10));
        m.setYear((String)dtm.getValueAt(0, 11));
        m.setNotes((String)dtm.getValueAt(0, 12));

        return m;
    }
    private static class Member
    {
        private static String name;
        private static String stu_id;
        private static String gender;
        private static String phone;
        private static String email;
        private static String school;
        private static String major;
        private static String stu_class;
        private static String id;
        private static String direction;
        private static String notes;
        private static String year;
        private static String admission;

        public static String getName() {
            return name;
        }

        public static String getStu_id() {
            return stu_id;
        }

        public static String getGender() {
            return gender;
        }

        public static String getPhone() {
            return phone;
        }

        public static String getEmail() {
            return email;
        }

        public static String getSchool() {
            return school;
        }

        public static String getMajor() {
            return major;
        }

        public static String getStu_class() {
            return stu_class;
        }

        public static String getId() {
            return id;
        }

        public static String getDirection() {
            return direction;
        }

        public static String getNotes() {
            return notes;
        }

        public static String getYear() {
            return year;
        }

        public static String getAdmission() {
            return admission;
        }

        public static void setName(String name) {
            Member.name = name;
        }

        public static void setStu_id(String stu_id) {
            Member.stu_id = stu_id;
        }

        public static void setGender(String gender) {
            Member.gender = gender;
        }

        public static void setPhone(String phone) {
            Member.phone = phone;
        }

        public static void setEmail(String email) {
            Member.email = email;
        }

        public static void setSchool(String school) {
            Member.school = school;
        }

        public static void setMajor(String major) {
            Member.major = major;
        }

        public static void setStu_class(String stu_class) {
            Member.stu_class = stu_class;
        }

        public static void setId(String id) {
            Member.id = id;
        }

        public static void setDirection(String direction) {
            Member.direction = direction;
        }

        public static void setNotes(String notes) {
            Member.notes = notes;
        }

        public static void setYear(String year) {
            Member.year = year;
        }

        public static void setAdmission(String admission) {
            Member.admission = admission;
        }
    }



}
