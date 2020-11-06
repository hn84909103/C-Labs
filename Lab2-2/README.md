## Lab 2.2 — Instance Variable and Superclass Initializing
Overview
The Details
Assuming the existence of the following classes
```java
class Name {
	Name(String first, String last) {…}
	public String toString() {return first + " " + last;}

	private String first, last;
}
```
```java
class Person {
	// Note the overloaded constructors
	Person(Name name, int age) {…}
	public String toString() {return name + " (" + age + ")";}

	private Name name;
	private int age;
}
```
```java
class Date {
	Date(int year, int month, int dom) {…}
	public String toString() {return month + "/" + dom + "/" + year;}

	private int year, month, dom;
}
```
Implement a subclass of Person named Employee with the following state/behavior:
- an integer instance variable for the employee id
- a Date instance variable for the hire date of the employee
- two constructors:
  - Employee(Name name, int age, id, Date hireDate)
  - Employee(String first, String last, int age, int id, int year, int month, int dom)
- a toString method that returns a string of the form:
    ```java
    name (age) #id hire-date
    ```
  (you will probably want to call the corresponding methods of Person and Date in this method)
  
