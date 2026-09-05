# STEP-Class

This repository contains my Java programming practice problems and assignments completed as part of the STEP Class.

The problems are solved week-wise and cover Java fundamentals, problem-solving, strings, arrays, validation, Object-Oriented Programming, classes, objects, constructors, encapsulation, references, static members, constructor chaining, `this`, `final`, static blocks, and `instanceof`.

---

# 📚 Week 01

## 📝 Week 01 - Practice Problems

The Week 01 practice problems focus on Java fundamentals including loops, arrays, strings, conditional statements, random number generation, recursion, searching, and formatted output.

### 1. Rock-Paper-Scissors Game

A Rock-Paper-Scissors game where the computer generates a random choice and the player's choice is compared against it to determine the winner.

The program also keeps track of the game results and displays basic statistics.

**How it is solved:**

- Generate a random choice for the computer.
- Accept or define the player's choice.
- Compare both choices using conditional statements.
- Determine whether the player wins, loses, or draws.
- Track the results and display the final statistics.

**Concepts covered:**

- Random number generation
- Conditional logic
- Loops
- Arrays
- Counters
- Basic statistics
- Formatted output

---

### 2. Palindrome Checker - 3 Approaches

Checks whether a given string is a palindrome using multiple approaches.

A palindrome reads the same forward and backward.

**How it is solved:**

- Compare characters from the beginning and end using an iterative approach.
- Use recursion to compare matching characters.
- Convert the string into a character array and compare it with its reversed form.

**Concepts covered:**

- String traversal
- Iteration
- Recursion
- Character arrays
- Array reversal
- String comparison

---

### 3. BMI Calculator for a Team

Calculates the BMI of multiple team members using their height and weight and displays the results in a formatted table.

**How it is solved:**

- Store heights and weights in arrays.
- Calculate BMI using the formula:

`BMI = weight / (height × height)`

- Use conditional statements to classify the BMI.
- Display each person's result in a formatted table.

**Concepts covered:**

- Arrays
- Arithmetic operations
- Loops
- Conditional statements
- BMI calculation
- Formatted output

---

### 4. First Non-Repeating Character

Finds the first character in a string that occurs only once.

**How it is solved:**

- Traverse the string and count character frequencies.
- Store the frequency of each character.
- Traverse the string again.
- Return the first character whose frequency is one.

**Concepts covered:**

- Character frequency counting
- String traversal
- Loops
- Arrays
- HashMap
- Early-exit scanning

---

### 5. Reverse Customer Name

Reverses a customer name using character traversal and constructs the reversed string.

**How it is solved:**

- Read the customer name.
- Traverse the characters from the end toward the beginning.
- Add each character to the resulting string.
- Print the reversed name.

**Concepts covered:**

- String traversal
- Character arrays
- Methods
- String reconstruction
- Loops

---

## 📌 Week 01 - Assignment

The Week 01 assignment focuses on arrays, nested loops, strings, comparison, counting, searching, and basic problem-solving.

### 1. Exam Hall Seat Duplication Checker

Checks whether any seat number has been assigned more than once.

**How it is solved:**

- Store all seat numbers in an integer array.
- Use nested loops to compare every seat number with the others.
- If two different positions contain the same value, a duplicate is found.
- Print the duplicated seat number.
- If no duplicate is found, print a confirmation message.

**Concepts covered:**

- Arrays
- Nested loops
- Duplicate detection
- Conditional logic
- Array traversal

---

### 2. Typing Speed Test Accuracy Checker

Compares an original passage with a user's typed version and calculates typing accuracy.

**How it is solved:**

- Traverse both strings character by character.
- Compare characters at the same positions.
- Count matching characters.
- Store the position of the first mismatch.
- Calculate accuracy using:

`Accuracy = (Matched Characters / Total Characters) × 100`

- Display the accuracy and first mismatch.

**Concepts covered:**

- String traversal
- `charAt()`
- `length()`
- Character comparison
- Loops
- Percentage calculation
- Conditional logic

---

### 3. Traffic Signal Streak Analyzer

