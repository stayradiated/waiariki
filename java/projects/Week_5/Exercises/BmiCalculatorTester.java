
public class BmiCalculatorTester {

  public static void main (String[] args) {

    // Create new instance of the BmiCalculator
    BmiCalculator calc = new BmiCalculator();

    // Get information
    calc.inputName();
    calc.inputWeight();
    calc.inputHeight();
    calc.inputGender();

    // Display information
    System.out.println();
    calc.outputValues();
    System.out.println();

    // Calculate BMI
    double bmi = calc.calculateBMI();
    System.out.printf("Your body mass index (bmi) is %.2f\n", bmi);
    System.out.println();

    String gender = calc.getGender();
    if ((gender.equals("male") && bmi > 27.8) || (gender.equals("female") && bmi > 27.3)) {
      System.out.println("Warning! Your bmi is high for a " + gender + "!");
    } else {
      System.out.println("Your bmi is normal for a " + gender);
    }

  }

}
