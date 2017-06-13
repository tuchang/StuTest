package view;

import Test.Captcha;
import control.SignInListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static control.LoginControl.*;

/**
 * Created by tuchang on 22/02/2017.
 */
public class Login {
    public static JFrame loginWindow = new JFrame("欢迎登录学生管理系统");
    public static JPanel jp = new JPanel();
    public static JPanel backgound = new JPanel();
    public static void view()
    {
        backgound.add(new JLabel(new ImageIcon("C:\\Users\\hasee\\IdeaProjects\\StuTest\\doc\\background.jpg")));
        jp.add(captchaImg);
        type.addItem("管理员");
        type.addItem("教师");
        type.addItem("学生");
        type.addItem("教务员");
        type.addItem("学院管理员");
        ;
        loginWindow.setLayout(new FlowLayout());
        loginWindow.add(backgound);
        loginWindow.add(Box.createHorizontalStrut(10000));
        loginWindow.add(new JLabel("用户名:"));
        loginWindow.add(username);
        loginWindow.add(Box.createHorizontalStrut(10000));
        loginWindow.add(new JLabel("密码:"));
        loginWindow.add(password);
        loginWindow.add(Box.createHorizontalStrut(10000));
        loginWindow.add(type);
        loginWindow.add(Box.createHorizontalStrut(10000));
        loginWindow.add(jp);
        loginWindow.add(captchaText);
        loginWindow.add(Box.createHorizontalStrut(10000));
        loginWindow.add(signIn);
        loginWindow.add(exit);
        loginWindow.setSize(770,530);
        loginWindow.setVisible(true);
        loginWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        signIn.addActionListener(new SignInListener());
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                captcha = null;
                captcha = new Captcha();
                captchaImg = captcha.getCaptchaImage();
                jp.removeAll();
                jp.add(captchaImg);
                loginWindow.invalidate();
                loginWindow.repaint();
                loginWindow.revalidate();
                System.out.println(loginWindow.getSize());
            }
        });
    }
}
