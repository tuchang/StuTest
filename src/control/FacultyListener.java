package control;

import model.StuManageDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

/**
 * Created by tuchang on 23/02/2017.
 */
public class FacultyListener {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    StuManageDatabase studentModel = (StuManageDatabase) applicationContext.getBean("studentModel");
    String[][] members = null;
    public String[][] queryStu(int itemtype, String queryText)
    {
        try{
            members = studentModel.queryStu(itemtype,queryText);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "查询失败", "提示", JOptionPane.WARNING_MESSAGE);
        }

        return members;
    }
}
