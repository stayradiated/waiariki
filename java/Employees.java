import java.util.ArrayList;
import java.io.*;

public class Employees {

  private final String FILENAME = "employees.txt";
  private final String ERROR = "Error! ";
  private final String ERROR_OPEN = "File %s cannot be opened\n";
  private final String ERROR_READ = "File %s cannot be read\n";

  private ArrayList<Employee> employees;
  private int nextId = 101;
  public int length;
  public final int max = 10;

  public Employees () {
    this.length = 0;
    this.employees = new ArrayList<Employee>();
  }

  public void add (Employee employee) {
    employee.setId(nextId++);
    this.employees.add(employee);
    this.length = this.employees.size();
  }

  public boolean write () {
    FileWriter file = null;
    PrintWriter writer = null;
    try {
      file = new FileWriter(FILENAME);
      writer = new PrintWriter(file);
    }
    catch (FileNotFoundException e) {
      this.error(String.format(ERROR_OPEN, FILENAME));
      return false;
    }
    catch (IOException e) {
      this.error(ERROR_READ);
      return false;
    }
    return true;
  }

  public boolean read () {
    return false;
  }

  private void error (String message) {
    System.out.println(ERROR + message);
  }

}