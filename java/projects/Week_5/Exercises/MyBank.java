
import java.util.Scanner;

public class MyBank {
  
  public static void main (String[] args) {

    Scanner input = new Scanner(System.in);

    BankAccount account1 = new BankAccount(1000.00);
    AccountHolder accountHolder1 = new AccountHolder(1235, "Fred Jones", account1);
    account1.displayAccount(accountHolder1.getNumber(), accountHolder1.getName());

    System.out.println();

    System.out.println("Account Name: ");
    String name = input.nextLine();

    System.out.println("Account Balance: ");
    double balance = input.nextDouble();

    System.out.println("Account Number: ");
    int number = input.nextInt();

    System.out.println();

    BankAccount account2 = new BankAccount(balance);
    AccountHolder accountHolder2 = new AccountHolder(number, name, account2);
    account2.displayAccount(accountHolder2.getNumber(), accountHolder2.getName());

    account2.deposit(20.00);

    System.out.println();
    account2.displayAccount(accountHolder2.getNumber(), accountHolder2.getName());

  }

}
