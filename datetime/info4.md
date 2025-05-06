

# DateTime part-4

> Codes are in `partFour` package


## Clocks
- Provides access to the current `instant`, `date`, and `time` in a time `zone`,
- You can extend the `Clock` class to implement your own clock,
- Ex: See `testClock()` in `Test.java`,
    ```
    Clock clock = Clock.systemDefaultZone();
    Clock clock1 = Clock.system(ZoneId.of("+06:00")); 
    
    System.out.println( clock.getZone() ); // Asia/Dhaka
    System.out.println( clock.instant() ); // 2023-08-17T09:10:14.911558100Z <---- UTC
    System.out.println( clock.millis() ); // 1692263414911
    
    
    LocalDateTime ldt = LocalDateTime.now(clock);
    System.out.println( ldt ); // 2023-08-17T15:10:14.911558100 <----- system time
    ```


## Period & Duration
- Amount of time in terms of calendar fields `years`, `months`, and `days`. Whereas `Duration` is also an amount of time in terms of `seconds` and `nanoseconds`,
- `Negative periods` are supported,
- `Duration` represents an `exact number of nanoseconds`, whereas `Period` represents an `inexact amount of time`,
- `Period` is for `humans` what a `Duration` is for `machines`,
- For example: `2 months` is a period since this is not exact. It can be `59`,`60`,`61` days,
- `Additions`, `subtractions`, `multiplications`, and `negation` can be performed on a period,
- Object is created using `static factory method`,
- When you add a `period of one day` to a `ZonedDateTime`, the `date component` changes to the `next day`, keeping the `time the same`. But,
- When you add a `duration of a day`, it will always add `24 hours`,
- `normalized()` method of the `Period` class to normalize the `years` and `months` only,
- Ex(`Period`): See `testPeriod()` in `Test.java`,
  ```
  private static void testPeriod(){  
      Period period;
      period = Period.of(1,1,1);
      System.out.println( period ); // P1Y1M1D <--- 1year 1month 1day
  
      period = Period.ofDays(10);
      System.out.println( period ); // P10D <--- 10days
  
      period = period.negated();
      System.out.println( period ); // P-10D
  
      period = period.negated();
      System.out.println( period ); // P10D
  
      period = period.plusMonths(16);
      System.out.println( period ); // P16M10D
  
      period = period.minusMonths(4);
      System.out.println( period ); // P12M10D
  
      period = period.multipliedBy(2);
      System.out.println( period ); // P24M20D
  
      period = period.normalized();
      System.out.println( period ); // P2Y20D <-- only year & month are normalized  
  }
  ```
- Ex(`Duration`): See `testDuration()` in `Test.java`,
  ```
  private static void testDuration(){
  
      Duration duration;
      duration = Duration.ofDays(10);
      System.out.println( duration ); // PT240H
  
      duration = duration.negated();
      System.out.println( duration ); // PT-240H
  
      duration = duration.negated();
      System.out.println( duration ); // PT-240H
  
      duration = duration.plusMinutes(160);
      System.out.println( duration ); // PT242H40M
  
      duration = duration.minusMinutes(20);
      System.out.println( duration ); // PT242H20M
  
      duration = duration.multipliedBy(2);
      System.out.println( duration ); // PT484H40M
  }
  ```

## Period Between Two Dates and Times
- For computing amount of time elapsed between two `dates`, `times`, and `datetime`,
- There are two ways:
  - `between()` method on one of the constants in the `ChronoUnit` enum,
    - Returns the amount of time elapsed from the `first` argument to the `second` argument,
    - Will return `negative` is `2nd` argument is before `1st`,
  - `until()` method on one of the datetime-related classes,
- It isn't always possible to compute the amount of time elapsed between two dates and times. For example:
  - `Hours` between a `LocalDate` and a `LocalDateTime` not possible, since `LocalDate` doesn't have `hours`, 
  - If such parameters are passed to the methods, a `runtime exception` is thrown,
- For calculating, specified `end date/time` should be `convertible` to the start `date/time`,
- Ex: See `calculateElapsed()` in `Test.java`,
  ```
  private static void calculateElapsed(){
  
      LocalTime t1 = LocalTime.of(7,12);
      LocalTime t2 = LocalTime.of(11,12);
  
      long hours = t1.until(t2, ChronoUnit.HOURS);
      System.out.println( hours ); // 4
  
      long hrs = ChronoUnit.HOURS.between(t1,t2);
      System.out.println( hrs ); // 4
  
  }
  ```

## Partials
- A partial is a `date`, `time`, or `datetime` that doesn't fully specify an `instant` on a timeline,
- Makes sense to `humans`,
- `LocalDate`, `LocalTime`, `LocalDateTime`, and `OffsetTime` are examples of `partials` since they can't be converted to `Instant`. But,
- `OffsetDateTime` and `ZonedDateTime` aren't partials. Since they can be converted into `Instant` without providing extra info,
- We have some other partials like for expressing Birthday(Has only Day & Month),
- `3` more partials are:
  - `Year`:
    - Represent only year,
  - `YearMonth`:
    - Represent `Year` and `Month` both,
  - `MonthDay`:
    - Represent `Month` and `Day`,
- Ex: See `calculateDayName()` in `Test.java`,
  ```
  private static void calculateDayName(){
      MonthDay spDate = MonthDay.of(Month.AUGUST,17);
  
      Year year = Year.of(2023);
  
      for(int i=0; i<5; i++){
  
          LocalDate date = year.plusYears(i).atMonthDay(spDate);
  
          String strDate = date.toString();
          String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
          System.out.println(strDate+" -> "+dayName);
      }
  }
  ```
  Output:
  ```
  2023-08-17 -> Thursday
  2024-08-17 -> Saturday
  2025-08-17 -> Sunday
  2026-08-17 -> Monday
  2027-08-17 -> Tuesday
  ```

### Temporal = Something related to date and time

## Adjusting Dates
- Sometimes we need to find date of `first Monday of the month`, `the next Tuesday` etc,
- Can be done using `TemporalAdjuster` interface,
- Ex:
  ```
  LocalDate localDate = LocalDate.of(2023,Month.AUGUST,17);
  
  LocalDate localDate1 = localDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
  System.out.println(localDate1); // 2023-08-19
  
  LocalDate localDate2 = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
  System.out.println(localDate2); // 2023-08-17
  
  LocalDate localDate3 = localDate.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
  System.out.println(localDate3); // 2023-08-24
  
  LocalDate localDate4 = localDate3.with(TemporalAdjusters.lastDayOfMonth());
  System.out.println(localDate4); // 2023-08-31
  ```
