package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tuchang on 22/02/2017.
 */
public class Admin {
    JFrame adminWindow = new JFrame("欢迎登陆，管理员");
    JButton userManageButton = new JButton("用户管理");
    JButton stuManageButton = new JButton("学生信息管理");
    JButton courseManageButton = new JButton("课程管理");
    JButton noticeManageButton = new JButton("公告管理");




    public void adminView()
    {
        adminWindow.setLayout(new FlowLayout());
        adminWindow.add(userManageButton);
        adminWindow.add(stuManageButton);
        adminWindow.add(courseManageButton);
        adminWindow.add(noticeManageButton);
        adminWindow.setVisible(true);
        adminWindow.setSize(800,300);

        userManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserManager().view();
            }
        });

        stuManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view.StuManager().view();
            }
        });

        courseManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view.courseManager().view();
            }
        });

        noticeManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NoticeManager().view();
            }
        });
    }
}
