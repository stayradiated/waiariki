/**
 * Class: BmiCalculatorTester.java
 * Date: March 2013
 * Description: This class test the BmiCalculator class by invoking it methods to input the
 *   name, weight, height and gender from the user, then calculating the bmi and displaying
 *   whether the person's bmi is high or normal.
 */

import java.util.*;

public class BmiCalculatorTester {

  private Scanner in = new Scanner(System.in);

  public static void main (String [] args) {
    new BmiCalculatorTester();
  }

  public BmiCalculatorTester () {
    String runAgain;
    do {
      System.out.println();
      getDetails();
      System.out.print("\nWould you like to enter another set of data: (y/n) ");
      runAgain = in.next();
    } while (runAgain.equals("y"));
    System.out.println("\nThank you for using the BMI calculator.");
  }

  private void getDetails () {

    BmiCalculator b = new BmiCalculator();

    // Input name, weight, height and gender
    b.inputName();
    b.inputWeight();
    b.inputHeight();
    b.inputGender();

    // note this gender variable is different from the instance variable
    // also called gender.  This is a local variable only known in this
    // main method
    String gender = b.getGender();

    b.outputValues();

    double bmi = b.calculateBMI();
    System.out.printf("\nYour bmi is %-10.2f\n", b.calculateBMI());

    if ((gender.equals("male") && bmi > 27.8) || (gender.equals("female") && bmi > 27.3)) {
      System.out.printf("Warning!  Your bmi is high for a %s\n", gender);
    } else {
      System.out.printf("Your bmi is normal for a %s\n", gender);
    }

  }
}
