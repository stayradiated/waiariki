public class DrawName {

  public static void main (String[] args) {

    String name = "My name is George";

    String block = "+";
    int i = name.length() + 2;

    while (i-- > 0) {
      block += "-";
    }

    block += "+";

    System.out.println(block);
    System.out.println("| " + name + " |");
    System.out.println(block);

  }

}
