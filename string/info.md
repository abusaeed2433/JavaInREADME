
# String part-1

> Codes are in `partOne` package


## Introduction
- A sequence of zero or more characters,
- Represented by an object of the `java.lang.String` class,
- `String` class is `immutable`. i.e., contents of a `String` object can't be modified after it has been created,
- Has two companion classes,
  - `StringBuilder` & `StringBuffer`
  - These are `mutable`,

## String Literals
- `Literals` means `Constant-value`,
- Consists of a sequence of zero or more characters enclosed in `double quotes`,
- All `String literals` are `Objects` of the `String` class,
  - Ex:
  - `""` // empty String literals,
  - `Hello world` // String literals of 11 characters
- Cannot be broken into two lines,
  ```
  // compile-time error
  "He
  llo"
  ```
- Can be broken into 2 lines by using plus(`+`),
  ```
  // valid
  "He"+
  "llo"
  ```

## Escape Sequence in String Literals
- Valid to use all `escape sequence characters` to form a string literal,
- A character can also be represented as a `Unicode escape` in the form `\uxxxx`,
  - `x` is a hexadecimal digit,
- Ex: See `escapeTest()` in `Test.java`,
    ```
    private static void escapeTest(){
        System.out.println( "hello" ); // hello
    
        System.out.println( "he\nllo" );
        // he
        // llo
    
        System.out.println( "100%" ); // 100%
        System.out.println( "Said by \"Unknown\"" ); // Said by "Unknown"
    
        System.out.println("Apple"); // Apple
        System.out.println("\u0041pple"); // Apple
    
    }
    ```
- Not used too much,


## CharSequence
- Is an `interface` in the `java.lang package`,
- `String`, `StringBuffer`, and `StringBuilder` implements `CharSequence` interface. So, these can be used wherever `Charsequence` is required,
- Ex: See `charSequenceTest()` in `Test.java`,
    ```
    private static void printWithLength(CharSequence cs){
        System.out.println(cs+" -> "+cs.length());
    }
    ```
    ```
    private static void charSequenceTest(){
        String name = new String("Hello S");
        printWithLength(name); // Hello S -> 7
    
        StringBuffer buffer = new StringBuffer("Buffer"); // will be discussed later
        printWithLength(buffer); // Buffer -> 6
    
        StringBuilder builder = new StringBuilder("Builder"); // will be discussed later
        printWithLength(builder); // Builder -> 7
    }
    ```


## Creating String Objects
- `String` class contains `many constructors` that can be used for creating `String` object,
- Ex(Very few constructor): See `stringConstructorTest()` in `Test.java`,
    ```
    private static void stringConstructorTest(){
        String name;
    
        name = new String(); // empty String
        System.out.println(name); //
    
        name = new String("Hello");
        System.out.println(name); // Hello
    
        char[] chars = {'1','2','3','4','a','b','d'};
        name = new String(chars);
        System.out.println(name); // 1234abd
    
        name = new String(chars,3,3); // start from index - 3 & take 3 characters from index-3
        System.out.println(name); // 4ab
    }
    ```
  

## Some properties of String
 - Every `String` has an `integer` length,
   - `length()` method returns number(`int`) of character on that `String` object,
   - Ex:
     ```
     String name = new String("Hello March");
     System.out.println(name.length()); // 11
     ```
 - All string `literals` are objects of the `String` class,
   - All `methods` of the `String` class can be used with `String literals` directly,
   - Ex:
     ```
     String msg = "This is Pluto"; // "This is Pluto" is an object
     System.out.println(msg.length()); // 13
     System.out.println("This is Pluto".length()); // 13
     ```

## String Objects Are Immutable
- You cannot modify the content of a String object,
- Can be shared without worrying about them getting modified,
- Same String object can be referred by multiple variables, since immutable,
- Ex: See `immutableTest()` in `Test.java`,
    ```
    private static void immutableTest(){
    
        String var1 = "Test Case";
        String var2 = var1.substring(0,4);
    
        System.out.println(var1); // Test Case
        System.out.println(var2); // Test
    }
    ```
- Whenever you modify a `String`, new `String` is created with the result, performed on 1st `String`,


## Comparing Two Strings
- Remember, strings are object. So `==` can't be used for comparing,
- `int compareTo(String)` can be used for comparing two string objects,
- `int compareTo(String)`:
  - Returns an integer,
  - Zero(`0`): If both are `equals`, 
  - Positive integer(`>0`): `1st` one is lexicographically `larger` than `2nd`,
  - Negative integer(`<0`): `1st` one is lexicographically `smaller` than `2nd`,
  - It keeps comparing character by character, if different character is found, it returns `ascii value of that char in 1st` - `ascii value of that char at 2nd`
