// Class:    CityTester
// Purpose:  Testing the City class
// Author:   George Czabania
// Date:     Aug 20 2013

import java.util.Scanner;
import javax.swing.JOptionPane;

public class CityTester {

  public static void main (String[] args) {

    Scanner scanner = new Scanner(System.in);

    City[] cities = {
      new City("London",    "United Kingdom",  60.6545f),
      new City("Paris",     "France",          45.721f),
      new City("Auckland",  "New Zealand",     1.6010f),
      new City("Brisbane",  "Australia",       4.8234f)
    };

    // user created city
    City user = new City(); 
    user.setName(JOptionPane.showInputDialog("Name of city:"));
    user.setCountry(JOptionPane.showInputDialog("Name of country:"));
    user.setPopulation(Float.parseFloat(JOptionPane.showInputDialog("Name of population:")));

    // Print default cities
    for (int i = 0; i < cities.length; i++) {
      cities[i].print();
    }

    // Print user city
    user.print();

    System.out.printf("\nThe first city is %s, %s\n", cities[0].getName(), cities[0].getCountry());

  }

}
