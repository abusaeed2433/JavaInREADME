
# Interface - part1

> BROAD AND CONFUSING TOPIC. PRACTICE MORE

## Introduction
- Very important concept,
- Let us understand the need by considering a case,
- Suppose we have a `Person` class which has `walk()` method in it,
- We have a method named `letThemWalk(Person[])` defined as:
    ```java
    public static void letThemWalk(Person[] list){
        for(Person student : list) {
            student.walk();
        }
    }
    ```
    Calling the method like:
    ```java
    Person[] persons = new Person[3];
    persons[0] = new Person("Jack");
    persons[1] = new Person("Jeff");
    persons[2] = new Person("John");
    letThemWalk(persons); // <---------------
    ```
- `letThemWalk(Person[])` will be executed `3` times. There is no problem till now,
- Let us add a class named `Duck` in our project,
- `Duck` can also walk. Except this, there is no similarity between `Person` & `Duck`,
- So, there can have many such class(`Dog`,`Cat`...) that can have `walk()` method,
- But we can't use them based on this property(`Walkable`) only, since all are different classes.

## Some Solution of above problem
- Solution-1: 
  - Using `Object` class array instead of `Person` class array,
  - Ex:
    ```java
    private static Method getWalkMethod(Object obj) {
        Class c = obj.getClass();
        Method walkMethod = null;
        try {
            walkMethod = c.getMethod("walk");
            return walkMethod;
        }
        catch (NoSuchMethodException e) {
            // walk() method does not exist
        }
        return null;
    }
    ```
    `getWalkMethod(Object)` return the reference of `walk()` method if available in parameter class
    ```java
    private static void letThemWalkUpdated(Object[] list){
        for(Object  obj : list) {
            Method walkMethod = getWalkMethod(obj); // getting method reference
            if (walkMethod != null) {
                try {
                    walkMethod.invoke(obj); // calling walk method on the obj
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    ```
    ```java
    private static void solution1(){
        Object[] objects = new Object[4];
        objects[0] = new Person("Jack");
        objects[1] = new Person("Jeff");
        objects[2] = new Person("John");
        objects[3] = new Duck("Duck1");
        letThemWalkUpdated(objects);
    }
    ```
  - This code will work fine. But,
  - Problem here is: it will stop working if method name is changed,
  - It is also confusing and hard to debug.

- Solution-2:
  - Use different function for `Person` and `Duck` class,
    ```java
    private static void letDuckWalk(Duck[] list){
        for(Duck duck : list) {
            if(duck == null) continue;
            duck.walk();
        }
    }
    ```
    ```java
    private static void letPersonWalk(Person[] list){
        for(Person student : list) {
            if(student == null) continue;
            student.walk();
        }
    }
    ```
    ```java
    private static void solution2(){
        Person[] persons = new Person[3];
        persons[0] = new Person("Jack");
        persons[1] = new Person("Jeff");
        persons[2] = new Person("John");
        letPersonWalk(persons); // <-------

        Duck[] ducks = new Duck[3];
        ducks[0] = new Duck("Ab");
        ducks[1] = new Duck("Bc");
        ducks[2] = new Duck("Ka");
        letDuckWalk(ducks); // <----------
    }
    ```
  - It's not good solution at all since we need to write different function for every class.

- Solution-3:
  - We can create a parent class named say `Animal` then inherit this into `Person` and `Duck` class,
  - Not good because it requires a parent class,
  - Try yourself if you want to.

## Ideal solution for above problem
- We can create an interface named `Walkable` then implement this to `Person2` and `Duck2` class,
- `Person` and `Person2` are same,
- `Duck` and `Duck2` are same,
- `Person2` & `Duck2` are created for separating this solution from earlier only,
- Ex:
  ```java
  private static void idealSolution(){
      Walkable[] arr = new Walkable[4]; // <----- See variable type
      arr[0] = new Person2("Abu");
      arr[1] = new Person2("Saeed");
      arr[2] = new Person2("John");
  
      arr[3] = new Duck2("duck1"); // <------- Duck2
      letAllWalkTogether(arr);
  }
  ```
  ```java
  private static void letAllWalkTogether(Walkable[] arr){
      for(Walkable obj : arr){
          obj.walk();
      }
  }
  ```
- Perfect and simplest solution. Isn't it?

## About interface
- Declared using the keyword `interface`, 
- Can have abstract method declarations,
- A class can implement one or more interfaces using the keyword `implements` in its declaration,
- By implementing an interface, a class guarantees that it will provide an implementation for all methods declared in the interface or the class will declare itself abstract,
- Can't create object of an interface type,
- Ex:
  ```java
  public interface Walkable {
      void walk();
  }
  ```
- See `Person2.java` & `Duck2.java`:
  ```java
  public class Person2 implements Walkable{
      private String name;
      public Person2(String name) {
          this.name = name;
      }
  
      @Override
      public void walk() {
          System.out.println(name + " (a student) is walking.");
      }
  
  }
  ```
- Now this statement becomes valid. i.e. variable of interface can refer to the object of class that implements this interface,
  ```java
  Walkable walkable = new Person2("Doe");
  walkable.walk(); // --------(a)
  ```
  `(a)` will automatically call `walk()` method of `Person2` class. No need to define explicitly,
- `interface` lets you put unrelated classes under one umbrella. For example: object of `Person2` and `Duck2` can be referred using the variable of `Walkable` interface.

<!-- bottom_nav_bar_1243 -->
<div align="center">
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/inheritance/part7/">
    <img src="https://img.shields.io/badge/◀%20Previous-blue?style=for-the-badge" alt="Previous">
</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/interfaces/part2/">
    <img src="https://img.shields.io/badge/Next%20▶-blue?style=for-the-badge" alt="Next">
</a>
</div>
<!-- bottom_nav_bar_1243 -->
    