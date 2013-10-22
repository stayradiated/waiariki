// Class: InputOutputTester
// Purpose: Not sure yet
// Author: George Czabania
// Date: Aug 20 2013

import java.util.Scanner;

public class InputOutputTester {
  
    public static void main (String[] args) {
      
        String name;
        int age;
        float height;
        float weight;
        double bmi;

        Scanner input = new Scanner(System.in);

        System.out.printf("Please enter your name: ");
        name = input.nextLine();

        System.out.printf("Please enter your age: ");
        age = input.nextInt();

        System.out.printf("Please enter your height: ");
        height = input.nextFloat();

        System.out.printf("Please enter your weight: ");
        weight = input.nextFloat();

        // Calculate bmi
        bmi = weight / Math.pow(height, 2);

        System.out.printf("%-20s %s\n", "Name:", name);
        System.out.printf("%-20s %s\n", "Age:", age);
        System.out.printf("%-20s %.2f\n", "Height:", height);
        System.out.printf("%-20s %.2f\n", "Weight:", weight);
        System.out.printf("%-20s %.2f\n", "Your bmi is:", bmi);

    }

}
