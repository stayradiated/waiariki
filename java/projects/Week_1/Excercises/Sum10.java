public class Sum10 {
  public static void main (String[] args) {

    int max = 10;

    int sum = 0;
    int i = 0;

    while (++i <= max) {
      sum += i;
    };

    System.out.println(sum);
  }
}
