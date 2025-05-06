
# DateTime part-3

> Codes are in `partThree` package

## `LocalDate`, `LocalTime`, and `LocalDateTime`
- `LocalDate`:
  - Represent `Date` without `time` and `zone`,
- `LocalTime`:
  - Represent `Time` without `date` and `zone`,
- `LocalDateTime`:
  - Represent `Date` & `Time` without `zone`,
- Ex: See `dateTimeDateTime()` in `Test.java`,
    ```
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
    ```

## `OffsetTime` and `OffsetDatetime`
- Represents a `time` and a `datetime` respectively with a `zone offset` from `UTC`,
- `OffsetTime` can be converted into `LocalTime`. Since,
  ```
  OffsetTime = LocalTime + ZoneOffset
  ```
- `OffsetDateTime` can be converted into `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`. Since,
  ```
  OffsetDateTime = LocalDateTime + ZoneOffset
  ```
- Ex: See `zoneTimeDateTime()` in `Test.java`,
    ```
    ZoneOffset zone = ZoneOffset.of("+06:00");

    OffsetTime time = OffsetTime.of(11,12,13,0,zone);
    System.out.println( time ); // 11:12:13+06:00

    LocalTime localTime = time.toLocalTime(); // to localTime
    System.out.println( localTime ); // 11:12:13

  
    OffsetDateTime offsetDateTime = OffsetDateTime.of(2023,3,23,11,12,13,0,zone);
    System.out.println( offsetDateTime ); // 2023-03-23T11:12:13+06:00

    LocalDateTime localDateTime = offsetDateTime.toLocalDateTime(); // to LocalDateTime
    System.out.println( localDateTime ); // 2023-03-23T11:12:13

    LocalDate localDate = offsetDateTime.toLocalDate(); // to LocalDate
    System.out.println( localDate ); // 2023-03-23

    LocalTime localTime1 = offsetDateTime.toLocalTime(); // to LocalTime
    System.out.println( localTime1 ); // 11:12:13

    OffsetDateTime offsetDateTime1 = OffsetDateTime.of(2023,3,23,11,12,13,0,zone);
    System.out.println( offsetDateTime1 ); // 2023-03-23T11:12:13+06:00

    Instant instant = offsetDateTime1.toInstant(); // UTC so, 6 is subtracted
    System.out.println( instant ); // 2023-03-23T05:12:13Z
    ```

## `ZonedDatetime`
- Represents a `datetime` with time `zone`,
    ```
    ZonedDateTime = LocalDateTime + ZoneId
    ```
- Ex: See `testZonedDateTime()` in `Test.java`,
    ```
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
    ```

## Same Instant, Different Times
- Can `Instant` can have different time because of different `zone`,
- Ex: See `zoneConversion()` in `Test.java`,
    ```
    LocalDateTime ldt = LocalDateTime.of(2023, Month.MARCH, 14, 17, 30);
    ZoneId zoneSaudi = ZoneId.of("Asia/Riyadh");
    
    ZonedDateTime zdt = ZonedDateTime.of(ldt, zoneSaudi); // <-----------(1)
    System.out.println( zdt ); // 2023-03-14T17:30+03:00[Asia/Riyadh]
    
    ZoneId zoneDhaka = ZoneId.of("Asia/Dhaka");
    ZonedDateTime zdt2 = zdt.withZoneSameInstant(zoneDhaka); // <--------(2)
    System.out.println( zdt2 ); // 2023-03-14T20:30+06:00[Asia/Dhaka]
    
    ZonedDateTime zdt3 = zdt.withZoneSameInstant(ZoneId.of("Z")); // utc
    System.out.println( zdt3 ); // 2023-03-14T14:30Z
    ```
