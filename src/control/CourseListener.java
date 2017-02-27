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

    public void grade(Vector dataVector)
    {
        new GradeDatabase().setGrade(dataVector);
    }
}
