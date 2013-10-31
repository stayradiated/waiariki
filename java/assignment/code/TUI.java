/**
 * class: TUI
 * purpose: The Textual User Interface (TUI) handles the input and output of the system.  This includes displaying menus, and lists as well as listening to user input.
 */

import java.util.Scanner;

public class TUI {

  /**
   * Private variables
   */

  private Scanner   scanner;
  private Employees employees;


  /**
   * Constants
   */

  private final String NL = "\n";

  private final TableColumn[] TABLE_EMPLOYEE = {
    new TableColumn("ID"             , 3),
    new TableColumn("Name"           , 20),
    new TableColumn("Gender"         , 6),
    new TableColumn("Age"            , 3),
    new TableColumn("Number of Jobs" , 20)
  };

  private final Question[] QUESTION_EMPLOYEE = new Question[] {
    new Question("Enter name:"              , "String"),
    new Question("Enter gender (m/f):"      , "gender"),
    new Question("Enter age in years:"      , "age"),
    new Question("Number of jobs assigned:" , "int"),
  };


  /**
   * Default constructor
   */

  public TUI () {
    this.scanner = new Scanner(System.in);
    this.employees = new Employees();
    if (this.employees.fileExists()) {
      this.employees.read();
    }
    this.menu();
  }

  /**
   * Display the main menu
   */

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

    this.print("\nWelcome to the ABC Company Employee System\n\n");
    this.numberOfEmployees();
    table.print();

    final Question prompt = new Question("Select Option: ", "int");
    int selection = (Integer) prompt.ask(this.scanner);

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
      this.print("\nThe maximum amount of employees has been reached.\n");
      return;
    }

    Employee employee = new Employee();

    Questions questions = new Questions(QUESTION_EMPLOYEE);
    Object[] answers = questions.ask(this.scanner);
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

    final Question qId = new Question("Enter Employee ID: ", "int");
    int id = (Integer) qId.ask(this.scanner);

    if (this.employees.has(id) == false) {
      this.print("Could not find employee " + id + NL);
      return;
    }

    Employee employee = this.employees.get(id);
    this.printEmployeeDetails(employee);

    final Question qConfirm = new Question("Are you sure you want to delete this record? (y/N)", "yesno");
    boolean confirm = (Boolean) qConfirm.ask(this.scanner);

    if (confirm == true) {
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

    final Question qId = new Question("Enter Employee ID: ", "int");
    int id = (Integer) qId.ask(this.scanner);

    // Check employee ID exists
    if (!this.employees.has(id)) {
      this.print("Error - invalid ID" + NL);
      return;
    }

    // Get employee to be modified
    Employee employee = this.employees.get(id);

    // Print current details
    this.print(NL);
    this.printEmployeeDetails(employee);

    // Ask questions
    Questions questions = new Questions(QUESTION_EMPLOYEE);
    Object[] answers = questions.ask(this.scanner);

    // Confirm changes
    Question confirm = new Question(
      NL + "Are you sure you want to modify this record? (Y/n)",
      "yesno"
    );

    boolean confirmAnswer = (Boolean) confirm.ask(this.scanner);

    if (confirmAnswer == false) {
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

    Table table = new Table(TABLE_EMPLOYEE, this.employees.serialize());
    table.print();
    this.numberOfEmployees();
  }

  /**
   * 5. View single employee details
   */

  private void listSingle () {

    final Title title = new Title("5. Details for a Single Employee");
    title.print();

    final Question qId = new Question("Enter ID: ", "int");
    int id = (Integer) qId.ask(this.scanner);

    if (this.employees.has(id)) {
      this.printEmployeeDetails(this.employees.get(id));
    } else {
      this.print("Could not find an employee with that ID." + NL + NL);
    }

    Question question = new Question("Would you like to view another employee? (Y/n): ", "yesno");
    boolean answer = (Boolean) question.ask(this.scanner);

    // Keep running until the user enters 'n' to stop
    if (answer) {
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
    });

    Object[] age = questions.ask(this.scanner);

    Employees list = this.employees.inAgeGroup(
      (Integer) age[0],
      (Integer) age[1]
    );

    Table table = new Table(TABLE_EMPLOYEE, list.serialize());

    this.print(NL);
    table.print(new String[] {
      "ID", "Name", "Age"
    });

    this.print(
      "\nThere are " + list.getLength() +
      " employee(s) in the age range of " + age[0] +
      " to " + age[1] + ".\n"
    );

  }

  /**
   * 7. Highest jobs assigned
   */

  public void showMostDuties () {

    final Title title = new Title("7. Employee(s) with Most Jobs Assigned");
    title.print();

    Employees employees = this.employees.withMostDuties();
    Table table = new Table(TABLE_EMPLOYEE, employees.serialize());
    table.print();

  }

  /**
   * 8. No jobs assigned
   */

  public void showNoDuties () {

    final Title title = new Title("8. Employees with No Jobs Assigned");
    title.print();

    Employees list = this.employees.withNoDuties();
    Table table = new Table(TABLE_EMPLOYEE, list.serialize());
    table.print();

    this.print(
      "\nThere are " + list.getLength() +
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
    this.print("Thank you for using the ABC Company Employee System\n");
    this.waitForUser();
    System.exit(0);
  }


  /**
   * Change employee settings after the questions have been asked
   * @param employee - the employee instance
   * @param answers - the answers from the questions
   */

  private void setEmployee (Employee employee, Object[] answers) {
    employee.setName(   (String)    answers[0] );
    employee.setGender( (Character) answers[1] );
    employee.setAge(    (Integer)   answers[2] );
    employee.setDuties( (Integer)   answers[3] );
  }

  /**
   * Write the employee records to the text file
   */

  private void write () {
    this.employees.write();
    this.print(
      "Number of employee records written to employees.txt file: " +
      this.employees.getLength() + NL + NL);
  }


  /**
   * Print the number of employees in the system
   */

  private void numberOfEmployees () {
    this.print(
      "Number of employees in system: " +
      + employees.getLength() + NL + NL);
  }


  /**
   * Print the employee details
   * @param employee
   */

  private void printEmployeeDetails (Employee employee) {
    String[][] rows = {
      employee.serialize()
    };
    Table table = new Table(TABLE_EMPLOYEE, rows);
    table.print();
  }


  /**
   * Wait for the user to press enter
   */

  private void waitForUser () {
    this.print("\nPress ENTER to continue...\n");
    this.scanner.skip(NL);
    this.scanner.nextLine();
  }


  /**
   * Print text to the screen
   * @param String - text to print
   */

  private void print (String string) {
    System.out.print(string);
  }


}
