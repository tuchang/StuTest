package view;

import model.UserDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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


    int flag = -1;



    void view()
    {

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

            }
        });

        changeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subTitle.setText("修改用户");
                flag = 1;
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
                    case 0: new UserDatabase().createUser(userTableModel.getDataVector());
                        break;
                    case 1: new UserDatabase().changeUser(userTableModel.getDataVector());
                        break;
                    case 2: new UserDatabase().closeUser();
                        break;
                }
            }
        });

        userManagerWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Login.loginWindow.setVisible(true);
                Admin.adminWindow.setVisible(true);
                userManagerWindow.dispose();
            }
        });


    }
}
