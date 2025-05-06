package datetime.part6;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {
        testParse();
    }

    private static void testParse(){

        {
            System.out.println("-------- parse() method of the datetime class --------------");

            String strDate = "2023-08-17";

            LocalDate localDate = LocalDate.parse(strDate);
            System.out.println(localDate); // 2023-08-17

            strDate = "2023-W33-4"; // this format is discussed in previous section
            LocalDate localDate1 = LocalDate.parse(strDate,DateTimeFormatter.ISO_WEEK_DATE);
            System.out.println(localDate1); // 2023-08-17


        }

        {
            System.out.println("-------------- using parse() of DateTimeFormatter class, -------------------");
            String pattern = "yyyy-MM-dd";
            String strDate = "2023-08-17";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.US);
            TemporalAccessor ta = formatter.parse(strDate);

            LocalDate localDate = LocalDate.from(ta);
            System.out.println(localDate); // 2023-08-17

            String pattern1 = "dd/MM/yyyy";
            String strDate1 = "17/08/2023";

            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(pattern1);
            TemporalAccessor ta1 = formatter1.parse(strDate1);

            LocalDate localDate1 = LocalDate.from(ta1);
            System.out.println(localDate1); // 2023-08-17

        }

    }

}
