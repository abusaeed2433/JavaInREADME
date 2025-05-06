
# DateTime part-1

> Codes are in `partOne` package


## Introduction
- `Java 8` introduced a new `Date-Time API`,
- Before this new API, there was `Legacy Date-Time API`,
- `Legacy Date-Time API`:
  - Includes classes like:
    - `Date`, 
    - `Calendar`, 
    - `GregorianCalendar`
  - Available in `java.util` and `java.sql` packages,
  - Some issues with the legacy Date-Time API are:
    - A `date` always had two components: `a date` and `a time`. No option for using one separately,
    - Manipulating dates were complex,
    - `Mutable` and therefore `not thread-safe`,
 
## `The New Date-Time API`:
- `Correct`, `powerful`, and `extensible` Date-Time API,
- It consists of about `80` classes,
- `15` classes are enough for using effectively,
- Has a separate set of classes to deal with `machine-based time` and `calendar-based human time`,
- Lets you convert `machine-based time` to `human-based time` and vice versa,
- Most `classes` are `immutable`,
- Doesn't provide public `constructors`,
- They allow creating object via `static factory methods` like,
  - `of()`, `ofXxx()`, and `from()`,

## Exploring the New Date-Time API
- Contains large number of classes,
- Naming convention of methods help understand the API tremendously,
- Methods starting with the same prefix do the similar work,
- All `classes`, `interfaces`, and `enums` for the `Date-Time API` are in `java.time` package,
- Some frequently used classes of `java.time` package are:
  - `LocalDate`: Only `Date`,
  - `LocalTime`: Only `Time`,
  - `LocalDateTime`: `Date` and `Time`,
  - `ZonedDateTime`: `Date`, `Time` and `Zone`,
  - `Period`: Deals with `years`, `months`, and `days` & their operation,
  - `Duration`: Represents a period of time in terms of `seconds` and `nanoseconds`,
  - `Instant`: Represents a `specific point` in time,
- `4` of its subpackages are:
  - `java.time.chrono`:
    - Contains classes supporting `non-ISO calendar` systems like `Hijrah calendar`, `ThaiBuddhist calendar`,
  - `java.time.format`:
    - Contains classes for `formatting` and `parsing` `dates` and `times`,
    - `java.time.temporal`:
      - Contains classes for accessing `components of dates and times`,
      - Also contains classes that act like `date-time adjusters`,
    - `java.time.zone`: 
      - contains classes supporting time zones and zone rules
- Ex: See `basicExample()` in `Test.java`: (Will be explained later),
    ```
    private static void basicExample(){
        LocalDate ld = LocalDate.of(2023, Month.MARCH,23);
        System.out.println(ld); // 2023-03-23
    
        LocalDate newDate = ld.plusDays(9);
        System.out.println(newDate); // 2023-04-01
    
        System.out.println( newDate.getDayOfWeek() ); // SATURDAY
        System.out.println( newDate.getMonthValue() ); // 4
    }
    ```

## The `ofXXX()` Methods
- Allow creating object,
- Ex:
    ```
    LocalDate date1 = LocalDate.now();
    System.out.println(date1); // 2023-08-16

    LocalDate date2 = LocalDate.of(2023,4,23);
    System.out.println(date2); // 2023-04-23

    LocalDate date3 = LocalDate.ofEpochDay(1000); // epoch means time from Midnight January 1, 1970 UTC
    System.out.println(date3); // 1972-09-27

    LocalDate date4 = LocalDate.ofYearDay(2023,140);
    System.out.println(date4); // 2023-05-20
    ```
## The `from()` Methods
- A `static factory method`, similar to an `of()` method,
- Create object from another `argument`. `argument` should have necessary value for converting,
- Ex:
    ```
    LocalDate date6 = LocalDate.now();
    System.out.println(date6); // 2023-08-16

    LocalDate date7 = LocalDate.from(date6);
    System.out.println(date7); // 2023-08-16

    LocalDateTime ldt = LocalDateTime.now();
    System.out.println(ldt); // 2023-08-16T23:33:54.223464

    LocalDate date8 = LocalDate.from(ldt);
    System.out.println(date8); // 2023-08-16
    ```
    - Here `ldt` has `Date` component, so it can be used for creating `LocalDate` object,

