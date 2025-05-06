
# String part-2

> Codes are in `partTwo` package

## Some String operations
- See `testFewOperations()` in `Test.java`,
- ### Character at given position:
  - `.chartAt(index)`,
  - Runtime error if `index` is invalid,
  - Ex:
    ```
    String str = "I can write poems";
    System.out.println( str.charAt(2) ); // c
    ```
- ### Equals check:
  - `.equals(str2)` & `.equalsIgnoreCase(str2)`:
  - `true` is both strings are completely equal(`1st`),
  - `true` if equals after ignoring case(`2nd`),
  - Ex:
    ```
    String str1 = "Hello";
    String str2 = "hello";

    System.out.println( str1.equals(str2) ); // false
    System.out.println( str1.equalsIgnoreCase(str2) ); // true
    ```
- ### Empty check:
  - Can be checked in `3` ways, 
  - Ex:
    ```
     String name = "";

     System.out.println( name.isEmpty() ); // true
     System.out.println( name.equals("") ); // true
     System.out.println( name.length()==0 ); // true
    ```
- ### Changing case:
  - `.toLowerCase()` & `.toUpperCase()`, 
  - Ex:
    ```
    String mix = "Process FINISHED";
    System.out.println( mix.toUpperCase() ); // PROCESS FINISHED
    System.out.println( mix.toLowerCase() ); // process finished
    ```
- ### Finding position:
  - `.indexOf(text)`, `lastIndexOf(text)`, 
  - Ex:
    ```
     String msg = "You are welcome";
     System.out.println( msg.indexOf('o') ); // 1 - first o
     System.out.println( msg.indexOf('x') ); // -1
     System.out.println( msg.indexOf("are") ); // 4
     
     System.out.println( msg.lastIndexOf('o') ); // 12
    ```
- ### Representing value into String:
  - `String.valueOf(value)`,
  - Ex:
    ```
    // Representing value into String
    String strInt = String.valueOf(1000);
    System.out.println(strInt); // 10000

    String strDou = String.valueOf(200.5d);
    System.out.println(strDou); // 200.5

    String strBoo = String.valueOf(true);
    System.out.println(strBoo); // true
    ```
- ### Finding substring:
  - `.substring(int beginIndex)`, `.substring(int beginIndex,int beforeThisIndex)`,
  - Ex:
    ```
    String total = "Rahim Karim Tamim";

    String rahim = total.substring(0,5);
    System.out.println(rahim); // Rahim

    String karim = total.substring(6,11);
    System.out.println(karim); // Karim
    ```
- ### Removing Leading and trailing spaces and control characters:
  - `.trim()`,
  - Ex:
    ```
    String code = " \n hello pluto \t ";
    System.out.println( code.trim() ); // hello pluto
    ```
- ### Replacing part of string,
  - `.replace(oldStr, new)`, `replaceAll(n_Regex,new)`,
  - I will discuss `n_Regex` later insha'Allah if I can,
  - Ex:
    ```
    String greeting = "Hello old man, Hello";
    System.out.println( greeting.replace("Hello","Hi") ); // Hi old man, Hi
    System.out.println( greeting.replaceAll("Hello","Hi") ); // Hi old man, Hi 
    ```
- ### Matching start & end of a string;
  - `.startsWith(str)`, `.endsWith(str)`,
  - Ex:
    ```
    String eq = "20 + 22 = 42";
    System.out.println( eq.startsWith("2")); // true
    System.out.println( eq.endsWith("42")); // true
    ```

- ### Splitting string:
  - `.split(n_Regex)`,
  - Ex:
    ```
     String strVowels = "a,e,i,o,u";
     String[] vowels = strVowels.split(","); //split(n_Regex)
    ```
- ### Joining string:
  - `String.join(sep, str1,str2.....)`,
  - Ex:
    ```
    String joined = String.join(",","A","E","I","O","U"); // 1st one is separator
    System.out.println(joined); // A,E,I,O,U
    ```


## String in switch statement
- `switch` can't be null,
- `case` must be string literal,
- `case` can't be variable,
- It is basically an `if-else` ladder,
- Ex: See `testSwitchExpression()` in `Test.java`,
  ```
  private static void testSwitchExpression(){
          
      String status = "on";
  
      switch (status){ // status mustn't be null
          case "on":
              System.out.println("on"); //executed
              break;
          case "off": // check if status.equals("off")
              System.out.println("off");
              break;
      }
  
  }
  ```


## StringBuilder & StringBuffer
- Similar like `String` but `mutable`,
- Content can be changed without creating new object,
- `StringBuffer` is `thread-safe`, but `StringBuilder` is not,
- `StringBuffer` may be slower than `StringBuilder`,
- Ex: See `stringBuilderTest()` in `Test.java`,
  ```
  private static void stringBuilderTest(){
  
      StringBuilder builder = new StringBuilder();
      builder.append("This is builder-").append(5).append(". ");
  
      String phone = "0179210xxxx";
  
      builder.append("His phone number is: ").append(phone).append(", Bg:").append('O');
  
      System.out.println(builder); // This is builder-5. His phone number is: 0179210xxxx, Bg:O
  
      builder.insert(0,"Hello, ");
      System.out.println(builder); // Hello, This is builder-5. His phone number is: 0179210xxxx, Bg:O
  
      builder.delete(0,7);
      System.out.println(builder); // This is builder-5. His phone number is: 0179210xxxx, Bg:O
  
      builder.reverse();
      System.out.println(builder); // O:gB ,xxxx0129710 :si rebmun enohp siH .5-redliub si sihT
  
      // palindrome check
      String toCheck = "Step on no pets";
  
      StringBuilder b1 = new StringBuilder(toCheck).reverse();
      System.out.println(toCheck.equalsIgnoreCase(b1.toString())); // true
  }
  ```
- All methods are same in `StringBuffer`. See `stringBufferTest()` in `Test.java`,

## String concatenation
- Can be concatenated using `+` operator,
- Better to use `StringBuilder` or `StringBuffer` since multiple objects are not being created,
- Ex: See `concatenateTest()` in `Test.java`,
  ```
  private static void concatenateTest(){
      int num = 5;
  
      String total = "This ";
      total += "is ";
      total += String.valueOf(num);
  
      System.out.println(total); // This is 5
  
      // better approach since multiple objects are not created
      StringBuilder builder = new StringBuilder();
      builder.append("This ").append("is ").append(num);
      System.out.println(builder); // This is 5
  }
  ```
## Language-Sensitive String Comparison
- For comparing strings based on the `dictionary order`,
- Use `compare()` method of the `java.text.Collator` for this,
- `compare()` in `java.text.Collator`:
  - Returns `0` if equals,
  - Returns `-1` if `1st` one comes before `2nd` one,
  - Returns `1` if `1st` one comes after `2nd` one,
- Ex: See `dictCompare()` in `Test.java`,
  ```
  private static void dictCompare(){
  
      String str1 = "abc";
      String str2 = "bcd";
      String str3 = "Bcd";
  
      Collator collator = Collator.getInstance(Locale.US);
  
      int res;
  
      res = collator.compare(str1,str2);
      System.out.println(res); // -1 since abc is before bcd
  
      res = collator.compare(str2,str1);
      System.out.println(res); // 1 since bcd is after abc
  
      res = collator.compare(str2,str3);
      System.out.println(res); // -1 since bcd is before Bcd
  }
  ```
