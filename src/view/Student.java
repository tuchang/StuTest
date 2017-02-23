package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by tuchang on 23/02/2017.
 */
public class Student {
    JFrame stuWindow = new JFrame("学生界面");
    JButton queryStuButton = new JButton("查询个人信息");
    JButton queryCourseButton = new JButton("查询课程");
    JButton watchNotice = new JButton("查看公告");
    DefaultTableModel facultyTableModel = new DefaultTableModel();
    JTable facultyWindowTable = new JTable(facultyTableModel);
    JPanel jp = new JPanel();

    void view()
    {
        
    }
}
