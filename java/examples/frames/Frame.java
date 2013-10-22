
import javax.swing.*;

public class Frame {

  public static void main (String[] args) {
    new Frame("This is pretty neat");
  }

  public Frame (String message) {

    JFrame frame = new JFrame(message);
    JPanel panel = new JPanel();
    JButton button = new JButton("This is a button");

    button.setVisible(true);
    button.setSize(100, 100);

    panel.setVisible(true);
    panel.setSize(400, 300);

    panel.add(button);
    frame.add(panel);

    frame.setSize(400, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.revalidate();
    frame.repaint();
  }

}