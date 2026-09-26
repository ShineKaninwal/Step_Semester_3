# Week 8 Practice Problems - Concept Questions

## Question 1: Encapsulation
Encapsulation means combining data and methods in one class while restricting direct access to internal data. The User object should control its email attribute because the email must be valid and unique. If outside code can modify it directly, an invalid or duplicate email could be stored. Making email private and allowing changes only through changeEmail() ensures validation happens before the value is updated. This protects the object's state.

## Question 2: Inheritance and Composition
Inheritance is suitable when report types share a common identity and behavior, such as a base Report class with specialized report subclasses. Composition is more suitable for optional capabilities like DataExport and DataVisualization. A report can contain or use the capabilities it needs without forcing every report to inherit them. Putting every capability into one inheritance hierarchy can create rigid classes, unnecessary methods, and difficulty adding new combinations of features.

## Question 3: Abstraction and Runtime Polymorphism
A Notification interface can define a common send() method. EmailNotification, SMSNotification, and PushNotification implement that method with their own behavior. NotificationService depends on the interface and calls send() without checking the concrete type. At runtime, Java selects the overridden method belonging to the actual object. A new InAppNotification can implement the same interface and be used without changing the main service logic.

## Question 4: Composition and Aggregation
Composition represents strong ownership: the part's lifecycle depends on the whole. Aggregation represents a weaker relationship in which the part can exist independently. Organization and Department use composition because departments are dissolved when the organization ceases to exist. Department and Employee use aggregation because employees can continue to exist and move to another department when a department is dissolved.

## Question 5: Student and Course Multiplicity
The relationship between Student and Course is many-to-many. A student can enroll in zero or more courses, and a course can have zero or more students. The multiplicity is therefore 0..* at both ends. The rule that a student cannot enroll in the same course twice is a business constraint, not a multiplicity. It should be enforced through application validation or a unique constraint on the student-course enrollment pair.
