/* Program: MoveTester.java
 * Author: Don kannangara
 * Purpose: This program demonstrates a basic object-oriented program that 
 *          creates a rectangle object and moves it.
 * Date:    March 2013
*/


import java.awt.Rectangle;

public class MoveTester
{ 
  public static  void main (String [] args)
  {
    //                            x,  y,  w,  h
    Rectangle box = new Rectangle(5, 10, 20, 30);
    box.translate(15, 25);
    System.out.println(box.getX());  
    System.out.println(box.getY());
  }
}

