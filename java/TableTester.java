public class TableTester {

  public static void main (String[] args) {

    TableColumn[] columns = {
      new TableColumn("ID", 4),
      new TableColumn("Name", 15),
      new TableColumn("Gender", 6),
      new TableColumn("Age", 4),
      new TableColumn("Jobs Assigned", 20)
    };

    String[][] rows = {
      new String[] { "1", "George", "M", "19", "4" },
      new String[] { "2", "Sam", "F", "21", "2" },
      new String[] { "3", "Mike", "M", "15", "1" },
      new String[] { "4", "Jono", "M", "17", "6" }
    };

    Table table = new Table(columns, rows);

    System.out.println(table.print());

  }

}
