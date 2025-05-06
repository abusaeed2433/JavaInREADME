
# Regex part-3

> Codes are in `partThree` package

## Using Named Groups
- group can be named instead of using with number,
- Format:
  ```
  (?<groupName>pattern)
  ```
- The group name must consist of
  - Only `letters` and `digits`,
  - `a to z`, `A to Z`, and `0 to 9`,
  - Must start with `letter`,
- Ex: See `groupTest2()` in `Test.java`,
  - This is the previous example but using `name` instead of `number`,
  - Will find phone number,
  - Find code & number from that phone number,
  - Format the number & print
  ```
  private static void groupTest2(){
      String phones = "+8801792101111, +8801234567890, +8804324567890,+2101234";
  
      String regex = "(\\+\\d{3})(\\d+)\\b"; // <--------------
      Pattern pattern = Pattern.compile(regex);
  
      Matcher matcher = pattern.matcher(phones);
  
      while (matcher.find()){
          String code = matcher.group(1); // <--------------
          String num = matcher.group(2); // <--------------
  
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

## Resetting the Matcher
- `Matcher` class has a `reset()` method,
- `reset()`:
  - Next call to match a pattern will start from the `beginning` of the input text,
  - Uses the same string,
- `reset(input)`
  - Next call to match a pattern will start from the `beginning` of the input text,
  - Uses the provided `input` string,
- Ex: See `resetTest()` in `Test.java`,
  ```
  private static void resetTest(){
      String[] arr = {"+8801792101111", "+8801234567890", "+8804324567890","+2101234"};
  
      String regex = "(?<code>\\+\\d{3})(?<num>\\d+)\\b";
      Pattern pattern = Pattern.compile(regex);
  
      Matcher matcher = pattern.matcher(""); // dummy
  
      for(String phone : arr){
          matcher.reset(phone);
          matcher.find();
  
          String code = matcher.group("code");
          String num = matcher.group("num");
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

## Find & Replace Using RE


## Example
- We are given this input:
  ```
  A train carrying 125 men and women was traveling at the speed of 
  100 miles per hour. The train fare was 75 dollars per student.
  ```
- We want to replace number by text like this:
  - `100` by `a hundred`,
  - `> 100` by `more than a hundred`,
  - `< 100` by `less than a hundred`,
- Our output will be:
  ```
  A train carrying more than a hundred men and women was traveling at the speed of 
  a hundred miles per hour. The train fare was less than a hundred dollars per student.
  ```
- For accomplishing that we have `2` methods in `Matcher` class,
  - `Matcher appendReplacement(StringBuilder sb, String replacement)`:
    - If this is the first match or `first call to the find()` then
      - It appends the text `starting from the beginning of the input` until the `character before the matching text`,
    - else
      - It will append text from the previously saved position till character before the matching text,
    - Then, it adds the replacementText to the `StringBuilder`,
    - Then, it sets the `append position` ( in `Matcher` object) to the character position just `after previous matching text`,
    - Continues,
  - `StringBuilder appendTail(StringBuilder sb)`:
    - Add rest of the part to `StringBuilder` after last saved position till end of the input,
- Solution code: See `solution()` in `Test.java`,
  ```
  private static void solution(){
  
      String input = "A train carrying 125 men and women was traveling at the speed of 100 miles per hour. "+
              "The train fare was 75 dollars per student.";
  
      String regex = "\\b\\d+\\b";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
  
      StringBuilder output = new StringBuilder();
  
      while (matcher.find()){
          String text = matcher.group();
          int num = Integer.parseInt(text);
  
          String replaceWith;
  
          if(num == 100) replaceWith = "a hundred";
          else if(num < 100) replaceWith = "less than a hundred";
          else replaceWith = "more than a hundred";
  
          matcher.appendReplacement(output,replaceWith);
      }
  
      matcher.appendTail(output); // rest of the part <-----------(a)
      System.out.println(output); // A train carrying more than a hundred men and women was traveling at the speed of a hundred miles per hour. The train fare was less than a hundred dollars per student.
  }
  ```
- In above solution, body of while loop will be executed 3 times,
- Content of `output` in each iteration is given:
- `1st` iteration:
  ```
  A train carrying more than a hundred
  ```
- `2nd` iteration:
  ```
  A train carrying more than a hundred men and women was traveling at the speed of a hundred
  ```
- `3rd` iteration:
  ```
  A train carrying more than a hundred men and women was traveling at the speed of a hundred miles per hour. The train fare was less than a hundred
  ```
- Outside while loop, at point `(a)`,
  ```
  A train carrying more than a hundred men and women was traveling at the speed of a hundred miles per hour. The train fare was less than a hundred dollars per student.
  ```

>> Do you still remember the image while starting regex? 🐱

