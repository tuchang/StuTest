package control;

import model.LoginDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.LoginControl.*;

/**
 * Created by tuchang on 22/02/2017.
 */

public class SignInListener implements ActionListener
{
    public static class LoginData
    {
        String usr = null;
        String pwd = null;
        String tpye = null;

        public String getUsr() {
            return usr;
        }

        public String getPwd() {
            return pwd;
        }

        public String getTpye() {
            return tpye;
        }

        public void setUsr(String usr) {
            this.usr = usr;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public void setTpye(String tpye) {
            this.tpye = tpye;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Admin adminView = (Admin) applicationContext.getBean("adminView");
        Faculty facultyView = (Faculty) applicationContext.getBean("facultyView");
        Student studentView = (Student) applicationContext.getBean("studentView");
        Admin2 adminView2 = (Admin2) applicationContext.getBean("adminView2");
        Admin2 adminView3 = (Admin2) applicationContext.getBean("adminView2");
        LoginDatabase loginModel = (LoginDatabase) applicationContext.getBean("loginModel");

        //判断用户名是否为空
        if (username.getText().isEmpty()||username.getText()==null)
        {
            JOptionPane.showMessageDialog(new JFrame(), "请输入用户名", "提示", JOptionPane.WARNING_MESSAGE);
            return ;
        }
        if (password.getPassword().length<=0||password.getPassword()==null)
        {
            JOptionPane.showMessageDialog(new JFrame(), "请输入密码", "提示", JOptionPane.WARNING_MESSAGE);
            return ;
        }

        LoginData lg = loginModel.getLoginData(username.getText());
        System.out.println(lg.getTpye());
        System.out.println(type.getSelectedIndex());
        if (lg.getUsr()==null)
        {
            JOptionPane.showMessageDialog(new JFrame(), "用户名或密码错误", "登陆失败", JOptionPane.WARNING_MESSAGE);
            return;
        }
        System.out.println(lg);
        if (!lg.getTpye().equals(String.valueOf(type.getSelectedIndex())))
        {
            JOptionPane.showMessageDialog(new JFrame(), "登陆失败", "提示", JOptionPane.WARNING_MESSAGE);
            return ;
        }

        if (lg.getPwd().equals(String.valueOf(password.getPassword()))&&captchaText.getText().equals(captcha.getCaptchaCode()))
        {
            view.Login.loginWindow.setVisible(false);
            switch (type.getSelectedIndex())
            {
                case 0:adminView.adminView(Integer.parseInt(lg.getUsr()));
                    break;
                case 1:facultyView.view(Integer.parseInt(lg.getUsr()));//temp_id = 1;
                    break;
                case 2:studentView.view(Integer.parseInt(lg.getUsr()));//temp_id = 1;
                    break;
                case 3:adminView2.adminView(Integer.parseInt(lg.getUsr()));
                    break;
                case 4:adminView3.adminView(Integer.parseInt(lg.getUsr()));
                    break;
                //default:System.out.println(type.getItemCount());
            }
        }
        else if (!captchaText.getText().equals(captcha.getCaptchaCode()))
        {
            JOptionPane.showMessageDialog(new JFrame(), "验证码错误", "登陆失败", JOptionPane.WARNING_MESSAGE);
        }
        else if(!lg.getPwd().equals(String.valueOf(password.getPassword())))
        {
            JOptionPane.showMessageDialog(new JFrame(), "用户名或密码错误", "登陆失败", JOptionPane.WARNING_MESSAGE);
        }
    }
}
