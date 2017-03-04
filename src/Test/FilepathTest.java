package Test;

/**
 * Created by tuchang on 28/02/2017.
 */
public class FilepathTest {
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("")+"../../../NoticeArive");
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("")+"../../../NoticeArive"+1);

        //System.out.println((int) null + 1);


    }

}
