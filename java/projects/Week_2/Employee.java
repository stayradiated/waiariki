
public class Employee {

  // Instance variables
  private String name;
  private char gender;
  private int age;
  private double salary;
  
  /*
   * Constructor
   */

  public Employee () {
    name = "";
    gender = ' ';
    age = 0;
    salary = 0;
  }

  public Employee (String _name, char _gender, int _age, double _salary) {
    name = _name;
    gender = _gender;
    age = _age;
    salary = _salary;
  }


  /*
   * Name
   */

  public void setName (String _name) {
    name = _name;
  }

  public String getName () {
    return name;
  }

  /*
   * Gender
   */

  public void setGender (char _gender) {
    gender = _gender;
  }

  public char getGender () {
    return gender;
  }

  /*
   * Salary
   */

  public void setSalary (double _salary) {
    salary = _salary;
  }

  public double getSalary () {
    return salary;
  }


  /*
   * Age
   */

  public void setAge (int _age) {
    age = _age;
  }

  public int getAge () {
    return age;
  }

  /*
   * Printing
   */

  public void printName () {
    System.out.println(name);
  }

  public void printGender () {
    System.out.println(gender);
  }

  public void printSalary () {
    System.out.println(salary);
  }

  public void printAge () {
    System.out.println(age);
  }

  public void printAll () {
    System.out.println("\n----");
    printName();
    printGender();
    printSalary();
    printAge();
    System.out.println("----\n");
  }

}
