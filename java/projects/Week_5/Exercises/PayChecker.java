
import java.util.Scanner;

public class PayChecker {

  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Name: ");
    String name = input.nextLine();

    System.out.print("Wage: ");
    float wage = input.nextFloat();
    float overtimeWage = wage * 1.5f;

    System.out.print("Number of hours (per week): ");
    int hours = input.nextInt();

    int overtime = 0;
    if (hours > 40) {
      overtime = hours - 40;
      hours = 40;
    }

    float pay = wage * hours;
    float overtimePay = overtimeWage * overtime;


    System.out.println("----------------------------------------------------");
    System.out.printf("Pay: %s\n", pay);
    System.out.printf("Overtime pay: %s\n", overtimePay);

  }

}
