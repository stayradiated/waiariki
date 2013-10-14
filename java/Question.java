public class Question {

  private String text;
  private String type;
  public int length;

  public Question (String _text, String _type) {
    this.text = _text;
    this.type = _type;
    this.length = this.text.length();
  }

  /**
   * Get text
   * @return text
   */

  public String getText () {
    return this.text;
  }

  /**
   * Set text
   * @param text
   */

  public void setText (String _text) {
    this.text = _text;
  }

  /**
   * Get type
   * @return type
   */

  public String getType () {
    return this.type;
  }

  /**
   * Set type
   * @param type
   */

  public void setType (String _type) {
    this.type = _type;
  }

}