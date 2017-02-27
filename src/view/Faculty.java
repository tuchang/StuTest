package view;

import control.FacultyListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tuchang on 23/02/2017.
 */
public class Faculty {
    JFrame facultyWindow = new JFrame("教师界面");
    JButton queryStuButton = new JButton("查询学生信息");
    JButton course = new JButton("查询课程/导出名册");
    JButton watchNotice = new JButton("查看公告");
    DefaultTableModel facultyTableModel = new DefaultTableModel();
    JTable facultyWindowTable = new JTable(facultyTableModel);
    JPanel jp = new JPanel();
    JLabel subheading = new JLabel();
    JButton confirm = new JButton("确认");


    String[] titles = {"姓名", "学号", "性别", "手机", "邮箱",
            "学院", "专业", "班级", "身份证", "培养方向", "学制", "入学年份", "备注"};
    JComboBox queryItem = new JComboBox(titles);
    JTextField queryField = new JTextField("请输入查询文本");

    JButton export = new JButton("导出名册");


    int flag = -1;

    void view()
    {
        facultyWindow.setLayout(new FlowLayout());
        facultyWindow.add(queryStuButton);
        facultyWindow.add(course);
        facultyWindow.add(watchNotice);
        //jp.setLayout(new FlowLayout());
        jp.setLayout(new BorderLayout());
        facultyWindow.setVisible(true);
        facultyWindow.setSize(600,800);
        facultyWindow.add(Box.createHorizontalStrut(1000));
        //facultyWindow.add(jp);

        jp.add(facultyWindowTable.getTableHeader(),BorderLayout.NORTH);
        jp.add(facultyWindowTable);
        facultyWindow.add(confirm,BorderLayout.SOUTH);





        queryStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
                subheading.setText("查询学生信息");



                facultyWindow.remove(jp);
                jp.remove(export);
                facultyWindow.add(queryItem);
                facultyWindow.add(queryField);
                facultyWindow.add(jp);






            }
        });

        course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;
                subheading.setText("查询课程/导出名册");
                facultyWindow.remove(queryItem);
                facultyWindow.remove(queryField);
                jp.add(export,BorderLayout.EAST);
            }
        });


        watchNotice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;
                subheading.setText("查看公告");
                facultyWindow.remove(queryItem);
                facultyWindow.remove(queryField);
                jp.remove(export);
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
                            ),titles);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });

    }
}
