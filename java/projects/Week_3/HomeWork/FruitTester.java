/*
 * Class: FruitTester.java
 * Author: Don kannangara
 * Date: March 2013
 * Description: This class tests out the methods of the Fruit class
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class FruitTester {

  public static void main(String[] args) {  

    // Store total price of fruit
    double totalPrice = 0;

    // Array of fruit descriptions
    String [] descriptions = {
      "Granny Smith Apples",
      "NZ Oranges",
      "Kiwifruit"
    };

    // Array of fruits
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    // Point to a single fruit
    Fruit fruit;

    // Add fruits
    for (int i = 0; i < descriptions.length; i++) {
      fruit = new Fruit();
      fruit.setDescription(descriptions[i]);
      fruits.add(fruit);
    }

    // input price of fruit
    for (int i = 0; i < fruits.size(); i++) {
      fruit = fruits.get(i);
      String _price = JOptionPane.showInputDialog("How much are " + fruit.getDescription());
      int price = Integer.parseInt(_price);
      fruit.setPrice(price);
    }

    // input quantity of fruit
    for (int i = 0; i < fruits.size(); i++) {
      fruit = fruits.get(i);
      String _quantity = JOptionPane.showInputDialog("How many " + fruit.getDescription() + " do you want?");
      int quantity = Integer.parseInt(_quantity);
      fruit.setQuantity(quantity);
    }

    // Output report heading
    System.out.println("+----------------------+----------+");
    System.out.println("| Description          | Price    |");
    System.out.println("+----------------------+----------+");

    // input quantity of fruit
    for (int i = 0; i < fruits.size(); i++) {
      fruit = fruits.get(i);
      fruit.printDetails();
      totalPrice += fruit.getPrice() * fruit.getQuantity();
    }

    System.out.println("+----------------------+----------+");
    System.out.printf("|                Total | $%-7.2f |\n", totalPrice);
    System.out.println("+----------------------+----------+");

    System.exit(0);

  }

}
