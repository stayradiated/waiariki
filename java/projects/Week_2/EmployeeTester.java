
// require Employee

public class EmployeeTester {
  
  public static void main (String[] args) {

    // Create employees
    Employee peter =   new Employee("Peter",   'M', 30, 45000.90);
    Employee richard = new Employee("Richard", 'M', 40, 60345.40);
    Employee sarah =   new Employee("Sarah",   'F', 20, 67900.00);

    // Create an array of employees
    Employee[] employees = { peter, richard, sarah };

    // Loop through employees and print their details
    for (int i = 0; i < employees.length; i++){
      employees[i].printAll();
    }

  }

}
