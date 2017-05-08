package view;//import control.SignIn;

import Test.Captcha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static control.LoginControl.*;

/**
 * Created by tuchang on 22/02/2017.
 */
public class Login {
    public static JFrame loginWindow = new JFrame("欢迎登录");
    public static JPanel jp = new JPanel();
    public static void main(String[] args)
    {
        jp.add(captchaImg);

        type.addItem("管理员");
        type.addItem("教师");
        type.addItem("学生");
        type.addItem("教务员");
        type.addItem("学院管理员");

        loginWindow.setLayout(new FlowLayout());
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
        loginWindow.setSize(400,200);
        loginWindow.setVisible(true);



        loginWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        signIn.addActionListener(new control.SignInListener());

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jp.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                captcha = null;
                captcha = new Captcha();
                captchaImg = captcha.getCaptchaImage();
//                loginWindow.remove(jp);
                jp.removeAll();
                jp.add(captchaImg);
//                loginWindow.remove(captchaImg);
//                captchaImg.updateUI();
                loginWindow.invalidate();
                loginWindow.repaint();
                loginWindow.revalidate();

                System.out.println("你点击了一次验证码 验证码是"+captcha.getCaptchaCode());
            }
        });

    }

}
