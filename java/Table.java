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

  public Table (TableColumn[] _columns, String[][] _rows) {
    this(_columns);
    this.addRows(_rows);
  }

  public String print () {

    String out = "";
    String line = "";
    int width;

    for (int i = 0; i < columns.length; i++) {
      line += CORNER;
      width = columns[i].getWidth();
      width += PAD.length() * 2;
      for (int j = 0; j < width; j++) {
        line += H_SEP;
      }
      if (i == columns.length - 1) {
        line += CORNER;
      }
    }

    line += NL;

    out += line;

    out += V_SEP + PAD;
    for (int i = 0; i < columns.length; i++) {
      out += BOLD;
      out += String.format("%-" + columns[i].getWidth() + "s", columns[i].getName());
      out += RESET;
      out += PAD + V_SEP + PAD;
    }

    out += NL;
    out += line;

    for (int i = 0; i < this.rows.length; i++) {
      out += V_SEP + PAD;
      for (int j = 0; j < this.rows[i].length; j++) {
        out += String.format("%-" + columns[j].getWidth() + "s", this.rows[i][j]);
        out += PAD + V_SEP + PAD;
      }
      out += NL;
    }

    out += line;

    System.out.print(out);

    return out;

  }

  /**
   * Add multiple rows to the table
   */

  public void addRows (String[][] _rows) {
    String[][] result = Arrays.copyOf(this.rows, this.rows.length + _rows.length);
    System.arraycopy(_rows, 0, result, this.rows.length, _rows.length);
    this.rows = result;
  }

}
