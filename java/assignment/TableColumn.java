/**
 * class: TableColumn
 * purpose: Model a column of a talbe
 */

public class TableColumn {

  /**
   * Private variables
   */

  private int width;
  private String name;

  /**
   * Default constructor
   */

  public TableColumn () {
    this.width = 0;
    this.name = "";
  }

  /**
   * Alternative constructor
   * @param name - name of the column
   * @param width - width of the column
   */

  public TableColumn (String name, int width) {
    this.width = width;
    this.name  = name;
  }

  /**
   * Get the width of the column
   * @return int - the width
   */

  public int getWidth () {
    return this.width;
  }

  /**
   * Set the width of the column
   * @return int - the width
   */

  public void setWidth (int width) {
    this.width = width;
  }

  /**
   * Get the name of the column
   * @return String - the name
   */

  public String getName () {
    return this.name;
  }

  /**
   * Set the name of the column
   * @param String - the name
   */

  public void setName (String name) {
    this.name = name;
  }

}
