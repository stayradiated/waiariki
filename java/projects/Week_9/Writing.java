import java.io.*;

public class Writing {

  public static void main (String[] args) {

    PrintWriter output = null;
    String filename = "/home/stayrad/text.txt";

    try {
      output = new PrintWriter(new FileWriter(filename, true));
    }
    
    catch (FileNotFoundException e) {
      System.out.println("Error: " + e); 
      System.exit(0);
    }

    catch (IOException e) {
      System.out.println("Error: " + filename);
      System.exit(0);
    }

    System.out.println("Writing to file: " + filename);

    output.println("1234567");
    output.println("Joe Bloggs");
    output.println("Intro Prog");
    output.println("A+");

    output.close();

    System.out.println("Finished writing file");

  }

}