Finds the longest continuous sequence of the same traffic signal color.

**How it is solved:**

- Traverse the signal log character by character.
- Compare the current character with the previous character.
- Increase the current streak when they are the same.
- Reset the streak when the color changes.
- Keep track of the longest streak and its color.

**Concepts covered:**

- String traversal
- `charAt()`
- Character comparison
- Loops
- Counters
- Maximum value tracking

---

### 4. Warehouse Inventory Balancer

Compares inventory quantities in two warehouse sections and finds the highest quantity item.

**How it is solved:**

- Store quantities for both sections in arrays.
- Calculate the total quantity of each section.
- Compare both totals to determine whether they are balanced.
- Traverse both arrays to find the maximum quantity.
- Store the section and index where the maximum value occurs.

**Concepts covered:**

- Arrays
- Loops
- Sum accumulation
- Maximum value tracking
- Index tracking
- Conditional comparison

---

### 5. Movie Review Word Length Profiler

Classifies words in a movie review according to their length.

**How it is solved:**

- Split the review into individual words.
- Traverse every word.
- Check its length.
- Classify it as:
  - Short → 1–4 letters
  - Medium → 5–8 letters
  - Long → 9 or more letters
- Maintain counters for each category.

**Concepts covered:**

- `split()`
- String traversal
- Word processing
- `length()`
- Conditional logic
- Counting

---

# 📚 Week 02

## 📝 Week 02 - Practice Problems

The Week 02 practice problems focus on string manipulation, character processing, validation, `StringBuilder`, CSV parsing, and formatted output.

### 1. Vowel & Consonant Counter

Counts the number of vowels and consonants in a given text.

**How it is solved:**

- Traverse the string using `charAt()`.
- Ignore spaces.
- Convert characters to a common case.
- Check whether each character is a vowel.
- If it is not a vowel, count it as a consonant.

**Concepts covered:**

- `charAt()`
- `length()`
- Loops
- Character comparison
- Case-insensitive processing
- Conditional logic

---

### 2. CSV Student Record Parser

Parses a student record provided in CSV format.

**How it is solved:**

- Use `split(",")` to separate the fields.
- Check whether exactly three fields exist.
- Extract the student's name, roll number, and department.
- Print the information in a formatted record.
- Print `Invalid Record` when the number of fields is incorrect.

**Concepts covered:**

- `split()`
- Arrays
- Array length validation
- String concatenation
- Formatted output

---

### 3. File Extension Validator

Checks whether a file has an accepted extension such as PDF, DOCX, or ZIP.

**How it is solved:**

- Find the last `.` using `lastIndexOf('.')`.
- Extract the extension using `substring()`.
- Compare the extension using `equalsIgnoreCase()`.
- Print whether the file is accepted or rejected.

**Concepts covered:**

- `lastIndexOf()`
- `substring()`
- `equalsIgnoreCase()`
- String processing
- Conditional logic

---

### 4. Masked Phone Number Formatter

Validates a phone number and displays only its last four digits.

**How it is solved:**

- Check whether the phone number contains exactly 10 digits.
- Extract the last four digits using `substring()`.
- Create a masked representation using `StringBuilder`.
- Insert a `-` between the mask and the visible digits.

**Example:**

`9876543210 → XXXXXX-3210`

**Concepts covered:**

- String validation
- `length()`
- Digit checking
- `substring()`
- `StringBuilder`
- String formatting

---

### 5. Bank Transaction Reference Generator & Validator

Normalizes and validates a transaction reference containing a bank code, date, and sequence number.

**How it is solved:**

- Remove leading and trailing spaces using `trim()`.
- Convert only the first three characters to uppercase.
- Validate that the reference contains exactly 14 characters.
- Check that the first three characters are letters.
- Check that the remaining characters are digits.
- Build the final formatted output using `StringBuilder`.

**Concepts covered:**

- `trim()`
- `substring()`
- String concatenation
- `Character.isLetter()`
- `Character.isDigit()`
- `StringBuilder`
- Multi-stage validation

---

## 📌 Week 02 - Assignment