## The `withXXX()` Methods
- Most classes in the Date-Time API are `immutable`,
- For changing some field you need to use something like `withXXX`,
- A `withXXX()` method `returns a copy` of an object with the `specified field changed`,
- Ex:
    ```
    LocalDate date9 = LocalDate.of(2023,Month.AUGUST,16);
    LocalDate date10 = date9.withYear(2024);
    System.out.println(date9); // 2023-08-16
    System.out.println(date10);// 2024-08-16
    
    LocalDate date11 = date9.withMonth(3);
    System.out.println(date11); // 2023-03-16
    ```

## The `getXXX()` Methods
- Returns the specified `component` of the object,
- Ex:
    ```
    LocalDate date = LocalDate.of(2023,Month.AUGUST,16);
    
    System.out.println( date.getYear() ); // 2023
    
    System.out.println( date.getMonth() ); // AUGUST
    System.out.println( date.getMonthValue() ); // 8
    
    System.out.println( date.getDayOfMonth() ); // 16
    System.out.println( date.getDayOfWeek() ); // WEDNESDAY
    
    System.out.println( date.get(ChronoField.DAY_OF_YEAR) ); // 228
    ```

## The `toXXX()` Methods
- Converts an object to a related XXX type,
- Ex:
    ```
    LocalDateTime dateTime = LocalDateTime.of(2023,Month.AUGUST,16,23,10);
    System.out.println(dateTime); // 2023-08-16T23:10
    
    LocalDate date1 = dateTime.toLocalDate();
    System.out.println(date1); // 2023-08-16
    
    LocalTime time1 = dateTime.toLocalTime();
    System.out.println(time1); // 23:10
            
    System.out.println( date.toEpochDay() ); // 19585
    ```

## The `atXXX()` Methods
- Lets you build a `new datetime object` from an `existing datetime object` by supplying `some additional` pieces of information,
- `withXXX()` changes field and return same type of object. But
- `atXXX()` may return different type by taking additional info,
- Ex:
    ```
    LocalDate date2 = LocalDate.of(2023,Month.AUGUST,16);
    System.out.println(date2); // 2023-08-16
    
    LocalDateTime dateTime2 = date2.atTime(23,10);
    System.out.println(dateTime2); // 2023-08-16T23:10
    
    ZonedDateTime zonedDateTime2 = dateTime2.atZone(ZoneOffset.UTC);
    System.out.println(zonedDateTime2); // 2023-08-16T23:10Z
    ```

## The `plusXXX()` and `minusXXX()` Methods
- Returns a copy after adding or subtracting a component value,
- Ex:
    ```
    LocalDate date3 = LocalDate.of(2023,Month.AUGUST,16);
    System.out.println(date3); // 2023-08-16
    
    LocalDate date4 = date3.plusDays(15);
    System.out.println(date4); // 2023-08-31
    
    LocalDate date5 = date3.plusMonths(35);
    System.out.println(date5); // 2026-07-16
    ```

## The `multipliedBy()`, `dividedBy()`, `negated()` Methods
- Don't make sense on `dates` and `times`,
- Applicable to `Duration` and `Period`,
- Ex:
    ```
    Duration d = Duration.ofSeconds(200);
    System.out.println(d); // PT3M20S <-- 3min 20sec
    
    Duration d1 = d.multipliedBy(2);
    System.out.println(d1); // PT6M40S
    
    Duration d2 = d.dividedBy(4);
    System.out.println(d2); // PT50S
    
    Duration d3 = d.negated();
    System.out.println(d3); // PT-3M-20S
    ```
