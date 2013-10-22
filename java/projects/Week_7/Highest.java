public class Highest {

  public static void main (String[] args) {

    int[] numbers = {4, 8, 12, 16, 2};
    int highest = numbers[0];

    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > highest) {
        highest = numbers[i];
      }
    }

    System.out.println("The highest number is " + highest);

  }

}
