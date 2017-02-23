package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuchang on 22/02/2017.
 */
public class UserManager {
    JFrame userManagerWindow = new JFrame("用户管理");
    JButton createUserButton = new JButton("创建新用户");
    JButton changeUserButton = new JButton("修改用户");
    JButton closeUserButton = new JButton("注销用户");




    void view()
    {
        userManagerWindow.setLayout(new FlowLayout());
        userManagerWindow.add(createUserButton);
        userManagerWindow.add(changeUserButton);
        userManagerWindow.add(closeUserButton);
        userManagerWindow.setVisible(true);
        userManagerWindow.setSize(400,100);
    }
}
