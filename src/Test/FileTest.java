package Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by tuchang on 01/03/2017.
 * /Users/tuchang/IdeaProjects/StuTest/out/production/StuTest/../../../NoticeArive/1.txt
 */
public class FileTest {
    public static void main(String[] args) {
        //String path = "/Users/tuchang/IdeaProjects/StuTest/out/production/StuTest/../../../NoticeArchive/a.txt";
        String path = "file:/Users/tuchang/IdeaProjects/StuTest/out/production/StuTest/../../../NoticeArchive/a.txt";
        File file = new File(path);
        try {

            if (!file.exists()) {
                //System.out.println(path);
                //file.createNewFile();
            }

//            System.out.println(file);


            System.out.println(file.getAbsolutePath());

            System.out.println(file.getPath());
            System.out.println(file.toPath());
            System.out.println(file.getCanonicalPath());


            String downloadPath = null;
            URL url = FileTest.class.getResource("");
            downloadPath = new File(url.toURI()).getAbsolutePath();


            //System.out.println(new File(((URL)path).toURI()).getAbsolutePath());

            System.out.println("url=" + url);
            System.out.println(new File(url.toURI()).getAbsolutePath());
            System.out.println("dPath=" + downloadPath);
            System.out.println("dPath=" + downloadPath+"/../../../../");


//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write("heihei.".getBytes());
//            fos.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
