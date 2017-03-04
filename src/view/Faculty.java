package view;

import control.FacultyListener;

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
public class Faculty {
    JFrame facultyWindow = new JFrame("教师界面");
    JButton queryStuButton = new JButton("查询学生信息");
    JButton course = new JButton("查询课程/导出名册");
    JButton watchNotice = new JButton("查看公告");


    String[] courseTitles = {"课程编号","课程名称","教师编号","教师名称","上课时间","上课地点","学期代号","课程描述"};
    String[] noticeTitles = {"公告编号","标题","摘要","修改时间","创建时间"};

    DefaultTableModel facultyTableModel = new DefaultTableModel();
    JTable facultyWindowTable = new JTable(facultyTableModel);
    JPanel jp = new JPanel();
    JLabel subheading = new JLabel();
    JButton confirm = new JButton("确认");



    String[] stuTitles = {"姓名", "学号", "性别", "手机", "邮箱",
            "学院", "专业", "班级", "身份证", "培养方向", "学制", "入学年份", "备注"};
    JComboBox queryItem = new JComboBox(stuTitles);
    JTextField queryField = new JTextField("请输入查询文本");

    JButton export = new JButton("导出名册");


    int flag = -1;

    public void view(int id)
    {
        facultyWindow.setLayout(new FlowLayout());
        facultyWindow.add(queryStuButton);
        facultyWindow.add(course);
        facultyWindow.add(watchNotice);
        //jp.setLayout(new FlowLayout());
        jp.setLayout(new BorderLayout());
        facultyWindow.setVisible(true);
        facultyWindow.setSize(1000,800);
        facultyWindow.add(Box.createHorizontalStrut(1000));
        //facultyWindow.add(jp);
        facultyWindow.add(subheading);
        facultyWindow.add(Box.createHorizontalStrut(1000));


        jp.add(facultyWindowTable.getTableHeader(),BorderLayout.NORTH);
        jp.add(facultyWindowTable);
        jp.add(confirm,BorderLayout.SOUTH);





        queryStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
                subheading.setText("查询学生信息");
                facultyTableModel.setDataVector(new Object[1][13],stuTitles);



                facultyWindow.remove(jp);
                jp.remove(export);
                facultyWindow.add(queryItem);
                facultyWindow.add(queryField);
                facultyWindow.add(jp);


                facultyWindow.repaint();
                facultyWindow.validate();




            }
        });

        course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                facultyTableModel.setDataVector(new Object[1][8],courseTitles);
                flag = 1;
                subheading.setText("查询课程/导出名册");
                facultyWindow.remove(queryItem);
                facultyWindow.remove(queryField);
                jp.add(export,BorderLayout.EAST);

                facultyWindow.repaint();
                facultyWindow.validate();
            }
        });


        watchNotice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facultyTableModel.setDataVector(new Object[1][5],noticeTitles);
                flag = 2;
                subheading.setText("查看公告");
                facultyWindow.remove(queryItem);
                facultyWindow.remove(queryField);
                jp.remove(export);

                facultyWindow.repaint();
                facultyWindow.validate();
            }
        });


        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (flag)
                {
                    case 0:facultyTableModel.setDataVector(
                            new FacultyListener().queryStu(
                                    queryItem.getSelectedIndex(),queryField.getText()
                            ),stuTitles);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });



        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("敬请期待");
            }
        });
        facultyWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Login.loginWindow.setVisible(true);
                facultyWindow.dispose();
            }
        });


    }
}
