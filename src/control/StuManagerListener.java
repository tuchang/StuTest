package control;

import java.lang.reflect.Member;
import java.util.Vector;

/**
 * Created by tuchang on 23/02/2017.
 */
public class StuManagerListener {





    public String[][] control(int flag, int itemtype, String queryText, Vector inputTables)
    {


            String[][] members = null;


            switch (flag)
            {

                case 0:
//                    System.out.println("hehe.1");
                    members = new model.StuManageDatabase().createStu(inputTables);
//                    System.out.println("hehe.");
                    break;
                case 1:members = new model.StuManageDatabase().changeStu(inputTables);
                    break;
                case 2:members = new model.StuManageDatabase().queryStu(itemtype,queryText);
                    break;
                default:
            }

            //System.out.println(members);








            return members;



    }




}
