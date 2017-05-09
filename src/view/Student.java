package view;

import control.CourseListener;
import control.NoticeControl;
import control.StuManagerListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by tuchang on 23/02/2017.
 */
public class Student {


    JFrame stuWindow = new JFrame("学生界面");
    JButton queryStuButton = new JButton("查询个人信息");
    JButton queryCourseButton = new JButton("查询课程");
    JButton queryGradeButton = new JButton("查询成绩");
    JButton watchNotice = new JButton("查看公告");
    JButton addCourse = new JButton("选课");

    String[] stuTitles = {"姓名", "学号", "性别", "手机", "邮箱",
            "学院", "专业", "班级", "身份证", "培养方向", "学制", "入学年份", "备注"};
    String[] courseTitles = {"课程编号","课程名称","教师编号","教师名称","上课时间","上课地点","学期代号","课程描述"};
    String[] gradeTitles = {"成绩编号","课程编号","学生ID","成绩"};
    String[] noticeTitles = {"公告编号","标题","摘要","修改时间","创建时间"};
    String[] addCourseTitle = {"课程编号"};
    DefaultTableModel studentTableModel = new DefaultTableModel();
    JTable studentWindowTable = new JTable(studentTableModel);
    JPanel jp = new JPanel(new BorderLayout());
    JScrollPane jScrollPane = new JScrollPane(studentWindowTable);


    JButton confirm = new JButton("确认");
    int flag = -1;

    JLabel subtitle = new JLabel();

    JPanel jp2 = new JPanel(new BorderLayout());
    JTextField title = new JTextField();
    JTextArea content = new JTextArea(20,30);
    JScrollPane jScrollPane2 = new JScrollPane(content);

    public void view(int id)
    {
        studentWindowTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane2.setSize(content.getSize());
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        stuWindow.setLayout(new FlowLayout());
        stuWindow.add(queryStuButton);
        stuWindow.add(queryCourseButton);
        stuWindow.add(queryGradeButton);
        stuWindow.add(watchNotice);
        stuWindow.add(addCourse);
        stuWindow.add(Box.createHorizontalStrut(10000));
        stuWindow.add(subtitle);
        stuWindow.add(Box.createHorizontalStrut(10000));
        stuWindow.add(jp);

        stuWindow.setVisible(true);
        stuWindow.setSize(1000,560);

        jp.add(studentWindowTable.getTableHeader(),BorderLayout.NORTH);
        jp.add(jScrollPane);
//        jp.add(studentWindowTable);
        jp.add(confirm,BorderLayout.SOUTH);

        jp2.add(title,BorderLayout.NORTH);
//        jp2.add(content);
        jp2.add(jScrollPane2);
        jp2.add(confirm,BorderLayout.SOUTH);

        queryStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(975,jScrollPane.getHeight());
                jp.setPreferredSize(new Dimension(975,jp.getHeight()));

                stuWindow.remove(jp2);
                stuWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);

                flag = 0;
                studentTableModel.setDataVector(new Object[1][13],stuTitles);

                stuWindow.repaint();
                stuWindow.validate();


            }
        });

        queryCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(975,jScrollPane.getHeight());
                jp.setPreferredSize(new Dimension(975,jp.getHeight()));

                stuWindow.remove(jp2);
                stuWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);


                flag = 1;
                studentTableModel.setDataVector(new Object[1][8],courseTitles);

                stuWindow.repaint();
                stuWindow.validate();
            }
        });


        queryGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(975,jScrollPane.getHeight());
                jp.setPreferredSize(new Dimension(975,jp.getHeight()));

                stuWindow.remove(jp2);
                stuWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);

                flag = 2;
                studentTableModel.setDataVector(new Object[1][4],gradeTitles);

                stuWindow.repaint();
                stuWindow.validate();
            }
        });

        watchNotice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(975,jScrollPane.getHeight());
                jp.setPreferredSize(new Dimension(975,jp.getHeight()));

                stuWindow.remove(jp2);
                stuWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);

                flag = 3;
                studentTableModel.setDataVector(new Object[1][5],noticeTitles);



                studentTableModel.setDataVector(new NoticeControl().showNotice(),noticeTitles);


                stuWindow.repaint();
                stuWindow.validate();


            }
        });

        //选课
        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(975,jScrollPane.getHeight());
                jp.setPreferredSize(new Dimension(975,jp.getHeight()));

                stuWindow.remove(jp2);
                stuWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);

                flag = 4;
                studentTableModel.setDataVector(new Object[1][1],addCourseTitle);

                stuWindow.repaint();
                stuWindow.validate();
            }
        });


        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(stuWindow.getSize());
//                System.out.println(jScrollPane.getSize());
//                System.out.println(jp.getSize());
                switch (flag)
                {
                    case 0:
                        studentTableModel.setDataVector(
                            new StuManagerListener().control(2,1,String.valueOf(id),studentTableModel.getDataVector())
                            ,stuTitles);

                        break;
                    case 1:
//                        System.out.println("暂未实现");
                        studentTableModel.setDataVector(new CourseListener().queryCourse(id,2),courseTitles);




                        break;
                    case 2:
                        studentTableModel.setDataVector(new CourseListener().getGrade(id),gradeTitles);
                        break;
                    case 3:
                        stuWindow.remove(jp);
                        stuWindow.add(jp2);
                        jp2.add(confirm,BorderLayout.SOUTH);
                        title.setText((String) studentTableModel.getValueAt(studentWindowTable.getSelectedRow(),1));
                        content.setText(new NoticeControl().watchNotice(Integer.valueOf(String.valueOf(studentTableModel.getValueAt(studentWindowTable.getSelectedRow(),0)))));
//                        System.out.println(studentTableModel.getValueAt(studentWindowTable.getSelectedRow(),0));
                        stuWindow.repaint();
                        stuWindow.validate();
                        break;

                    case 4:
                        try{
                            if(new CourseListener().addCourse(id,Integer.valueOf((String) studentTableModel.getValueAt(0,0))))
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "选课成功", "提示", JOptionPane.WARNING_MESSAGE);
                            }
                            else{
                                JOptionPane.showMessageDialog(new JFrame(), "选课失败，输入必须是数字，查看公告获取选课代码。", "提示", JOptionPane.WARNING_MESSAGE);//输入必须是数字 查看公告获取选课代码
                            }
                        }catch (Exception e2){
                            JOptionPane.showMessageDialog(new JFrame(), "选课失败，输入必须是数字，查看公告获取选课代码。", "提示", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                }
            }
        });


        stuWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stuWindow.dispose();
                Login.loginWindow.setVisible(true);
            }
        });
    }
}
