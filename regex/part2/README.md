
# Regex part-2

> Codes are in `partTwo` package

## Beware of Backslashes
- `\w` means word character,
- `Backslash` is also used as a part of an escape character,
- Can be used to nullify the special meaning of `metacharacters`,
  - Ex: `\[[0-9]\]`
    - Will match `[` then `any digit` then `]`,
    - Will match `[4]`, `[2]` etc,
    - For expressing it, you need to use two `backslashes`,
    - Regex for above will `\\[[0-9]\\]]`,
- Ex: See `backslashTest()` in `Test.java`,
  ```
  private static void backslashTest(){
  
      //String regex = "\\[[0-9]\\]"; // valid
      String regex = "\\[[0-9]]"; // both are valid. ] itself don't have special meaning. So backslashes is optional
  
      Pattern pattern = Pattern.compile(regex);
  
      String[] arr = {"[0]","[1","[s]","2]","[5]"};
  
      for (String str : arr){
          Matcher matcher = pattern.matcher(str);
          if(matcher.find()){
              System.out.println(str+" -> passed");
          }
          else {
              System.out.println(str+" -> failed");
          }
      }
  
  }
  ```
  Output
  ```
  [0] -> passed
  [1 -> failed
  [s] -> failed
  2] -> failed
  [5] -> passed
  [O] -> failed. This capital 'O', not zero
  ```


## Quantifiers in Regular Expressions
- We can specify `number of times` a character appear,
- These are the quantifiers
  <table>
  <tr> <th>Quantifiers</th> <th>Meaning</th> </tr>
  <tr> <th>*</th> <th>Zero or more times</th> </tr>
  <tr> <th>+</th> <th>One or more times</th> </tr>
  <tr> <th>?</th> <th>Once or not at all</th> </tr>

  <tr> <th>{m}</th> <th>Exactly m times</th> </tr>
  <tr> <th>{m, }</th> <th>At least m times</th> </tr>
  <tr> <th>{m, n}</th> <th>At least m, but not more than n times</th> </tr>
  </table>
- `quantifiers` must follow a `character` or `character class` for which it specifies the quantity. Ex: `\d+`,
- Ex-1: See `quantifierTest1()` in `Test.java`,
  - Will match word of the format `fName lName`. where, 
  - `fName` is at least `3` letter, and 
  - `lName` is `5 to 10` letters
  ```
  private static void quantityTest(){
      String regex = "[a-zA-Z]{3,} [A-Za-z]{5,10}";
      Pattern pattern = Pattern.compile(regex);
  
      String[] arr = { "Ibne Sina", "Shujoy Kundu",
              "Hasib Hasan Hasib Hasan",
              "Mahir Abrar", "gd n8"
      };
  
      for(String name : arr){
          Matcher matcher = pattern.matcher(name);
          if(matcher.matches()){
              System.out.println(name+" -> passed");
          }
          else{
              System.out.println(name+" -> failed");
          }
      }
  }
  ```
  Output:
  ```
  Ibne Sina -> failed
  Shujoy Kundu -> passed
  Hasib Hasan Hasib Hasan -> failed
  Mahir Abrar -> passed
  gd n8 -> failed
  ```
- Ex-2: See `quantifierTest2()` in `Test.java`,
- Will match word
  - consists of `small letter` and
  - contain small `s` only one or not at all
  ```
  private static void quantityTest2(){
      String regex = "[a-rt-z]*s?[a-rt-z]*";
      Pattern pattern = Pattern.compile(regex);
  
      String[] arr = {"amskn","sssla","substr","ms","s"};
  
      for(String str : arr){
          Matcher matcher = pattern.matcher(str);
  
          if(matcher.matches()){
              System.out.println(str+" -> passed");
          }
          else{
              System.out.println(str+" -> failed");
          }
  
      }
  }
  ```
  Output:
  ```
  amskn -> passed
  sssla -> failed
  substr -> failed
  ms -> passed
  s -> passed
  ```


## Matching Boundaries
- Finding location of match,
- Ex: Replacing `apple` with `orange`:
  ```
  I have an apple and five pineapples // input 
  I have an orange and five pineapples // replaced
  ```
- Boundary matchers in java:
  <img src="files/boundary_matcher.jpg" height="200px">
- Remember, A word character is defined by `[a-zA-Z_0-9]`,
- `A word boundary` is a `zero-width match` that matches the following:
  - Between a `word character` and a `non-word character`,
  - `Start of the string` and a `word character`,
  - A `word character` and the `end of the string`,
- Similarly, a `non-word boundary` matches the following:
  - The `empty string`,
  - Between two word characters,
  - Between two non-word characters,
  - Between a non-word character and the start,
  - Between a non-word character and end of the string,
- For matching `apple` in earlier sentence regex should be `\bapple\b`,
- Ex-1: See `boundaryMatcher1()` in `Test.java`,
  ```
  private static void boundaryMatcher1(){
      String input = "I have an apple and five pineapples";
  
      String regex = "\\bapple\\b"; // Use \\b to get \b inside the string literal
      String replacedWith = "orange";
  
      String output = input.replaceAll(regex,replacedWith);
      System.out.println(output); // I have an orange and five pineapples
  }
  ```
- Ex-2: See `boundaryMatcher1Manually()` in `Test.java`,
  ```
  private static void boundaryMatcher1Manually(){
      String input = "apple, I have an apple, and five pineapples & two more apple";
  
      String regex = "\\bapple\\b";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);

      while (matcher.find()){
          System.out.println(matcher.group()+" from "+matcher.start()+" to "+matcher.end());
      }  
  }
  ```
  Output:
  ```
  apple from 0 to 5
  apple from 17 to 22
  apple from 55 to 60
  ```

## Groups and Back Referencing
- A `group` is created inside a RE by enclosing one or more characters inside `parentheses()`,
- Ex: `(ab)`, `ab(z)`,
- Each group in a RE has a `group number`,
- `Group number` starts at `1`,
- `groupCount()` that returns total number of groups found in `Matcher`,
- There is a `special group`,
  - Called `group 0`,
  - It refers to the `entire RE`,
  - This `group 0` is not reported by the `groupCount()` method,
- For regex `((AB)(CD))(XY)`:
  - `group-0`: `ABCDXY`
  - `group-1`: `ABCD`
  - `group-2`: `AB`
  - `group-3`: `CD`
  - `group-4`: `XY`

- For finding group, find left parenthesis(`(`), then find the `corresponding `right parenthesis(`)`),
- Ex: See `groupTest2()` in `Test.java`, 
  - Will find phone number,
  - Find code & number from that phone number,
  - Format the number & print
  ```
  private static void groupTest2(){
      String phones = "+8801792101111, +8801234567890, +8804324567890,+2101234";
  
      String regex = "(\\+\\d{3})(\\d+)\\b"; // \ is used before +, since + has special meaning
      Pattern pattern = Pattern.compile(regex);
  
      Matcher matcher = pattern.matcher(phones);
  
      while (matcher.find()){
          // String found = matcher.group(0); // or .group(); phone num
  
          String code = matcher.group(1);
          String num = matcher.group(2);
  
          System.out.println(code+" - "+num);
      }
  }
  ```
  Output:
  ```
  +880 - 1792101111
  +880 - 1234567890
  +880 - 4324567890
  +210 - 1234
  ```
