import java.util.Scanner;

public class StudentArray {

  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);
    Student[] students = new Student[5];

    for (int i = 0; i < students.length; i++) {

      System.out.println("==== STUDENT " + i + " ====");

      System.out.print("Student ID: ");
      int id = input.nextInt();

      input.skip("\n");
      System.out.print("Student Name: ");
      String name = input.nextLine();

      System.out.print("Student DOB: ");
      String dob = input.nextLine();

      students[i] = new Student(id, name, dob);

    }

    for (int i = 0; i < students.length; i++) {
      System.out.println("\nStudent " + i);
      System.out.printf(" | %-10s %s\n", "ID:", students[i].getStudentId());
      System.out.printf(" | %-10s %s\n", "Name:", students[i].getName());
      System.out.printf(" | %-10s %s\n", "DOB:", students[i].getDOB());
    }

  }

}
