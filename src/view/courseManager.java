package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tuchang on 22/02/2017.
 */
public class courseManager {
    JFrame courseManagerWindow = new JFrame("课程管理");
    JButton createCourseButton = new JButton("创建新课程");
    JButton changeCourseButton = new JButton("修改课程");
    JButton closeCourseButton = new JButton("成绩录入/修改成绩");




    void view()
    {
        courseManagerWindow.setLayout(new FlowLayout());
        courseManagerWindow.add(createCourseButton);
        courseManagerWindow.add(changeCourseButton);
        courseManagerWindow.add(closeCourseButton);
        courseManagerWindow.setVisible(true);
        courseManagerWindow.setSize(400,100);
    }
}
