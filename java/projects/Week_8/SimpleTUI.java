
import java.util.Scanner;

public class SimpleTUI {

  private static Scanner input = new Scanner(System.in);

  private static String[] options = {
    "Output 'Hello'",
    "Output your name",
    "Exit"
  };

  public static void main (String[] args) {
    displayMainMenu();
    selectOption();
  }

  public static void displayMainMenu () {
    for (int i = 0; i < options.length; i++) {
      System.out.printf("%s. %s\n", i + 1, options[i]);
    }
  }

  public static void selectOption () {
    int option = 0;
    while (option != 3) {
      System.out.printf("Select option: ");
      option = input.nextInt();
      switch (option) {
        case 1:
          outputHello();
          break;
        case 2:
          outputName();
          break;
        case 3:
          outputGoodbye();
          break;
        default:
          System.out.println("Please choose an option between 1 - 3");
      }
    }
  }

  public static void outputHello () {
    System.out.println("Hello");
  }

  public static void outputName () {
    input.skip("\n");
    System.out.printf("What is your name? ");
    String name = input.nextLine();
    System.out.println("Hello " + name + "!");
  }

  public static void outputGoodbye () {
    System.out.println("Goodbye!");
  }

}