- Ex: See `stringCompareTo()` in `Test.java`,
    ```
    private static void stringCompareTo(){
        String val1 = "abc";
        String val2 = "abc";
        String val3 = "aBc";
        String val4 = "zbd";
        String val5 = "abcd";
    
        System.out.println(val1.compareTo(val2)); // 0
    
        System.out.println(val1.compareTo(val3)); // 32
    
        System.out.println(val3.compareTo(val1)); // -32 <-----------(a)
    
        System.out.println(val1.compareTo(val4)); // -25
        System.out.println(val4.compareTo(val1)); // 25
    
        System.out.println(val1.compareTo(val5)); // -1
        System.out.println(val5.compareTo(val1)); // 1
    }
    ```
  - At `(a)`, `val3 = "aBc"`, `val1 = "abc"` then `val3.compareTo(val1)`:
    - 1st character is same, continue
    - 2nd character is different. So return `'B'-'b'` which is `66-98 = -32`,
    - Doesn't check any other character,


    
## String Pool
- Java maintains a pool of all `string literals`,
- To minimize the memory usage and for better performance,
- It creates a `String object` in the `string pool` for every string literal it finds in a program,
- When it encounters a string literal,
  - It looks for a `string object` in the `string pool` with the identical content,
    - If it doesn't find a match in the `string pool`, 
      - It creates a new `String object` with that content and adds it to the `string pool`,
      - Then, it replaces the `string literal` with the reference of the newly created `String object` in pool,
    - If it finds a match in the `string pool`, 
      - It replaces the `string literal` with the reference of the `String object` found in the pool,
- For below statement:
    ```
    String str = new String("Hello"); // <---------(a)
    ```
  - Here `"Hello"` is a `String literal`,
  - `"Hello"` is not in `String pool` initially,
  - So `String object`(say `x`) having content `Hello` will be created and added to `String pool`,
  - Above statement will be like:
    ```
    String str = new String(x);
    ```
  - Since we are using `new String()`, So another `String object` will be created on the `heap memory`,
  - So total `2` String objects will be created for `(a)`,
- For these `2` statements below,
    ```
    String str1 = new String("Hello"); // <---------(c)
    String str2 = new String("Hello");// <----------(d)
    ```
  - Assuming before executing those statements, `String pool` doesn't contain `"Hello"`,
  - How many `Sting` objects will be created ?
  - Answer is `3`. Because
    - For `(c)`, `2` string objects will be created,(explained earlier),
    - For `(d)`,
      - `"Hello"` String literal already exists in `String pool`, So no String object will be created in `String pool`,
      - Since `new String()` is used in `(d)`, So a `String object` will be created in `heap memory`,
  - Total `3` `String object` will be created,

- Another ex: See `stringPoolTest()` in `Test.java`,
    ```
    private static void stringPoolTest(){
        String rohit = "Rohit"; // added to pool
        String salma = "Salma"; // added to pool
    
        String rohitAgain = "Rohit"; // not added
        String rohitNew = new String("Rohit"); // not added to pool, but created in heap
    
        System.out.println(rohit == salma); // false
        System.out.println(rohit == rohit); // true
        System.out.println(rohit == rohitAgain); // true, since referring same object in String pool
        System.out.println(rohit == rohitNew); // false, Remember new always creates new object
    
        String added = "Have" + "Fun"; // added to pool
        String together = "HaveFun"; // not added to pool
    
        System.out.println(added == together); // true, since ("Have" + "Fun") is evaluated at compile time and result "HaveFun" is added to pool
    
        final String constStr = "Constant"; // constStr is a constant since final
        String s1 = constStr + " is pooled"; // "Constant is pooled" will be added to the string pool
    
        String res1 = "Constant is pooled"; // not added to pool
        System.out.println(s1 == res1); // true
    
    
        String varStr = "Variable"; // varStr is not a constant since not final
        String s2 = varStr + " is not pooled";
    
        String res2 = "Variable is not pooled"; // added to pool
        System.out.println(s2 == res2); // false
    }
    ```
  - If you have confusion, practice by yourself. Also see the links provided in last part of `String`,

- `intern()` method:
  - Called as `str.intern()`,
  - If `str` is found in pool, then returns that reference,
  - If `str` isn't found in pool, then create an object in the `String pool` & return reference of the created object,
  - Ex: See `internTest()` in `Test.java`,
    ```
    private static void internTest(){
        String var = "My variable";
        String s2 = (var + " is actually pooled").intern(); // added to pool
    
        String res = "My variable is actually pooled";
        System.out.println(s2 == res); // true. without intern() output is false
    }
    ```

>> Actually you don't need to understand all of these

