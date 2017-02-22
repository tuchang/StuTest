package control;

import model.LoginDatabase;
import view.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.Login.password;
import static view.Login.type;

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
        LoginData lg = new LoginDatabase().getLoginData(Login.username.getText());



        //System.out.println(type.getSelectedIndex());
        if (lg.getPwd().equals(password.getText()))
        {
            switch (Login.type.getSelectedIndex())
            {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                //default:System.out.println(type.getItemCount());
            }
        }
    }
}
