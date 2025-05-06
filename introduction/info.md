# Introduction to JAVA
## Abstraction
Abstraction is a way of focusing on relevant details and ignoring the irrelevant details about it in a particular context.
- Info is hidden to programmer, because it is not needed.
- Ex: `Math.max(int,int)` function. We don't need to know the implementation details.
- This is not for security reason.

## Encapsulation
Encapsulation is bundling of data and 'operations on the data' into an entity called a class.
- array: encapsulation of several elements of the same type.
- package: bundle/encapsulate one or more logically related classes.
- compilation unit: bundle one or more related classes.

## Information hiding
Process of hiding implementation details that are likely to change.
- Developer hides this info intentionally by using access modifier.
- This provides more security and prevent accidental access to data.

## Example
Look at the implementation of Person class for more details...
```
public void setAge(int age) { 
    if(age < 0){
    return;
    }
    this.age = age;
}
```
Here the setter `setAge(int)` restrict user from setting invalid age. Variable `age` defined in `Person` clas is hidden intentionally.

## Inheritance
Allows creating parent-child relationship where child inherits all properties of Parent class.
- See Student(child) and Person(Parent) class for more info.
```
  public class Student extends Person{
    ...
  }
  ```


## Polymorphism
Polymorphism is the ability of an entity to take on different meanings in different contexts. 

Example: `Method overloading`, `method overriding`, `subtyping`, and `generics`

```
Person p1 = new Student("Saeed",21,57); 
p1.printMyStatus(); //I am a student

p1 = new Person("Saeed",36);
p1.printMyStatus(); //I am a Person
```
p1 calls appropriate method based on the object it's referring.

