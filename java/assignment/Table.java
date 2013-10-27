/**
 * class: Table
 * purpose: Generate a table using symbols
 */

import java.util.Arrays;

public class Table {

  /**
   * Private variables
   */

  private int           width;
  private String[][]    rows;
  private TableColumn[] columns;

  private final String V_SEP  = "|";
  private final String CORNER = "+";
  private final String H_SEP  = "-";
  private final String NL     = "\n";
  private final String PAD    = " ";

  /**
   * Constructor
   * @param _columns - an arary of table columns
   */

  public Table (TableColumn[] _columns) {
    this.columns = _columns;
    this.rows = new String[][] {};
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

    // Create the line
    // +----+---------+------+

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

    // Top line
    out += line;

    // Left border and padding
    out += V_SEP + PAD;

    // Table column heading
    for (int i = 0; i < index.length; i++) {
      column = this.columns[index[i]];
      out += String.format(
        "%-" + column.getWidth() + "s",
        column.getName()
      );
      out += PAD + V_SEP + PAD;
    }

    // New line 
    out += NL + line;

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
   * @param _rows - table rows as a multidimensional array of strings
   * {
   *   { "cell A1", "cell B1", "cell C1" },
   *   { "cell A2", "cell B2", "cell C2" },
   *   { "cell A3", "cell B3", "cell C3" },
   * }
   */

  public void addRows (String[][] _rows) {
    // Concatenate two arrays
    String[][] result = Arrays.copyOf(this.rows, this.rows.length + _rows.length);
    System.arraycopy(_rows, 0, result, this.rows.length, _rows.length);
    this.rows = result;
  }

}
