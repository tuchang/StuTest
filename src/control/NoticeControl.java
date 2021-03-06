package control;

import Test.FileTest;
import model.NoticeDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by tuchang on 27/02/2017.
 */
public class NoticeControl {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    NoticeDatabase noticeModel = (NoticeDatabase) applicationContext.getBean("noticeModel");
    public void createNotice(String title, String content)
    {
        String path = new Thread().currentThread().getContextClassLoader().getResource("")+"../../../NoticeArchive/"+ calculateId()+".txt";
        //获得当前路径后前面会有一段file: 需要去掉 不然mac端无法createNewFile
        if(path.contains("file:"))
        {
            URL url = FileTest.class.getResource("");
            try {
                path = new File(url.toURI()).getAbsolutePath()+"/../../../../NoticeArchive/"+ calculateId()+".txt";
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
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
        File outFile = new File(path);
        try {
            if (!outFile.exists())
            {
                outFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(outFile);
            fos.write(content.getBytes());
            fos.close();
            input[4] = outFile.getCanonicalPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        noticeModel.createNotice(input);
    }
    public void changeNotice(int id,String title,String content)
    {
        String path = noticeModel.getPath(id);
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
        noticeModel.changeNotice(input,id);
    }
    public String[][] showNotice()
    {
        return noticeModel.showNotice();
    }
    public String watchNotice(int id)
    {
        String path = noticeModel.watchNotice(id);
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
        return noticeModel.getMaxId()+1;
    }
}
//        if(path.contains("file:"))
//        {
//            path.replace("file:","");
//            System.out.println(path);
//        }