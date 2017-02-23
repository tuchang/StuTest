package view;//import control.SignIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by tuchang on 22/02/2017.
 */
public class Login {
    public static JFrame loginWindow = new JFrame("欢迎登录");
    public static JTextField username = new JTextField("请输入用户名");
    public static JTextField password = new JTextField("请输入密码");
    public static JComboBox type = new JComboBox();

    static JButton signIn = new JButton("登录");
    static JButton exit = new JButton("退出");
    public static void main(String[] args)
    {
        type.addItem("管理员");
        type.addItem("教师");
        type.addItem("学生");

        loginWindow.setLayout(new FlowLayout());
        loginWindow.add(new JLabel("用户名:"));
        loginWindow.add(username);
        loginWindow.add(Box.createHorizontalStrut(1000));
        loginWindow.add(new JLabel("密码:"));
        loginWindow.add(password);
        loginWindow.add(Box.createHorizontalStrut(1000));
        loginWindow.add(type);
        loginWindow.add(Box.createHorizontalStrut(1000));
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



    }

}
