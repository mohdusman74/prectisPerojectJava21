# SEALED CLASSES

A Sealed Class is a class that allows only specific classes to inherit from it.

**Simple word:** A sealed class gives permission to only selected classes to extend it.

```java
sealed class Animal permits Dog, Cat {
}

final class Dog extends Animal {
}

final class Cat extends Animal {
}
```

---

## Pattern Matching for `instanceof`

Pattern Matching for `instanceof` allows you to check an object's type and automatically cast it in a single statement.

### Benefits
- Less code
- No manual casting
- Safer and more readable

### Before Java 17

You had to check the type and then cast it manually.

```java
Object obj = "Hello";

if (obj instanceof String) {
    String str = (String) obj;
    System.out.println(str.length());
}
```

### Java 17

The cast is done automatically.

```java
public static void main(String[] args) {
    Object obj = "Hello";

    if (obj instanceof String str) {
        System.out.println("String length: " + str.length());
    } else {
        System.out.println("Not a string");
    }
}
```

Here:
- `instanceof String` → checks the type.
- `str` → automatically casts `obj` to `String`.

---

## Pattern Matching for `switch`

Pattern Matching for `switch` allows a switch statement to match objects by their type and automatically cast them, making type-based logic simpler and more readable.

### Benefits
- Cleaner code
- Replaces long `if-else instanceof` chains
- Easier to maintain
- Better readability

### Before Java 17

You had to write multiple `instanceof` checks.

```java
Object obj = "Hello";

if (obj instanceof String) {
    System.out.println("String");
} else if (obj instanceof Integer) {
    System.out.println("Integer");
}
```

### After Java 17

```java
Object obj = "Hello";

switch (obj) {
    case String s -> System.out.println("String: " + s);
    case Integer i -> System.out.println("Integer: " + i);
    default -> System.out.println("Unknown");
}
```

The `switch` automatically checks the type and provides the correctly typed variable.

---

## Difference

| Feature       | Pattern Matching for `instanceof` | Pattern Matching for `switch`     |
|---------------|-----------------------------------|-----------------------------------|
| Introduced    | Final in Java 17                  | Preview in Java 17                |
| Purpose       | Type check + automatic cast       | Type-based switch cases           |
| Replaces      | `instanceof` + manual cast        | Long `if-else instanceof` chains  |
| Example       | `if (obj instanceof String s)`    | `case String s ->`                |

---

## Record Classes

A **Record** is a special type of class used to store data with less code. It automatically creates the constructor, getters, `equals()`, `hashCode()`, and `toString()` methods.

> "A Record is a Java class that is used to hold immutable data without writing boilerplate code."

**Record = Data Holder + Immutable + Less Code**

### Benefits
- Less code
- Immutable by default
- Better readability
- Automatically generates common methods
- Perfect for DTOs (Data Transfer Objects)

### Example

```java
record Employee(int id, String name) {
}
```

### Why use Records?

1. Reduce Boilerplate Code (Main Reason)
2. Immutable by Default
3. Better Readability
4. Perfect for DTOs
5. Automatically Generates Methods

### 1. Reduce Boilerplate Code (Main Reason)

**Without a record:**

```java
class Employee {
    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    // equals(), hashCode(), toString()
}
```

You have to write a lot of code.

**With a record:**

```java
record Employee(int id, String name) {
}
```

### 2. Immutable by Default

Once a record object is created, its data cannot be changed.

```java
record Employee(int id, String name) {
}

Employee e = new Employee(101, "Usman");

// e.id = 102; ❌ Not allowed
```

This makes your objects safer and easier to reason about.

### 3. Perfect for DTOs

Records are commonly used for:
- Request DTOs
- Response DTOs
- API responses
- Database query results
- Configuration objects

### 4. Automatically Generates Methods

Java generates:
- Constructor
- Accessor methods (`id()`, `name()`)
- `equals()`
- `hashCode()`
- `toString()`

No need to write them manually.

---

## Enhanced Pseudo-Random Number Generators

Enhanced Pseudo-Random Number Generators are the new Java 17 random number API that provides a common interface and multiple high-quality random number generation algorithms.

---

## Virtual Threads (Final)

**Virtual Threads** are lightweight threads introduced as a final feature in Java 21. They are managed by the JVM instead of the operating system, enabling applications to handle millions of concurrent tasks with low memory overhead.

### Why do we use Virtual Threads?

Traditional (platform) threads are expensive because each thread is mapped to an operating system thread.

Creating thousands of platform threads can:
- Consume a lot of memory
- Reduce performance
- Limit scalability

Virtual Threads solve this problem by being lightweight and managed by the JVM.

### Example

```java
Thread.startVirtualThread(() -> {
    System.out.println("Hello from Virtual Thread");
});
```

### Example with Executor

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> {
        System.out.println("Task executed");
    });
}
```

### Where are Virtual Threads used?
- Web applications
- REST APIs
- Microservices
- Database operations
- Network applications
- High-concurrency servers

### Benefits
- Lightweight
- Faster than creating many platform threads
- Low memory usage
- Supports millions of concurrent tasks
- Simpler than asynchronous programming in many cases

### Platform Thread vs Virtual Thread

| Feature            | Platform Thread     | Virtual Thread                  |
|--------------------|---------------------|---------------------------------|
| Managed By         | Operating System    | JVM                             |
| Memory Usage       | High                | Low                             |
| Number of Threads  | Limited             | Millions                        |
| Creation Cost      | Expensive           | Cheap                           |
| Best For           | CPU-intensive tasks | I/O-bound, high-concurrency tasks |


---

### Note (Hinglish)

Virtual Threads lightweight hote hain kyunki ye directly OS threads se bind nahi hote. JVM inhe schedule karti hai. Jab koi virtual thread I/O operation ke liye wait karta hai, JVM usse park kar deti hai aur usi OS thread par kisi dusre virtual thread ko chala deti hai. Isse memory kam use hoti hai aur application bahut zyada concurrent tasks efficiently handle kar sakti hai.
