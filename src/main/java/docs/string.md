Here’s a detailed documentation of the `String` class in Java:

---

## **Overview**
The `String` class in Java, part of the `java.lang` package, is an immutable sequence of characters. Strings are widely used in Java, and the `String` class provides many methods for manipulating and handling strings.

---

## **Key Features of the `String` Class**
- Immutable: Once created, a `String` object cannot be modified.
- Thread-safe: Since strings are immutable, they are inherently thread-safe.
- Implements `CharSequence`, `Comparable<String>`, and `Serializable`.

---

## **1. String Constructors**
| Constructor | Description |
|-------------|-------------|
| **`String()`** | Creates an empty string. |
| **`String(String original)`** | Creates a string from another string. |
| **`String(char[] value)`** | Creates a string from a character array. |
| **`String(char[] value, int offset, int count)`** | Creates a string from a subarray of characters. |
| **`String(byte[] bytes)`** | Creates a string from a byte array using the default charset. |
| **`String(byte[] bytes, Charset charset)`** | Creates a string from a byte array with the specified charset. |
| **`String(byte[] bytes, int offset, int length)`** | Creates a string from a subarray of bytes using the default charset. |
| **`String(int[] codePoints, int offset, int count)`** | Constructs a string from an array of Unicode code points. |

---

## **2. String Methods**

### **2.1 String Comparison**
| Method | Description |
|--------|-------------|
| **`equals(Object obj)`** | Compares the string to the specified object. |
| **`equalsIgnoreCase(String anotherString)`** | Compares strings ignoring case differences. |
| **`compareTo(String anotherString)`** | Compares strings lexicographically. |
| **`compareToIgnoreCase(String anotherString)`** | Compares strings lexicographically, ignoring case differences. |
| **`contentEquals(CharSequence cs)`** | Compares the string with a `CharSequence`. |
| **`regionMatches(int toffset, String other, int ooffset, int len)`** | Tests if two string regions are equal. |

---

### **2.2 Searching and Indexing**
| Method | Description |
|--------|-------------|
| **`charAt(int index)`** | Returns the character at the specified index. |
| **`indexOf(int ch)`** | Returns the index of the first occurrence of a character. |
| **`indexOf(String str)`** | Returns the index of the first occurrence of a substring. |
| **`lastIndexOf(int ch)`** | Returns the index of the last occurrence of a character. |
| **`contains(CharSequence s)`** | Checks if the string contains the specified sequence. |
| **`startsWith(String prefix)`** | Checks if the string starts with the specified prefix. |
| **`endsWith(String suffix)`** | Checks if the string ends with the specified suffix. |

---

### **2.3 Substring and Character Extraction (continued)**
| Method | Description |
|--------|-------------|
| **`substring(int beginIndex)`** | Returns a new string starting from the specified index to the end of the original string. |
| **`substring(int beginIndex, int endIndex)`** | Returns a new string that is a substring of the original string, from `beginIndex` (inclusive) to `endIndex` (exclusive). |
| **`toCharArray()`** | Converts the string into a new character array. |
| **`codePointAt(int index)`** | Returns the Unicode code point at the specified index. |
| **`codePointBefore(int index)`** | Returns the Unicode code point before the specified index. |
| **`codePointCount(int beginIndex, int endIndex)`** | Returns the number of Unicode code points in the specified range. |

---

### **2.4 Modifying Strings (Returns a New String)**
| Method | Description |
|--------|-------------|
| **`concat(String str)`** | Concatenates the specified string to the end of the original string. |
| **`replace(char oldChar, char newChar)`** | Replaces all occurrences of a character with another character. |
| **`replace(CharSequence target, CharSequence replacement)`** | Replaces each substring matching the target sequence with the replacement sequence. |
| **`replaceFirst(String regex, String replacement)`** | Replaces the first substring that matches the regex. |
| **`replaceAll(String regex, String replacement)`** | Replaces every substring that matches the regex. |
| **`trim()`** | Removes leading and trailing whitespace from the string. |
| **`toLowerCase()`** | Converts the string to lowercase using the default locale. |
| **`toUpperCase()`** | Converts the string to uppercase using the default locale. |
| **`strip()`** | Removes leading and trailing whitespace, including Unicode spaces. |
| **`repeat(int count)`** | Returns a string repeated `count` times. |

---

### **2.5 Splitting and Joining Strings**
| Method | Description |
|--------|-------------|
| **`split(String regex)`** | Splits the string around matches of the regex. |
| **`split(String regex, int limit)`** | Splits the string around matches of the regex with a limit on the number of splits. |
| **`join(CharSequence delimiter, CharSequence... elements)`** | Joins multiple strings using the specified delimiter. |

