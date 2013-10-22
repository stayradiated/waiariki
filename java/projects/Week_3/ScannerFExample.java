import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerFExample {
  public static void main(String[] args) {

    Scanner scObj = new Scanner(System.in);

    System.out.print("Please input your name: ");
    String name = scObj.nextLine();

    System.out.print("Please input your age: ");
    int age = scObj.nextInt();

    System.out.print("Please input your salary: ");
    double salary = scObj.nextDouble();

    // String is just an array of chars
    // So we can use string.charAt(int index) to get the first char
    System.out.print("Please input your gender (M or F): ");
    char gender = scObj.next().charAt(0);

    System.out.printf("%10s: %s\n", "name", name);
    System.out.printf("%10s: %d\n", "age", age);
    System.out.printf("%10s: $%.2f\n", "salary", salary);
    System.out.printf("%10s: %c\n", "gender", gender);

  }
}
