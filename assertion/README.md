# assertion

### Introduction
- State `something` in a strong, confident, and forceful way,
- When you assert `something`, you believe that `something` to be true,
- But it does not make that `something` always true,
- Sometimes you may be wrong and that `something` may be false, even if you assert it to be true,

### Why assertion
- Helps to debug code in development and testing phase,
- Used for detecting logical errors in a program,

### assertion
- Can be written in 2 ways:
  - `assert booleanAssertionExpression;`
    - This form is enough in almost all cases,
  - `assert booleanAssertionExpression : errorMessageExpression;`
    - `errorMessageExpression`: allows writing custom error message. Can be any data type,
- If `booleanAssertionExpression` evaluates to true, no action is taken. Code is executed normally,
- But if evaluates to false, `java.lang.AsssertionError` is thrown,
- Assertion is by default disabled. You must run your code using below to see assertion in action:
    ```
    java -ea YourClassName
    ```
- Ex:
    ```
    java -ea src/j_Assertion/Test.java
    ```
- Ex(See `Test.java`):
    ```
    private static void assertType1(){
        int a = getNumber(2);
    
        assert a==4;
        /*
            when we write 4, we know how getNumber(int) works. It helps to debug code.
            Because if a != 4, then there must have error in getNumber(int) function
        */
    
        // assert a == 6; // will throw runtime exception
        System.out.println(a);
    }
    
    private static void assertType2(){
        int a = getNumber(2);
    
        assert a==6 : "Something is wrong in getNumber(int)";
    
        System.out.println(a); // java.lang.AssertionError: Something is wrong in getNumber(int)
    }
    ```
- Must have to run using above command. Otherwise, assertion will be ignored,

### Another example:
- method definition
  ```
    private static int calculateAge(LocalDate localDate){
        ...
        return (int)age;
    }
  ```
- Calling like:

    ```
    LocalDate dob = LocalDate.of(2001,3,21);
    int age = calculateAge(dob);
    
    assert age >= 22;
    System.out.println("I was right"); // executed
    ```

    
    
    
    
    
<!-- bottom_nav_bar_1243 -->
<div align="center">
<a href="../exceptionhandling/part2/">
    <img src="https://img.shields.io/badge/◀%20Previous-blue?style=for-the-badge" alt="Previous">
</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="../string/part1/">
    <img src="https://img.shields.io/badge/Next%20▶-blue?style=for-the-badge" alt="Next">
</a>
</div>
<!-- bottom_nav_bar_1243 -->
    