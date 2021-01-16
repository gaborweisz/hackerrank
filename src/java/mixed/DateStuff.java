package java.mixed;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by gabor on 2019.04.24..
 */
public class DateStuff {

    public static void main(String[] args) throws ParseException {

        LocalDate d1 = LocalDate.of(2015,8,5);
        LocalDate d2 =  LocalDate.parse("05/08/2015", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(d1.getDayOfWeek());
        System.out.println(d2.getDayOfWeek().toString());
    }
}
