
# Exception Handling - part2

## Rethrowing an Exception
- Can be rethrown i.e. can be thrown from `catch` block,
- Can be used for
  - Propagating exception to calling method,
  - Wrapping exception into another exception,
  - Hiding exception details from client,
- Structure:
    ```java
    try {
     ...
    }
    catch(MyException e) {
     throw e; // Rethrowing the same exception
    }
    ```
- Rethrown exceptions must be caught from another outer `try-catch` block,
- Ex: See `rethrowException()` in `Test.java`,
  ```java
  private static void rethrowException(int y){
      try{
          ...
      }catch (Exception e){
          throw new RuntimeException("Can't divide by zero");
      }
  }
  ```
  When calling(See `testRethrow()` in `Test.java`),
  ```java
  try {
      rethrowException(0);
  }catch (Exception e){
      e.printStackTrace(); // executed
  }
  ```
- It can also be handled like this:
  ```java
  try { // outer, will catch rethrown exception
      try { // innner
          ...
      } catch (Exception e) {
          throw new RuntimeException("Can't divide by zero too");
      }
  }catch (Exception e){
      e.printStackTrace(); // executed
  }
  ```
- Location of exception can also be hidden by using `fillInStackTrace()` method,
- Ex: See `m2()`, `m1()` & `hideTrace()` in  `Test.java`,
  ```java
  public static void hideTrace() {
      try {
          m1();
      }
      catch(Exception e) {
          e.printStackTrace(); // hidden original trace
      }
  }
  public static void m1() throws Exception {
      try {
          m2();
      }
      catch(Exception e) {
          e.fillInStackTrace(); // hide trace here -----(a)
          throw e; // rethrowing
      }
  }
  public static void m2() throws Exception {
      throw new Exception("An error has occurred."); // just throw
  }
  ```
  - Stack trace with `(a)`:
    ```log
    java.lang.Exception: An error has occurred.
          at exceptionhandling.part2.Test.m1(Test.java:19)
          at exceptionhandling.part2.Test.hideTrace(Test.java:7)
          at exceptionhandling.part2.Test.main(Test.java:74)
    ```
  - Stack trace without `(a)`:
    ```log
    java.lang.Exception: An error has occurred.
            at exceptionhandling.part2.Test.m2(Test.java:25)
            at exceptionhandling.part2.Test.m1(Test.java:16)
            at exceptionhandling.part2.Test.hideTrace(Test.java:7)        
            at exceptionhandling.part2.Test.main(Test.java:76)
    ```
  - Practice yourself to understand clearly,
  

## Throwing too Many Exceptions
- Can be thrown as many as exception you want,
- Ex: See `throwMultiple()` in `Test.java`,
  ```java
  private static void throwMultiple(Integer y) throws RuntimeException{
      if(y == null) throw new NullPointerException("Can't be null");
  
      if(y == 0) throw new ArithmeticException("Can't be zero");
  
      System.out.println("ok");
  }
  ```


## Accessing the Stack of a Thread
- Each thread is allocated a stack to store its temporary data,
- A thread stores the state of a method invocation onto its stack,
- When a method is called, it is pushed into the stack,
- When method execution is completed, it is popped from stack,
- Suppose we call a method `m1()` from `main()` then,
  - Stack content (from `m1()`) will be 
    - `m1()` on top,
    - `main()` on bottom
  - Stack content (from `main()`) will be
    - `main()` on top
    - Because `m1()` is completed and popped from stack,
- For getting stack content at any given time, we can create an object of the `Throwable` class (or any `Exception` class), it captures the stack of the thread that is executing,
  ```
  Throwable t = new Throwable();
  StackTraceElement[] frames = t.getStackTrace(); // will return current stack content
  ```
- See `StackFrameTest.java` for more,


## The try-with-resources Block
- For closing object of any resources such as `File`,
- It can be done using `finally` also,
- Structure
  ```java
  try (AnyResource aRes = create the resource...) {
   // Work with the aRes here
  }
  ```
- A resource that you specify in a try-with-resources must be of the type java.lang.AutoCloseable,
- When the program exits the try-with-resources block, the `close()` method of all the resources is called automatically,
- Equivalent code using finally
  ```java
  AnyResource aRes;
  try {
    aRes = create the resource...;
  }
  finally {
    try {
     if (aRes != null) aRes.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  ```
- So, `try-with-resource` make code simpler,
- Ex: see `MyResource.java` & `Test2.java`
  ```java
  public class MyResource implements AutoCloseable{
      private MyMessage myMessage;
      ...
  
      public MyResource(String message, int id, String sender) {...}
      ...
      
      @Override
      public void close() throws Exception { // must
          myMessage = null;
          System.out.println("Closed "+sender);
      }
  }
  ```
  See `testTryWithResource()` in `Test.java`,
  ```java
  private static void testTryWithResource(){
      try(
              MyResource res1 = new MyResource("Hello world!",1,"Saeed");
              MyResource res2 = new MyResource("Hi world!",2,"None");
      ){
          System.out.println(res1.getSender()); // Saeed
          System.out.println(res2.getSender()); // None
      }
      catch (Exception e){
          System.out.println("Something went wrong");
      }
      // Closed None. JVM automatically call close method on res2
      // Closed Saeed. JVM automatically call close method on res1
      System.out.println("Resource will be closed before this"); // Resource will be closed before this
  }
  ```
- Output
  ```text
  Saeed
  None
  Closed None
  Closed Saeed
  Resource will be closed before this
  ```
- It's actually useful. Just make sure your resource class implements `AutoCloseable` & has `close()` method,



<!-- bottom_nav_bar_1243 -->
<div align="center">
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/exceptionhandling/part1/">
    <img src="https://img.shields.io/badge/◀%20Previous-blue?style=for-the-badge" alt="Previous">
</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/assertion/">
    <img src="https://img.shields.io/badge/Next%20▶-blue?style=for-the-badge" alt="Next">
</a>
</div>
<!-- bottom_nav_bar_1243 -->
    