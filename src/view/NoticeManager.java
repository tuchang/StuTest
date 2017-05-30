 package view;

import control.NoticeControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

 /**
 * Created by tuchang on 22/02/2017.
 */
public class NoticeManager {
    JFrame noticeManagerWindow = new JFrame("公告管理");
    JButton createNoticeButton = new JButton("新建公告");
    JButton changeNoticeButton = new JButton("修改公告");
    JButton watchNoticeButton = new JButton("查看公告");
    JLabel subtitle = new JLabel();
    JPanel jp = new JPanel(new BorderLayout());
    JPanel jp2 = new JPanel(new BorderLayout());
    String[] titles = {"公告编号","标题","摘要","修改时间","创建时间"};
    DefaultTableModel noticeTableModel = new DefaultTableModel(new Object[1][5],titles);
    JTable noticeTable = new JTable(noticeTableModel);
    JScrollPane jScrollPane = new JScrollPane(noticeTable);
    JTextField title = new JTextField("请输入标题");
    JTextArea content = new JTextArea("请输入公告内容。",30,40);
    JScrollPane jScrollPane2 = new JScrollPane(content);
    JButton confirm = new JButton("确认");
    int flag = -1;
    void view()
    {
        noticeManagerWindow.remove(jp);
        noticeManagerWindow.remove(jp2);
        noticeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane2.setSize(content.getSize());
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        noticeManagerWindow.setLayout(new FlowLayout());
        noticeManagerWindow.add(createNoticeButton);
        noticeManagerWindow.add(changeNoticeButton);
        noticeManagerWindow.add(watchNoticeButton);
        noticeManagerWindow.add(Box.createHorizontalStrut(10000));
        noticeManagerWindow.add(subtitle);
        noticeManagerWindow.add(Box.createHorizontalStrut(10000));
        noticeManagerWindow.setVisible(true);
        noticeManagerWindow.setSize(800,1000);
        content.setLineWrap(true);
        jp.add(noticeTable.getTableHeader(),BorderLayout.NORTH);
        jp.add(jScrollPane);
        jp.add(confirm,BorderLayout.SOUTH);
        jp2.add(title,BorderLayout.NORTH);
        jp2.add(jScrollPane2);
        jp2.add(confirm,BorderLayout.SOUTH);
        createNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 0;
                subtitle.setText("创建公告");
                noticeManagerWindow.remove(jp);
                noticeManagerWindow.add(jp2);
                jp2.add(confirm,BorderLayout.SOUTH);
                noticeManagerWindow.repaint();
                noticeManagerWindow.validate();
            }
        });
        changeNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;
                subtitle.setText("修改公告");
                noticeManagerWindow.remove(jp2);
                noticeManagerWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);
                noticeTableModel.setDataVector(new NoticeControl().showNotice(),titles);
                noticeManagerWindow.repaint();
                noticeManagerWindow.validate();
            }
        });
        watchNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;
                subtitle.setText("查看公告");
                noticeManagerWindow.remove(jp2);
                noticeManagerWindow.add(jp);
                jp.add(confirm,BorderLayout.SOUTH);
                noticeTableModel.setDataVector(new NoticeControl().showNotice(),titles);
                noticeManagerWindow.repaint();
                noticeManagerWindow.validate();

            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(flag)
                {
                    //新建
                    case 0:new NoticeControl().createNotice(title.getText(),content.getText());
                    //System.out.println("新建一次");
                        break;
                    //修改
                    case 1:
                        flag = 3;
                        noticeManagerWindow.remove(jp);
                        noticeManagerWindow.add(jp2);
                        jp2.add(confirm,BorderLayout.SOUTH);
                        title.setText((String) noticeTableModel.getValueAt(noticeTable.getSelectedRow(),1));
                        content.setText(new NoticeControl().watchNotice(Integer.valueOf(String.valueOf(noticeTableModel.getValueAt(noticeTable.getSelectedRow(),0)))));
                        noticeManagerWindow.repaint();
                        noticeManagerWindow.validate();

                        break;
                    //查看
                    case 2:
                        noticeManagerWindow.remove(jp);
                        noticeManagerWindow.add(jp2);
                        jp2.add(confirm,BorderLayout.SOUTH);
                        title.setText((String) noticeTableModel.getValueAt(noticeTable.getSelectedRow(),1));
                        content.setText(new NoticeControl().watchNotice(Integer.valueOf(String.valueOf(noticeTableModel.getValueAt(noticeTable.getSelectedRow(),0)))));
                        noticeManagerWindow.repaint();
                        noticeManagerWindow.validate();
                        break;
                    case 3:
                        //new NoticeControl().changeNotice((int)noticeTableModel.getDataVector().get(0),title.getText(),content.getText());
                        new NoticeControl().changeNotice(Integer.valueOf(String.valueOf(noticeTableModel.getValueAt(noticeTable.getSelectedRow(),0))),title.getText(),content.getText());
                        noticeManagerWindow.repaint();
                        noticeManagerWindow.validate();
                        break;
                    case 4:
                        noticeManagerWindow.remove(jp);
                        noticeManagerWindow.add(jp2);
                        title.setText((String) noticeTableModel.getValueAt(noticeTable.getSelectedRow(),1));
                        content.setText(new NoticeControl().watchNotice(Integer.valueOf(String.valueOf(noticeTableModel.getValueAt(noticeTable.getSelectedRow(),0)))));
                        break;
                }
            }
        });
        noticeManagerWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                noticeManagerWindow.dispose();
                Admin.adminWindow.setVisible(true);
            }
        });
    }
}
