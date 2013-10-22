/**
 * Class: BankAccount.java
 * Author: Don Kannangara
 * Date: Aug 2013
 * Description: This class models a Bank account that has a balance that can be 
 *              changed by deposits and withdrawals and the addition of interest
 */

public class BankAccount {

  private double balance;
  
  // Interest rate is a constant value set at 2.5%
  private static final double INTEREST_RATE = 2.5;
  
  /**
   * Constructs a bank account with a zero balance
   */
  public BankAccount () {
    balance = 0;
  }
  
  /* 
   * Constructs a bank account with a given balance.
   * @param initialBalance - the initial balance
   */
  public BankAccount (double initialBalance) {
    balance = initialBalance;
  }
  
  /*
   * Deposits money into the bank account
   * @param amount - the amount to deposit
   */
  public void deposit (double amount) {
    balance = balance + amount;
  }
  
  /*
   * Withdraws money from the bank account.
   * @param amount - the amount to withdraw
   */
  public void withdraw (double amount) {
    if (balance >= amount) {
      balance = balance - amount;
    } else {
      System.out.println("Error! Withdrawal amount is greater than the balance!");
    }
  }
  
  /*
   * Gets the current balance of the bank account.
   * @return the current balance
   */
  public double getBalance () {
    return balance;
  }
  
  /*
   * Calculates and adds an interest amount to the balance
   */
  public void addInterest() {
    double interestAmount = (INTEREST_RATE/100.0) * balance;
    balance = balance + interestAmount;
  }

  /*
   * Prints information about the account
   */
  public void displayAccount (int accountNumber, String accountName) {
    System.out.printf("%-60s %s\n", "Account Number", accountNumber);
    System.out.printf("%-60s %s\n", "Account Number:", accountName);
    System.out.printf("%-60s %.2f\n", "Balance:", balance);
  }
  
}
