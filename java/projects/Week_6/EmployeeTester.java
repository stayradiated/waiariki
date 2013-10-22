
/**
 * class: EmployeeTester
 * author: George Czabania
 * date: 3rd September 2013
 * purpose: Test Employee class
 */

import java.util.Scanner;

public class EmployeeTester {

  private Scanner in = new Scanner(System.in);

  /**
   * Main method to start the program
   */
  public static void main (String[] args) {
    new EmployeeTester();
  }

  /**
   * Default constructor
   */
  public EmployeeTester () {

    // Store employees
    Employee[] users = {
      getDetails(), getDetails(), getDetails()
    };

    // Print table header
    System.out.printf("\n%-10s%10s%10s\n", "Name", "Age", "Salary");
    System.out.println("------------------------------");

    // Loop through all employees
    for (int i = 0; i < users.length; i++) {

      // Give each employee a random salary increase
      users[i].increaseSalary(Math.random() * 100);

      // Print out the employee details
      users[i].printDetails();

    }

  }

  /**
   * Get the details from System.in and create a new Employee
   * @return Employee - a new Employee with the users details
   */
  private Employee getDetails () {

    // Uses Scanner class assumes input is all good and correct
    System.out.print("Input employee details: (name age salary) ");
    String name = in.next();
    int age = in.nextInt();
    double salary = in.nextDouble();

    // Creates and returns a new Employee object
    return new Employee(name, age, salary);

  }

}
