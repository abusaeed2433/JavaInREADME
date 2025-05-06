package datetime.part5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        testFormatter();
        localeSpecific();

    }


    private static void localeSpecific(){
        System.out.println("--------------------- localeSpecific ---------------------");

        LocalDate ld = LocalDate.of(2023, Month.AUGUST, 17);

        DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println( fmt.format(ld) ); // 8/17/23


        LocalTime localTime = LocalTime.of(11,12,13);

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println( formatter.format(localTime) );


        LocalDateTime ldt = LocalDateTime.of(ld,localTime);

        ZonedDateTime zdt = ldt.atZone(ZoneId.of("+06:00"));

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        System.out.println( formatter1.format(zdt) ); // Thursday, August 17, 2023 at 11:12:13 AM +06:00

    }


    private static void testFormatter(){
        System.out.println("------------------- testFormatter ---------------------------");

        {
            System.out.println("----------- Using pre-defined standard datetime formatters -----------");
            LocalDate date = LocalDate.of(2023, Month.AUGUST,17);

            String strDate;

            strDate = DateTimeFormatter.ISO_DATE.format(date);
            System.out.println( strDate ); // 2023-08-17

            strDate = DateTimeFormatter.ISO_WEEK_DATE.format(date);
            System.out.println( strDate ); // 2023-W33-4 <----- 33 weeks 4 days

            //strDate = DateTimeFormatter.ISO_TIME.format(date); // Runtime error. since date doesn't have time component

            LocalTime time = LocalTime.of(11,12,13);
            String strTime = DateTimeFormatter.ISO_TIME.format(time);

            System.out.println( strTime ); // 11:12:13

        }

        {
            System.out.println("----------- Using the format() method of the datetime classes -----------");

            LocalDate date = LocalDate.of(2023, Month.AUGUST,17);
            String strDate;

            strDate = date.format(DateTimeFormatter.ISO_DATE);
            System.out.println(strDate); // 2023-08-17

            strDate = date.format(DateTimeFormatter.ISO_WEEK_DATE);
            System.out.println(strDate); // 2023-W33-4

            LocalTime time = LocalTime.of(11,12,13);
            String strTime = time.format(DateTimeFormatter.ISO_TIME);
            System.out.println(strTime); // 11:12:13

        }

        {
            System.out.println("----------- Using user-defined patterns -----------");

            LocalDate date = LocalDate.of(2023, Month.AUGUST,17);

            String pattern = "ddMMM yy";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            String strDate = formatter.format(date);
            System.out.println(strDate); // 17Aug 23


            LocalDateTime ldt = LocalDateTime.of(2023,Month.AUGUST,17,19,16);

            String fullPattern = "ddMM yy 'at' hh:mm:ssa";
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(fullPattern);

            String formatted = formatter1.format(ldt);
            System.out.println(formatted); // 1708 23 at 07:16:00PM

        }

        {
            System.out.println("----------- Using the DateTimeFormatterBuilder class -----------");
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendLiteral("My birthday in ")
                    .appendValue(ChronoField.YEAR)
                    .appendLiteral(" is not on ")
                    .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
                    .toFormatter();

            LocalDate ld = LocalDate.of(2023, Month.MARCH, 22);
            String str = ld.format(formatter);
            System.out.println(str); // My birthday in 2023 is not on Wednesday
        }

    }

}
