import java.util.Arrays;

public class Table {

  private TableColumn[] columns;
  private String[][] rows;
  private int width;

  private final String V_SEP  = "|";
  private final String CORNER = "+";
  private final String H_SEP  = "-";
  private final String NL     = "\n";
  private final String PAD    = " ";

  private final String BOLD;
  private final String RESET;


  /**
   * Default constructor
   * @param _columns - table columns
   */

  public Table (TableColumn[] _columns) {
    this.columns = _columns;
    this.rows = new String[][] {};

    if (System.getProperty("os.name").equals("Linux")) {
      BOLD  = "\033[1m";
      RESET = "\033[0m";
    } else {
      BOLD  = "";
      RESET = "";
    }

  }


  /**
   * Alternative constructor 
   * @param _columns - table columns
   * @param _rows - table rows
   */

  public Table (TableColumn[] _columns, String[][] _rows) {
    this(_columns);
    this.addRows(_rows);
  }


  /**
   * Print all columns
   * @return String - the table contents
   */

  public String print () {
    int[] index = new int[this.columns.length];
    for (int i = 0; i < index.length; i++) {
      index[i] = i;
    }
    return this.print(index);
  }


  /**
   * Print only certain columns by name
   * @param String[] - an array of the names of each columns
   * @return String - table contents
   */

  public String print (String[] _columns) {

    String name;
    int[] index = new int[_columns.length];

    // Find out the index of each column
    for (int i = 0; i < this.columns.length; i++) {

      name = this.columns[i].getName();

      for (int j = 0; j < _columns.length; j++) {

        if (name.equals(_columns[j])) {
          index[j] = i;
        }

      }
    }

    return this.print(index);

  }

  /**
   * Print only certain columns by index
   * @param int[] - an array of the indexes of each column
   * @return String - table contents
   */

  public String print (int[] index) {

    String out = "";
    String line = "";
    int width;
    TableColumn column;
    String[] row;

    for (int i = 0; i < index.length; i++) {

      column = this.columns[index[i]];
      line += CORNER;
      width = column.getWidth();
      width += PAD.length() * 2;
      for (int j = 0; j < width; j++) {
        line += H_SEP;
      }
      if (i == index.length - 1) {
        line += CORNER;
      }
    }

    line += NL;

    out += line;

    out += V_SEP + PAD;
    for (int i = 0; i < index.length; i++) {
      column = this.columns[index[i]];
      out += BOLD;
      out += String.format(
        "%-" + column.getWidth() + "s",
        column.getName()
      );
      out += RESET;
      out += PAD + V_SEP + PAD;
    }

    out += NL;
    out += line;

    // Print all rows
    for (int i = 0; i < this.rows.length; i++) {
      row = this.rows[i];

      out += V_SEP + PAD;

      // Print columns defined by index
      for (int j = 0; j < index.length; j++) {
        column = this.columns[index[j]];
        out += String.format(
          "%-" + column.getWidth() + "s",
          row[index[j]]
        );
        out += PAD + V_SEP + PAD;
      }

      out += NL;
    }

    if (this.rows.length > 0) {
      out += line;
    }

    out += NL;

    System.out.print(out);

    return out;

  
  }


  /**
   * Add multiple rows to the table
   * @param _rows - table rows
   */

  public void addRows (String[][] _rows) {
    String[][] result = Arrays.copyOf(this.rows, this.rows.length + _rows.length);
    System.arraycopy(_rows, 0, result, this.rows.length, _rows.length);
    this.rows = result;
  }

}
