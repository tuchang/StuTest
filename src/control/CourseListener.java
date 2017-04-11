package control;

import model.CourseDatabase;
import model.GradeDatabase;

import java.util.Vector;

/**
 * Created by tuchang on 27/02/2017.
 */
public class CourseListener {
    public void createCourse(Vector dataVector)
    {
        new CourseDatabase().createCourse(dataVector);
    }

    public void changeCourse(Vector dataVector)
    {
        new CourseDatabase().changeCourse(dataVector);
    }

    public void setGrade(Vector dataVector)
    {
        new GradeDatabase().setGrade(dataVector);
    }

    public String[][] getGrade(int id)
    {
        String[][] temp = new GradeDatabase().getGrade(id);
        String[][] gradeItem = new String[temp.length][4] ;
        for (int i=0; i<temp.length;i++)
        {
            gradeItem[i][0] = temp[i][0];
            gradeItem[i][1] = temp[i][1];
            gradeItem[i][2] = String.valueOf(id);
            gradeItem[i][3] = temp[i][2];
            System.out.print(temp[i][0]);

        }

        return gradeItem;
    }

    public String[][] queryCourse(int id,int type)
    {
        return new CourseDatabase().queryCourse(id,type);
    }
}
