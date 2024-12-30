# Object vs reference
Objects are class instance or arrays, and the reference values (often just references) are pointers to these objects, and a special null reference, which refers to no object. [Java spec](https://docs.oracle.com/javase/specs/jls/se9/html/jls-4.html#jls-4.3.1)
```java
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();    
    }
}
```
In the above snippet, sol reference variable holds a pointer to Solution object.
All the values whether primitive or object values are passed by value. In case of objects, the pointer to the object is copied each time it is passed to the methods in the reference variable. If the reference variable is pointed to a different object then the originally passed pointer to the object is not impacted.
Any changes done in the method on the object is preserved if the pointer is unchanged.

# Arrays
- In Java, all arrays are dynamically allocated. This means that the memory is allocation at runtime and is maintained till it is not garbage collected by JVM or end of program execution.
- The elements are allocated in contiguous memory blocks.
- Since arrays are objects in Java, we can find their length using the object property length.
- A Java array variable can also be declared like other variables with [] after the data type.
- The variables in the array are ordered, and each has an index beginning from 0.
- Java array can also be used as a static field, a local variable, or a method parameter.
- The size of an array must be specified by int or short value and not long.
- The direct superclass of an array type is Object.
- Inserting an element at the beginning of the array or in the middle will require ~O(N) complexity as we need to shift the elements to make space for the element to be inserted.
- An element num between 1 and n will be at index num - 1 in the array
- In place operations:
    - Sliding Window
    - Two pointer technique
- We can use counting sort algorithm to sort an array by using additional array
```java
class Test
{
    public static void main(String args[])
    {
        int intArray[] = new int[3];
        byte byteArray[] = new byte[3];
        short shortsArray[] = new short[3];
         
        // array of Strings
        String[] strArray = new String[3];
         
        System.out.println(intArray.getClass());
        System.out.println(intArray.getClass().getSuperclass());
        System.out.println(byteArray.getClass());
        System.out.println(shortsArray.getClass());
        System.out.println(strArray.getClass());
    }
}
/*
Output
class [I
class java.lang.Object
class [B
class [S
class [Ljava.lang.String;
*/
```
- Every array type implements the interfaces Cloneable and java.io.Serializable.
- Java always initializes empty Array slots to null if the Array contains objects, or to default values if it contains primitive types. For example, the array int [] would contain the default value of 0 for each element, float[] would contain default values of 0.0, and bool[] would contain default values of false.

# Array Literals in Java
a. Initialization of array elements at the time of creating array object
```java
int[] i = {1, 2, 3, 4, 5};
```
Thing to note here is that we can't directly pass the above initialization to a method or perform operations on it without assigning it to a variable. Cannot assign it to an existing initialized variable. 

b. Using anonymous arrays
```java
double volume = computeVolume(new int[] { 3, 4, 5 });
```

# Arrays class from Collections framework

[Java 11 Arrays](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html)
[Java 11 Collections Framework](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/package-summary.html#CollectionsFramework)
