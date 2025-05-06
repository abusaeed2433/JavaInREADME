package datetime.part3;

import java.time.*;

public class Test {

    public static void main(String[] args) {
        dateTimeDateTime();
        zoneTimeDateTime();
        testZonedDateTime();
        zoneConversion();
    }

    private static void zoneConversion(){
        System.out.println("-------------------- zoneConversion ------------------------");

        LocalDateTime ldt = LocalDateTime.of(2023, Month.MARCH, 14, 17, 30);
        ZoneId zoneSaudi = ZoneId.of("Asia/Riyadh");

        ZonedDateTime zdt = ZonedDateTime.of(ldt, zoneSaudi); // <------------------(1)
        System.out.println( zdt ); // 2023-03-14T17:30+03:00[Asia/Riyadh]

        ZoneId zoneDhaka = ZoneId.of("Asia/Dhaka");
        ZonedDateTime zdt2 = zdt.withZoneSameInstant(zoneDhaka); // <---------------(2)
        System.out.println( zdt2 ); // 2023-03-14T20:30+06:00[Asia/Dhaka]

        ZonedDateTime zdt3 = zdt.withZoneSameInstant(ZoneId.of("Z")); // utc
        System.out.println( zdt3 ); // 2023-03-14T14:30Z
    }

    private static void testZonedDateTime(){
        System.out.println("---------------- testZonedDateTime -----------------------");

        ZoneId zoneId = ZoneId.of("+06:00");

        ZonedDateTime zdt = ZonedDateTime.of(2023,3,21,11,12,12,0,zoneId);
        System.out.println( zdt ); // 2023-03-21T11:12:12+06:00

        ZoneOffset offset = zdt.getOffset();
        System.out.println( offset ); // +06:00

        ZoneId id = zdt.getZone();
        System.out.println( id ); // +06:00

        LocalDate localDate = zdt.toLocalDate();
        System.out.println( localDate ); // 2023-03-21

        LocalTime localTime = zdt.toLocalTime();
        System.out.println( localTime ); // 11:12:12

        OffsetDateTime offsetTime = zdt.toOffsetDateTime();
        System.out.println( offsetTime ); // 2023-03-21T11:12:12+06:00

        LocalDateTime localDateTime = zdt.toLocalDateTime();
        System.out.println( localDateTime ); // 2023-03-21T11:12:12

    }

    private static void zoneTimeDateTime(){
        System.out.println("---------------- zoneTimeDateTime ------------------------");

        ZoneOffset zone = ZoneOffset.of("+06:00");

        OffsetTime time = OffsetTime.of(11,12,13,0,zone);
        System.out.println( time ); // 11:12:13+06:00

        LocalTime localTime = time.toLocalTime();
        System.out.println( localTime ); // 11:12:13

        OffsetDateTime offsetDateTime = OffsetDateTime.of(2023,3,23,11,12,13,0,zone);
        System.out.println( offsetDateTime ); // 2023-03-23T11:12:13+06:00

        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
        System.out.println( localDateTime ); // 2023-03-23T11:12:13

        LocalDate localDate = offsetDateTime.toLocalDate();
        System.out.println( localDate ); // 2023-03-23

        LocalTime localTime1 = offsetDateTime.toLocalTime();
        System.out.println( localTime1 ); // 11:12:13

        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(2023,3,23,11,12,13,0,zone);
        System.out.println( offsetDateTime1 ); // 2023-03-23T11:12:13+06:00

        Instant instant = offsetDateTime1.toInstant(); // UTC so, 6 is subtracted
        System.out.println( instant ); // 2023-03-23T05:12:13Z

    }

    private static void dateTimeDateTime(){
        System.out.println("------------------ dateTimeDateTime ----------------------");

        LocalDate date = LocalDate.of(2023, Month.MARCH, 23);
        System.out.println( date ); // 2023-03-23

        LocalDate date1 = date.plusDays(20);
        System.out.println( date1 ); // 2023-04-12

        LocalTime time = LocalTime.of(11,12,13);
        System.out.println( time ); // 11:12:13

        LocalTime time1 = time.plusHours(14);
        System.out.println(time1); // 01:12:13

        LocalDateTime dateTime = LocalDateTime.of(2023,Month.MARCH,23,11,12,13);
        System.out.println( dateTime ); // 2023-03-23T11:12:13

        LocalDateTime dateTime1 = dateTime.plusMonths(23);
        System.out.println( dateTime1 ); // 2025-02-23T11:12:13

        LocalDate date2 = LocalDate.from(dateTime1); // dateTime has date component
        System.out.println( date2 );

        LocalTime time2 = LocalTime.from(dateTime1); // dateTime has time component
        System.out.println( time2 );

    }

}
