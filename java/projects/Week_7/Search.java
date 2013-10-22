public class Search {

  public static void main (String[] args) {


    int[] numbers = {4, 18, 12, 16, 2};
    boolean found = false;
    int searchVal = 12;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == searchVal) {
        found = true;
        System.out.println("Found " + searchVal);
        break;
      }
    }

    if (!found) {
      System.out.println("Could not find " + searchVal);
    }

  }

}
