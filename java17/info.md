
# CF changes from java-8 to java-17

## New `var` keyword
- A new `var` keyword was added that allows local variables to be declared in a more concise manner,
- Ex:
    ```
    var name = new String("hello");
    System.out.println(name); // hello
    
    var student = new Student(121,"Doniel",5.9);
    System.out.println(student.getName()); // Doniel
    System.out.println(student.getHeight()); // 5.9
    ```

## Extended switch expressions
- Cleaner and less error-prone syntax,
- `case` label followed by `->` followed by one of the following:
  - `An expression`, including but not limited to a constant value,
  - A `throw` statement,
  - A `code block` using opening and closing curly brackets
- Ex:
    ```
    int i = 20;
    switch (i){
        case 10 -> {
            System.out.println(10);
            System.out.println("10");
        }
        case 20-> System.out.println(20); // executed
        default-> System.out.println("Other");
    }
    
    i = 40;
    String message = switch (i){
        case 10 -> "10";
        case 20 -> "20";
        case 30 -> throw new RuntimeException("idk");
        case 40 ->{
            System.out.println("40"); // executed
            yield "like return";
        }
        default -> "none";
    };
    
    System.out.println(message); // like return
    ```

## `instanceof` pattern matching
- Till now, we do like this
  ```
  Student student = new PartTimeStudent(12,"Imran",5.5,12);
  PartTimeStudent partTimeStudent;
  if(student instanceof PartTimeStudent){
    partTimeStudent = (PartTimeStudent)student; 
  }
  ```
- Above can be simplified like this:
  ```
  Student student = new PartTimeStudent(12,"Imran",5.5,12);
          
  if(student instanceof PartTimeStudent partTimeStudent){
    // partTimeStudent
  }
  ```

## Sealed Classes
- Another way to `disable inheritance` introduced in `Java 17`,
- Allows you to define a class and exactly `what classes can subclass it`,
- Subclass of Sealed class must define their status: `final`, `sealed`, or `non-sealed`,
- Ex(Sealed class):
  ```
  public abstract sealed class Security permits Lock, Pin, Password { }
  ```
  Inheriting `sealed-class`:
  ```
  final class Lock extends Security{ } // no class can inherit it

  non-sealed class Pin extends Security{ } // any class can inherit it

  sealed class Password extends Security permits MyPassword{ } // same as sealed
  ```
  Inhering `subclass` of `sealed-class`,
  ```
  final class MyPassword extends Password{} // inherited above sealed class
  
  class MyPin extends Pin{} // Since Pin class can be inherited by any class
  ```
  
## Multiline Strings
- Is done via `TextBlocks`,
- A `text block` must start
  - with `three quotation marks`, then
  - `a new line`, then 
  - your text as you write normally,
- Ex(Earlier way):
  ```
  String formattedTextEarlier = "This is first line.\n"+
          "THis is second line.\n"+
          "Continue like that";
  System.out.println(formattedTextEarlier);
  ```
  New way:
  ```
  String formattedText = """
          This is first line.
          THis is second line.
          Continue like that""";
  System.out.println(formattedText);
  ```
  Output:
  ```
  This is first line.
  THis is second line.
  Continue like that
  ```
  Below one is `invalid` since uou can't write just after first `"""`,
  ```
  String formattedText2 = """This is first line.
          THis is second line.
          Continue like that""";
  ```


## Record
- Previous way:
  ```
  public class Person {
      final String name;
      final int age;
  
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public String getName() {
          return name;
      }
  
      public int getAge() {
          return age;
      }
  }
  ```
  New way:
  ```
  public record PersonRecord(String name, int age) { }
  ```
  Using like this:
  ```
  Person student = new Person("Saeed",2345);
  
  PersonRecord record = new PersonRecord("Saeed",2345);
  
  System.out.println(student.getName() + " - " + record.name()); // Saeed - Saeed
  System.out.println(student.getAge() + " - " + record.age()); // 2345 - 2345
  ```
