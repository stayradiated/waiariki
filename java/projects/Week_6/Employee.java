
/**
 * Class: Employee
 * Author: George Czabania
 * Date: 3 September 2013
 * Purpose: Represent employee data
 */

public class Employee {

  // Instance variables
  private String name;
  private int age;
  private double salary;
  
  /**
   * Default Constructor
   */
  public Employee () {
    name = "";
    age = 0;
    salary = 0;
  }

  /**
   * Alternative Constructor
   * @param _name - the name of the employee
   * @param _age - the age of the employee
   * @param _salary - the salary of the employee
   */
  public Employee (String _name, int _age, double _salary) {
    name = _name;
    age = _age;
    salary = _salary;
  }


  /**
   * Set the name of the employee
   * @param _name - the name of the employee
   */
  public void setName (String _name) {
    name = _name;
  }

  /**
   * Get the name of the employee
   * @return name - the name of the employee
   */
  public String getName () {
    return name;
  }

  /**
   * Set the salary of the employee
   * @param _salary - the salary of the employee
   */
  public void setSalary (double _salary) {
    salary = _salary;
  }

  /**
   * Get the salary of the employee
   * @return salary - the salary of the employee
   */
  public double getSalary () {
    return salary;
  }

  /**
   * Set the age of the employee
   * @param _age - the age of the employee
   */
  public void setAge (int _age) {
    age = _age;
  }

  /**
   * Get the age of the employee
   * @return age - the age of the employee
   */
  public int getAge () {
    return age;
  }

  /**
   * Print the details about the employee
   */
  public void printDetails () {
    System.out.printf("%-10s%10s%10.2f\n", name, age, salary);
  }

  /**
   * Increase employee salary by percentage
   * @param percent - percent to increase the salary
   */
  public void increaseSalary (double percent) {
    salary += salary * percent / 100.00;
  }

}
