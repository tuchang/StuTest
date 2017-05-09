package Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by tuchang on 28/02/2017.
 */
public class FilepathTest {
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("")+"../../../NoticeArchive");
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("")+"../../../NoticeArchive"+1);
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("")+"../../../RosterArchive/名册模板.xls");

        String path = null;
        path=Thread.currentThread().getContextClassLoader().getResource("")+"..\\..\\..\\RosterArchive\\名册模板.xls";
        if(path.contains("file:"))
        {
            URL url = FileTest.class.getResource("");
            try {
                path = new File(url.toURI()).getAbsolutePath()+"/../../../../RosterArchive/";
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        System.out.println(path);
        //System.out.println((int) null + 1);


    }

}
