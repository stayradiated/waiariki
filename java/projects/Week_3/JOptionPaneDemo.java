
import javax.swing.JOptionPane;

public class JOptionPaneDemo {
  
  public static void main(String[] args) {
    
    int appleCount = 0;
    int orangeCount = 0;

    String appleString = JOptionPane.showInputDialog("Enter number of apples:");

    try {
      appleCount = Integer.parseInt(appleString);
    }
    catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "'" + appleString + "' is not a number!\n");
    }

    String orangeString = JOptionPane.showInputDialog("Enter number of oranges:");

    try {
      orangeCount = Integer.parseInt(orangeString);
    }
    catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "'" + orangeString + "' is not a number!\n");
    }

    int totalFruitCount = appleCount + orangeCount;
    JOptionPane.showMessageDialog(null, "The total number of fruits = " + totalFruitCount);

    System.exit(0);
  
  }

}
