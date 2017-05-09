package view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by tuchang on 22/02/2017.
 */
public class Admin {
    static JFrame adminWindow = null;
    JButton userManageButton = new JButton("用户管理");
    JButton stuManageButton = new JButton("学生信息管理");
    JButton courseManageButton = new JButton("课程管理");
    JButton noticeManageButton = new JButton("公告管理");




    public void adminView(int id)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserManager userManager = (UserManager) applicationContext.getBean("userManagerView");
        StuManager stuManager = (StuManager) applicationContext.getBean("studentManagerView");
        CourseManager courseManager = (CourseManager) applicationContext.getBean("courseManagerView");
        NoticeManager noticeManagerView = (NoticeManager) applicationContext.getBean("noticeManagerView");

        adminWindow= new JFrame("欢迎登陆，管理员");

        //adminWindow.removeAll();
        //removeAll之后显示不出来add的组件
        //adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                adminWindow.setVisible(false);
                userManager.view();
            }
        });

        stuManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow.setVisible(false);
                stuManager.view();

            }
        });

        courseManageButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                adminWindow.setVisible(false);
                courseManager.view();
            }
        });

        noticeManageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow.setVisible(false);
                noticeManagerView.view();
            }
        });

        adminWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Login.loginWindow.setVisible(true);
                adminWindow.dispose();
                adminWindow=null;
            }
        });
    }
}
