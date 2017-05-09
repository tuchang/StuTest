package control;

import model.CourseDatabase;
import model.GradeDatabase;
import model.Roster;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by tuchang on 27/02/2017.
 */
public class CourseListener {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    CourseDatabase courseModel = (CourseDatabase) applicationContext.getBean("courseModel");
    GradeDatabase gradeModel = (GradeDatabase) applicationContext.getBean("gradeModel");
    Roster rosterModel = (Roster) applicationContext.getBean("rosterModel");
    public void createCourse(Vector dataVector)
    {
        try{
            if (courseModel.createCourse(dataVector))
            {
                JOptionPane.showMessageDialog(new JFrame(), "添加课程信息成功", "提示", JOptionPane.WARNING_MESSAGE);
            }
        else{
                JOptionPane.showMessageDialog(new JFrame(), "添加课程信息失败", "提示", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "添加课程信息失败", "提示", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void changeCourse(Vector dataVector)
    {
        try {
            if (courseModel.changeCourse(dataVector))
            {
                JOptionPane.showMessageDialog(new JFrame(), "修改课程信息成功", "提示", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(new JFrame(), "修改课程信息失败", "提示", JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "修改课程信息失败", "提示", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void setGrade(Vector dataVector)
    {
        try{
            int mark = -1;
            mark=gradeModel.setGrade(dataVector);
            if (mark==0){
                JOptionPane.showMessageDialog(new JFrame(), "设置成绩成功", "提示", JOptionPane.WARNING_MESSAGE);
            }
            else if(mark==1){
                JOptionPane.showMessageDialog(new JFrame(), "修改成绩成功", "提示", JOptionPane.WARNING_MESSAGE);
            }
            else if (mark==-1)
            {
                JOptionPane.showMessageDialog(new JFrame(), "设置成绩失败", "提示", JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(new JFrame(), "设置成绩失败", "提示", JOptionPane.WARNING_MESSAGE);
        }

    }

    public String[][] getGrade(int id)
    {
        String[][] temp = gradeModel.getGrade(id);
        String[][] gradeItem = new String[temp.length][4] ;
        for (int i=0; i<temp.length;i++)
        {
            gradeItem[i][0] = temp[i][0];
            gradeItem[i][1] = temp[i][1];
            gradeItem[i][2] = String.valueOf(id);
            gradeItem[i][3] = temp[i][2];
//            System.out.print("temp[i][0]:"+temp[i][0]);
        }

        return gradeItem;
    }

    public String[][] queryCourse(int id,int type)
    {
        return courseModel.queryCourse(id,type);
    }

    public boolean addCourse(int stu_id,int course_id)
    {
        return courseModel.addCourse(stu_id,course_id);
    }

    public boolean output(int course_id)
    {
        try{
            if (rosterModel.output(course_id))
            {
                JOptionPane.showMessageDialog(new JFrame(), "导出成功", "提示", JOptionPane.WARNING_MESSAGE);
                return true;
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "导出失败", "提示", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "导出失败", "提示", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }
}
