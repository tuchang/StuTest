package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tuchang on 21/02/2017.
 */
public class information {


    static String text = "heihei";
    static JButton jb1 = new JButton("添加");
    static JButton jb2 = new JButton("修改");
    static JButton jb3 = new JButton("删除");
    static JTextArea jta = new JTextArea("默认");

    public static void main(String[] args)
    {


        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(Box.createHorizontalStrut(1000)); //换行
        jf.add(jta);
        jf.setSize(800,600);
        jf.setVisible(true);

        jb1.addActionListener(new AddButtonListener());
    }



    private static class AddButtonListener implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            jta.setText(text);
        }
    }

}
