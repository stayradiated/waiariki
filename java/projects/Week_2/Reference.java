public class Reference {
  
  private String data;
  private String myString;  
  public int val;

  public void set (String in) {
    myString = in;
  }

  public String get () {
    return myString;
  }

  public String data () {
    return " -- " + data;
  }

  public String setData (String in) {
    return data = in;
  }

}
