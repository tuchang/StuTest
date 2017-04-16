package view;

import control.CourseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by tuchang on 22/02/2017.
 */
public class CourseManager {
    JFrame courseManagerWindow = new JFrame("课程管理");
    JButton createCourseButton = new JButton("创建新课程");
    JButton changeCourseButton = new JButton("修改课程");
    JButton gradeButton = new JButton("成绩录入/修改成绩");//希望增加Excel格式导入

    String[] courseTitles = {"课程编号","课程名称","教师编号","教师名称","上课时间","上课地点","学期代号","课程描述"};
    DefaultTableModel courseModel = new DefaultTableModel(new Object[1][8], courseTitles);
    DefaultTableModel courseModel2 = new DefaultTableModel(new Object[1][8], courseTitles){
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            //第一列不可修改
            if (columnIndex == 0) {
                return false;
            } else {
                return true;
            }
        }
    };
    String[] gradeTitles = {"成绩编号","课程编号","学生ID","成绩"};
    DefaultTableModel gradeModel = new DefaultTableModel(new Object[1][4],gradeTitles);
    JTable courseTable = new JTable();
    JPanel jp = new JPanel();

    JLabel jl = new JLabel();
    JButton confirm = new JButton("确认");
    int flag = -1;

    void view()
    {
        courseManagerWindow.setLayout(new FlowLayout());
        courseManagerWindow.add(createCourseButton);
        courseManagerWindow.add(changeCourseButton);
        courseManagerWindow.add(gradeButton);
        courseManagerWindow.add(Box.createHorizontalStrut(1000));
        courseManagerWindow.add(jp);
        jp.setLayout(new BorderLayout());
        courseManagerWindow.setVisible(true);
        courseManagerWindow.setSize(800,600);

        jp.add(courseTable.getTableHeader(),BorderLayout.NORTH);
        jp.add(courseTable);
        jp.add(confirm,BorderLayout.SOUTH);

        courseModel2.setValueAt("自动",0,0);

        createCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl.setText("创建课程");
                courseTable.setModel(courseModel2);
                //id自增 不手动填
                flag = 0;
            }
        });

        changeCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl.setText("修改课程");
                courseTable.setModel(courseModel);
                //需要课程id
                flag = 1;
            }
        });

        gradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl.setText("录入/修改成绩");
                flag = 2;
                courseTable.setModel(gradeModel);

            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (flag)
                {
                    case 0:new CourseListener().createCourse(courseModel2.getDataVector());
                        break;
                    case 1:new CourseListener().changeCourse(courseModel.getDataVector());
                        break;
                    case 2:new CourseListener().setGrade(gradeModel.getDataVector());
                        break;
                }


            }
        });


        courseManagerWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                courseManagerWindow.dispose();
                Admin.adminWindow.setVisible(true);
            }
        });


    }
}
