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
   * Private variables
   */

  private final String FILENAME = "employees.txt";
  private final String ERROR = "Error! ";
  private final String ERROR_OPEN = "File %s cannot be opened\n";
  private final String ERROR_READ = "File %s cannot be read\n";

  private ArrayList<Employee> employees;
  private int nextId = 101;
  private final int max = 10;

  /**
   * Public variables
   */

  public int length;


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
    if (id == -1) {
      id = this.nextId++;
      employee.setId(id);
    } else {
      this.nextId = id + 1;
    }
    this.employees.add(employee);
    this.length = this.employees.size();
    return id;
  }


  /**
   * Check if an employee with id exists
   * @param id
   * @return boolean
   */

  public boolean has (int id) {
    Employee employee;
    for (int i = 0; i < this.length; i++) {
      employee = this.employees.get(i);
      if (employee.getId() == id) {
        return true;
      }
    }
    return false;
  }


  /**
   * Get an employee by id
   * @param id
   * @return Employee
   */

  public Employee get (int id) {
    Employee employee;
    for (int i = 0; i < this.length; i++) {
      employee = this.employees.get(i);
      if (employee.getId() == id) {
        return employee;
      }
    }
    throw new IndexOutOfBoundsException();
  }


  /**
   * Get an employee by index
   * @param index
   * @return Employee
   */

  public Employee at (int index) {
    return this.employees.get(index);
  }

  /**
   * Remove an employee from the records
   * @param id
   */

  public void remove (int id) {
    for (int i = 0; i < this.length; i++) {
      if (this.employees.get(i).getId() == id) {
        this.employees.remove(i);
      }
    }
    this.length = this.employees.size();
  }


  /**
   * Retrieve a list of all the Employees in a certain age group
   * @param min - minimum age (inclusive)
   * @param max - maximum age (inclusive)
   * @return new Employees
   */

  public Employees inAgeGroup (int min, int max) {
    Employees list = new Employees();
    Employee employee;
    int age;

    for (int i = 0; i < this.length; i++) {
      employee = this.employees.get(i);
      age = employee.getAge();
      if (age >= min && age <= max) {
        list.add(employee);
      }
    }

    return list;
  }


  /**
   * Get the employee with the most jobs
   */

  public Employee withMostDuties () {
    Employee employee = null;
    int max = 0;
    for (int i = 0; i < this.length; i++) {
      if (this.employees.get(i).getDuties() > max) {
        employee = this.employees.get(i);
        max = employee.getDuties();
      }
    }
    return employee;
  }


  /**
   * Get a list of the employees with no duties
   */

  public Employees withNoDuties () {
    Employees list = new Employees();
    Employee employee;
    int duties;

    for (int i = 0; i < this.length; i++) {
      employee = this.employees.get(i);
      duties = employee.getDuties();
      if (duties == 0) {
        list.add(employee);
      }
    }

    return list;
  }


  /**
   * Write records to disk
   */

  public void write () {
    FileWriter file = null;
    PrintWriter writer = null;

    try {
      file = new FileWriter(FILENAME);
      writer = new PrintWriter(file);
    }
    catch (FileNotFoundException e) {
      this.error(String.format(ERROR_OPEN, FILENAME));
    }
    catch (IOException e) {
      this.error(String.format(ERROR_READ, FILENAME));
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
   * Read records from disk
   */

  public void read () {
    try {
      FileReader file = new FileReader(FILENAME);
      BufferedReader reader = new BufferedReader(file);
      String line = reader.readLine();
      while (line != null) {
        this.add(this.parse(line));
        line = reader.readLine();
      }
    }
    catch (FileNotFoundException e) {
      this.error(String.format(ERROR_OPEN, FILENAME));
    }
    catch (IOException e) {
      this.error(String.format(ERROR_READ, FILENAME));
    }
  }

  /**
   * Check if file exists
   */

  public boolean fileExists () {
    return new File(FILENAME).exists();
  }

  /**
   * Check if records are full
   */

  public boolean isFull () {
    return this.max <= this.length;
  }


  /**
   * Convert records into table row
   */

  public String[][] asRows () {
    String[][] rows = new String[this.length][5];
    for (int i = 0; i < this.length; i++) {
      rows[i] = this.employees.get(i).asRow();
    }
    return rows;
  }


  /**
   * Print error and exit
   */

  private void error (String message) {
    System.out.println(ERROR + message);
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
   * Convert string into an employee
   * @return Employee
   */

  private Employee parse (String string) {
    String[] parts = string.split(",");
    Employee employee = new Employee();

    if (parts.length < 5) {
      throw new UnsupportedOperationException();
    }

    employee.setId(     Integer.parseInt(parts[0]) );
    employee.setName(   parts[1]                   );
    employee.setGender( parts[2].charAt(0)         );
    employee.setAge(    Integer.parseInt(parts[3]) );
    employee.setDuties( Integer.parseInt(parts[4]) );

    return employee;
  }

}
