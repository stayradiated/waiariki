
import javax.swing.JOptionPane;

public class BankAccountTester {
  public static void main(String[] args) {

    BankAccount savings = new BankAccount();
    double amount;

    amount = Double.parseDouble(JOptionPane.showInputDialog("How much do you want to deposit?"));
    savings.deposit(amount);
    System.out.printf("%-20s $%.2f\n", "Deposit Amount:", amount);
    System.out.printf("%-20s $%.2f\n\n", "Balance:", savings.getBalance());

    amount = Double.parseDouble(JOptionPane.showInputDialog("How much do you want to deposit?"));
    savings.deposit(amount);
    System.out.printf("%-20s $%.2f\n", "Deposit Amount:", amount);
    System.out.printf("%-20s $%.2f\n\n", "Balance:", savings.getBalance());

    amount = Double.parseDouble(JOptionPane.showInputDialog("How much do you want to withdraw?"));
    savings.withdraw(amount);
    System.out.printf("%-20s $%.2f\n", "Withdrawl Amount:", amount);
    System.out.printf("%-20s $%.2f\n\n", "Balance:", savings.getBalance());
  }
}
