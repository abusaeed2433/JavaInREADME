
# Object part-2
> Codes are in `partTwo` package

## Cloning Objects
- Java doesn't provide an automatic mechanism to clone (make a copy) an object,
- For two reference variable `x` & `y`,
  - `x = y`,(Assigning `y` into `x`)
    - Copy reference of `y` into `x`, 
    - Doesn't copy the content of the object that `y` refers to,
- For cloning , you must implement `Clonable` interface to your class. Why? See `Marker interface` in interface section,
- `clone()` method in `Object` class is as follows:
  ```
  protected Object clone() throws CloneNotSupportedException
  ```
- `clone()` method
  - It is `protected`, so you must `override` it for using in your class,
  - Return type is `Object`. So, you have to cast it after cloning,
  - You do not need to know any internal details of it, 
  - The `clone()` method in the Object class has all the code that is needed to clone an object,
  - Just call the `clone()` method of your class,
  - It will make a `bitwise copy` of the original object and return the reference of the copy,
  
- Ex-1: See `Student.java`,
  ```
  public class Student implements Cloneable{
      ...
      @Override
      protected Object clone() {
          try {
              return super.clone(); // calling default clone()
          }catch (CloneNotSupportedException e){
              return null;
          }
      }
  }
  ```
  Calling like this: See `cloneTest()` in `Test.java`,
  ```
  private static void cloneTest(){
  
      Student who = new Student(269,"who",23,173);
  
      System.out.println(who); // roll: 269, name: who, age: 23, height: 173.0
  
      Student copied = (Student) who.clone();
  
      System.out.println(copied); // roll: 269, name: who, age: 23, height: 173.0
  
      copied.setAge(30);
      System.out.println(copied); // roll: 269, name: who, age: 30, height: 173.0
      System.out.println(who); // roll: 269, name: who, age: 23, height: 173.0
  }
  ```
  As you can see, after changing cloned object, it is not affecting original object,

- Ex-2: See `Cat.java`, `Human.java`,
  ```
  public class Human implements Cloneable{
      private String name;
      private Cat cat;
      ...
  
      @Override
      public String toString() {
          return "owner: " + name + ", " + "catName: " + cat.getName();
      }
  
      @Override
      protected Object clone() {
          try {
              return super.clone();
          }catch (CloneNotSupportedException e){
              e.printStackTrace();
              return null;
          }
      }
  
  }
  ```
  Calling like this: See `cloneTest2()` in `Test.java`,
  ```
  private static void cloneTest2(){
      Human tomal = new Human("Tomal","Loki");
  
      System.out.println(tomal); // owner: Tomal, catName: Loki
  
      Human copied = (Human) tomal.clone();
  
      System.out.println(copied); // owner: Tomal, catName: Loki
  
      copied.setName("Totomal");
      System.out.println(tomal); // owner: Tomal, catName: Loki
      System.out.println(copied); // owner: Totomal, catName: Loki
  
      copied.setCatName("kilo");
      System.out.println(tomal); // owner: Tomal, catName: kilo <--------------------
      System.out.println(copied);// owner: Totomal, catName: kilo <-------------------
          
  }
  ```
  As you can see even after cloning the main object, when we change the nested object, actual object is affected.
- For solving this issue, you must handle this manually.
- See commented `clone()` of `Human.java`:
  ```
  @Override
  protected Object clone() {
      try {
          Human human = (Human) super.clone();
          human.cat = (Cat)this.cat.clone();
          return human;
      }catch (CloneNotSupportedException e){
          e.printStackTrace();
          return null;
      }
  }
  ```
  Result is(Perfectly fine):
  ```
  private static void cloneTest2(){
      Human tomal = new Human("Tomal","Loki");
      System.out.println(tomal); // owner: Tomal, catName: Loki
  
      Human copied = (Human) tomal.clone();
      System.out.println(copied); // owner: Tomal, catName: Loki
  
      copied.setName("Totomal");
      System.out.println(tomal); // owner: Tomal, catName: Loki
      System.out.println(copied); // owner: Totomal, catName: Loki
  
      copied.setCatName("kilo");
      System.out.println(tomal); // owner: Tomal, catName: Loki
      System.out.println(copied);// owner: Totomal, catName: kilo
  }
  ```

## Finalizing an Object
- Sometimes an object uses resources that need to be released when the object is destroyed,
- In Java, you create objects, but you `cannot destroy objects`,
- `Garbage Collector` handles object destruction part. But,
- It gives a trigger before destroying object by calling `finalize()` method,
- `finalize()` method:
  - Structure:
    ```
    protected void finalize() throws Throwable {
    ```
  - Doesn't do anything,
  - is called when `garbage collector` determines that no reference exists for the object,
  - **It is not even guaranteed that a finalizer will run at all. So avoid relying on it for cleanup,**
  - `Deprecated` and will be `removed` in the future,
- Ex: Try yourself like `finalizeTest()` in `Test.java`,


## Immutable objects
- Object whose state `cannot be changed` after it is created,
- A class whose objects are `immutable` is called an `immutable-class`,
- If an object’s state `can be changed` after it has been created, it is called a `mutable object`, and its class is called a `mutable-class`,
- Two views of an object’s state:
  - `internal`: Defined by the actual values of its instance variables at a point in time,
  - `external`: Defined by the values that the users of the object see at a point in time, 
- `An immutable object` means `external immutability`,
- Advantages:
  - Can be shared without worrying about changes,
  - Testing an immutable class is easy,
  - Thread safe since can't be changed,
- Ex of mutable class: See `immutableTest()` in `Test.java`,
  ```
  private static void immutableTest(){
      Cat cat = new Cat("Oscar");
      System.out.println(cat.getName()); // Oscar
  
      cat.setName("Billi"); // state changed < - - - - -
      System.out.println(cat.getName()); // Billi
  }
  ```
- Immutable version of `Cat` class will be like this. See `GammaCat.java`,
  ```
  public class GammaCat {
      private final String name; // <------- final optional though
  
      public GammaCat(String name) { this.name = name; }
  
      public String getName() { return name; }
      
      @Override
      protected Object clone(){
          try {
              return super.clone();
          }catch (CloneNotSupportedException e){
              e.printStackTrace();
              return null;
          }
      }
  
      @Override
      protected void finalize() throws Throwable {
          System.out.println(name);
      }
  
  }
  ```
  just remove the ways that can make changes in variable. Here `setName()` is removed,
- If you want to make your class `immutable` and your class contains reference of any other classes, then make sure to make those reference classes `immutable`,
- For ex: for making `Human` class immutable, you have to make `Cat` class immutable also,
- So, for making a class `immutable`,
  - Make all instance variable `final`,(Optional, but compiler will ensure immutability),
  - Make all references class `immutable`,
  - Remove methods that can change variables state(Setter methods),

