
import java.util.Scanner;

public class OddEvens {

  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter a number: ");

    int number = input.nextInt();

    String message;

    if (number % 2 == 0) {
      message = "Even";
    } else {
      message = "Odd";
    }

    System.out.println(message);


  }

}
