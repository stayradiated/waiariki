public class Variables {

  public static void main (String[] args) {

    // Ints
    int myHeight;
    myHeight = 178;
    System.out.println("My height is " + myHeight);

    // Chars
    char myGender;
    myGender = 'M';
    System.out.println("My gender is " + myGender);
  
    // Booleans
    boolean myAnswer;
    myAnswer = true;
    System.out.println("My answer is " + myAnswer);

    // Notice how floats need an f
    float myFloat;
    myFloat = 210.3f;
    System.out.println("My float is " + myFloat);

    // Doubles
    double myAge;
    myAge = 19.6;
    System.out.println("My age is " + myAge);

    // Strings
    String myName;
    myName = "George";
    System.out.println("My name is " + myName);

    // Bytes
    byte myByte;
    myByte = 127;
    System.out.println("My byte is " + myByte);

    // You can also assign on the same line
    int myInt = 2103;

    // Some basic maths
    int length = 340;
    int width = 40;
    int area = length * width;
    String prompt = "The area is ";
    System.out.println(prompt + area);

    // A while loop
    int i = 0;
    while (i < 10) {
      System.out.print(i + " "); 
      i++;
    }

  }

}
