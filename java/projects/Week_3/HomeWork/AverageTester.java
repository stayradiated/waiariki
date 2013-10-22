/*
 * Class: AverageTester.java
 * Author: 
 * Date: 2013
 * Description: This class tests the methods of the Average class
 */

import java.util.*;

public class AverageTester
{
  public static void main (String[] args)
  {
     double num1, num2;
     Average av = new Average();
     
     // Create a scanner to read from keyboard
     Scanner input = new Scanner (System.in);
    
     // Input numbers
     System.out.println("Enter first number:");
     num1 = input.nextDouble();
     System.out.println("Enter first number:");
     num2 = input.nextDouble();
     
     av.calculateAv(num1, num2);
     // output value of average
     av.outputAv();
     
  }
}