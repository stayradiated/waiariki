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

  private final Question[] QUESTION_EMPLOYEE = new Question[] {
    new Question("Enter name:", "String"),
    new Question("Enter gender (m/f):", "char"),
    new Question("Enter age in years:", "int"),
    new Question("Number of jobs assigned:", "int"),
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
      new TableColumn("Main Menu", 60)
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

    int selection = this.readInt("Select Option: ");

    switch (selection) {
      case 1: // Add employee
        this.add();
        break;

      case 2: // Delete employee
        this.delete();
        break;

      case 3: // Modify employee
        this.modify();
        break;

      case 4: // List all employees
        this.listAll();
        break;

      case 5: // View single emplyoee
        this.listSingle();
        break;

      case 6: // View age group
        this.listAgeGroup();
        break;

      case 7: // Most duties
        this.showMostDuties();
        break;

      case 8: // No duties
        this.showNoDuties();
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

    final Title title = new Title("1. Add Employee");
    title.print();

    // Check employees record is not full
    if (this.employees.isFull()) {
      this.print(MESSAGE_FULL);
      return;
    }

    Employee employee = new Employee();

    Questions questions = new Questions(QUESTION_EMPLOYEE, this.scanner);
    Object[] answers = questions.ask();
    this.setEmployee(employee, answers);

    int id = this.employees.add(employee);
    this.print("\nEmployee ID is " + id + "\n");

  }


  /**
   * 2. Delete an employee
   */


  private void delete () {

    final Title title = new Title("2. Delete Employee");
    title.print();

    int id = this.readInt("Enter Employee ID: ");

    if (this.employees.has(id) == false) {
      this.print("Could not find employee " + id + NL);
      return;
    }

    Employee employee = this.employees.get(id);
    this.printEmployeeDetails(employee);
    Question question = new Question("Are you sure you want to delete this record? (y/N)", "char");
    if ((Character) question.ask(this.scanner) == 'y') {
      this.employees.remove(id);
      this.print(NL + "Employee " + id + " has been deleted." + NL);
    } else {
      this.print(NL + "Employee " + id + " has NOT been deleted." + NL);
    }
  }


  /**
   * 3. Modify an employee
   */

  private void modify () {

    final Title title = new Title("3. Modify Employee");
    title.print();

    int id = readInt("Enter Employee ID: ");

    // Check employee ID exists
    if (!this.employees.has(id)) {
      this.print("Error - invalid ID" + NL);
      return;
    }

    // Get employee to be modified
    Employee employee = this.employees.get(id);

    // Ask questions
    Questions questions = new Questions(QUESTION_EMPLOYEE, this.scanner);
    Object[] answers = questions.ask();

    // Confirm changes
    Question confirm = new Question(
      NL + "Are you sure you want to modify this record? (Y/n)",
      "char"
    );

    char answer = (Character) confirm.ask(this.scanner);

    if (answer == 'n') {
      return;
    }

    // Modify employee
    this.setEmployee(employee, answers);
    this.print(NL + "Record modified." + NL);

  }



  /**
   * 4. List all employees
   */

  private void listAll () {

    final Title title = new Title("4. List of All Employees");
    title.print();

    Table table = new Table(TABLE_EMPLOYEE, this.employees.asRows());
    table.print();
    this.numberOfEmployees();
  }

  /**
   * 5. View single employee details
   */

  private void listSingle () {

    final Title title = new Title("5. Details for a Single Employee");
    title.print();

    int id = this.readInt("Enter ID: ");

    if (this.employees.has(id)) {
      this.printEmployeeDetails(this.employees.get(id));
    } else {
      this.print("Could not find an employee with that ID." + NL + NL);
    }

    this.print("Would you like to view another employee? (Y/n): ");
    this.scanner.skip(NL);

    // Default is to loop
    if (! this.scanner.nextLine().equals("n")) {
      this.print(NL);
      this.listSingle();
    }

  }

  /**
   * 6. View employees in an age group
   */

  public void listAgeGroup () {

    final Title title = new Title("6. Employees in Age Group");
    title.print();

    Questions questions = new Questions(new Question[] {
      new Question("Minimum age:", "int"),
      new Question("Maximum age:", "int")
    }, this.scanner);

    Object[] age = questions.ask();

    Employees list = this.employees.inAgeGroup(
      (Integer) age[0],
      (Integer) age[1]
    );

    Table table = new Table(TABLE_EMPLOYEE, list.asRows());

    this.print(NL);
    table.print(new String[] {
      "ID", "Name", "Age"
    });

    this.print(
      "\nThere are " + list.length +
      " employee(s) in the age range of " + age[0] +
      " to " + age[1] + ".\n"
    );

  }

  /**
   * 7. Highest jobs assigned
   */

  public void showMostDuties () {

    final Title title = new Title("7. Employee with Most Duties Assigned");
    title.print();

    Employee employee = this.employees.withMostDuties();
    this.printEmployeeDetails(employee);
  }

  /**
   * 8. No jobs assigned
   */

  public void showNoDuties () {

    final Title title = new Title("8. Employees with No Duties Assigned");
    title.print();

    Employees list = this.employees.withNoDuties();
    Table table = new Table(TABLE_EMPLOYEE, list.asRows());
    table.print();

    this.print(
      "\nThere are " + list.length +
      " employee(s) with no jobs assigned.\n"
    );

  }


  /**
   * 9. Exit
   */

  private void exit () {

    final Title title = new Title("9. Exit");
    title.print();

    this.write();
    this.print(MESSAGE_THANKS);
    this.waitForUser();
    System.exit(0);
  }

  /**
   * Change employee settings
   */

  private void setEmployee (Employee employee, Object[] answers) {
    employee.setName(   (String)    answers[0] );
    employee.setGender( (Character) answers[1] );
    employee.setAge(    (Integer)   answers[2] );
    employee.setDuties( (Integer)   answers[3] );
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
