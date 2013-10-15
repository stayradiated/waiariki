import java.util.ArrayList;
import java.util.Iterator;
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
    int id = nextId++;
    employee.setId(id);
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
    for (Employee employee : this.employees) {
      System.out.println(employee.getId());
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
    for (Employee employee : this.employees) {
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
    Iterator<Employee> it = this.employees.iterator();
    while (it.hasNext()) {
      Employee employee = it.next();
      if (employee.getId() == id) {
        it.remove();
      }
    }
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
    for (Employee employee : this.employees) {
      // Write each employee to the file
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
    int i = 0;
    for (Employee employee : this.employees) {
      rows[i++] = employee.asRow();
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
    string += employee.getDuties() + "\n";
    return string;
  }
  

  /**
   * Convert string into an employee
   * @return Employee
   */

  private Employee parse (String string) {
    String[] parts = string.split(",");
    Employee employee = new Employee();
    employee.setId(     Integer.parseInt(parts[0]) );
    employee.setName(   parts[1]           );
    employee.setGender( parts[2].charAt(0) );
    employee.setAge(    Integer.parseInt(parts[2]) );
    employee.setDuties( Integer.parseInt(parts[2]) );
    return employee;
  }

}
