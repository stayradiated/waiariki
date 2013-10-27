/**
 * class: Title
 * purpose: Create a title using a Table
 */

public class Title {

  /**
   * Private variables
   */

  private final int WIDTH = 64;
  private String title;
  private Table table;


  /**
   * Default constructor
   */

  public Title () {
    this.title = "";
  }


  /**
   * Alternative constructor
   * @param _title - the title of the table
   */

  public Title (String _title) {
    this.setTitle(_title);
  }


  /**
   * Print the table
   */

  public void print () {
    this.table.print();
  }


  /**
   * Set the title
   * @param _title - The title of the table
   */

  public void setTitle (String _title) {
    this.title = "# " + _title + " #";
    this.createTable();
  }


  /**
   * Create a new table that centers the title text
   * @return this.table
   */

  private Table createTable () {

    // Calculate amount of padding required
    int length = this.title.length();
    int padding = (WIDTH / 2) + (length / 2);

    // Use String.format to prepend extra spaces to the title
    String text = String.format("%" + padding + "s", this.title);

    // Create a new table with the padded text
    this.table = new Table(new TableColumn[] {
      new TableColumn(text, WIDTH)
    });

    return this.table;
  }

}
