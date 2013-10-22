/* Program: MessageNewTester.java
 * Author: Don kannangara
 * Purpose: This program tests the MessageNew class by creating an object
 * Date:    March 2013
*/

import java.util.*;   // this package is needed for the Scanner class

public class MessageNewTester
{
  public static void main (String[] args) 
  {
    // Declare an instance of Scanner
    Scanner input = new Scanner (System.in);
    
    // Prompt user and input their name
    MessageNew nameprompt = new MessageNew ();
    nameprompt.setMessage("What is your name?");
    nameprompt.printMessage();
    // This will input the first name only
    String name = input.nextLine();    
    
    // Output greeting with user's name
    MessageNew mine = new MessageNew ();
    mine.setMessage("Hello");
    System.out.println(mine.getMessage() + " " + name + "!");
  }
}
