package control;

import java.lang.reflect.Member;

/**
 * Created by tuchang on 23/02/2017.
 */
public class StuManagerListener {





    public String[][] control(int flag, int itemtype, String queryText)
    {


            String[][] members = null;


            switch (flag)
            {
                case 0:members = new model.StuManageDatabase().createStu();
                    break;
                case 1:members = new model.StuManageDatabase().changeStu();
                    break;
                case 2:members = new model.StuManageDatabase().queryStu(itemtype,queryText);
                    break;
                default:
            }










            return members;



    }




}
