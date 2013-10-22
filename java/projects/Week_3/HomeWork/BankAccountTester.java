/*
 * Class: BankAccountTester.java
 * Author: Don Kannangara
 * Date: 2013
 * Description:  This class tests a bank account class by 
 * creating BankAccount objects and depositing and withdrawing amounts
 * and displaying the balance.
 */
import java.util.*;
public class BankAccountTester
{
  public static void main (String[] args) 
  {

    BankAccount mySavings = new BankAccount();
    BankAccount yourSavings = new BankAccount(200.00);

    mySavings.deposit(100.00);
    mySavings.withdraw(20.00);

    yourSavings.deposit(20.00);
    yourSavings.withdraw(50.00);

    System.out.printf("My balance is %.2f\n", mySavings.getBalance());
    System.out.printf("Your balance is %.2f\n", yourSavings.getBalance());
    
  }
}
