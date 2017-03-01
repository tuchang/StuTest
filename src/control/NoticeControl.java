package control;

import model.NoticeDatabase;

import java.io.*;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by tuchang on 27/02/2017.
 */
public class NoticeControl {
    public void createNotice(String title, String content)
    {

        //System.out.println(title);
        //System.out.println(content);

        String path = new Thread().currentThread().getContextClassLoader().getResource("")+"../../../NoticeArive/"+ calculateId()+".txt";
        String abstractString = null;

        if (content.length()>20)
        {
            abstractString = content.substring(20)+"...";
        }
        else
            abstractString = content;

        String[] input = new String[5];
        input[0] = title;
        input[1] = abstractString;
        input[2] = LocalDate.now().toString()+"-"+ LocalTime.now().toString();
        input[3] = input[2];
        input[4] = path;

        File outFile = new File(path);
        try {

            if (!outFile.exists())
            {
                outFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(outFile);
            fos.write(content.getBytes());
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new NoticeDatabase().createNotice(input);





    }

    public void changeNotice(int id,String title,String content)
    {
        String path = new NoticeDatabase().getPath(id);
        String abstractString;
        if (content.length()>20)
        {
            abstractString = content.substring(20)+"...";
        }
        else
            abstractString = content;

        String[] input = new String[3];
        input[0] = title;
        input[1] = abstractString;
        input[2] = LocalDate.now().toString()+"-"+ LocalTime.now().toString();

        File outFile = new File(path);


        try {

            if (!outFile.exists())
            {
                System.out.println(path);
                outFile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(outFile);
            fos.write(content.getBytes());
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new NoticeDatabase().changeNotice(input,id);


    }

    public String[][] showNotice()
    {

        return new NoticeDatabase().showNotice();
    }

    public String watchNotice(int id)
    {
        String path = new NoticeDatabase().watchNotice(id);
        File f = new File(path);

        try {
            FileInputStream fis = new FileInputStream(f);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();
            String content = new String(b);
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private int calculateId()
    {
        return new NoticeDatabase().getMaxId()+1;
    }

}
