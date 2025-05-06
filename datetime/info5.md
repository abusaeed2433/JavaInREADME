

# DateTime part-5

> Codes are in `partFive` package

## Formatting Dates and Times
- Representing a `datetime` object in a `user-defined textual form`,
- The most important point to keep in mind is that `formatting` and `parsing` are always performed by an object of the `DateTimeFormatter` class,
- `Parsing` is the `opposite of formatting`,
- To format a `datetime object`, `a formatter` needs `2` pieces of information:
  - A format `pattern`, and 
  - A `locale`,
- Formatting can be performed in several ways. They all use `a DateTimeFormatter object` directly or indirectly,
- Some ways are:
  - Using `pre-defined` `standard datetime formatters`,
  - Using the `format()` method of the `datetime classes`,
  - Using `user-defined patterns`,
  - Using the `DateTimeFormatterBuilder class`,

## Using `pre-defined` `standard datetime formatters`,
- Most of the formatters use `ISO datetime formats`,
- Ex:
    ```
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
    ```

## Using the `format()` method of the `datetime classes`
- Done using `format()` method on `datetime` related class,
- `format()` method take an object of the `DateTimeFormatter` class,
- Ex:
    ```
    LocalDate date = LocalDate.of(2023, Month.AUGUST,17);
    String strDate;
    
    strDate = date.format(DateTimeFormatter.ISO_DATE);
    System.out.println(strDate); // 2023-08-17
    
    strDate = date.format(DateTimeFormatter.ISO_WEEK_DATE);
    System.out.println(strDate); // 2023-W33-4
    
    LocalTime time = LocalTime.of(11,12,13);
    String strTime = time.format(DateTimeFormatter.ISO_TIME);
    System.out.println(strTime); // 11:12:13
    ```


## Using user-defined patterns
- Most commonly used methods in the `DateTimeFormatter` class is the `ofPattern()` method,
- `ofPattern()`:
  - Takes `pattern` and `locale`(optional),
  - Returns a `DateTimeFormatter object` with the `specified pattern and locale`,
- Here formatting is performed based on a `pattern`,
  - A `pattern` is a sequence of characters that have `special meanings`,
- Some widely used special characters are:
    <table>
    
    <tr> <th>Symbol</th> <th>Description</th> <th>Example</th> </tr>
    
    <tr>
     <th>y</th> <th>Year of era.<br>Always positive for AD & BC</th> 
     <th>
      <table>
        <tr> <th>yy</th> <th>23</th> </tr>
        <tr> <th>yyyy</th> <th>2023</th> </tr>
        <tr> <th>yyyyy</th> <th>02023</th> </tr>
      </table>
    </tr>
    
    <tr>
     <th>D</th> <th>Day of year (1 -366)</th> 
     <th>
      <table>
        <tr> <th>D</th> <th>150</th> </tr>
      </table>
    </tr>
    
    <tr>
     <th>M</th> <th>Month of year</th> 
     <th> 
       <table>
        <tr> <th>M</th> <th>5</th> </tr>
        <tr> <th>MM</th> <th>05</th> </tr>
        <tr> <th>MMM</th> <th>Jul</th> </tr>
        <tr> <th>MMMM</th> <th>July</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>d</th> <th>Day of month</th> 
     <th> 
       <table>
        <tr> <th>d</th> <th>23</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>W</th> <th>Week of month</th> 
     <th> 
       <table>
        <tr> <th>W</th> <th>5</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>E</th> <th>Day of week</th> 
     <th> 
       <table>
        <tr> <th>E</th> <th>7</th> </tr>
        <tr> <th>EE</th> <th>07</th> </tr>
        <tr> <th>EEE</th> <th>Sun</th> </tr>
        <tr> <th>EEEEE</th> <th>Sunday</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>a</th> <th>AM/PM of day</th> 
     <th> 
       <table>
        <tr> <th>a</th> <th>AM</th> </tr>
        <tr> <th>a</th> <th>PM</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>h</th> <th>Clock hour of AM/PM (1-12)</th> 
     <th> 
       <table>
        <tr> <th>h</th> <th>5</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>k</th> <th>Clock hour of AM/PM (1-24)</th> 
     <th> 
       <table>
        <tr> <th>k</th> <th>9</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>H</th> <th>Hour of day (0-23)</th> 
     <th> 
       <table>
        <tr> <th>H</th> <th>7</th> </tr>
        <tr> <th>HH</th> <th>07</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>m</th> <th>Minute of hour</th> 
     <th> 
       <table>
        <tr> <th>mm</th> <th>30</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>s</th> <th>Second of minute</th> 
     <th> 
       <table>
        <tr> <th>ss</th> <th>12</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>V</th> <th>Time zone ID</th> 
     <th> 
       <table>
        <tr> <th>VV</th> <th>America/Chicago</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>Z</th> <th>Zone offset</th> 
     <th> 
       <table>
        <tr> <th>Z</th> <th>-0500</th> </tr>
        <tr> <th>ZZ</th> <th>-0500</th> </tr>
        <tr> <th>ZZZ</th> <th>-05:00</th> </tr>
        <tr> <th>ZZZZ</th> <th>GMT-05:00</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>'</th> <th>Escape for text<br>Text within single quotes is output directly</th> 
     <th> 
       <table>
        <tr> <th>'Hello'</th> <th>Hello</th> </tr>
        <tr> <th>'Hello' MMMM</th> <th>Hello July</th> </tr>
       </table>
     </th>
    </tr>
    
    <tr>
     <th>''</th> <th>A single quote</th> 
     <th> 
       <table>
        <tr> <th>'''Hello''' MMMM</th> <th>'Hello' July</th> </tr>
       </table>
     </th>
    </tr>
    
    </table>

- Ex:
    ```
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
    ```

## Using the DateTimeFormatterBuilder class
- Previous one is enough for all cases,
- Ex:
    ```
    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendLiteral("My birthday in ")
            .appendValue(ChronoField.YEAR)
            .appendLiteral(" is not on ")
            .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
            .toFormatter();
    
    LocalDate ld = LocalDate.of(2023, Month.MARCH, 22);
    String str = ld.format(formatter);
    System.out.println(str); // My birthday in 2023 is not on Wednesday
    ```

## Using Locale Specific Formats
- Uses predefined format for which is locale specific,
- Ex:
    ```
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
    ```


