package view;

import control.StuManagerListener;

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

    String[] titles = {"姓名", "学号", "性别", "出生日期", "民族", "层次", "学历类别", "学习形式", "手机", "邮箱",
            "系", "学院", "专业", "班级", "身份证", "培养方向", "学制", "入学日期", "预计毕业日期", "学籍状态", "备注"};

    DefaultTableModel stuTableModel = new DefaultTableModel(new Object[1][21], titles);
    JTable stuTable = new JTable(stuTableModel);
//    JScrollPane jScrollPane = new JScrollPane(stuTable);

    //JTable changeStuTable = new JTable();

//    public JComboBox getQueryItem() {
//        return queryItem;
//    }
//    public JTextField getQueryField() {
//        return queryField;
//    }


    JComboBox queryItem = new JComboBox(titles);
    JTextField queryField = new JTextField("请输入查询文本",15);




    public void view()
    {
        jp.setLayout(new BorderLayout());

//        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        stuTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        jScrollPane.setSize(stuTable.getSize());

        stuManagerWindow.setLayout(new FlowLayout());
        stuManagerWindow.add(createStuButton);
        stuManagerWindow.add(changeStuButton);
        stuManagerWindow.add(queryStuButton);
        stuManagerWindow.add(Box.createHorizontalStrut(3000));
        stuManagerWindow.add(subheading);
        stuManagerWindow.add(Box.createHorizontalStrut(3000));
        stuManagerWindow.add(jp);

        jp.add(stuTable.getTableHeader(),BorderLayout.NORTH);
//        jp.add(jScrollPane);
        jp.add(stuTable);
        jp.add(confirm,BorderLayout.SOUTH);



        stuManagerWindow.setVisible(true);
        stuManagerWindow.setSize(1600,600);
        //jp.setSize(400,600);


        createStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(jp.getSize());
                flag = 0;
                subheading.setText("新建学生信息");


                stuManagerWindow.remove(queryItem);
                stuManagerWindow.remove(queryField);

                //jp.removeAll();
//                jp.add(stuTable.getTableHeader(),BorderLayout.NORTH);
//                jp.add(stuTable);
//                jp.add(confirm,BorderLayout.SOUTH);




                //System.out.println("hehe");

                //stuManagerWindow.getContentPane().removeAll();
//                stuManagerWindow.add(createStuButton);
//                stuManagerWindow.add(changeStuButton);
//                stuManagerWindow.add(queryStuButton);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(subheading);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//
//                stuManagerWindow.add(stuTable.getTableHeader());
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(stuTable);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(confirm);

            }
        });
        changeStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;
                subheading.setText("修改学生信息(以学号为准，不可修改学号)");

                stuManagerWindow.remove(queryItem);
                stuManagerWindow.remove(queryField);

//                jp.removeAll();
//                jp.add(stuTable.getTableHeader(),BorderLayout.NORTH);
//                //jp.add(Box.createHorizontalStrut(2000));
//                jp.add(stuTable);
//                //jp.add(Box.createHorizontalStrut(1000));
//                jp.add(confirm,BorderLayout.SOUTH);

//                stuManagerWindow.removeAll();
//                stuManagerWindow.add(createStuButton);
//                stuManagerWindow.add(changeStuButton);
//                stuManagerWindow.add(queryStuButton);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(subheading);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//
//                stuManagerWindow.add(stuTable.getTableHeader());
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(stuTable);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(confirm);
            }
        });

        queryStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;
                subheading.setText("查询学生信息");
                //jp.removeAll();

                stuManagerWindow.remove(jp);
                stuManagerWindow.add(queryItem);
                stuManagerWindow.add(queryField);
                stuManagerWindow.add(jp);
                //jp.add(Box.createHorizontalStrut(1000));
                //jp.add(stuTable.getTableHeader());
                //jp.add(Box.createHorizontalStrut(2000));
                //jp.add(stuTable);
                //jp.add(Box.createHorizontalStrut(2000));
                //jp.add(confirm);

//                stuManagerWindow.removeAll();
//                stuManagerWindow.add(createStuButton);
//                stuManagerWindow.add(changeStuButton);
//                stuManagerWindow.add(queryStuButton);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(subheading);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//
//                stuManagerWindow.add(queryItem);
//                stuManagerWindow.add(queryField);
//
//                stuManagerWindow.add(stuTable.getTableHeader());
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(stuTable);
//                stuManagerWindow.add(Box.createHorizontalStrut(1000));
//                stuManagerWindow.add(confirm);
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                System.out.println("flag."+flag);
//                System.out.println(new StuManagerListener().control(flag,queryItem.getSelectedIndex(),queryField.getText()
//                        ,stuTableModel.getDataVector()));

                switch(flag)
                {
                    //弹框新建学生信息 成功/新建失败
                    case 0:
//                        System.out.println("hehe.0");
                        new StuManagerListener().control(
                                flag,-1,null
                                ,stuTableModel.getDataVector());
//                        System.out.println("hehe.1");
                          break;
                    //修改学生信息成功/修改学生信息失败
                    case 1:
                        new StuManagerListener().control(
                                flag,-1,null
                                ,stuTableModel.getDataVector());
                          break;
                    case 2: stuTableModel.setDataVector(
                            new StuManagerListener().control(
                                    flag,queryItem.getSelectedIndex(),queryField.getText()
                                    ,stuTableModel.getDataVector())
                            ,titles);
                        //输出信息

//                            stuManagerWindow.remove(queryItem);
//                            stuManagerWindow.remove(queryField);

                          break;
                    case -1:subheading.setText("未选择管理操作");
                        break;

                }

            }
        });


        stuManagerWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //System.out.println("hehe");
                Admin.adminWindow.setVisible(true);
                stuManagerWindow.dispose();
            }
        });

    }
}

/*
* 删除学生信息 修改成1或者0 新建的时候改成新的
* 怎么把view数据传递到control
*
* */