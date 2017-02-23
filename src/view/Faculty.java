package view;

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
    JButton insertGrade = new JButton("查询课程/导出名册");
    JButton watchNotice = new JButton("查看公告");
    DefaultTableModel facultyTableModel = new DefaultTableModel();
    JTable facultyWindowTable = new JTable(facultyTableModel);
    JPanel jp = new JPanel();

    void view()
    {
        facultyWindow.setLayout(new FlowLayout());
        facultyWindow.add(queryStuButton);
        facultyWindow.add(insertGrade);
        facultyWindow.add(watchNotice);
        jp.setLayout(new FlowLayout());
        facultyWindow.setVisible(true);
        facultyWindow.setSize(600,800);
        facultyWindow.add(jp);




        queryStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                flag = 2;
//                subheading.setText("查询学生信息");
//                jp.removeAll();
//                jp.add(facultyWindowTable);
//
//
//
//                jp.add(queryItem);
//                jp.add(queryField);
//                jp.add(stuTable);
            }
        });


    }
}
