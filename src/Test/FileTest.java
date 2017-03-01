package Test;

import java.io.*;

/**
 * Created by tuchang on 01/03/2017.
 * /Users/tuchang/IdeaProjects/StuTest/out/production/StuTest/../../../NoticeArive/1.txt
 */
public class FileTest {
    public static void main(String[] args) {
        String path = "/Users/tuchang/IdeaProjects/StuTest/out/production/StuTest/../../../NoticeArive/a.txt";
        File file = new File(path);
        try {

            if (!file.exists()) {
                System.out.println(path);
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            //fos.write("heihei.".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
