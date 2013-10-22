/**
 * Class: BmiCalculator.java
 * Author: Don Kannangara
 * Date: Aug 2013
 * Description: This class inputs the name, height and width for a person, then calculates
 *              and displays the body mass index (bmi) value for that person .
 */

import java.util.Scanner;

public class BmiCalculator {

  // Instance variables
  private String name;
  private double height, weight;
  private Scanner in = new Scanner(System.in);
  private String gender;
  
  /*
   * Inputs a value for name
   */
  public void inputName () {
    System.out.print("Name: ");
    name = in.nextLine();
  }
  
  /*
   * Inputs a value for height in metres
   */  
  public void inputHeight () {
    System.out.print("Height (m): ");
    height = in.nextDouble();
  }
  
  /*
   * Inputs a value for weight in kilograms
   */  
  public void inputWeight () {
    System.out.print("Weight (kg): ");
    weight = in.nextDouble();
  }

  /*
   * Inputs a value for gender
   */
  public void inputGender () {
    System.out.print("Gender (male/female): ");
    gender = in.next();
  }

  /*
   * Returns the value of gender
   */
  public String getGender () {
    return gender;
  }
  
  /*
   * Outputs the name, height and weight for a person
   */
  public void outputValues () {
    // output values
    System.out.printf("%-20s %-20s\n", "Name:", name);
    System.out.printf("%-20s %-20.2f\n", "Weight:", weight);
    System.out.printf("%-20s %-20.2f\n", "Height:", height);
    System.out.printf("%-20s %-20s\n", "Gender:", gender);
  }
  
  /*
   * Calculate the body mass index of a person using the formula
   * weight /(height * height)
   * @return bmi calculated body mass index
   */
  public double calculateBMI()
  {
    double bmi = 0;
    if (weight <= 0 || height <= 0) {
      System.out.println("Error: weight and height must be above 0");
    } else {
      bmi = weight/(height * height);
    }
    return bmi;
  }
  
}