The Week 02 assignment focuses on basic validation, string manipulation, `StringBuilder`, CSV parsing, word processing, frequency counting, and sorting.

### 1. ATM PIN Length Validator

Checks whether an ATM PIN contains exactly four characters.

**How it is solved:**

- Accept the PIN as a string.
- Use `length()` to determine its size.
- Use an `if / else` statement to check whether the length is exactly 4.
- Print the appropriate validation message.

**Concepts covered:**

- `length()`
- `if / else`
- Comparison operators
- Basic validation

---

### 2. Word Reversal Encoder

Reverses every word individually while keeping the original word order.

**Example:**

`hello club → olleh bulc`

**How it is solved:**

- Split the sentence using `split(" ")`.
- Traverse every word.
- Reverse each word using `StringBuilder`.
- Add the reversed words to the result.
- Preserve spaces between words.

**Concepts covered:**

- `split()`
- Loops
- `StringBuilder`
- `reverse()`
- String joining

---

### 3. Product Inventory CSV Parser

Parses product inventory information provided in CSV format.

**How it is solved:**

- Split the input using `split(",")`.
- Check that exactly three fields are present.
- Extract the product name, SKU, and quantity.
- Print the data in the required format.
- Print `Invalid Record` for incorrect input.

**Concepts covered:**

- `split()`
- Arrays
- Array length validation
- String concatenation
- Formatted output

---

### 4. Library ISBN Normalizer & Validator

Normalizes and validates a library book code containing a three-letter publisher code followed by ten digits.

**How it is solved:**

- Remove leading and trailing spaces using `trim()`.
- Convert the first three characters to uppercase.
- Check that the final string contains exactly 13 characters.
- Validate the first three characters using `Character.isLetter()`.
- Validate the remaining characters using `Character.isDigit()`.
- Build the formatted result using `StringBuilder`.

**Concepts covered:**

- `trim()`
- `substring()`
- String concatenation
- `Character.isLetter()`
- `Character.isDigit()`
- `StringBuilder`
- Multi-stage validation

---

### 5. Stop-Word-Filtered Word Frequency Report

Counts meaningful words in a feedback paragraph while ignoring common stop words.

Stop words include:

`the, was, and, a, is, of, in`

**How it is solved:**

- Convert the paragraph to lowercase.
- Remove punctuation using `replace()`.
- Split the text using `split("\\s+")`.
- Ignore words present in the stop-word list.
- Store word frequencies using a `HashMap`.
- Sort the words based on frequency in descending order.
- Print each word with its frequency.

**Concepts covered:**

- `replace()`
- `split("\\s+")`
- `toLowerCase()`
- Stop-word filtering
- `HashMap`
- Frequency counting
- Sorting
- Derived-value comparison

---

# 📚 Week 03

## 📝 Week 03 - OOP Practice Problems

The Week 03 practice problems introduce Object-Oriented Programming concepts including classes, objects, constructors, encapsulation, constructor overloading, reference variables, instance members, and static members.

### 1. From Parallel Arrays to a Class - Placement Record

Replaces separate student, company, and package arrays with a `PlacementRecord` class.

**How it is solved:**

- Create a `PlacementRecord` class.
- Define `studentName`, `company`, and `packageLpa` as fields.
- Initialize the fields through a constructor.
- Create multiple `PlacementRecord` objects.
- Store the objects inside an array.
- Use an instance method to print each record.

**Concepts covered:**

- Classes and objects
- Constructors
- Instance fields
- Instance methods
- Arrays of objects
- OOP vs parallel arrays

---

### 2. Encapsulated Mess-Card Wallet

Creates a wallet where the balance cannot be directly modified from outside the class.

**How it is solved:**

- Declare `balance` as a `private` field.
- Initialize it through the constructor.
- Use `topUp()` to safely increase the balance.
- Use `deduct()` to prevent the balance from becoming negative.
- Use `getBalance()` for read-only access.

**Concepts covered:**

- Encapsulation
- Private fields
- Public methods
- Data validation
- Getter methods
- Controlled access to data

---

