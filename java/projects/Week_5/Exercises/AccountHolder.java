
public class AccountHolder {

  // Instance variables
  private int number;
  private String name;
  private BankAccount account;

  public AccountHolder () {
    number = 0;
    name = "";
    account = new BankAccount();
  }

  public AccountHolder (int _number, String _name, BankAccount _account) {
    number = _number;
    name = _name;
    account = _account;
  }

  public int getNumber () {
    return number;
  }

  public void setNumber (int _number) {
    number = _number;
  }

  public String getName () {
    return name;
  }

  public void setName (String _name) {
    name = _name;
  }

  public BankAccount getAccount () {
    return account;
  }

  public void setAccount (BankAccount _account) {
    account = _account;
  }

}
