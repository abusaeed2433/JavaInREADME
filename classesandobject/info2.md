
# Classes and Object part-2
> Codes are in `partTwo` package

## Local variable
- Variable declared inside `method`, `constructor`, `block`,
- Formal parameters for a method are treated as local variables,
- `Not initialized` by default,
- Can't be used until it is assigned a value. Will show `error` instead of garbage value,
- Must be declared before it is used,
- If variables having same name found, local variable get precedence,
- See `LocalVariable.java` for full code,
  ```
  public class LocalVariable {
      ...
      private int num; // global, value = 0
      ...
  
      public void assignMust(){
          int num; // local, no default value
          //System.out.println(num); // error. Not initialized.
      }
  
      public int calculateDifference(int num2){
          int num = 1001; // local
          System.out.println(num); // 1001 since local get precedence
          return this.num - num2; // this.num refers to global num
      }
  }
  ```

## Null
- A `special reference type` called `null type`,
- It has no name,
- `Assignment compatible` with any other `reference` type. Ex:
  ```
  String name = null; // ok
  Integer number = null; // ok
  Hooman none = null; // ok
  int count = null; // error. int is not reference type. Remember?
  ```
- After making `sh = null;`, the object `sh` was referring will be destroyed by JVM, since it is no longer accessible.
  ```
  Hooman sh = new Hooman("sh",22);
  sh = null;
  ```

## this
- Extremely useful keyword,
- Reference to the `current instance` of a class. (Alert it's for `instance`, not class),
- Can be used only in the context of an `instance/object`,
- Ex: See `TriState.java`,
  ```
  public class TriState {
      ...
      private StateEnum state = StateEnum.FIRST; // will be discussed later
      public TriState(StateEnum state) { // state = SECOND is passed
          System.out.println(this.state); // FIRST
          System.out.println(state); // SECOND
          this.state = state; // this.state refers to the global state --- (a)
      }
      ...
  }
  ```
- Creating instance of above class
  ```
  TriState triState = new TriState(SECOND);
  System.out.println(triState.state); ---- (b)
  ```
- `triState.state` in outside is same as `this.state` inside the class for a specific object of the class. See `(b)` and `(a)`.
- Practice yourself,

## final
- `prevent modification` on which it is used,
- For declaring `constant`,
- Can be used in the following `3` contexts:
  - `Variable`
    - Can be `assigned` a value `only once`,
    - `Can't reassign` after assigning,
    - Can be assigned while declaration or later,
    - If you do not initialize a final variable at the time of its declaration, such a variable is known as a `blank final` variable,
    - Ex: 
      ```
      final int total;
      ```
  - `Class`:
    - final class can't be `extended` or `inherited`,
  - `Method`:
    - final method can't be `redefined` (`overridden` or `hidden`) in the `subclasses`,

## final local variable && final parameter
  - Ex: See `getArea()` of `Test.java`:
    ```
    private static double getArea(final double r){ // final parameter
       final double pi = 3.1415; // final local variable
       //pi = 3; // error
       //r = 5; // error
       return pi*r*r;
    }
    ```

## final instance variable
- Can be `final` or `blank final`,
- `Rules` apply for `initializing` a `blank final` instance variable:
  - Must be initialized in `one of the instance initializers` or in `all` constructors,
  - Don't be confused. Just remember that you can only `assign value at once`. If you try to reassign it, you will get error,
- All `blank final` variables and `final reference variables` are runtime constants. i.e. they are calculated at runtime,
- Ex: See `Circle.java`,
  ```
  public final class Circle {
  
      public static final double PI = 3.14159; // final
  
      private final double r; // blank - final
  
      public Circle() {
          this.r = 0;
      }
  
      public Circle(double r) {
          this.r = r;
      }
  
      public Circle(Circle c){
          this(c.r); // it will assign value
          //this.r = c.r; // error, since already assigned in previous line
      }
  
      public double getArea(){
          return PI * r * r;
      }
  
  }
    
  ```
## final class variable
- Same like previous,
- Good practice to use `capital letter` for variable naming,
- Ex:
  ```
  public static final double PI = 3.14159;
  ```

## Varargs
- Full form is `variable-length arguments`,
- Can be used both in method and `constructor`,
- 3dots(`...`) is used,
- We can pass any number of arguments, parameter will work like `array`. But we don't have to pass array explicitly,
- Ex: See `max()` in `Test.java`,
  ```
  private static int max(int... arr){
      if(arr.length == 0) return 0;
      int mx = Integer.MIN_VALUE;
      for(int num : arr){
          if(num > mx) mx = num;
      }
      return mx;
  }
  ```
  Using like this:
  ```
  System.out.println( max() ); // 0
  System.out.println( max(1,22) ); // 22
  System.out.println( max(1,2,3,4,5,6,7,8,10) ); // 10
  ```
- Isn't it awesome?
- There is `2` restriction:
  - A varargs method can have `maximum one varargs`,
     ```
     // n1 has infinite length, so n2 is not needed. error
      void m1(String str, int...n1, int...n2) {
       ...
     }
     ```
  - The varargs `must be the last argument` in the argument-list. Same reason even though parameter type is different.
     ```
     void m2(int...n1, String str) {
      ...
     }
    ```
    This is perfectly valid: See `findMinMax()` `Test.java`,
     ```
     private static int findMinMax(boolean findMax, int ...arr){...}
     ```

## Generic class
- Allows for writing `true polymorphic` code(Works for any types),
- Structure:
  ```
  public class Wrapper<T> {
   // Code for the Wrapper class goes here
  }
  ```
- `T` is a `type variable`. It can be of any type, but must be reference type,
- Ex: See `MyList.java`,
  ```
  public class MyList <T>{
      private final List<T> list = new ArrayList<>();
      
      public MyList() {}
  
      public void add(T item){
          list.add(item);
      }
  
      public T get(int index) throws ArrayIndexOutOfBoundsException{...}
  
  }
  ```
  Using like this: See `simpleGenericTest()` in  `Test.java` ,
  ```
  private static void simpleGenericTest(){
    MyList<Integer> myList = new MyList<>();
    //MyList myList = new MyList<>(); // ok but not recommended.
    myList.add(12);
    myList.add(32);
    myList.add(42);
    myList.add(62);
  
    //System.out.println( myList.get(5) ); // Index out of bound
  
    System.out.println( myList.get(1) ); // 32
  }
  
  ```
- Above one is a simple example. Learn more by yourself if you want to,

