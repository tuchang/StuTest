 package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by tuchang on 22/02/2017.
 */
public class NoticeManager {
    JFrame noticeManagerWindow = new JFrame("公告管理");
    JButton createNoticeButton = new JButton("新建公告");
    JButton changeNoticeButton = new JButton("修改用户");
    JButton watchNoticeButton = new JButton("查看公告");
    DefaultTableModel noticeTableModel = new DefaultTableModel();
    JTable noticeTable = new JTable();




    void view()
    {


        noticeManagerWindow.setLayout(new FlowLayout());
        noticeManagerWindow.add(createNoticeButton);
        noticeManagerWindow.add(changeNoticeButton);
        noticeManagerWindow.add(watchNoticeButton);
        noticeManagerWindow.add(Box.createHorizontalStrut(1000));
        noticeManagerWindow.add(noticeTable);
        noticeManagerWindow.setVisible(true);
        noticeManagerWindow.setSize(400,100);
    }
}
