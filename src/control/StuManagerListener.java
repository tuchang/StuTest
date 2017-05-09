package control;

import model.StuManageDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Vector;

/**
 * Created by tuchang on 23/02/2017.
 */
public class StuManagerListener {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    StuManageDatabase studentModel = (StuManageDatabase) applicationContext.getBean("studentModel");



    public String[][] control(int flag, int itemtype, String queryText, Vector inputTables)
    {
            String[][] members = null;
            switch (flag)
            {
                case 0:
                    members = studentModel.createStu(inputTables);
                    break;
                case 1:members = studentModel.changeStu(inputTables);
                    break;
                case 2:members = studentModel.queryStu(itemtype,queryText);
                    break;
                default:
            }
            //System.out.println(members);
            return members;
    }




}
