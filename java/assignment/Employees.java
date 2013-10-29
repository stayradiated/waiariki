/**
 * class: Employees
 * purpose: Handle a collection of employees, including methods to save and load the collection using a text file.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Employees {

  /**
   * Instance variables
   */

  private int nextId = 101;
  private int length;
  private ArrayList<Employee> employees;

  /**
   * Constants
   */

  public  final int max = 10;

  private final String SAVEFILE   = "employees.txt";
  private final String ERROR_OPEN = "File %s cannot be opened.\n";
  private final String ERROR_READ = "File %s cannot be read.\n";


  /**
   * Default constructor
   */

  public Employees () {
    this.length = 0;
    this.employees = new ArrayList<Employee>();
  }


  /**
   * Add employee to the records
   * @param employee
   * @return id
   */

  public int add (Employee employee) {
    int id = employee.getId();

    // Assign the employee a new ID if they haven't already got one
    if (id == -1) {
      id = this.nextId++;
      employee.setId(id);
    } else {
      // If the employee does have an ID, set the nextId to be just after it
      this.nextId = id + 1;
    }

    // Add the employee to the array
    this.employees.add(employee);
    this.length = this.employees.size();

    // Return the employees id
    return id;
  }


  /**
   * Get an employee by their index in the array
   * @param index
   * @return Employee
   */

  public Employee at (int index) {
    // Use the ArrayList methods to locate the employee
    return this.employees.get(index);
  }


  /**
   * Get the index of the employee in the array
   * @param id - the id of the employee
   * @return int - the index of the employee in the array
   */

  public int indexOf (int id) {

    // Loop through the array
    for (int i = 0; i < this.length; i++) {

      // Check the employee id
      if (this.at(i).getId() == id) {

        // Return the current index
        return i;
      }
    }

    // If we can't find the employee, return -1
    return -1;
  }


  /**
   * Check if an employee with id exists
   * @param id - the employee id
   * @return boolean - if the employee exists in the array
   */

  public boolean has (int id) {
    int index = this.indexOf(id);
    return index > -1;
  }


  /**
   * Get an employee by id
   * @param id
   * @return Employee
   */

  public Employee get (int id) {
    int index = this.indexOf(id);

    if (index > -1) {
      return this.at(index);
    } else {
      throw new IndexOutOfBoundsException();
    }

  }


  /**
   * Remove an employee from the records
   * @param id
   */

  public void remove (int id) {

    int index = this.indexOf(id);

    if (index > -1) {

      // Remove the employee
      this.employees.remove(index);

      // Update the length
      this.length = this.employees.size();

    }

  }


  /**
   * Retrieve a list of all the Employees in a certain age group
   * @param min - minimum age (inclusive)
   * @param max - maximum age (inclusive)
   * @return Employees - a new Employees instance
   */

  public Employees inAgeGroup (int min, int max) {
    Employees list = new Employees();
    Employee employee;
    int age;

    // Loop through each employee
    for (int i = 0; i < this.length; i++) {

      // Check the employees age
      employee = this.employees.get(i);
      age = employee.getAge();
      if (age >= min && age <= max) {

        // Add them to the new Employees collection
        list.add(employee);
      }
    }

    return list;
  }


  /**
   * Get the employee with the most jobs
   * @return Employees - a new Employees instance
   */

  public Employees withMostDuties () {
    Employees mostDuties = new Employees();
    int max = 0;

    // Loop through each employee
    for (int i = 0; i < this.length; i++) {

      // Check if they have more duties
      if (this.employees.get(i).getDuties() > max) {

        // Update the max duties variable
        max = this.employees.get(i).getDuties();

      }

    }

    // Loop through each employee
    for (int i = 0; i < this.length; i++) {

      // Check if they have the max duties
      if (this.employees.get(i).getDuties() == max) {

        // Add them to the mostDuties array
        mostDuties.add(this.employees.get(i));

      }

    }

    return mostDuties;
  }


  /**
   * Get a list of the employees with no duties
   * @return Employees - a new Employees instance
   */

  public Employees withNoDuties () {
    Employees list = new Employees();
    Employee employee;
    int duties;

    // Loop through each employee
    for (int i = 0; i < this.length; i++) {

      // Check if the duties are 0
      employee = this.employees.get(i);
      duties = employee.getDuties();
      if (duties == 0) {

        // Add them to the new Employee instance
        list.add(employee);
      }
    }

    return list;
  }


  /**
   * Write all the employee records to disk
   */

  public void write () {
    FileWriter file = null;
    PrintWriter writer = null;

    try {
      file = new FileWriter(SAVEFILE);
      writer = new PrintWriter(file);
    }
    catch (FileNotFoundException e) {
      this.error(String.format(ERROR_OPEN, SAVEFILE));
    }
    catch (IOException e) {
      this.error(String.format(ERROR_READ, SAVEFILE));
    }

    // Loop through the ArrayList of employees
    Employee employee;
    for (int i = 0; i < this.length; i++) {
      // Write each employee to the file
      employee = this.employees.get(i);
      writer.println(this.stringify(employee));
    }

    writer.close();
  }


  /**
   * Read the employee records from disk
   */

  public void read () {
    try {
      FileReader file = new FileReader(SAVEFILE);
      BufferedReader reader = new BufferedReader(file);
      String line = reader.readLine();
      while (line != null) {
        // Parse each line of the file
        this.add(this.parse(line));
        line = reader.readLine();
      }
    }
    catch (FileNotFoundException e) {
      this.error(String.format(ERROR_OPEN, SAVEFILE));
    }
    catch (IOException e) {
      this.error(String.format(ERROR_READ, SAVEFILE));
    }
  }


  /**
   * Check if the save file exists
   * @return boolean
   */

  public boolean fileExists () {
    return new File(SAVEFILE).exists();
  }


  /**
   * Check if records are full
   * @return boolean
   */

  public boolean isFull () {
    return this.max <= this.length;
  }


  /**
   * Get the amount of employees.
   * @return this.length
   */

  public int getLength () {
    return this.length;
  }


  /**
   * Convert records into an array of arrays of Strings
   * @return String[][] - the employees
   */

  public String[][] serialize () {
    String[][] rows = new String[this.length][5];
    for (int i = 0; i < this.length; i++) {
      rows[i] = this.employees.get(i).serialize();
    }
    return rows;
  }


  /**
   * Print error and exit
   * @param message - error message
   */

  private void error (String message) {
    System.out.println("Fatal error: " + message);
    System.exit(0);
  }


  /**
   * Convert employee into string
   * @return string
   */

  private String stringify (Employee employee) {
    String string = "";
    string += employee.getId()     + ",";
    string += employee.getName()   + ",";
    string += employee.getGender() + ",";
    string += employee.getAge()    + ",";
    string += employee.getDuties();
    return string;
  }


  /**
   * Convert a string into an employee
   * @param  string - an employee string made using this.stringify()
   * @return Employee
   */

  private Employee parse (String string) {
    String[] parts = string.split(",");
    Employee employee = new Employee();

    // A single employee requires 5 attributes
    if (parts.length < 5) {
      throw new UnsupportedOperationException();
    }

    // Convert the Strings into the correct type
    employee.setId(     Integer.parseInt(parts[0]) );
    employee.setName(   parts[1]                   );
    employee.setGender( parts[2].charAt(0)         );
    employee.setAge(    Integer.parseInt(parts[3]) );
    employee.setDuties( Integer.parseInt(parts[4]) );

    return employee;
  }

}
