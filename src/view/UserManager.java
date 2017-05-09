package view;

import model.UserDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class UserManager {
    JFrame userManagerWindow = new JFrame("用户管理");
    JButton createUserButton = new JButton("创建新用户");
    JButton changeUserButton = new JButton("修改用户");
    JButton closeUserButton = new JButton("注销用户");//弹窗提醒
    JButton ok = new JButton("确认");

    JPanel jp = new JPanel();
    String[] titles = {"用户名","密码","身份类型"};
    DefaultTableModel userTableModel = new DefaultTableModel(new String[1][3],titles);
    JTable userTable = new JTable(userTableModel);
    JLabel subTitle = new JLabel();

    String[] types = {"系统管理员","教务管理员","学院管理员","教师","学生"};
    JComboBox jcb = new JComboBox(types);

    int flag = -1;

    void view()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserDatabase userDatabase = (UserDatabase) applicationContext.getBean("userModel");

        userManagerWindow.setLayout(new FlowLayout());
        userManagerWindow.add(createUserButton);
        userManagerWindow.add(changeUserButton);
        userManagerWindow.add(closeUserButton);
        userManagerWindow.setVisible(true);
        userManagerWindow.setSize(400,300);

        userManagerWindow.add(Box.createHorizontalStrut(1000));
        userManagerWindow.add(subTitle);
        userManagerWindow.add(Box.createHorizontalStrut(1000));
        userManagerWindow.add(jp);
        userManagerWindow.add(Box.createHorizontalStrut(1000));

        jp.setLayout(new BorderLayout());
        jp.add(userTable.getTableHeader(),BorderLayout.NORTH);
        jp.add(userTable);
        jp.add(ok,BorderLayout.SOUTH);

        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subTitle.setText("新建用户");
                flag = 0;
                userTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jcb));
            }
        });
        changeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subTitle.setText("修改用户");
                flag = 1;
                userTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jcb));
            }
        });
        closeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subTitle.setText("注销用户");
                flag = 2;
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (flag)
                {
                    case 0: userDatabase.createUser(userTableModel.getDataVector());
                        break;
                    case 1: userDatabase.changeUser(userTableModel.getDataVector());
                        break;
                    case 2:
                        userDatabase.deleteUser(userTableModel.getDataVector());
                        break;
                }
            }
        });
        userManagerWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Admin.adminWindow.setVisible(true);
                userManagerWindow.dispose();
            }
        });
    }
}
