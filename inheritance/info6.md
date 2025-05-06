
# inheritance part-6
> Codes are in `partSix` package


## Method Overriding and Generic Method Signatures
- When Java codes with generics types is compiled, the generic types are transformed into raw types
- The process that is used to transform the generic type parameters information is known as `type erasure`,
- Ex: See `GenericSuper.java`, `GenericSub.java`,
    ```
    public class GenericSuper<T> {
        public void m1(T a) { }
    
        public <P extends Employee> void m2(P a) { }
    }
    ```
    When the `GenericSuper` class is compiled, the `erasure` transforms the code during compilation and the resulting code looks as shown
    ```
    public class GenericSuper {
        public void m1(Object a) { }
    
        public void m2(Employee a) { }
    }
    ```
- Overriding generic class like:
    ```
    public class GenericSub extends GenericSuper<Object>{
        public void m1(Object a) { }
    
        public void m2(Employee a) { }
    }
    ```
- In overriding generic class,
  - You may think that they(`m1()`, `m2()`) don't have the same signature. But,
  - If a method uses generic parameters, you need to compare its `erasure`, not the generic version of its declaration,
  - So, comparing with `erasure`, overriding is completely valid,


## Typo Danger in Method Overriding
- Ex:
  ```
  public void m1(double num) { } // in Parent class
  ```
  ```
  public void m1(int num) { } // in Child class
  ```
  Here 2nd `m1()` won't override 1st `m1()` since parameter type is different,
- Always use `@Override` annotation in `overriding-method`,
- After using `@Override` annotation, compiler will check if overriding is actually done. If not it will show compile-time error,

## is-a relationship
- This is nothing but `inheritance`,
- Ex: `FullTimeStudent` is a `Student`,

## Aggregation / has-a relationship
- An object of a class contains an object of another class,
- It is known as `aggregation`,
- Ex: See `Person.java`, `Address.java`,
  ```
  public class Address {
      private String street;
      private String city;
      private String state;
      private int postalCode;
  
      public Address(String street, String city, String state, int postalCode) {
          this.street = street;
          this.city = city;
          this.state = state;
          this.postalCode = postalCode;
      }
      ...
  }
  ```
  ```
  public class Person {
      private String name;
      private String phone;
      private String email;
      private Address address; // <--------------------(a)
  
      public Person(String name, String phone, String email, Address address) {
          this.name = name;
          this.phone = phone;
          this.email = email;
          this.address = address;
      }
      ...
      public void setAddress(Address address) {
          this.address = address;
      }
  }
  
  ```
  At line `(a)`, `Person` class has an `Address` variable for storing `Address` info of the student,
- This is `has-a` relationship. Since above relation can be expressed as `Person has an Address`,
- In above example, instead of `Address` field in `Person` class, we can use all fields of `Address` class. But,
  - It will make code hard to understand, &
  - It Will be complex if we want `Person` to have multiple `Address`,

## Composition / part-of relationship
- Known as `composition`,
- Strong type of `aggregation`,
- The `whole`(main) controls the creation/destruction of the `part`(nested),
- Sometimes existence of an object only make sense inside another object,
- For example: `MobileDisplay` is a part of a `Mobile`, & 
- If `Mobile` is destroyed then its `MobileDisplay` is also destroyed,
- Ex-1(`Nested class`): See `Mobile.java`, `testComposition1()` in `Test.java`,
  ```
  public class Mobile {
      private String brand;
      private MobileDisplay display;
  
      public Mobile(String brand) {
          this.brand = brand;
          this.display = new MobileDisplay(16);
      }
      ...
      public void showData(){ display.showSomething(); }
  
      private class MobileDisplay { // <-------------- nested class
          private int density;
          public MobileDisplay(int density) { this.density = density; }
  
          private void showSomething(){
              for(int i=0; i<density; i++){
                  System.out.print("@");
              }
              System.out.println("");
          }
          ...
      }
  
  }
  ```
  Can be used like this:
  ```
  private static void testComposition1(){
      Mobile mobile = new Mobile("Nokia");
      mobile.showData(); // @@@@@@@@@@@@@@@@
  }
  ```
- In above example, you can't use `MobileDisplay` outside `Mobile` class. But it may be needed to use `MobileDisplay` others,

- Ex-2: See `Engine.java`, `Car.java`, `testComposition2()` in `Test.java`,
  ```
  public class Engine {
      private String type;
      ...
  }
  ```
  ```
  public class Car {
      private String brand;
      private Engine engine;
  
      public Car(String brand, String engineType) {
          this.brand = brand;
          this.engine = new Engine(engineType); // creating here
      }
  
      public String getBrand() {
          return brand;
      }
  
      public Engine getEngine() {
          return engine;
      }
  
  }
  ```
  Using like this:
  ```
  private static void testComposition2(){
  
      Car myCar = new Car("Toyota", "Gasoline");
      System.out.println(myCar.getBrand()); // Toyota
      System.out.println(myCar.getEngine().getType()); // Gasoline
  }
  ```
- Use whatever you need based on your need,
- In both example, nested object(`part`) can't exist without the existence of main(`whole`) object, since `Engine` and `MobileDisplay` are created inside the `Car` and `Mobile` class,

## aggregation vs composition
<table>

<tr>
  <th>Aspect</th>
  <th>Aggregation</th>
  <th>Composition</th>
</tr>

<tr>
  <td>Relationship</td>
  <td>Indicates Has-a relationship</td>
  <td>Indicates part-of relationship</td>
</tr>

<tr>
<td>Lifespan</td>
<td>Both object has independent life-cycle</td>
<td>Lifecycle of part is dependent on whole</td>
</tr>

<tr>
<td>Example</td>
<td>Peron has an Address</td>
<td>Engine is part of Car</td>
</tr>

</table>

## inheritance or composition ?
- Both let you share the code,
- Whenever you are in doubt in choosing between `composition` and `inheritance`, give preference to `composition`,