### 3. Overloaded Constructors for a Course

Creates courses using either a full constructor or a theory-only constructor.

**How it is solved:**

- Create a four-argument constructor containing the complete initialization logic.
- Create a three-argument constructor for theory-only courses.
- Use `this(...)` to call the four-argument constructor.
- Set `labCredits` to `0` for theory-only courses.
- Calculate total credits using an instance method.

**Concepts covered:**

- Constructor overloading
- `this()`
- Constructor chaining
- Instance methods
- Code reuse
- Avoiding duplicated initialization

---

### 4. Reference Copies and a Shared ID Card

Demonstrates the difference between copying an object reference and creating a new object.

**How it is solved:**

- Create one `IdCard` object.
- Assign another reference variable to the same object.
- Modify the object using the second reference.
- Observe the modification through the first reference.
- Use `==` to prove both references point to the same object.
- Create another object with identical values.
- Use `==` to show that it is a separate object.

**Concepts covered:**

- Object references
- Reference copying
- `==` operator
- Object identity
- Shared references
- Separate objects

---

### 5. Instance vs Static - Student Class

Demonstrates the difference between instance fields and static fields.

**How it is solved:**

- Store `name` and `attendance` as instance fields.
- Store `collegeName` as a static field shared by all students.
- Maintain `studentCount` as a static counter.
- Increment the counter inside the constructor.
- Create multiple `Student` objects.
- Access the static information through the class name.

**Concepts covered:**

- Instance variables
- Static variables
- Static methods
- Shared class data
- Object counters
- Class-level members
- Accessing static members through the class

---

## 🏠 Week 03 - Homework Assignment

The Week 03 Homework Assignment focuses on Object-Oriented Programming concepts including classes, objects, constructors, encapsulation, constructor overloading, reference copying, instance members, and static members.

### 1. From Parallel Arrays to a Class - Library Inventory

Creates a `BookInventory` class instead of using separate parallel arrays for book titles, authors, and available copies.

**How it is solved:**

- Create a `BookInventory` class.
- Define `title`, `author`, and `copiesAvailable` fields.
- Initialize all fields using a constructor.
- Create four `BookInventory` objects.
- Store the objects in an array.
- Traverse the array using a loop.
- Call `printEntry()` for every object.

**Concepts covered:**

- Classes and objects
- Constructors
- Instance fields
- Instance methods
- Arrays of objects
- OOP vs parallel arrays

**File:**

`Problem01_BookInventory.java`

---

# 📚 Week 04

## 📝 Week 04 - Practice Problems

The Week 04 practice problems focus on Java constructors and keywords including `this()`, `this`, `final`, static blocks, and `instanceof`.

### 1. Library Book

Demonstrates constructor chaining using `this()` while creating library book records.

**Concepts covered:**

- Constructors
- Constructor overloading
- `this()`
- Constructor chaining
- Classes and objects

**File:**

`M1_LibraryBook.java`

---

### 2. Payroll Bonus

Demonstrates the use of the `this` keyword for referring to instance variables and handling employee payroll information.

**Concepts covered:**

- Classes and objects
- Constructors
- `this` keyword
- Instance variables
- Methods

**File:**

`M2_PayrollBonus.java`

---

### 3. Late Fees

Demonstrates the use of `final` methods while calculating and displaying late fees.

**Concepts covered:**

- Classes and objects
- Constructors
- `final` methods
- Method calls
- Calculations

**File:**

`M3_LateFees.java`

---

### 4. SRM Student

Demonstrates the use of a static block for initializing class-level information.

**Concepts covered:**

- Static members
- Static blocks
- Constructors
- Instance variables
- Classes and objects

**File:**

`M4_SrmStudent.java`

---

### 5. Account Payments

Demonstrates runtime type checking using `instanceof` and type casting for different payment types.

**Concepts covered:**

- Inheritance
- Method overriding
- `instanceof`
- Type casting
- Polymorphism
- Classes and objects

**File:**

`M5_AccountPayments.java`

---

## 📌 Week 04 - Assignment

