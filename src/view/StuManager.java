package view;

import control.StuManagerListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tuchang on 22/02/2017.
 */
public class StuManager {

    int flag = -1;
    JFrame stuManagerWindow = new JFrame("学生信息管理");
    JButton createStuButton = new JButton("新建学生信息");
    JButton changeStuButton = new JButton("修改学生信息");
    JButton queryStuButton = new JButton("查询学生信息");
    //JButton closeStuButton = new JButton("注销学生信息");

    JPanel jp = new JPanel();

    JLabel subheading = new JLabel();
    JButton confirm = new JButton("确认");


    DefaultTableModel stuTableModel = new DefaultTableModel();
    JTable stuTable = new JTable(stuTableModel);

    //JTable changeStuTable = new JTable();

    public JComboBox getQueryItem() {
        return queryItem;
    }

    public JTextField getQueryField() {
        return queryField;
    }

    String[] titles = {"姓名", "学号", "性别", "手机", "邮箱",
            "学院", "专业", "班级", "身份证", "培养方向", "学制", "入学年份", "备注"};
    JComboBox queryItem = new JComboBox(titles);
    JTextField queryField = new JTextField("请输入查询文本");




    public void view()
    {
        jp.setLayout(new FlowLayout());

        stuManagerWindow.setLayout(new FlowLayout());
        stuManagerWindow.add(createStuButton);
        stuManagerWindow.add(changeStuButton);
        stuManagerWindow.add(queryStuButton);
        stuManagerWindow.add(Box.createHorizontalStrut(1000));
        stuManagerWindow.add(subheading);




        stuManagerWindow.setVisible(true);
        stuManagerWindow.setSize(400,100);


        createStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
                subheading.setText("新建学生信息");

            }
        });
        changeStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;
                subheading.setText("修改学生信息");
                jp.removeAll();
                jp.add(stuTable);
            }
        });

        queryStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;
                subheading.setText("查询学生信息");
                jp.removeAll();
                jp.add(queryItem);
                jp.add(queryField);
                jp.add(stuTable);
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stuTableModel.setDataVector(
                        new StuManagerListener().control(flag,queryItem.getSelectedIndex(),queryField.getText())
                        ,titles);

            }
        });



    }
}

/*
* 删除学生信息 修改成1或者0 新建的时候改成新的
*
*
* */