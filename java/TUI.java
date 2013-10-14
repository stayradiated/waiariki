/**
 * The Textual User Interface (TUI) handles the input and output of the system.
 * This includes displaying menus, and lists as well as listening to user input.
 */

import java.util.Scanner;

public class TUI {

  private Scanner scanner;
  private Employees employees;

  private final String MESSAGE_WELCOME = "Welcome to the ABC Company Employee System\n\n";
  private final String MESSAGE_NUMBER = "Number of employees in system: ";
  private final String MESSAGE_PROMPT = "Select Option: ";
  private final String NL = "\n";

  public static void main (String[] args) {
    new TUI();
  }

  private TUI () {
    this.scanner = new Scanner(System.in);
    this.employees = new Employees();
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

    int selection = this.readInt();

    switch (selection) {
      case 1: // Add employee
        Employee employee = new Employee();

        Questions questions = new Questions(new Question[] {
          new Question("Enter name:", "String"),
          new Question("Enter gender (m/f):", "char"),
          new Question("Enter age in years:", "int"),
          new Question("Number of jobs assigned:", "int"),
        }, this.scanner);

        questions.ask();

        break;

      case 2: // Delete an employee
        break;

    }

  }

  private void numberOfEmployees () {
    this.print(MESSAGE_NUMBER + employees.length + NL);
  }

  private int readInt () {
    this.print(MESSAGE_PROMPT);
    System.out.flush();
    while (! this.scanner.hasNextInt()) {
      this.scanner.nextLine();
      this.print(MESSAGE_PROMPT);
      System.out.flush();
    }
    int option = this.scanner.nextInt();
    return option;
  }

  private void print (String string) {
    System.out.print(string);
  }


}