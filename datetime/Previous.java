package datetime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Previous {

    public static void main(String[] args) {
        //new Test().start();
        //new Test().start2();
        //new Test().start3();;
        //new Test().printAllZone();
        //new Test().start4();
        //new Test().exceptionalCase();
        //new Test().zoneConvert();
        //new Test().betweenTest();
        //new Test().printDec25DayName();
        //new Test().testOldDate();
        //new Test().timestampTest();
        //String time = "06:00PM";
        //System.out.println( new Test().getTimeStamp(time) );
        new Previous().timeTest();
    }

    private void timeTest(){
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour());
    }

    private long getTimeStamp(String time){
        try{
            String pattern = "hh:mma";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            TemporalAccessor ta = formatter.parse(time);
            LocalTime localTime = LocalTime.from(ta);

            return localTime.getLong(ChronoField.MINUTE_OF_DAY);

        }catch (Exception e){
            e.printStackTrace();
            return Long.MAX_VALUE;
        }
    }


    private void timestampTest(){
        LocalTime localTime = LocalTime.now();
        long ms = localTime.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(ms);
    }

    private void testOldDate(){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        String formattedDate = formatter.format(today);

        System.out.println("(dd/MM/yyyy): " + formattedDate);

        formatter.applyPattern("MMMM dd, yyyy");

        formattedDate = formatter.format(today);

        System.out.println("(MMMM dd, yyyy): " + formattedDate);

        /*
         *
         * Locale US
         * (dd/MM/yyyy): 10/12/2022
         * (MMMM dd, yyyy): December 10, 2022
         *
         * Locale CHINA
         * (dd/MM/yyyy): 10/12/2022
         * (MMMM dd, yyyy): ??? 10, 2022
         *
         * Locale JAPAN
         * (dd/MM/yyyy): 10/12/2022
         * (MMMM dd, yyyy): 12? 10, 2022
         */

    }

    private void printDec25DayName(){

        try{

        }
        catch (ArithmeticException | NullPointerException e){
            e.printStackTrace();
        }

        MonthDay dec25 = MonthDay.of(12,25);
        Year year = Year.of(2015);

        for(int i=0;i<5;i++){
            LocalDate localDate = year.plusYears(i).atMonthDay(dec25);
            System.out.println("25 dec at " + year.plusYears(i) + " is " + localDate.getDayOfWeek());
        }

        /*
            25 dec at 2015 is FRIDAY
            25 dec at 2016 is SUNDAY
            25 dec at 2017 is MONDAY
            25 dec at 2018 is TUESDAY
            25 dec at 2019 is WEDNESDAY
        */

    }

    private void betweenTest(){
        LocalDateTime ldt = LocalDateTime.of(2002,Month.MARCH,21,15,15);
        LocalDateTime ldt2 = LocalDateTime.now();


        long dif = ChronoUnit.DAYS.between(ldt,ldt2); // 7555

        System.out.println(dif);

    }

    private void zoneConvert(){
        ZoneId zoneId = ZoneId.of("America/Chicago");

        LocalDateTime ldt = LocalDateTime.of(2022,11,24,11,30);

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt.toString()); // 2022-11-25T23:43:37.027292300+06:00[Asia/Dhaka]

        //will convert it into america time

        Instant instant = zdt.toInstant();
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant,zoneId);
        System.out.println(zdt2.toString()); // 2022-11-25T11:43:37.027292300-06:00[America/Chicago]

        ZonedDateTime zdt3 = zdt.withZoneSameInstant(zoneId);
        System.out.println(zdt3.toString()); // 2022-11-25T11:43:37.027292300-06:00[America/Chicago]

        // 2022-11-25T23:43:37.027292300+06:00[Asia/Dhaka]
        // 2022-11-25T11:43:37.027292300-06:00[America/Chicago]
        // 12 hour difference, +6 dhaka and -6 america

    }

    private void exceptionalCase(){
        ZoneId zoneId = ZoneId.of("America/Chicago");
        LocalDateTime ldt = LocalDateTime.of(2013,Month.MARCH,10,2,30);
        ZonedDateTime zdt = ZonedDateTime.of(ldt,zoneId);
        System.out.println(zdt.toLocalTime().toString()); // Local time 03:30, 1 hour is added because 2:30 didn't exist in real life

        LocalDateTime ldt2 = LocalDateTime.of(2013,Month.NOVEMBER,3,1,30); // this time was twice in real life
        ZonedDateTime zdt2 = ZonedDateTime.of(ldt2,zoneId);
        System.out.println(zdt2.getOffset()); // -05:00, earlier offset is used by default

        System.out.println(zdt2.withEarlierOffsetAtOverlap().getOffset()); // -05:00
        System.out.println(zdt2.withLaterOffsetAtOverlap().getOffset()); // -06:00

    }

    private void start4(){
        ZoneId zoneId = ZoneId.of("Asia/Dhaka"); // throw ZoneRulesException Unknown time-zone ID if zone not found
        ZoneRules rules = zoneId.getRules();
        System.out.println(rules.getOffset(LocalDateTime.now())); // +06:00
        List<ZoneOffsetTransition> list = rules.getTransitions();
        for(ZoneOffsetTransition tr : list){
            System.out.println(tr);
        }

        /*
        Transition[Overlap at 1890-01-01T00:00+06:01:40 to +05:53:20]
        Transition[Gap at 1941-10-01T00:00+05:53:20 to +06:30]
        Transition[Overlap at 1942-05-15T00:00+06:30 to +05:30]
        Transition[Gap at 1942-09-01T00:00+05:30 to +06:30]
        Transition[Overlap at 1951-09-30T00:00+06:30 to +06:00]
        Transition[Gap at 2009-06-19T23:00+06:00 to +07:00]
        Transition[Overlap at 2010-01-01T00:00+07:00 to +06:00]
        */
        //ignore all of this, not needed anything for me at least

    }

    private void start(){
        LocalDate date = LocalDate.now();;
        System.out.println(date.toString()); // 2022-11-25 -> yyyy-mm-dd

        LocalTime lt = LocalTime.now();
        System.out.println(lt.toString()); // 10:25:04.786477300 -> hh:mm:ss.sssss

        OffsetTime time = OffsetTime.now();
        System.out.println(time.toString()); // 19:42:32.779731600+06:00

        OffsetDateTime odt = OffsetDateTime.now();
        Instant instant = odt.toInstant();
        System.out.println(odt.toString()); // 2022-11-25T19:46:17.381516600+06:00, 19ok
        System.out.println(instant); // 2022-11-25T13:44:53.533278200Z, 13 is shown instead 19, 13+6 = 19, look just after T

        // so Instant is zone independent, proved

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.toString()); // 2022-11-25T10:26:27.192953300 yyyy-mm-dd T hh:mm:ss.sss, T = time(?)

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt.toString()); // 2022-11-25T10:27:56.365880+06:00[Asia/Dhaka], yyyy-mm-dd T hh:mm:ss.sssss +GMT


        System.out.println(" - -- - - - - -- - - -");
        LocalDate ld = LocalDate.of(2002, Month.MARCH,21);
        LocalDate ld2 = LocalDate.of(2002, 3,21);
        System.out.println(ld.toString());  // 2002-03-21
        System.out.println(ld2.toString()); // 2002-03-21 same as above

        LocalDate ld3 = LocalDate.ofEpochDay(0); // 1970-01-01
        System.out.println(ld3.toString());

        LocalDate ld4 = LocalDate.ofEpochDay(365);
        System.out.println(ld4.toString()); // 1971-01-01

        LocalDate ld5 = LocalDate.ofEpochDay(-365);
        System.out.println(ld5.toString()); // 1969-01-01

        // .ofEpochDay(int offset), offset is from 1970-01-01

        LocalDate ld6 = LocalDate.ofYearDay(2002,80);
        System.out.println(ld6.toString()); // 2002-03-21

        System.out.println(" -- - - - - -- - - ");

    }

    private void start2(){
        LocalDateTime ldt = LocalDateTime.of(2002,Month.MARCH,21,15,0,15);
        LocalDate ld = LocalDate.from(ldt);
        System.out.println(ld.toString()); // 2002-03-21

        LocalTime lt = LocalTime.from(ldt); // crash is ld is used in parameter as expected
        System.out.println(lt.toString()); // 15:00:15

        System.out.println(" - - -- - - - - - ");
        LocalDate ld1 = LocalDate.of(2003,3,1);
        LocalDate ld2 = ld1.withYear(2001).withDayOfMonth(21);
        System.out.println(ld2.toString()); // 2001-03-21

        LocalTime lt1 = LocalTime.of(14,15,5);
        LocalTime lt2 = lt1.withHour(15).withSecond(15);
        System.out.println(lt2.toString()); // 15:15:15

        long daySinceJan1970 = ld2.toEpochDay();
        System.out.println(daySinceJan1970); // 11402

        LocalDateTime ldt2 = LocalDateTime.of(2002,3,21,15,15,15);
        // dayOfMonth must be valid i.e. must be <= number of days in given month at given year
        // ex: February 29, april 31 crashes(DateTimeException) at year = 2002
        System.out.println(ldt2.toString()); // 2002-03-21T15:15:15

        LocalDate ld3 = ldt2.toLocalDate();
        LocalTime lt3 = ldt2.toLocalTime();
        System.out.println(ld3.toString()+"T"+lt3.toString()); // 2002-03-21T15:15:15

        System.out.println(" - -- - - - - - - ");

        LocalDate ld4 = LocalDate.of(2002,3,21);
        LocalDateTime ldt4 = ld4.atStartOfDay();
        System.out.println(ldt4.toString()); // 2002-03-21T00:00

        LocalDateTime ldt5 = ld4.atTime(15,15,15);
        System.out.println(ldt5.toString()); // 2002-03-21T15:15:15

        LocalDate ld6 = Year.of(2002).atMonth(Month.MARCH).atDay(21);
        System.out.println(ld6.toString()); // 2002-03-21

        System.out.println(" --- - -- multiplied by -- - - -");
        // not applicable to date time as expected, but applicable to,
        Duration duration = Duration.of(211, ChronoUnit.SECONDS);
        Duration duration1 = Duration.ofSeconds(211);
        System.out.println(duration.toString()); // PT3M31S
        System.out.println(duration1.toString()); // PT3M31S

        Duration duration2 = duration.multipliedBy(2);
        System.out.println(duration2.toString()); // PT7M2S

        Duration duration3 = duration2.negated();
        System.out.println(duration3.toString()); // PT-7M-2S




    }

    private void start3(){
        Instant instant = Instant.ofEpochSecond(86460);
        System.out.println(instant.toString()); // 1970-01-02T00:01:00Z

        Instant instant1 = Instant.ofEpochSecond(-86400);
        System.out.println(instant1.toString()); // 1969-12-31T00:00:00Z


        Instant i1 = Instant.ofEpochSecond(0);
        Instant i2 = Instant.ofEpochSecond(0);

        System.out.println("  -- - - - - -- -  ");
        System.out.println(i1.toString()); // 1970-01-01T00:00:00Z
        System.out.println(i2.toString()); // 1970-01-01T00:00:00Z

        System.out.println(i1.isBefore(i2)); // false

        Duration duration = Duration.ofSeconds(86400);

        i1.minus(duration);
        i2.plus(duration);

        System.out.println(i1.toString()); // 1970-01-01T00:00:00Z
        System.out.println(i2.toString()); // 1970-01-01T00:00:00Z
        System.out.println(i1.isBefore(i2)); // false, because of immutable. idiot, i1.minus(d) return object, and you are not using it, look below

        Instant i3 = i1.minus(duration);
        Instant i4 = i2.plus(duration);

        System.out.println(i3.toString()); // 1969-12-31T00:00:00Z
        System.out.println(i4.toString()); // 1970-01-02T00:00:00Z
        System.out.println(i3.isBefore(i4)); // true

    }

    private void printAllZone(){
        Set<String> zones = ZoneId.getAvailableZoneIds();
        System.out.println("Available zones are -> "+zones.size()); // 601 zones
        for(String zn : zones){
            System.out.println(zn);
        }

    }


}
