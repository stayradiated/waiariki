public class PrintFExample {
  public static void main(String [] args) {

    /**
     * %d digit
     * %f float
     * %s string
     * %c char
     * /n new line
     * /t tab
     */

    // Property keys
    String line1 = "Surname";
    String line2 = "Age";
    String line3 = "Salary";
    String line4 = "Address";

    // Property values 
    String value1 = "Brown";
    int value2 = 50;
    double value3 = 41000.45;
    String value4 = "121, Old Taupo Road, Rotorua 3015";

    System.out.println("\n--- Print Line ---\n");

    // Print using println
    System.out.println(line1 + value1);
    System.out.println(line2 + value2);
    System.out.println(line3 + value3);
    System.out.println(line4 + value3);

    System.out.println("\n--- Print Formatted ---\n");

    // Print using printf
    System.out.printf("%10s: %s\n", line1, value1);
    System.out.printf("%10s: %d\n", line2, value2);
    System.out.printf("%10s: %.2f\n", line3, value3);
    System.out.printf("%10s: %s\n", line4, value4);

    System.out.println("\n--- Multiple Values --\n");

    // Using multiple values
    System.out.printf("My fried %s is %d years old\n", "Fred", 21);

    System.out.println("\n");

  }
}
