
public class TUI {

  public static void main (String[] args) {
    new TUI();
  }

  public TUI () {
    this.menu();
  }

  public void menu () {

    TableColumn[] columns = {
      new TableColumn("#", 1),
      new TableColumn("MAIN MENU", 60)
    };

    String[][] rows = {
      new String[] { "1", "Add employee" },
      new String[] { "2", "Delete an employee" },
      new String[] { "3", "Modify an employee record" },
      new String[] { "4", "List all employees" },
      new String[] { "5", "View details of an employee" },
      new String[] { "6", "List all employees in an age group" },
      new String[] { "7", "View the employee with the highest number of jobs assigned" },
      new String[] { "8", "Show total number of employees with no jobs assigned" },
      new String[] { "9", "Exit" }
    };

    Table table = new Table(columns, rows);
    table.print();


  }

}