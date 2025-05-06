

# interface part-3

> CODES ARE IN `partThree` PACKAGE

## Interface Defines a New Type
- An `interface` defines a new reference type,
- You can use an `interface` type anywhere you can use a reference type,
- All rules for a reference type variable apply to a variable of an `interface` type,
- Let us see through an example:
- See `Swimmable.java`, `Swimmer.java` & `Test.java`
    ```
    public interface Swimmable {
        double DEFAULT_SPEED = 20;
        void swim();
    }
    ```
  ```
  public class Swimmer implements Swimmable{
      ...
      private Swimmable swimmable; // global variable
  
      ...
  
      public Swimmable getSwimmable() {
          if(swimmable == null){
              swimmable = this; // referring to this instance
          }
          return swimmable;
      }
  
      public Swimmable getSwimmable() {
          Swimmable swimmable = this; // local variable
          if(this.swimmable == null){
              this.swimmable = swimmable;
          }
          return swimmable;
      }
      ...
  }
  ```
  Calling like this:
  ```
  private static void testReferenceType(){
      Swimmer swimmer = new Swimmer("John",1);
      swimmer.swim(); // calling function
  }
  ```
- A variable of an interface type refers to an object in memory whose class implements that interface,
- Variable of interface type:
  - Can be `null`,
  - Can access constant field,
  - Instant & static variable are initialized to `null` by default,
  - Ex: See `Test.java`,
    ```
    private static void testOperationOnVariable(){
        Swimmable swimmable = null; // can be null
        System.out.println(swimmable);
  
        swimmable = new Swimmer("Tamim",60);
        double speed = swimmable.DEFAULT_SPEED; // can access constant field
        System.out.println(speed); // 20.0
          
    }
    ```

## Implementing an Interface
- An `interface` defines a `specification` for objects about how they will communicate with other objects, i.e,
- `interface` specifies how communication will be made between objects. i.e,
- `interface` specifies method and `implementing-class` provides `implementation` for that method,
- A `specification` is a set of statements,
- `implementation` is the realization/execution of those statements,
- When a class implements an `interface` is known as `implementing-class`,
- `implementing-class` must provide implementations for all `abstract` methods of the interface if the class is not `abstract` itself,
- `implementing-class` can also override `default` method of an `interface`,
- Ex: See `Swimmable.java` & `Swimmer.java`:
  ```
  public interface Swimmable {
      ...
      void swim();
  }
  ```
  implementing class definition is like
  ```
  public class Swimmer implements Swimmable{
      ...
      @Override
      public void swim() { // must have to provide implementation
          System.out.println("Swimming...");
      }
  
  }
  ```
- As discussed earlier, variable of `interface` can hold object of `implementing-class` &
- Assignment rules are similar to object assignment rules,
- Ex:
  ```
  private static void variableTest(){
      Swimmable tuna = new Swimmer("Tuna",22);
      Swimmable dolphin = new Swimmer("Dolphin",23);
  
      Swimmer shark = new Swimmer("Shark",45);
  
      tuna = dolphin; // valid
      dolphin = tuna; // valid
  
      tuna = shark; // valid
      dolphin = shark; // valid
  
  
      shark = tuna; // invalid
      shark = dolphin; // invalid
  
  }
  ```

## Implementing Interface Methods
- `implementing-class` must provide implementation for abstract method in `interface`,
- Methods in an `interface` are implicitly public,
- Implementing `throws` clause is optional in `implementing-class`. But,
- You can't throw any exception that are not listed in interface,
- Ex: `MyCheckedException.java`, `Pressable.java` & `MyView.java`,
  ```
  public class MyCheckedException extends Exception{  
      public MyCheckedException() {
          // does nothing
      }
  }
  ```
  ```
  public interface Pressable {
      int LONG_PRESS_DURATION = 200; // ms
  
      void onPressed() throws IOException;
      void onClicked();
  }
  ```
  ```
  public class MyView implements Pressable{
  //    @Override
  //    public void onPressed() {} // ok. dropping exception

  
      @Override
      public void onPressed() throws IOException {}
  
  
  //    @Override
  //    public void onPressed() throws Exception {} // error. Can't throw new exception

  
  //    @Override
  //    public void onClicked() throws MyCheckedException{} // invalid. can't add checked exception

  
      @Override
      public void onClicked() {}
  }
  ```
- General rule of thumb:
  - If it makes sense to you, it's ok,
  - If `overriding-method` in class relaxes the restrictions declared in the interface, then ok. Otherwise, not ok,
  - `relaxes` means ignoring some exception like shown in above example,
- Ignore all of these. Override method as it is defined in `interface`,



## Implementing Multiple Interfaces
- A class can implement multiple `interfaces`,
- Must have to override all `abstract` methods of all `interfaces`,
- Ex: See `Clickable.java`, `Pressable.java` & `MyCustom.java`,
  ```
  public interface Clickable {
      default void onClicked(){...}
  }
  ```
  ```
  public interface Pressable {
      ...
      void onPressed() throws IOException;
      void onClicked();
  }
  ```
  ```
  public class MyCustom implements Clickable,Pressable{
      
      @Override
      public void onPressed() throws IOException {}
  
      @Override
      public void onClicked() {
          Clickable.super.onClicked(); // <----------(a) 
      }   
  }
  ```
  - In statement `(a)`, it is calling `onClicked()` method of `Clickable` interface,
  - We have defined `onClicked()` in both in `Clickable` and `Pressable` interface,
  - In `Clickable` interface, we have provided a default implementation of `onClicked()` method,
  - We are calling the default implementation of `Clickable` interface when overriding in `MyCustom` class,
  - You can provide your own implementation instead of calling the default method,
- You can implement multiple interfaces in a class & those interface may contain some common method,
- There is no problem if interfaces contain common method. Because we are providing our own implementation by overriding that method in `implementing-class`,
- There is no such problem like `Diamond-problem` in implementing multiple interfaces,


## Partially Implementing an Interface
- A class can partially implement an `interface` iff it is declared as `abstract`,
- Remember, `abstract-class` can have abstract method,
- So, if a class implement few methods of an interface, then it will have to be `abstract`,
- When a class inherit this `abstract-class`, it has to override all methods,
- Simple concept. Don't be confused,
- Ex: see by yourself,


## The Supertype-Subtype Relationship
- Implementing an `interface` to a class establishes a supertype-subtype relationship,
- The class becomes a subtype of all the interfaces it implements,
- All interfaces become a supertype of the class,
- A subtype can be used wherever supertype can be used(`Substitution rule`),
- Ex: See `MyCustom.java`,
  ```
  public class MyCustom implements Clickable,Pressable{
     ...
  }
  ```
  - Here `MyCustom` class is like subtype, and `Clickable`, `Pressable` are like supertype,
  
- Ex: See `Test.java`,
  ```
  private static void requestClick(Clickable clickable){
      clickable.onClicked();
  }
  ```
  ```
  private static void subSuperTest(){
      Clickable clickable = new MyCustom();
      requestClick(clickable); // Clicked in clickable
  
      MyCustom myCustom = new MyCustom();
      requestClick(myCustom); // Clicked in clickable
  }
  ```
  - Here parameter of `requestClick` method is of `Clickable` type. But,
  - We can pass object of `MyCustom` class. Remember `Substitution rule`,