The Week 04 assignment focuses on constructors and Java keywords including constructor chaining using `this()`, the `this` keyword, `final` methods, static blocks, and `instanceof`.

### 1. Hackathon Registration

Manages hackathon participants using constructors for both team participants and solo participants.

The program uses constructor chaining to assign `"Unassigned"` as the team name for solo participants.

**How it is solved:**

- Create a `Participant` class.
- Define `name`, `teamName`, and `registered` fields.
- Use a constructor for participants with a team.
- Use `this(name, "Unassigned")` for solo participants.
- Store participant names and team names in parallel arrays.
- Process all participants using a single loop.
- Print the registration status.

**Concepts covered:**

- Classes and objects
- Constructors
- Constructor overloading
- `this()`
- Constructor chaining
- Parallel arrays
- Conditional statements
- Instance methods

**File:**

`A1_HackathonRegistration.java`

---

### 2. Canteen Inventory

Manages canteen inventory using the `this` keyword to distinguish instance variables from constructor and method parameters.

**How it is solved:**

- Create an `Item` class.
- Define `itemName` and `stock` as fields.
- Initialize the fields using a constructor.
- Use `this.itemName` and `this.stock` for field assignment.
- Use `restock()` to increase the available stock.
- Create multiple item objects.
- Add stock to every item using a loop.

**Concepts covered:**

- Classes and objects
- Constructors
- `this` keyword
- Instance variables
- Instance methods
- Arrays of objects
- Loops

**File:**

`A2_CanteenInventory.java`

---

### 3. Parking Overstay Fine

Calculates parking fines based on the number of minutes a vehicle stays beyond the allotted time.

The calculation and receipt methods are declared as `final`.

**How it is solved:**

- Create a `ParkingTicket` class.
- Store the vehicle number and rate per minute.
- Calculate the fine using the overstay time and rate.
- Use a `final` method for fine calculation.
- Use another `final` method to print the receipt.
- Store vehicle numbers, rates, and overstay times in parallel arrays.
- Print a fine only when the overstay is greater than zero.

**Concepts covered:**

- Classes and objects
- Constructors
- `final` methods
- Arithmetic operations
- Parallel arrays
- Conditional statements
- Loops

**File:**

`A3_ParkingFine.java`

---

### 4. Library Membership Card

Creates library membership cards for students using a static block to initialize common library information.

The static block executes only once when the class is loaded.

**How it is solved:**

- Create a `MembershipCard` class.
- Define `libraryName` and `validUntil` as static fields.
- Use a static block to initialize the common library information.
- Print `Library info loaded` when the static block executes.
- Store the student name as an instance field.
- Create membership cards for multiple students.
- Display the membership confirmation for every student.

**Concepts covered:**

- Classes and objects
- Constructors
- Static variables
- Static blocks
- Instance variables
- Shared class-level data
- Loops

**File:**

`A4_LibraryMembership.java`

---

### 5. Canteen Closing-Time Payment Dispatch

Processes different types of payments using inheritance, `instanceof`, and type casting.

Card payments include a 2% processing fee while cash payments are processed normally.

**How it is solved:**

- Create a `Payment` class for normal payments.
- Create a `CardPayment` class that extends `Payment`.
- Add a processing fee for card payments.
- Create a `PaymentProcessor` class to process transactions.
- Use `instanceof` to check whether a payment is a card payment.
- Cast the object to `CardPayment` when required.
- Process all payments using a `Payment[]` array.
- Calculate and display the total amount collected.

**Concepts covered:**

- Inheritance
- Classes and objects
- Method overriding
- `instanceof`
- Type casting
- Polymorphism
- Arrays of objects
- Conditional statements
- Arithmetic operations

**File:**

`A5_CanteenPayments.java`

---

# 📌 Repository Structure

```text
STEP-Class
│
├── Week-01-Practice-Problems
├── Week-01-Assignment
│
├── Week-02-Practice-Problems
├── Week-02-Assignment
│
├── Week-03-Practice-Problems
├── Week-03-Homework-Assignment
│
├── Week-04-Practice-Problems
└── Week-04-Assignment