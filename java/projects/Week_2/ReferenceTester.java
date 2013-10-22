public class ReferenceTester {
  
  public static void main (String[] args) {

    // Array of strings
    String[] test = { "hello ", "world" };
    System.out.println(test[0] + test[1]);

    // Variables
    String local;

    // Create instance
    Reference ref = new Reference();

    // Set string
    ref.set("string 1");

    // Get string back
    local = ref.get();
    System.out.println(local);

    // Set string again
    ref.set("string 2");
    System.out.println(local);
    System.out.println(ref.get());
    
    // Modifying public variables on the instance
    ref.val = 200;
    System.out.println(ref.val);

    ref.setData("some string");
    System.out.println(ref.data());
  }

}
