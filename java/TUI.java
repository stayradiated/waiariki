/**
 * The Textual User Interface (TUI) handles the input and output of the system.
 * This includes displaying menus, and lists as well as listening to user input.
 */

import java.util.Scanner;

public class TUI {

  private Scanner scanner;
  private Employees employees;

  private final String MESSAGE_WELCOME = "\nWelcome to the ABC Company Employee System\n\n";
  private final String MESSAGE_NUMBER = "Number of employees in system: ";
  private final String MESSAGE_FULL = "\nThe maximum amount of employees has been reached.\n";
  private final String MESSAGE_WAIT = "\nPress ENTER to continue...\n";
  private final String MESSAGE_THANKS = "Thank you for using the ABC Company Employee System\n";
  private final String MESSAGE_WRITE = "Number of employee records written to employees.txt file: ";
  private final String NL = "\n";

  private final TableColumn[] TABLE_EMPLOYEE = {
    new TableColumn("ID", 3),
    new TableColumn("Name", 20),
    new TableColumn("Gender", 6),
    new TableColumn("Age", 3),
    new TableColumn("Number of Duties", 20)
  };

  public static void main (String[] args) {
    new TUI();
  }

  private TUI () {
    this.scanner = new Scanner(System.in);
    this.employees = new Employees();
    if (this.employees.fileExists()) {
      this.employees.read();
    }
    this.menu();
  }

  private void menu () {

    final TableColumn[] columns = {
      new TableColumn("#", 1),
      new TableColumn("MAIN MENU", 60)
    };

    final String[][] rows = {
      new String[] { "1", "Add employee" },
      new String[] { "2", "Delete an employee" },
      new String[] { "3", "Modify an employee record" },
      new String[] { "4", "List all employees" },
      new String[] { "5", "View details of an employee" },
      new String[] { "6", "List all employees in an age group" },
      new String[] { "7", "View the employee with the highest number of jobs assigned" },
      new String[] { "8", "Show total number of employees with no jobs assigned" },
      new String[] { "9", "Exit" }
    };

    final Table table = new Table(columns, rows);

    this.print(MESSAGE_WELCOME);
    this.numberOfEmployees();
    table.print();

    int selection = this.readInt("\nSelect Option: ");

    switch (selection) {
      case 1: // Add employee
        this.add();
        break;

      case 2: // Delete employee
        this.delete();
        break;

      case 4: // List all employees
        this.listAll();
        break;

      case 9: // Delete an employee
        this.exit();
        break;

    }

    // Show the menu again
    this.waitForUser();
    this.menu();

  }

  /**
   * 1. Add Employee
   */

  private void add () {

    // Check employees record is not full
    if (this.employees.isFull()) {
      this.print(MESSAGE_FULL);
      return;
    }

    Employee employee = new Employee();

    Questions questions = new Questions(new Question[] {
      new Question("Enter name:", "String"),
      new Question("Enter gender (m/f):", "char"),
      new Question("Enter age in years:", "int"),
      new Question("Number of jobs assigned:", "int"),
    }, this.scanner);

    Object[] answers = questions.ask();

    employee.setName(   (String)    answers[0] );
    employee.setGender( (Character) answers[1] );
    employee.setAge(    (Integer)   answers[2] );
    employee.setDuties( (Integer)   answers[3] );

    int id = this.employees.add(employee);
    this.print("\nEmployee ID is " + id + "\n");

  }


  /**
   * 2. Delete an employee
   */


  private void delete () {
    int id = this.readInt("Enter Employee ID: ");

    if (this.employees.has(id) == false) {
      this.print("Could not find employee " + id + NL);
      return;
    }

    Employee employee = this.employees.get(id);
    this.printEmployeeDetails(employee);
    this.print("Are you sure you want to delete this record? (y/n)");
    this.employees.remove(id);
  }


  /**
   * 4. List all employees
   */

  private void listAll () {
    Table table = new Table(TABLE_EMPLOYEE, this.employees.asRows());
    table.print();
    this.numberOfEmployees();
  }


  /**
   * 9. Exit
   */

  private void exit () {
    this.write();
    this.print(MESSAGE_THANKS);
    this.waitForUser();
    System.exit(0);
  }


  /**
   * Write data to file
   */

  private void write () {
    this.employees.write();
    this.print(MESSAGE_WRITE + this.employees.length + NL + NL);
  }

  /**
   * Print the number of employees in the system
   */

  private void numberOfEmployees () {
    this.print(MESSAGE_NUMBER + employees.length + NL + NL);
  }

  /**
   * Print the employee details
   * @param employee
   */

  private void printEmployeeDetails (Employee employee) {
    String[][] rows = {
      employee.asRow()
    };
    Table table = new Table(TABLE_EMPLOYEE, rows);
    table.print();
  }

  /**
   * Read an integer
   */

  private int readInt (String prompt) {
    this.print(prompt);
    System.out.flush();
    while (! this.scanner.hasNextInt()) {
      this.scanner.nextLine();
      this.print(prompt);
      System.out.flush();
    }
    int option = this.scanner.nextInt();
    this.print(NL);
    return option;
  }

  /**
   * Wait for the user to press enter
   */

  private void waitForUser () {
    this.print(MESSAGE_WAIT);
    this.scanner.skip(NL);
    this.scanner.nextLine();
  }

  /**
   * Print text to the screen
   */

  private void print (String string) {
    System.out.print(string);
  }


}
