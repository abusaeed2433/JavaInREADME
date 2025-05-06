package datetime.part4;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {

        testClock();
        testPeriod();
        testDuration();
//        pdConversion();
        calculateElapsed();
        calculateDayName();
        testAdjuster();
    }

    private static void testAdjuster(){
        System.out.println("---------------- testAdjuster ------------------------------");

        LocalDate localDate = LocalDate.of(2023,Month.AUGUST,17);

        LocalDate localDate1 = localDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(localDate1); // 2023-08-19

        LocalDate localDate2 = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
        System.out.println(localDate2); // 2023-08-17

        LocalDate localDate3 = localDate.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        System.out.println(localDate3); // 2023-08-24

        LocalDate localDate4 = localDate3.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localDate4); // 2023-08-31
    }

    private static void calculateDayName(){
        System.out.println("------------------ calculateDayName -------------------------");

        MonthDay spDate = MonthDay.of(Month.AUGUST,17);

        Year year = Year.of(2023);

        for(int i=0; i<5; i++){

            LocalDate date = year.plusYears(i).atMonthDay(spDate);

            String strDate = date.toString();
            String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);

            System.out.println(strDate+" -> "+dayName);
        }

        /*
        2023-08-17 -> Thursday
        2024-08-17 -> Saturday
        2025-08-17 -> Sunday
        2026-08-17 -> Monday
        2027-08-17 -> Tuesday
        */

    }

    private static void calculateElapsed(){
        System.out.println("------------------- calculateElapsed -------------------");

        LocalTime t1 = LocalTime.of(7,12);
        LocalTime t2 = LocalTime.of(11,12);

        long hours = t1.until(t2, ChronoUnit.HOURS);
        System.out.println( hours ); // 4

        long hrs = ChronoUnit.HOURS.between(t1,t2);
        System.out.println( hrs ); // 4

    }

    private static void pdConversion(){ // error
        System.out.println("------------------ pdConversion ------------------------");

        Duration duration = Duration.ofDays(10);

        // duration to period
        Period period = Period.from(duration);
        System.out.println(period);

        // period to duration
        duration = Duration.from(period);
        System.out.println( duration );

    }

    private static void testDuration(){
        System.out.println("---------------- testDuration() ----------------");

        Duration duration;
        duration = Duration.ofDays(10);
        System.out.println( duration ); // PT240H

        duration = duration.negated();
        System.out.println( duration ); // PT-240H

        duration = duration.negated();
        System.out.println( duration ); // PT-240H

        System.out.println("-----------------------");

        duration = duration.plusMinutes(160);
        System.out.println( duration ); // PT242H40M

        duration = duration.minusMinutes(20);
        System.out.println( duration ); // PT242H20M

        duration = duration.multipliedBy(2);
        System.out.println( duration ); // PT484H40M

    }

    private static void testPeriod(){
        System.out.println("--------------- testPeriod ---------------------");

        Period period;
        period = Period.of(1,1,1);
        System.out.println( period ); // P1Y1M1D <--- 1year 1month 1day

        period = Period.ofDays(10);
        System.out.println( period ); // P10D <--- 10days

        period = period.negated();
        System.out.println( period ); // P-10D

        period = period.negated();
        System.out.println( period ); // P10D

        System.out.println("-----------------------");

        period = period.plusMonths(16);
        System.out.println( period ); // P16M10D

        period = period.minusMonths(4);
        System.out.println( period ); // P12M10D

        period = period.multipliedBy(2);
        System.out.println( period ); // P24M20D

        period = period.normalized();
        System.out.println( period ); // P2Y20D <-- only year & month are normalized

    }

    private static void testClock(){
        System.out.println("---------------- testClock ---------------------");

        Clock clock = Clock.systemDefaultZone();
        Clock clock1 = Clock.system(ZoneId.of("+06:00"));

        System.out.println( clock.getZone() ); // Asia/Dhaka
        System.out.println( clock.instant() ); // 2023-08-17T09:10:14.911558100Z <---- UTC
        System.out.println( clock.millis() ); // 1692263414911


        LocalDateTime ldt = LocalDateTime.now(clock);
        System.out.println( ldt ); // 2023-08-17T15:10:14.911558100 <----- system time



    }

}
