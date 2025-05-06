

# Enum

## Introduction
- Lets you create an ordered list of constants as a type,
- Mainly used for declaring constant,
- Simple structure:
    ```
    <access-modifier> enum <enum-type-name> {
     // List of comma separated names of enum constants
    }
    ```
- Ex:
    ```
    public enum Gender {
        MALE, FEMALE, OTHERS ; // these are enum constant
    }
    ```
- It is a convention to name the enum constants in uppercase,
- Java implements an enum type as a class,
- The compiler does a lot of work for an enum type and generates code for it that is essentially a class,
- Can't create object of enum type. But,
- It can have constructor which is called by compiler only,
- Can be used in `switch` statement,

## Enum constant
- All enum constants are objects of the same enum type,
- In above `Gender` enum: `MALE`, `FEMALE`, `OTHERS` are enum constant,
- Name is assigned to each enum constant,
- Order number is assigned to each enum constant called `ordinal`,
- The `ordinal` starts with zero & it is incremented by one for enum constant,
    ```
    System.out.println(Gender.MALE.name()); // MALE
    System.out.println(Gender.FEMALE.name()); // FEMALE
    System.out.println(Gender.OTHERS.name()); // OTHERS
    
    System.out.println(Gender.MALE.ordinal());   // 0
    System.out.println(Gender.FEMALE.ordinal()); // 1
    System.out.println(Gender.OTHERS.ordinal()); // 2
    ```
- Each enum constant can have different body. See `CommandList.java`, 

## Enum again
- An enum type is actually a class type. So, 
- You can declare pretty much everything inside an enum type body that you can declare inside a class body,
- Can't add a public or protected constructor to an enum type. If you do so, they will be automatically converted to private during compilation,
- Ex: See `MyWeekDay.java`:
    ```
    public enum MyWeekDay {
        SATURDAY(true),SUNDAY(false),MONDAY(false),
        TUESDAY(false), WEDNESDAY(false),THURSDAY(false), FRIDAY(false);
    
        // see above constant carefully. They all are objects. 
        // We are actually using constructor of this class to create constant.
    
        private final boolean isHoliday;
        private MyWeekDay(boolean isHoliday){
            this.isHoliday = isHoliday;
        }
    
        public boolean isHoliday() {
            return isHoliday;
        }
    
    }
    ```
- Example usage: See `Test.java`:
    ```
    private static int countWorkingDays(List<MyWeekDay> days){
        int counter = 0;
    
        for(MyWeekDay day : days){
            if(day.isHoliday()) continue;
    
            counter++;
        }
    
        return counter;
    }
    ```
    Calling is like:
    ```
    ArrayList<MyWeekDay> days = new ArrayList<>();
    days.add(SATURDAY);
    days.add(MONDAY);
    days.add(THURSDAY);
    
    System.out.println(countWorkingDays(days)); // 2
    ```

## Comparing Two Enum Constants
- Two enum constant can be compared in 3 ways:
  - `compareTo()` method 
    - Returns difference in their `ordinal`,
    - Must be of same type,
  - `equals()` method
    - An enum constant is equal only to itself,
    - For comparing two enum constants of different types,
  - `==` operator,
    - Must be of same type,
- Ex: See `compareEnum()` of `Test.java`:
    ```
    Gender gender1 = Gender.MALE;
    Gender gender2 = Gender.FEMALE;
    Gender gender3 = Gender.MALE;
    
    MyWeekDay day1 = SATURDAY;
    MyWeekDay day2 = MONDAY;
    MyWeekDay day3 = MONDAY;
    
    // compareTo
    System.out.println(gender1.compareTo(gender2)); // -1
    System.out.println(gender1.compareTo(gender3)); // 0
    
    // equals
    System.out.println(gender1.equals(day1)); // false
    System.out.println(day1.equals(day2)); // false
    System.out.println(day2.equals(day2)); // true
    
    // ==
    System.out.println(gender1 == gender3); // true
    System.out.println(day1 == day3); // false
    ```
 
## Nested enum type
- You can declare a nested enum type inside a class, an interface, or another enum type, 
- Nested enum types are implicitly static,
    ```
    public class Test {
        ...
        //nested enum
        public enum NestedEnum{
            MY_VALUE1,MY_VALUE2;
        }
        ...
    }
    ```

## Implementing interface
- An enum type may implement q_Interfaces,
- An enum type is never inherited by another enum type. So,
- You must provide implementation for all abstract methods in that interface,
- See `CommandList.java`, `Executable.java`:
    ```
    public interface Executable {
        void execute();
    }
    ```
    ```
    public enum CommandList implements Executable{
        RUN{
            @Override
            public void doNothing() { }
        },
        JUMP{
            @Override
            public void doNothing() { }
        };
    
        @Override
        public void execute() {
            if(this.equals(RUN)){
                System.out.println("Running");
            }
            else if(this.equals(JUMP)){
                System.out.println("Jumping");
            }
        }
        public abstract void doNothing();
    }
    ```
    Calling is like:
    ```
    RUN.execute(); // Running
    JUMP.execute(); // Jumping
    ```

## Abstract method in enum
- Enum can have abstract method. But,
- You must have to override it in every constant,
- See `doNothing()` in `CommandList.java` above;


## Reverse Lookup for Enum Constants
- We can get enum constant by `name` of `ordinal`,
    ```
    System.out.println(MyWeekDay.valueOf("SATURDAY")); // SATURDAY
    System.out.println(MyWeekDay.values()[0]); // SATURDAY
    ```

## Range of Enum Constants
- Can find all enum constant by performing search,
- Abstract class `EnumSet` is used for this,
- Ex:
    ```
    EnumSet<MyWeekDay> days = EnumSet.allOf(MyWeekDay.class);
    printArray(days.toArray()); // SATURDAY SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY
    
    EnumSet<MyWeekDay> workingDays = EnumSet.range(SUNDAY,THURSDAY);
    printArray(workingDays.toArray()); // SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY
    
    EnumSet<MyWeekDay> holidays = EnumSet.complementOf(workingDays);
    printArray(holidays.toArray()); // SATURDAY FRIDAY 
    ``` 


>> ENUM IS MAINLY USED FOR DECLARING CONSTANT & IT SHOULD BE ENOUGH FOR YOU
