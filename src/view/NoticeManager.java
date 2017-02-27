 package view;

import control.NoticeControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 /**
 * Created by tuchang on 22/02/2017.
 */
public class NoticeManager {
    JFrame noticeManagerWindow = new JFrame("公告管理");
    JButton createNoticeButton = new JButton("新建公告");
    JButton changeNoticeButton = new JButton("修改用户");
    JButton watchNoticeButton = new JButton("查看公告");

    JLabel subtitle = new JLabel();


     JPanel jp = new JPanel(new BorderLayout());
     String[] titles = {"公告编号","公告摘要","修改时间","公告创建时间"};
     DefaultTableModel noticeTableModel = new DefaultTableModel(new Object[1][4],titles);
     JTable noticeTable = new JTable();
     JTextField title = new JTextField("请输入标题");
     JTextArea content = new JTextArea("请输入公告内容。");
     JButton confirm = new JButton("确认");
     int flag = -1;






    void view()
    {



        noticeManagerWindow.setLayout(new FlowLayout());
        noticeManagerWindow.add(createNoticeButton);
        noticeManagerWindow.add(changeNoticeButton);
        noticeManagerWindow.add(watchNoticeButton);
        noticeManagerWindow.add(Box.createHorizontalStrut(1000));
        noticeManagerWindow.add(noticeTable);
        noticeManagerWindow.setVisible(true);
        noticeManagerWindow.setSize(800,1000);

        jp.add(noticeTable.getTableHeader(),BorderLayout.NORTH);
        jp.add(noticeTable);
        jp.add(confirm,BorderLayout.SOUTH);

        createNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
                subtitle.setText("创建公告");
                noticeManagerWindow.add(title);
                noticeManagerWindow.add(content);
                noticeManagerWindow.add(confirm);
            }
        });

        changeNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;
                subtitle.setText("修改公告");
                noticeManagerWindow.remove(title);
                noticeManagerWindow.remove(content);
                noticeManagerWindow.remove(confirm);
                noticeManagerWindow.add(jp);
            }
        });


        watchNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;
                subtitle.setText("查看公告");
                noticeManagerWindow.remove(title);
                noticeManagerWindow.remove(content);
                noticeManagerWindow.remove(confirm);
                noticeManagerWindow.add(jp);
            }
        });


        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(flag)
                {
                    case 0:new NoticeControl().createNotice(title.getText(),content.getText());
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });




    }
}
