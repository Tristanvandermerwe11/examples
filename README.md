# Java Examples and Study Notes

This README contains examples of how to collect user input in Java, use `JOptionPane` and `Scanner`, convert input into numerical values, store information in arrays, and perform unit testing using JUnit.

---

# Table of Contents

<details open>
<summary><strong>1. Getting User Input</strong></summary>

- [1.1 Using JOptionPane](#11-using-joptionpane)
- [1.2 Getting Numerical Input](#12-getting-numerical-input)

</details>

<details>
<summary><strong>2. Using Scanner</strong></summary>

- [2.1 Import Scanner](#21-import-scanner)
- [2.2 Create a Scanner Object](#22-create-a-scanner-object)
- [2.3 Collect User Input](#23-collect-user-input)

</details>

<details>
<summary><strong>3. Working with Two-Dimensional Arrays</strong></summary>

- [3.1 Create the Array](#31-create-the-array)
- [3.2 Populate the Array Using Loops](#32-populate-the-array-using-loops)
- [3.3 Display the Array Data](#33-display-the-array-data)

</details>

<details>
<summary><strong>4. Complete Example</strong></summary>

- [Complete Scanner and Array Example](#4-complete-example)

</details>

<details>
<summary><strong>5. Understanding the Code</strong></summary>

- [Understanding Array Storage](#5-understanding-the-code)

</details>

<details>
<summary><strong>6. Which Input Method Should You Use?</strong></summary>

- [Choosing an Input Method](#6-which-input-method-should-you-use)

</details>

<details>
<summary><strong>7. Unit Testing in Java</strong></summary>

- [7.1 What is Unit Testing?](#71-what-is-unit-testing)
- [7.2 Example Method to Test](#72-example-method-to-test)
- [7.3 Creating a Unit Test](#73-creating-a-unit-test)
- [7.4 Understanding the Unit Test](#74-understanding-the-unit-test)
- [7.5 Testing Multiple Scenarios](#75-testing-multiple-scenarios)
- [7.6 Unit Testing Two-Dimensional Arrays](#76-unit-testing-using-a-two-dimensional-array)
- [7.7 Common JUnit Assertions](#77-common-junit-assertions)
- [7.8 Using assertTrue](#78-example-of-asserttrue)
- [7.9 Using assertThrows](#79-example-of-assertthrows)
- [7.10 Running Tests in NetBeans](#710-running-unit-tests-in-netbeans)
- [7.11 Understanding Test Results](#711-understanding-test-results)
- [7.12 Why Unit Testing Is Important](#712-why-unit-testing-is-important)

</details>

---

# 1. Getting User Input

If information needs to be collected from a user in a Java application, there are several ways to do this.

The two common approaches are:

- `JOptionPane` – popup input boxes.
- `Scanner` – console input.

## 1.1 Using JOptionPane

`JOptionPane` allows the user to enter information using popup boxes.

```java
import javax.swing.JOptionPane;

public class Example {

    public static void main(String[] args) {

        String strName = JOptionPane.showInputDialog("Enter your name:");

        JOptionPane.showMessageDialog(null, "Hello " + strName);
    }
}
```

### What happens?

1. A popup asks the user to enter their name.
2. The user types their name.
3. The information is stored in `strName`.
4. A message box displays the entered name.

If the user enters `John`, the output would be:

> Hello John

---

## 1.2 Getting Numerical Input

`JOptionPane` initially returns input as a `String`.

If we want to use the input as a number, we need to convert it.

### Getting an integer

```java
String strInput = JOptionPane.showInputDialog("Enter your age:");

int intAge = Integer.parseInt(strInput);
```

### Getting a decimal

```java
String strInput = JOptionPane.showInputDialog("Enter a sales amount:");

double dblSales = Double.parseDouble(strInput);
```

For example, if the user enters:

```text
750
```

It becomes:

```java
double dblSales = 750.0;
```

### Common conversions

| Conversion | Method |
|---|---|
| String to int | `Integer.parseInt()` |
| String to double | `Double.parseDouble()` |
| String to float | `Float.parseFloat()` |
| String to long | `Long.parseLong()` |

---

# 2. Using Scanner

`Scanner` is commonly used in console-based Java applications.

It allows the application to collect information directly from the user through the keyboard.

## 2.1 Import Scanner

At the top of your Java class, add:

```java
import java.util.Scanner;
```

This allows us to use the `Scanner` class.

---

## 2.2 Create a Scanner Object

Inside your `main()` method, create the Scanner object:

```java
Scanner input = new Scanner(System.in);
```

### Explanation

| Code | Explanation |
|---|---|
| `Scanner` | The class |
| `input` | The name of the Scanner object |
| `new Scanner()` | Creates a new Scanner object |
| `System.in` | Allows Java to receive keyboard input |

---

## 2.3 Collect User Input

We can ask the user to enter information using `System.out.print()` and then capture the information using Scanner.

```java
System.out.print("Enter your name: ");
String strName = input.nextLine();

System.out.print("Enter your age: ");
int intAge = input.nextInt();
```

### Common Scanner Methods

| Method | Purpose |
|---|---|
| `nextLine()` | Reads a complete line of text |
| `next()` | Reads one word |
| `nextInt()` | Reads an integer |
| `nextDouble()` | Reads a decimal number |
| `nextFloat()` | Reads a float |
| `nextLong()` | Reads a long integer |
| `nextBoolean()` | Reads a boolean |

---

# 3. Working with Two-Dimensional Arrays

A two-dimensional array is useful when information needs to be stored in rows and columns.

For example, if a sales application records sales over two years and three quarters per year, we can use a two-dimensional array.

| | Quarter 1 | Quarter 2 | Quarter 3 |
|---|---:|---:|---:|
| Year 1 | 300 | 150 | 700 |
| Year 2 | 250 | 200 | 600 |

## 3.1 Create the Array

We can create an array to store the sales figures:

```java
int[][] productSales = new int[2][3];
```

This creates:

- `2` rows representing years.
- `3` columns representing quarters.

Initially, the array contains zero values.

---

## 3.2 Populate the Array Using Loops

Instead of writing six separate input statements, we can use nested loops.

```java
Scanner input = new Scanner(System.in);

int[][] productSales = new int[2][3];

for (int intRow = 0; intRow < productSales.length; intRow++) {

    for (int intCol = 0; intCol < productSales[intRow].length; intCol++) {

        System.out.print("Enter sales for Year " + (intRow + 1)
                + ", Quarter " + (intCol + 1) + ": ");

        productSales[intRow][intCol] = input.nextInt();
    }
}
```

### Understanding the Outer Loop

```java
for (int intRow = 0; intRow < productSales.length; intRow++)
```

The outer loop controls the rows.

In this example, the rows represent the years.

### Understanding the Inner Loop

```java
for (int intCol = 0; intCol < productSales[intRow].length; intCol++)
```

The inner loop controls the columns.

In this example, the columns represent the quarters.

### What the User Will See

The program automatically asks for:

```text
Enter sales for Year 1, Quarter 1:
Enter sales for Year 1, Quarter 2:
Enter sales for Year 1, Quarter 3:
Enter sales for Year 2, Quarter 1:
Enter sales for Year 2, Quarter 2:
Enter sales for Year 2, Quarter 3:
```

We do not need to write six separate input statements.

---

## 3.3 Display the Array Data

Once the information has been entered, we can display it using another nested loop.

```java
System.out.println("\nPRODUCT SALES");

for (int intRow = 0; intRow < productSales.length; intRow++) {

    System.out.println("Year " + (intRow + 1));

    for (int intCol = 0; intCol < productSales[intRow].length; intCol++) {

        System.out.println("Quarter " + (intCol + 1) + ": "
                + productSales[intRow][intCol]);
    }
}
```

### Example Output

```text
PRODUCT SALES

Year 1
Quarter 1: 300
Quarter 2: 150
Quarter 3: 700

Year 2
Quarter 1: 250
Quarter 2: 200
Quarter 3: 600
```

---

# 4. Complete Example

The following example combines:

- Scanner
- Two-dimensional arrays
- Nested loops
- User input
- Displaying information

```java
import java.util.Scanner;

public class ProductSalesExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[][] productSales = new int[2][3];

        // Collect sales information
        for (int intRow = 0; intRow < productSales.length; intRow++) {

            for (int intCol = 0; intCol < productSales[intRow].length; intCol++) {

                System.out.print("Enter sales for Year " + (intRow + 1)
                        + ", Quarter " + (intCol + 1) + ": ");

                productSales[intRow][intCol] = input.nextInt();
            }
        }

        // Display sales information
        System.out.println("\nPRODUCT SALES");

        for (int intRow = 0; intRow < productSales.length; intRow++) {

            System.out.println("\nYear " + (intRow + 1));

            for (int intCol = 0; intCol < productSales[intRow].length; intCol++) {

                System.out.println("Quarter " + (intCol + 1) + ": "
                        + productSales[intRow][intCol]);
            }
        }

        input.close();
    }
}
```

---

# 5. Understanding the Code

The most important line in the input loop is:

```java
productSales[intRow][intCol] = input.nextInt();
```

This is where the user's input is stored inside the array.

### Example

If the user enters:

```text
300
```

during the first iteration, Java stores it as:

```java
productSales[0][0] = 300;
```

If the user enters:

```text
150
```

during the next iteration, Java stores it as:

```java
productSales[0][1] = 150;
```

The array gradually fills itself with the information entered by the user.

### Array Indexing

Remember that array indexes start at `0`.

| Position | Array Index |
|---|---|
| Year 1 | `0` |
| Year 2 | `1` |
| Quarter 1 | `0` |
| Quarter 2 | `1` |
| Quarter 3 | `2` |

Therefore:

```java
productSales[0][0]
```

represents Year 1, Quarter 1.

```java
productSales[1][2]
```

represents Year 2, Quarter 3.

---

# 6. Which Input Method Should You Use?

| Situation | Recommended Method |
|---|---|
| Simple Java application | `JOptionPane` |
| Console-based application | `Scanner` |
| Existing Swing GUI | `JTextField` |
| Larger application | Forms with input validation |

For the Question 1 sales application, if the requirement were to allow the user to enter sales figures, I would use `Scanner` to collect the six quarterly sales values, store them in a two-dimensional array, and then pass that array to the calculation methods in `ProductSales`.

---

# 7. Unit Testing in Java

## 7.1 What is Unit Testing?

Unit testing is the process of testing individual parts of a program, usually individual methods, to determine whether they produce the expected results.

Instead of running the entire application and manually checking the output, we can write tests that automatically check whether a method works correctly.

For example, if we have a method that calculates the total sales, we can test it with known values.

| Input | Expected Output |
|---|---:|
| 100, 200, 300 | 600 |
| 50, 50, 50 | 150 |
| 0, 0, 0 | 0 |

If the method returns the expected result, the test passes.

---

## 7.2 Example Method to Test

Suppose we have a `ProductSales` class with a method that calculates the total sales.

### ProductSales.java

```java
public class ProductSales {

    public int calculateTotalSales(int[] sales) {

        int intTotal = 0;

        for (int intSale : sales) {
            intTotal += intSale;
        }

        return intTotal;
    }
}
```

### How the Method Works

```java
int intTotal = 0;
```

Creates a variable to store the total.

```java
for (int intSale : sales)
```

Loops through every value in the array.

```java
intTotal += intSale;
```

Adds each sales value to the total.

```java
return intTotal;
```

Returns the final result.

---

## 7.3 Creating a Unit Test

In Java, we can use **JUnit** to create unit tests.

JUnit allows us to test methods automatically and determine whether they produce the expected results.

### Example Test Class

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void testCalculateTotalSales() {

        ProductSales sales = new ProductSales();

        int[] intSales = {100, 200, 300};

        int intResult = sales.calculateTotalSales(intSales);

        assertEquals(600, intResult);
    }
}
```

---

## 7.4 Understanding the Unit Test

### `@Test`

```java
@Test
```

Tells JUnit that the method is a test method.

JUnit will execute this method when the tests are run.

### Creating the Object

```java
ProductSales sales = new ProductSales();
```

Creates an instance of the `ProductSales` class so that we can access its method.

### Creating Test Data

```java
int[] intSales = {100, 200, 300};
```

Provides sample data for the method.

We don't need to ask a user to enter information because we already know what values we want to test.

### Calling the Method

```java
int intResult = sales.calculateTotalSales(intSales);
```

Calls the method being tested and stores the returned result.

### Checking the Result

```java
assertEquals(600, intResult);
```

This compares:

- **Expected result:** `600`
- **Actual result:** Whatever the method returns

If both values match, the test passes.

If they differ, the test fails.

---

## 7.5 Testing Multiple Scenarios

A good unit test should test more than one scenario.

We can test:

- Normal values
- Zero values
- Different combinations of values

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    ProductSales sales = new ProductSales();

    @Test
    public void testNormalSales() {

        int[] intSales = {100, 200, 300};

        assertEquals(600, sales.calculateTotalSales(intSales));
    }

    @Test
    public void testZeroSales() {

        int[] intSales = {0, 0, 0};

        assertEquals(0, sales.calculateTotalSales(intSales));
    }

    @Test
    public void testSingleSale() {

        int[] intSales = {500};

        assertEquals(500, sales.calculateTotalSales(intSales);
    }

    @Test
    public void testNegativeValues() {

        int[] intSales = {-100, 200, 300};

        assertEquals(400, sales.calculateTotalSales(intSales));
    }
}
```

### Expected Results

| Test | Input | Expected Result |
|---|---|---:|
| Normal Sales | 100, 200, 300 | 600 |
| Zero Sales | 0, 0, 0 | 0 |
| Single Sale | 500 | 500 |
| Negative Value | -100, 200, 300 | 400 |

If all tests pass, JUnit will indicate that the tests were successful.

---

## 7.6 Unit Testing Using a Two-Dimensional Array

We can also test methods that work with your two-dimensional sales array.

### ProductSales.java

```java
public class ProductSales {

    public int calculateTotalSales(int[][] sales) {

        int intTotal = 0;

        for (int intRow = 0; intRow < sales.length; intRow++) {

            for (int intCol = 0; intCol < sales[intRow].length; intCol++) {

                intTotal += sales[intRow][intCol];
            }
        }

        return intTotal;
    }
}
```

### ProductSalesTest.java

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void testCalculateTotalSales() {

        ProductSales sales = new ProductSales();

        int[][] intSales = {
            {100, 200, 300},
            {400, 500, 600}
        };

        int intResult = sales.calculateTotalSales(intSales);

        assertEquals(2100, intResult);
    }
}
```

### How the Test Works

| | Quarter 1 | Quarter 2 | Quarter 3 |
|---|---:|---:|---:|
| Year 1 | 100 | 200 | 300 |
| Year 2 | 400 | 500 | 600 |

The method calculates:

```text
100 + 200 + 300 + 400 + 500 + 600 = 2100
```

Therefore, the expected result is:

```java
assertEquals(2100, intResult);
```

If the method returns `2100`, the test passes.

---

## 7.7 Common JUnit Assertions

JUnit provides different assertions for testing results.

| Assertion | Purpose | Example |
|---|---|---|
| `assertEquals()` | Checks if two values are equal | `assertEquals(10, result);` |
| `assertNotEquals()` | Checks if two values are different | `assertNotEquals(5, result);` |
| `assertTrue()` | Checks if a condition is true | `assertTrue(result > 0);` |
| `assertFalse()` | Checks if a condition is false | `assertFalse(result < 0);` |
| `assertNull()` | Checks if a value is null | `assertNull(result);` |
| `assertNotNull()` | Checks if a value isn't null | `assertNotNull(result);` |
| `assertThrows()` | Checks whether an exception is thrown | `assertThrows(...)` |

---

## 7.8 Example of `assertTrue()`

Suppose we want to check whether the total sales are greater than zero.

```java
@Test
public void testSalesAreGreaterThanZero() {

    ProductSales sales = new ProductSales();

    int[] intSales = {100, 200, 300};

    int intResult = sales.calculateTotalSales(intSales);

    assertTrue(intResult > 0);
}
```

The test passes if the total is greater than zero.

---

## 7.9 Example of `assertThrows()`

Unit tests can also check whether a method correctly handles invalid input.

For example, suppose we modify our method to prevent a null array from being accepted.

### ProductSales.java

```java
public class ProductSales {

    public int calculateTotalSales(int[] sales) {

        if (sales == null) {
            throw new IllegalArgumentException("Sales array cannot be null");
        }

        int intTotal = 0;

        for (int intSale : sales) {
            intTotal += intSale;
        }

        return intTotal;
    }
}
```

### Unit Test

```java
@Test
public void testNullSalesArray() {

    ProductSales sales = new ProductSales();

    assertThrows(IllegalArgumentException.class, () -> {
        sales.calculateTotalSales(null);
    });
}
```

This test checks that the method throws an `IllegalArgumentException` when a null array is supplied.

---

## 7.10 Running Unit Tests in NetBeans

1. Open your Java project in NetBeans.
2. Locate your test class.
3. Right-click the test class.
4. Select **Test File** or run the test using the testing options available in your project.
5. NetBeans executes the JUnit tests.
6. Review the test results.

### Successful Test

A successful test means the actual result matched the expected result.

### Failed Test

A failed test means:

- The actual result was different from the expected result.
- The method may contain an error.
- The test data or expected result may be incorrect.

---

## 7.11 Understanding Test Results

For example, if you have the following test:

```java
assertEquals(600, intResult);
```

And the method returns:

```text
600
```

The result is:

```text
PASSED
```

But if the method returns:

```text
500
```

The result is:

```text
FAILED
```

JUnit will show the expected and actual values, helping you identify the problem.

---

## 7.12 Why Unit Testing Is Important

Unit testing is useful because it:

- Detects errors early.
- Tests individual methods independently.
- Reduces the need for manual testing.
- Helps ensure calculations are correct.
- Makes it easier to identify bugs.
- Allows methods to be tested with different input values.
- Helps ensure that changes to the code do not break existing functionality.

---

# Quick Revision

| Concept | Meaning |
|---|---|
| Unit Test | Tests an individual method or component |
| JUnit | Java testing framework |
| `@Test` | Identifies a test method |
| `assertEquals()` | Compares expected and actual values |
| Expected Result | What the method should return |
| Actual Result | What the method really returns |
| Passed | Expected and actual results match |
| Failed | Expected and actual results differ |

### Example Testing Process

```text
Create Method
     ↓
Create Test Data
     ↓
Call Method
     ↓
Capture Actual Result
     ↓
Compare Actual and Expected
     ↓
   PASS / FAIL
```

**Unit testing is essentially a way of asking:**

> "If I give this method these specific values, does it produce the result I expect?"

That is the fundamental idea behind JUnit.

---

# End of Java Examples and Study Notes
