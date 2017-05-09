/**
 * Created by tc on 2017/5/9.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.Login;

public class Main {
    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Login login = (Login)applicationContext.getBean("loginView");
        login.view();
    }
}
