
import java.util.Scanner;

public class InputChecker {

  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Do you want to continue?");

    String answer = input.next();

    if (answer.equalsIgnoreCase("Y") || answer.equals("yes")) {
      System.out.println("Ok");
    } else if (answer.equalsIgnoreCase("N") || answer.equals("no")) { 
      System.out.println("Terminating");
    }

  }
  
}
