
class Adder {

  public static int value = 200;

  public Adder () {

  }

  public int add (int amount) {
    return value += amount;
  }

}

public class Test {
  
  public static void main (String [] args) {
    
    Adder num1 = new Adder();
    System.out.println(num1.add(20));

    Adder num2 = new Adder();
    System.out.println(num2.add(20));

    Adder num3 = new Adder();
    System.out.println(num3.add(20));

    System.out.println(Adder.value);

  }

}

