public class Sum {

  public static void main (String[] args) {
  
    int[] numbers = {4, 8, 12, 16, 2};
    int sum = 0;

    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
    }

    System.out.println("The sum is " + sum);

  }

}
