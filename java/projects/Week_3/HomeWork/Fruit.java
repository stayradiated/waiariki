/*
 * Class: Fruit.java
 * Author: Don Kannagara
 * Date: March 2013
 * Description: This class models a fruit item that has a descripion and price, the class 
 *    contains relevant methods to access and mutate each property of a fruit item.
 */

public class Fruit
{
  // instance variables
  private String description;
  private double price;
  private int quantity;

  public Fruit () {

  }
  
  /*
   * Sets the description of a fruit item
   * @param desc - value for description
   */
  public void setDescription(String desc)
  {
    description = desc;
  }
  
  /*
   * Sets the price of a fruit item
   * @param aPrice - value for price
   */
  public void setPrice(double aPrice)
  {
    price = aPrice;
  }

  /*
   * Sets the quantity of a fruit item
   * @param quant - number of fruit
   */
  public void setQuantity(int quant) {
    quantity = quant;
  }
  
  /*
   * Gets the description of a fruit item
   * @return value of description
   */
  public String getDescription()
  {
    return description;
  }
  
  /*
   * Gets the price of a fruit item
   * @return value of price
   */
  public double getPrice()
  {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  
  /*
   * Outputs/displays the description and price of a fruit item
   */
  public void printDetails()
  {
    System.out.printf("| %-20s | $%-7.2f |\n", description, quantity * price);
  }
  

}
