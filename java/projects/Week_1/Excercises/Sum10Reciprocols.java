public class Sum10Reciprocols {
  public static void main (String[] args) {

    int max = 10;

    float sum = 0;
    int i = 0;

    while (++i <= max) {
      sum += (float) 1 / i;
    };

    System.out.println(sum);
  }
}
