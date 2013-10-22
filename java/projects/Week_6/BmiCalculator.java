/**
 * Class: BmiCalculator.java
 * Author: 
 * Date: March 2013
 * Description: This class inputs the name, height and width for a person, then calculates
 *              and displays the body mass index (bmi) value for that person .
 */

import java.util.*;

public class BmiCalculator
{
  private String name;
  private double height, weight;
  String gender;
  private Scanner in = new Scanner(System.in);
  
  /*
   * Inputs a value for name
   */
  public void inputName ()
  {
    do {
      System.out.print("Name: ");
      name = in.nextLine();
    } while (name.equals(""));
  }
  
  /*
   * Inputs a value for height in metres
   */  
  public void inputHeight()
  {
    do {
      System.out.print("Height (m): ");
      height = in.nextDouble();
    } while (height < 0.5 || height > 2.5);
  }
  
  /*
   * Inputs a value for weight in kilograms
   */  
  public void inputWeight()
  {
    do {
      System.out.print("Weight (kg): ");
      weight = in.nextDouble();
    } while (weight < 10 || weight > 200);
  }
  
  /*
   * Inputs a value for weight in kilograms
   */  
  public void inputGender()
  {
    do {
      System.out.print("Gender (male/ female): ");
      gender = in.next();
    } while (!gender.equals("male") && !gender.equals("female"));
  }

  /*
   * Accessor method for gender variable
   * @return gender for this object
   */  
  public String getGender ()
  {
    return gender;
  }
  
  /*
   * Outputs the name, height and weight for a person
   */
  public void outputValues()
  {
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
    double bmi = weight/(height * height);
    return bmi;
  }
  
}