---

### **2.6 String Formatting**
| Method | Description |
|--------|-------------|
| **`format(String format, Object... args)`** | Returns a formatted string using the specified format string and arguments. |
| **`formatted(Object... args)`** | Returns a formatted string using this string as a format string. |

---

### **2.7 Regular Expressions**
| Method | Description |
|--------|-------------|
| **`matches(String regex)`** | Tests if the string matches the given regex. |
| **`contains(CharSequence s)`** | Checks if the string contains the specified sequence. |
| **`replaceAll(String regex, String replacement)`** | Replaces all matches of the regex with the replacement string. |
| **`replaceFirst(String regex, String replacement)`** | Replaces the first match of the regex with the replacement string. |

---

### **2.8 Utility Methods**
| Method | Description |
|--------|-------------|
| **`length()`** | Returns the length of the string. |
| **`isEmpty()`** | Checks if the string is empty. |
| **`isBlank()`** | Checks if the string is empty or contains only whitespace. |
| **`valueOf(Object obj)`** | Returns the string representation of an object. |
| **`intern()`** | Returns a canonical representation of the string from the string pool. |
| **`compareTo(String anotherString)`** | Compares two strings lexicographically. |
| **`compareToIgnoreCase(String anotherString)`** | Compares two strings lexicographically, ignoring case. |
| **`hashCode()`** | Returns the hash code of the string. |

---

### **3. Static Methods**
| Method | Description |
|--------|-------------|
| **`copyValueOf(char[] data)`** | Returns a string that represents the characters in the array. |
| **`copyValueOf(char[] data, int offset, int count)`** | Returns a string representing a subarray of the character array. |
| **`valueOf(boolean b)`** | Returns a string representation of a boolean. |
| **`valueOf(char c)`** | Returns a string representation of a char. |
| **`valueOf(char[] data)`** | Returns a string representation of a char array. |
| **`valueOf(double d)`** | Returns a string representation of a double. |
| **`valueOf(float f)`** | Returns a string representation of a float. |
| **`valueOf(int i)`** | Returns a string representation of an integer. |
| **`valueOf(long l)`** | Returns a string representation of a long. |

---

### **4. Important Characteristics**
1. **Immutability**: Once a `String` object is created, it cannot be changed. Any operation that seems to modify the string will actually create a new string.
2. **String Pool**: Java maintains a special memory area called the "string pool" for storing string literals. The `intern()` method can be used to place a string in this pool.

---

The **String Pool** in Java is located in the **Heap memory**.

---

### **Explanation**
1. **Heap Memory**:
   - The heap is the portion of memory allocated for objects at runtime. The String Pool resides here to store and manage string literals and their references.
   - Strings are immutable in Java, and the pool is designed to store one copy of each unique string literal to save memory and improve performance.

2. **String Pool Mechanism**:
   - When a string literal is created (e.g., `String str = "Hello";`), the JVM checks the pool:
     - If the string already exists, a reference to the existing string is returned.
     - If the string does not exist, it is added to the pool.
   - Strings created with the `new` keyword (e.g., `String str = new String("Hello");`) are stored directly in the heap, outside the pool. However, the `intern()` method can be used to explicitly move such strings to the pool.

3. **Stack Memory**:
   - The stack is used for method call execution and local variables. It only holds references to objects (including strings) that are stored in the heap or pool.

---

### **Summary**
- **String Pool**: Located in the Heap.
- **References to Strings**: Stored in the Stack when used in methods or local variables.

The **String Pool** in Java is a special storage area within the **heap memory** where string literals are stored. This mechanism helps in saving memory by reusing immutable string instances.

When a string literal is created, the Java Virtual Machine (JVM) checks the String Pool:

- **If the string already exists in the pool**: The JVM returns a reference to the existing string.

- **If the string does not exist in the pool**: The JVM adds it to the pool and returns a reference to this new string.

This process ensures that identical string literals share the same memory, enhancing efficiency.

It's important to note that while the String Pool is part of the heap, strings created using the `new` keyword (e.g., `String str = new String("example");`) are stored in the heap outside of the String Pool. However, invoking the `intern()` method on such strings can add them to the String Pool.

In summary, the String Pool resides in the heap memory, and it plays a crucial role in optimizing memory usage for string literals in Java.

[Source](https://www.scaler.com/topics/java/string-pool-in-java/)
