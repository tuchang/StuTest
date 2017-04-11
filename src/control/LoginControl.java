package control;

import Test.Captcha;

import javax.swing.*;

/**
 * Created by tuchang on 20/03/2017.
 */
public class LoginControl {

    public static JTextField username = new JTextField("请输入用户名");
    public static JTextField password = new JTextField("请输入密码");
    public static JTextField captchaText = new JTextField("请输入验证码");

    public static JComboBox type = new JComboBox();


    public static JButton signIn = new JButton("登录");
    public static JButton exit = new JButton("退出");


    public static Captcha captcha = new Captcha();
    public static JLabel captchaImg = captcha.getCaptchaImage();




}
