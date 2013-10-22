public class Table {

  private TableColumn[] columns;
  private int width;

  private final String V_SEP  = "|";
  private final String CORNER = "+";
  private final String H_SEP  = "-";
  private final String NL     = "\n";
  private final String PAD    = " ";

  private final String BOLD;
  private final String RESET;

  public Table (TableColumn[] _columns) {
    columns = _columns;

    if (System.getProperty("os.name").equals("Linux")) {
      BOLD  = "\033[1m";
      RESET = "\033[0m";
    } else {
      BOLD  = "";
      RESET = "";
    }

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

    out += line;
    out += NL;

    out += V_SEP + PAD;
    for (int i = 0; i < columns.length; i++) {
      out += BOLD;
      out += String.format("%-" + columns[i].getWidth() + "s", columns[i].getName());
      out += RESET;
      out += PAD + V_SEP + PAD;
    }

    out += NL;
    out += line;
    out += NL;
    out += line;

    return out;

  }

}
