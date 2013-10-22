
public class BankAccountTester {
  
  public static void main (String[] args) {
    
    BankAccount myAccount = new BankAccount(10);
    System.out.printf("%-60s%7.2f\n", "Opening balance", myAccount.getBalance());

    myAccount.deposit(129.30);
    System.out.printf("%-60s%7.2f\n", "Balance after deposit:", myAccount.getBalance());

    myAccount.withdraw(142.50);
    myAccount.withdraw(20.30);
    System.out.printf("%-60s%7.2f\n", "Balance after withdraw:", myAccount.getBalance());

    myAccount.addInterest();
    System.out.printf("%-60s%7.2f\n", "Balance after adding interest:", myAccount.getBalance());

    myAccount.displayAccount(123432, "Samuel L Jackson");

    if (myAccount.getBalance() < 0) {
      System.out.println("THIS ACCOUNT IS IN OVERDRAFT!");
    }

  }

}
