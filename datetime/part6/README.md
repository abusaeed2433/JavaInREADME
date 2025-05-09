
# DateTime - part6

## Parsing Dates and Times
- Process of creating a `date`, `time`, or `datetime` object from a `string`,
- `2` ways to parse:
  - Using the `parse()` method of the `datetime` class,
  - Using the `parse()` method of the `DateTimeFormatter` class,
- A `DateTimeParseException` is thrown if the text can't be parsed,
- `getErrorIndex()` method returns the `index` in the text where the error occurred,
- `getParsedString()` method returns the text being parsed,
- Ex(using `datetime` `parse()`):
    ```java
    String strDate = "2023-08-17";
    
    LocalDate localDate = LocalDate.parse(strDate);
    System.out.println(localDate); // 2023-08-17
    
    strDate = "2023-W33-4"; // this format is discussed in previous section
    LocalDate localDate1 = LocalDate.parse(strDate,DateTimeFormatter.ISO_WEEK_DATE);
    System.out.println(localDate1); // 2023-08-17
    ```
- Ex(Using `DateTimeFormatter` `parse()`):
    ```java
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
    ```

>> Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live. (Martin Golding)


<!-- bottom_nav_bar_1243 -->
<div align="center">
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/datetime/part5/">
    <img src="https://img.shields.io/badge/◀%20Previous-blue?style=for-the-badge" alt="Previous">
</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/formatter/">
    <img src="https://img.shields.io/badge/Next%20▶-blue?style=for-the-badge" alt="Next">
</a>
</div>
<!-- bottom_nav_bar_1243 -->
    