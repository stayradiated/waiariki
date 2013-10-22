public class TableColumn {

  private int width;
  private String name;

  public TableColumn () {
    this.width = 0;
    this.name = "";
  }

  public TableColumn (String name, int width) {
    this.width = width;
    this.name  = name;
  }

  public int getWidth () {
    return this.width;
  }

  public void setWidth (int width) {
    this.width = width;
  }

  public String getName () {
    return this.name;
  }

  public void setName (String name) {
    this.name = name;
  }

}
