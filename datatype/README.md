
#### Java is a statically typed programming language. That is, it checks the data types of all values at compile time,

# Data type
- Defined in terms of `3` components
  - `A set of values`,
  - A set of `operations` that can be applied,
  - A data `representation`, which determines how the values are stored,

## Built-in data types
- `Predefined data types`,
- Ex: `int`, `double`, `String` etc,

## Primitive data type
- Consists of an `atomic`, `indivisible value`, 
- Defined without the help of any other data types,
- Programmers `can't extend` primitive data types,

## Identifier
- `Sequence of characters` of unlimited length,
- Includes `letters` and `digits`,
- First letter must be a letter,
- `Spaces` aren't allowed in an identifier,
- `Case sensitive`, 
- Ex: `value`, `VALUE` are different identifier,

## Variables
- These `memory locations`,
- A variable has `3` properties:
  - A `memory location` for storing the value,
  - The `type of the data` to store at the memory location, and 
  - A `name` (also called identifier) to refer to the memory location,
- Ex: `int sum;` where
  - memory for storing `int` is allocated,
  - `data type` = `int`, 
  - `name` = `sum`,

## Java supports 2 kinds of data types:
- ### Primitive
  - Holds `a value`,
  - Ex: `int result;`,
  - 2 categories:
    - Numeric: `byte, short, int, long, char, float, double`, 
    - Boolean: `boolean`,
- ### Reference: 
  - Holds a `reference to an object`,
  - Ex: `String s;` 
    - Space is allocated for `variable` not for object,
  - Ex: `String s = new String("Saeed");`, 
    - `Space` is allocated separately for `variable` and the `object` it is referring,
  - Be alert while modifying object of reference type inside method,
    ```
    private static void printHumanData(Human human){
      System.out.println(human.getName()+" -> "+human.getAge());
      human.setAge(26); // will modify main object
    }
    ```
    Using like this:
    ```
    Human human = new Human("Saeed",21);
    printHumanData(human); // Saeed -> 21
    System.out.println(human.getAge()); // 26
    ```
    - These are discussed briefly in `Classes and Object` section,
