package control;

import view.Faculty;
import view.StuManager;

import java.util.Vector;

/**
 * Created by tuchang on 23/02/2017.
 */
public class FacultyListener {
    String[][] members = null;
    public String[][] queryStu(int itemtype, String queryText)
    {

        members = new model.StuManageDatabase().queryStu(itemtype,queryText);
        return members;
    }
}
