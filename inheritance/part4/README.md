
# Inheritance - part4

## Method overloading
- Having more than one method with the `same name` in the `same class`,
- Methods could be declared methods, inherited methods, or a combination of both,
- At least one of this must differ: 
  - `Number of parameters,` 
  - `Types of parameters`,
- Things that doesn't matter:
  - The return type, 
  - Access level,
  - `throws` clause,
- It is another kind of polymorphism where the same method name has different meanings,
- It is bound at `compile time` as opposed to `method overriding` that is bound at runtime,
- For an overloaded method call:
  - Compiler chooses the **most specific** method,
  - If it **doesn't** find an exact match, it will try to **look for a more generic version** by converting actual parameter into a more generic type,

- Ex-1:
    ```java
    private static int add(int x, int y){
        int res = (x+y);
        System.out.println("int add");
        return res;
    }
    
    private static double add(double x, double y){
        double res = x+y;
        System.out.println("double add");
        return res;
    }
    ```
    Calling like:
    ```java
    System.out.println( add(5,10) ); // 15
    System.out.println( add(5.0,10) ); // 15.8
    ```

- Ex-2:
    ```java
    public class MyMath {
        public double sub(int a, double b) { return a - b; }
  
        public double sub(double a, int b) { return a - b; }
    }
    ```
    Calling like:
    ```java
    MyMath myMath = new MyMath();
    myMath.sub(5.0,2); // fine
    myMath.sub(5,2.0); // fine
    //myMath.sub(5,5); // ambiguous - compile-time error
    ```
- Last one is ambiguous, because compiler can use both `sub()` methods,
- Most of the error will be compile-time. So don't worry,

> Overloading is simple. Just don't be confused,

## Inheritance and Constructors
- Constructors are `not inherited by subclasses` since they are not member of a class,
- To initialize the instance variables of `Parent` classes, the constructors of `Parent` class must be called,
- `super` keyword is used in child class for calling parent class constructor,
- Constructor of `Parent` class is called first then `Child` class,
- Ex:
  ```java
  public class Parent {
      public Parent() {
          System.out.println("parent constructor");
      }
  }
  ```
  ```java
  public class Child extends Parent{
      public Child() {
          // super(); // is automatically inserted
          System.out.println("Child constructor");
      }
  }
  ```
  Calling like this:
  ```java
  private static void testConstructorSequence(){
      Child child = new Child();
      /*
       Output
       parent constructor
       Child constructor
      */
  }
  ```
- Here `super()`:
  - Calls `Parent` class constructor,
  - Calls no argument constructor of `Parent` class,
  - Is automatically added by compiler,
  - Must be the first statement of a constructor,
- If constructor of `Parent` class takes some parameter then simply pass those inside `super(here)`,
- Ex:
  ```java
  public class Vehicle {
      String brand;
      public Vehicle(String brand) {
          this.brand = brand;
      }
      ...
  }
  ```
  ```java
  public class Car extends Vehicle{
      int noOfDoors;
      public Car(String brand, int noOfDoors) {
          super(brand); // <------------ calling parent class constructor and passing brand value
          this.noOfDoors = noOfDoors;
      }
      ...
  }
  ```
  Using like this:
  ```java
  private static void testConstructorParameter(){
      Car myCar = new Car("Toyota", 4);
  
      System.out.println(myCar.brand); // Toyota
      System.out.println(myCar.noOfDoors); // 4
  }
  ```

## Method hiding
- `Child` class inherits all non-private static methods of `Parent` class,
- Redefining a static method in `Child` class hide the static method in `Parent` class,
- The redefined static method in a subclass is said to hide the static method of its superclass,
- Recall that redefining a non-static method in a class is called `method overriding`, not `method-hidiing`,
- Redefining rules are same as method overriding rules,
- Remember, early binding is used for static methods,
- Ex:
  ```java
  public class SuperClass {
      public static void print() {
          System.out.println("Super.print()");
      }
  }
  ```
  ```java
  public class SubClass extends SuperClass{
      public static void print() {
          System.out.println("Sub.print()");
      }
  }
  ```
  ```java
  private static void testHidingBasic(){
  
      SuperClass spr = new SuperClass();
      SubClass sub = new SubClass();
  
      SuperClass.print(); // Super.print()
      spr.print(); // Super.print()
    
      SubClass.print(); // Sub.print()
      sub.print(); // Sub.print()

      ((SuperClass) sub).print(); // Super.print() <----(a)
  
      spr = sub;
      spr.print(); // Super.print() <---------------(b)
      ((SubClass) spr).print(); // Sub.print()  
  }
  ```
- Explanation of above example:
  - All are normally executed till `(a)`,
  - At `(a)`, 
    - The `compile-time` type of the `sub` variable is `SubClass`,
    - After typecasting, the `compile-time` type of `(SuperClass)sub` becomes `SuperClass`,
    - So `print()` of `SuperClass` is being called,
  - At `(b)`,
    - After `spr = sub;`, `compile-time` type of `spr` is still `SuperClass`,
    - So, `print()` of `SuperClass` is being called,
  - Last one is similar to `(b)`,
  
- A static method of a class cannot hide an instance method of its superclass
- It just hides the `Parent` class implementation of a static method, Nothing more,
- **Remember, always call static method using ClassName,**


## Field Hiding
- A field (`static` or `non-static`) in a `subclass` hides the inherited field with the same name in its `superclass`,
- Occurs solely based on the field `name`,
- The `type of the field` and its `access level` doesn't matter,
- Remember, `early-binding` is used for field access,
- Use `super` keyword to access the hidden fields of the `superclass`,
- Ex:
  ```java
  public class Mother {
      private static final String PREFIX = "MRS";
      protected String name;
  
      public Mother(String name) {
          this.name = name;
      }
  
      public void printFormattedName(){
          System.out.println(PREFIX+" "+name);
      }
      ...
  }
  ```
  ```java
  public class Daughter extends Mother{
      private static final String PREFIX = "MISS";
      private String name;
  
      public Daughter(String name) {
          super("Don't know");
          this.name = name;
      }
  
      public void printParentField(){
          System.out.println(super.name);
      }
  
      public void printFormattedName(){
          System.out.println(PREFIX+" "+name); // will use daughter name. hide name of Daughter
      }
      ...
  }
  ```
  Using like this:
  ```java
  private static void testFieldHiding(){
   
      Mother mother = new Mother("Rumi");
      Daughter daughter = new Daughter("Tisha");
  
      mother.printFormattedName(); // MRS Rumi
      daughter.printFormattedName(); // MISS Tisha
      daughter.printParentField(); // Don't know
  
  }
  ```


<!-- bottom_nav_bar_1243 -->
<div align="center">
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/inheritance/part3/">
    <img src="https://img.shields.io/badge/◀%20Previous-blue?style=for-the-badge" alt="Previous">
</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/inheritance/part5/">
    <img src="https://img.shields.io/badge/Next%20▶-blue?style=for-the-badge" alt="Next">
</a>
</div>
<!-- bottom_nav_bar_1243 -->
    