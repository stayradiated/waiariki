
/**
 * class:    Adder
 * author:   George Czabania
 * purpose:  Add numbers together
 * date:     3rd September 3013
 */

import java.util.Scanner;

public class Adder {

  public static void main (String[] args) {

    Scanner in = new Scanner(System.in);

    int n, sum = 0;

    do {
      System.out.print("Enter a number (0 to stop): ");
      n = in.nextInt();
      sum += n;
    } while (n != 0);

    /* for (int i = 1; i <= max; i++) { */
    /*   sum += i; */
    /* } */

    System.out.println(sum);

  }

}
