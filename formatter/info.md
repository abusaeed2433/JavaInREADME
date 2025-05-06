

## Formatting Numbers
- Two classes can be used to format and parse numbers,
  - `java.text.NumberFormat`:
    - Used to format a number in a particular `locale`’s predefined format,
 
  - `java.text.DecimalFormat`:
    - Used to format a number in a format `of your choice` in a particular `locale`,
    - Provides advanced formatting,
- Ex(`NumberFormat`): see `numberFormat()` in `Test.java`,
    ```
    private static void numberFormat(){
    
        //------------   default locale USA -----------
        NumberFormat format = NumberFormat.getNumberInstance();
    
        double num = 175570;
        String sn = format.format(num);
        System.out.println(sn); // 175,570
    
        NumberFormat format1 = NumberFormat.getCurrencyInstance();
    
        double num1 = 175570;
        String st = format1.format(num1);
        System.out.println(st); // $175,570.00
    
        //-------------------   BD locale --------------
        NumberFormat format2 = NumberFormat.getNumberInstance(new Locale("en","BD"));
    
        double num2 = 175570;
        sn = format2.format(num2);
        System.out.println(sn); // 175,570
    
        NumberFormat format3 = NumberFormat.getCurrencyInstance(new Locale("en","bd"));
        st = format3.format(num);
        System.out.println(st); // BDT175,570.00
    }
    ```
- Ex(`DecimalFormat`): see `decimalFormat()` in `Test.java`,
    ```
    private static void decimalFormat(){
        double num = 175.570354;
    
        String pattern = "####.####"; // my custom pattern
        DecimalFormat format = new DecimalFormat();
        format.applyPattern(pattern); // applying my pattern
    
        String sn = format.format(num);
        System.out.println(sn); // 175.5704
    
        pattern = "0000.0000";
        format.applyPattern(pattern);
  
        sn = format.format(num);
        System.out.println(sn); // 0175.5704
    
  
        num = -125.53;
        pattern = "#.##";
        format.applyPattern(pattern);
    
        sn = format.format(num);
        System.out.println(sn);// -125.53
  
    
        num = 12.53;
        pattern = "#.##;(#.##)"; // left part of semicolon is for positive number, right part for negative number
        format.applyPattern(pattern);
        sn = format.format(num); System.out.println(sn); // 12.53
    
        num = -12.53;
        sn = format.format(num); System.out.println(sn); // (12:53)
    }
    ```

## Printf-style Formatting
- `java.util.Formatter` class supports `printf-style` formatting,
- Similar to `printf()` in `C`,
- Ex: See `printfStyleFormatting()` in `Test.java`,
  ```
  private static void printfStyleFormatting(){
      // Formatting strings
      System.out.printf("%1$4s, %2$4s, and %3$6s %n", "Fu", "Hu", "Lo"); //  Fu,   Hu, and     Lo
  
      //formatting numbers
      //takes space on left side
      System.out.printf("%1$4d, %2$4d, %3$4d %n", 10, 100, 1000); //  10,  100, 1000
  
      //takes space on right side
      System.out.printf("%1$-4d, %2$-4d, %3$-4d %n", 1, 10, 100); //1   , 10  , 100
  }
  ```
- `%1$4s`:
  - `1` means it will use the first string provided by user. `"Fu"` for `1st` `println()`,
  - `4` means total `4` character will be taken.
    - Space will be added on left(`4`),
    - Space will be added on right( if negative is used),
  - `s` means `String`,
  
>> It's disturbing. Learn yourself if you want more. Not really useful.