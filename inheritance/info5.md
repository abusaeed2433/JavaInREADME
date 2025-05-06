
# inheritance part-5
> Codes are in `partFive` package

## Disabling Inheritance
- Prevent class from being used as parent class,
- Done by making a class final by adding `final` in class declaration,
- A method can be `final` also,
- A final method cannot be `overridden` or `hidden` by a `subclass`,
- Ex: `String` class is `final`,
- Why to disable inheritance? 
  - CF reasons are `security`, `correctness`, & `performance`,
  - If your class is important for security reasons, you do not want someone to inherit from your class and mess with the security that your class is supposed to implement,
  - A `final` method may result in better performance at runtime because a code optimizer is free to inline the final method calls,
- Ex of `final-class`: 
  ```
  public final class Parent{ }
  ```
  ```
  public class Child extends Parent{} // compile-time error
  ```
- Ex of `final-method`: See `DummyParent.java`, `DummyChild.java`,
  ```
  public class DummyParent {
  
      protected final void start(){
          System.out.println("Parent starting...");
      }
  }
  ```
  ```
  public class DummyChild extends DummyParent{
  
      protected final void start(){ //compile time error
          System.out.println("Parent starting...");
      }
  }
  ```

## Abstract Classes and Methods
- A class whose instance can't be created,
- Opposite of `abstract-class` is `concrete-class`,
- Abstract class 
  - Indicates that the class has some incomplete method, 
  - Considered incomplete for object creation purposes,
- Abstract method
  - Has a declaration, but no `body` at all,
  - Braces are replaced with a semicolon(`;`),
  - Indicated using `abstract` keyword,
- An `abstract-class` may have all concrete methods or no concrete methods at all,
- For sake of understanding:
  - Declaring a class as abstract is like placing an `under construction` sign in front of a building,
  - If an `under construction` sign is placed in front of a building, it is not supposed to be used (not supposed to be created in case of a class),
  - It does not matter whether the building is complete(`all concrete methods`) or not(`some abstract methods`),
- Mainly used for using as `Parent` class,
- It is completely similar like normal class, only difference is, you can't create object of `abstract-class`,
- Ex: See `Shape.java`, `Circle.java`, `Rectangle.java` & `testAbstract()` in `Test.java`,
  ```
  public abstract class Shape {
      protected final double PI = 3.14159;
      private String name;
      
      public Shape(String name) {
          this.name = name;
      }
      ...
      protected abstract void draw();
      protected abstract double getArea();
  }
  ```
  ```
  public class Circle extends Shape{
      private double r;
  
      public Circle(String name, double r) {
          super(name);
          this.r = r;
      }
  
      @Override
      protected void draw() {
          System.out.println("Circle");
      }
  
      @Override
      protected double getArea() {
          return PI*r*r;
      }
  }
  ```
  ```
  public class Rectangle extends Shape{
      private double width;
      private double height;
  
      public Rectangle(String name, double width, double height) {
          super(name);
          this.width = width;
          this.height = height;
      }
      ...
      
      @Override
      protected void draw() {
          System.out.println("Rectangle");
      }
      
      @Override
      protected double getArea() {
          return width*height;
      }
  }
  ```
  Using like this:
  ```
  private static void testAbstract(){
      Shape rectangle = new Rectangle("Rectangle",5,10); // <----(m)
      rectangle.draw(); // Rectangle
  
      Shape circle = new Circle("Circle",5); // <-------------(a)
      System.out.println(circle.getArea()); // 78.53975 <-----(b)
  }
  ```
- In above example, `(a)` & `(b)` involve these `OOP` concept:
  - `abstract-class`: `Shape` class is abstract,
  - `abstract-method`: `draw()` and `getArea()` are `abstract`,
  - `upcasting`: Object of `Circle` is cast to `Shape` type at `(a)`,
  - `method-overriding`: `draw()` & `getArea()` are overridden in `Circle` and `Rectangle` class,
  - `late-binding`: At `(b)`, `getArea()` is determined at runtime,
  - `runtime-polymorphism`: `(m)`, `(a)` & method calls,
- The greatest advantage of declaring an `abstract method` in a class is to force its `subclasses` to `override` and provide implementation for those methods,
- Ex-2: See `testAbstract2()` in `Test.java`,
  ```
  private static void printName(Shape[] shapes){
      for(int i=0; i<shapes.length; i++){
          Shape sp = shapes[i];
          System.out.print(sp.getName());
  
          if(i != shapes.length - 1) System.out.print(", ");
      }
      System.out.println("");
  }
  
  private static void testAbstract2() {  
      Shape[] shapes = new Shape[6];
  
      for(int i=0; i<shapes.length; i++){
          int rand = new Random().nextInt(10);
          shapes[i] = (rand % 2 == 0) ? new Rectangle("Rectangle",2,4) : new Circle("Circle",5);
      }
      printName(shapes); // Circle, Circle, Circle, Rectangle, Rectangle, Circle
  }
  ```
  - As you can see it doesn't matter which object variable of `Shape` class holding,
  - We can simply call the method, and it will be determined at runtime,
- Just see a bit
- An abstract class cannot be declared `final`. Since `final class` cannot be `subclassed`, which conflicts with the requirement of an `abstract-class`,
- An `abstract-class` shouldn't declare all constructors `private`. Otherwise, the `abstract-class` cannot be subclassed,
- An `abstract-method` can't be declared `static`,
- An `abstract-method` can't be declared `private`. Recall that a `private-method` isn't inherited and hence it can't be overridden,
- An `abstract-method` in a class can `override` an `abstract-method` in its superclass without providing an implementation,
- A `concrete instance method` may be overridden by an `abstract instance method`,
- An abstract method cannot be declared `native`, `strictfp`, `synchronized`. Because, 
  - These keywords refer to implementation details of a method, But
  - an abstract method does not have an implementation,

