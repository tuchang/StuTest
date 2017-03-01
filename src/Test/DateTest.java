package Test;

import sun.util.resources.LocaleData;

import java.text.DateFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

/**
 * Created by tuchang on 28/02/2017.
 */
public class DateTest {
    public static void main(String[] args)
    {
        Date today = new Date();

        System.out.println(today.toLocaleString());
        System.out.println(today.getTime());
        System.out.println(today.toString());
        System.out.println(today.toInstant());

        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        System.out.println(LocalTime.now());



    }
}
