package view;

import control.CourseListener;
import control.FacultyListener;
import control.NoticeControl;

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

    JButton createNoticeButton = new JButton("新建公告");//
    JTextField title = new JTextField("请输入标题");
    JTextArea content = new JTextArea("请输入公告内容。",30,40);
    JPanel jp2 = new JPanel();
    JScrollPane jScrollPane2 = new JScrollPane(content);



    String[] courseTitles = {"课程编号","课程名称","教师编号","教师名称","上课时间","上课地点","学期代号","课程描述"};
    String[] noticeTitles = {"公告编号","标题","摘要","修改时间","创建时间"};

    DefaultTableModel facultyTableModel = new DefaultTableModel();
    JTable facultyWindowTable = new JTable(facultyTableModel);
    JPanel jp = new JPanel();
    JLabel subheading = new JLabel();
    JButton confirm = new JButton("确认");

    JScrollPane jScrollPane = new JScrollPane(facultyWindowTable);




    String[] stuTitles = {"姓名", "学号", "性别", "手机", "邮箱",
            "学院", "专业", "班级", "身份证", "培养方向", "学制", "入学年份", "备注"};
    JComboBox queryItem = new JComboBox(stuTitles);
    JTextField queryField = new JTextField("请输入查询文本");

    JButton export = new JButton("导出名册");


    int flag = -1;

    public void view(int id)
    {
        facultyWindowTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        facultyWindowTable.setSize(900,500);
//        facultyWindowTable.setPreferredSize(new Dimension(900,500));

        jScrollPane2.setSize(content.getSize());
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jp.setPreferredSize(new Dimension(900,500));//!!
//        System.out.println("jp:"+jp.getSize());


        jp.add(facultyWindowTable.getTableHeader(),BorderLayout.NORTH);
//        jp.add(facultyWindowTable);
        jp.add(jScrollPane);
        jp.add(confirm,BorderLayout.SOUTH);

        jp2.setLayout(new BorderLayout());
        jp2.add(title,BorderLayout.NORTH);
//        jp2.add(content);
        jp2.add(jScrollPane2);
        jp2.add(confirm,BorderLayout.SOUTH);

        facultyWindow.setLayout(new FlowLayout());
        facultyWindow.add(queryStuButton);
        facultyWindow.add(course);
        facultyWindow.add(watchNotice);
        facultyWindow.add(createNoticeButton);
        //jp.setLayout(new FlowLayout());
        jp.setLayout(new BorderLayout());
        facultyWindow.setVisible(true);
        facultyWindow.setSize(1000,800);
        facultyWindow.add(Box.createHorizontalStrut(10000));
        //facultyWindow.add(jp);
        facultyWindow.add(subheading);
        facultyWindow.add(Box.createHorizontalStrut(10000));








        queryStuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(900,475);
                flag = 0;
                subheading.setText("查询学生信息");
                facultyTableModel.setDataVector(new Object[1][13],stuTitles);


                facultyWindow.remove(jp2);
                facultyWindow.remove(jp);
                jp.remove(export);
                facultyWindow.add(queryItem);
                facultyWindow.add(queryField);
                facultyWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);


                facultyWindow.repaint();
                facultyWindow.validate();




            }
        });

        course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(815,475);
//                System.out.println("jScrollPane:"+jScrollPane.getSize());
//                System.out.println("jp:"+jp.getSize());
//                System.out.println("tablesize:"+facultyWindowTable.getSize());

                facultyTableModel.setDataVector(new Object[1][8],courseTitles);
                flag = 1;
                subheading.setText("查询课程/导出名册");
                facultyWindow.remove(jp2);
                facultyWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);
                facultyWindow.remove(queryItem);
                facultyWindow.remove(queryField);
                jp.add(export,BorderLayout.EAST);

//                jScrollPane.setSize(900,500);
//                jp.setSize(950,600);

                facultyWindow.repaint();
                facultyWindow.validate();
            }
        });


        watchNotice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jScrollPane.setSize(900,475);
                facultyTableModel.setDataVector(new Object[1][5],noticeTitles);
                flag = 2;
                subheading.setText("查看公告");
                facultyWindow.remove(queryItem);
                facultyWindow.remove(queryField);
                facultyWindow.remove(jp2);
                facultyWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);
                jp.remove(export);

                facultyTableModel.setDataVector(new NoticeControl().showNotice(),noticeTitles);

                facultyWindow.repaint();
                facultyWindow.validate();
            }
        });

        createNoticeButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 3;
                subheading.setText("新建公告");
                title.setText("请输入标题");
                content.setText("请输入公告内容");
                facultyWindow.remove(queryItem);
                facultyWindow.remove(queryField);

                facultyWindow.remove(jp);
                facultyWindow.add(jp2);
                jp2.add(confirm,BorderLayout.SOUTH);
                facultyWindow.repaint();
                facultyWindow.validate();
            }
        }));


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
                    case 1:facultyTableModel.setDataVector(new CourseListener().queryCourse(id,1),courseTitles);
                        break;
                    case 2:facultyWindow.remove(jp);
                        facultyWindow.add(jp2);
                        jp2.add(confirm,BorderLayout.SOUTH);
                        title.setText((String) facultyTableModel.getValueAt(facultyWindowTable.getSelectedRow(),1));
                        content.setText(new NoticeControl().watchNotice(Integer.valueOf(String.valueOf(facultyTableModel.getValueAt(facultyWindowTable.getSelectedRow(),0)))));
//                        System.out.println(facultyTableModel.getValueAt(facultyWindowTable.getSelectedRow(),0));
                        facultyWindow.repaint();
                        facultyWindow.validate();
                        break;
                    case 3:new NoticeControl().createNotice(title.getText(),content.getText());
                        break;
                }
            }
        });



        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = (String) facultyTableModel.getValueAt(facultyWindowTable.getSelectedRow(),0);
//                System.out.println(temp);
                if(!(temp.isEmpty()||temp.equals("")||temp==null||temp.equals("null"))){
                    new CourseListener().output(Integer.parseInt(temp));
                }else {
                    JOptionPane.showMessageDialog(new JFrame(), "已选择项的第一个字段为空或不符合要求", "提示", JOptionPane.WARNING_MESSAGE);
                }

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
