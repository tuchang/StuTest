package control;

import model.StuManageDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tuchang on 23/02/2017.
 */
public class FacultyListener {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    StuManageDatabase studentModel = (StuManageDatabase) applicationContext.getBean("studentModel");
    String[][] members = null;
    public String[][] queryStu(int itemtype, String queryText)
    {

        members = studentModel.queryStu(itemtype,queryText);
        return members;
    }
}
