
import java.util.Scanner;

public class StudentTester {

  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);
    Student student = new Student();

    System.out.printf("Student ID: ");
    int id = input.nextInt();
    student.setId(id);

    System.out.printf("Student Name: ");
    String name = input.next();
    student.setName(name);

    System.out.printf("Student DOB: ");
    String dob = input.next();
    student.setDOB(dob);

    student.print();

  }
}
