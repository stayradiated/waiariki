/*
 * Class: Average.java
 * Author: 
 * Date: 2013
 * Description: This class contains methods that will calculate and output the average
 *    of two numbers
 */

public class Average
{
  private double average;
  
  /*
   * Calculates the average of two numbers
   * @param firstnum - the first number
   * @param secondnum - the second number
   */
  public void calculateAv(double firstnum, double secondnum)
  {
    average = (firstnum + secondnum)/2.0;
  }
  
  /*
   * Outputs the value of average
   */
  public void outputAv()
  {
    System.out.println("Average is " + average);
    System.out.printf("Average is %-5.2f" , average);
  }
}
