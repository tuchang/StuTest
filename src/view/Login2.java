package view;

import javax.swing.*;

/**
 * Created by tc on 2017/6/6.
 */
public class Login2 {
    private JPanel panel1;
    private JTextField 用户名TextField;
    private JButton 登陆Button;
    private JTextField 密码TextField;
    private JComboBox 身份类型ComboBox;
    private JLabel label1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //label1 = new JLabel(new ImageIcon("C:\\Users\\hasee\\IdeaProjects\\StuTest\\doc\\background.jpg"));
        //label1.setIcon(new ImageIcon("C:\\Users\\hasee\\IdeaProjects\\StuTest\\doc\\background.jpg"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login2");
        frame.setContentPane(new Login2().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
