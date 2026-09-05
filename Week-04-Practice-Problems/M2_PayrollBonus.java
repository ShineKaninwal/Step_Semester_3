class Employee {

    String id;
    double salary;

    // Constructor
    Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    // Add bonus to the employee salary
    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    // Display final salary
    void printSalary() {
        System.out.println(
            id + " | Final Salary: Rs " + salary
        );
    }
}

public class M2_PayrollBonus {

    public static void main(String[] args) {

        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        // Apply the same bonus to every employee
        for (int i = 0; i < employees.length; i++) {
            employees[i].raiseSalary(5000);
            employees[i].printSalary();
        }
    }
}