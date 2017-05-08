package control;

import model.LoginDatabase;
import view.Admin;
import view.Faculty;
import view.Student;

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
        LoginData lg = new LoginDatabase().getLoginData(username.getText());
        //view.Login.loginWindow.setVisible(false);


        //System.out.println(type.getSelectedIndex());
//        if (lg.getPwd().equals(password.getPassword())&&captchaText.getText().equals(captcha.getCaptchaCode()))
        {
            switch (type.getSelectedIndex())
            {
                case 0:new Admin().adminView();
                    view.Login.loginWindow.setVisible(false);
                    break;
                case 1:new Faculty().view(1);
                    view.Login.loginWindow.setVisible(false);
                    break;
                case 2:new Student().view(1);//temp_id = 1;
                    view.Login.loginWindow.setVisible(false);
                    break;
                case 3:new Admin().adminView();
                    view.Login.loginWindow.setVisible(false);
                    break;
                case 4:new Admin().adminView();
                    view.Login.loginWindow.setVisible(false);
                    break;
                //default:System.out.println(type.getItemCount());
            }
        }
//        else
//        {
//            System.out.println("登录失败");
//            System.out.println(password.getText());
//            System.out.println(lg.getPwd());
//        }
    }
}
