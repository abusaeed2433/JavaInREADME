
# Array

## Introduction
- A fixed-length data structure that is used to hold more than one value of the same data type,
- All elements of an array are stored contiguously in memory,
  - In case of a reference type array, the array elements store the references of the objects,
  - Those references in the elements are stored contiguously, not the objects they are referring to. 
  - The objects are stored on heap and their locations are, typically, not contiguous,
- All arrays in Java are objects but `abstract` i.e. can't create object directly,
- Since array are objects, so it can be assigned to other object. Rule is same,
- Arrays are created dynamically at runtime,
- The length of an array cannot be modified after it has been created,
- Ex:
    ```
    int[] arr = new int[5];
    ```
- Index is zero(`0`) based just like `C` or `C++`,
- Make sure to assign values before using,
- Ex: See `arrayTest()` of `Test.java`,
    ```
    String[] names = new String[4];
    printArray(names); // null null null null
    
    names[0] = "Pantho";
    names[2] = "Aslam";
    printArray(names); // Pantho null Aslam null
    
    names[1] = "Maruf";
    names[3] = "Anik";
    
    printArray(names); // Pantho Maruf Aslam Anik 
    for (int i=0;i<names.length; i++){
        names[i] = names[i].substring(0,1); // ----(a)
    }
    printArray(names); // P M A A 
    ```
    - If you don't assign `Maruf` and `Anik`, then program will crash at `(a)`,
- See `Test.java`,


## Initializing Array Elements
- Array elements are initialized to a default value no matter it is global or local,
- Array elements of primitive data type are initialized to the default value for their data types,
  - Numeric array elements are initialized to zero(`0`), 
  - boolean elements to `false`,
- Reference type elements to `null`,
- Ex:
    ```
    String[] names = new String[4];
    printArray(names); // null null null null
    ```
- Explicit initializing:
    ```
    int[] rolls = new int[]{1,2,3,4,5}; // or
    int[] rolls2 = {1,2,3,4,5};
    ```
- You cannot specify the length of an array if you specify the array initialization list,
- The length of the array is the same as the number of values specified in the initialization list, i.e. `5` in above example,

## Limitations of Arrays
- Cannot be expanded or shrunk after it is created,

## Variable-Length Arrays
- `ArrayList` and `Vector` are two classes in the `java.util` package that can be used whenever variable-length arrays are needed,
- `ArrayList` and `Vector` classes work the same way except,
  - Methods in the `Vector` class are `synchronized`(Thread safe), 
  - Whereas methods in `ArrayList` are not `synchronized`,
  - `Vector` is slower, `ArrayList` is faster,
- Use `ArrayList` (my suggestion),
- Ex:
    ```
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2000);
    arr.add(3);
    
    Integer num1 = 1;
    Integer num2 = 2000;
    
    for(int i=0; i<arr.size(); i++) System.out.print(arr.get(i)+" ");
    System.out.println("");
    
    System.out.println(arr.size()); // 3
    
    arr.add(20);
    arr.add(22);
    System.out.println(arr.size()); // 5
    ```

## Passing array as parameter
- Can be passed to method just like other variable,
- Alert when modifying array inside called method. Remember, array are object, so modifying inside method will also modify original array,
- Ex: `printArray(T[] arr)` in `Test.java`,
- Ex2:
    ```
    private static void resizeValues(int[] arr){
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 20) arr[i] = 20;
        }
    }
    ```
    ```
    private static void passArray(){
        int[] arr = {1,2,23,24,25,3};
    
        printArray(arr); // 1 2 23 24 25 3
        resizeValues(arr);
        printArray(arr); // 1 2 20 20 20 3 
    }
    ```
- Make a copy then pass to method if you are going to modify inside method,
- Remember, `main(String[])` method takes an array as parameter,

## Multi-Dimensional Arrays
- Just like `C` and `C++`,
- Ex: See `multiDimenArray()` of `Test.java`,
    ```
    int[][] table = new int[3][2];
    
    int[][] tbl = {
            {1,2},
            {3,4},
            {5,6}
    };
    
    for(int i=0;i<tbl.length; i++){
        for(int j=0; j<tbl[i].length; j++){
            System.out.print(tbl[i][j]+" ");
        }
        System.out.println("");
    }
    
    System.out.println("---");
    // better approach
    for(int[] arr : tbl){
        for(int ij : arr){
            System.out.print(ij+" ");
        }
        System.out.println("");
    }
    /*
    output
    1 2
    3 4
    5 6
     */
    ```
- All operations are like normal array. Just `don't be confused`,

## Converting an ArrayList to an Array
- Accessing array elements is faster than ArrayList,
- You may convert when you know size won't be changed anymore,
- No need to convert. Use `ArrayList`(Suggestion),
- Ex: See `Test.java`:
  ```
  ArrayList<String> names = new ArrayList<>();
  
  names.add("John");
  names.add("Jane");
  names.add("Mary");
  
  Object[] arr = names.toArray(); // <--------- way-1
  printArray(arr); // John Jane Mary
  
  String[] brr = new String[names.size()];
  
  names.toArray(brr); // <------------ way-2
  printArray(brr); // John Jane Mary
  ```
