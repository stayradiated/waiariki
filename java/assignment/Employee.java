
/**
 * class: Employee
 * purpose: Model a single employee
 */

public class Employee {

  private int    id;
  private int    age;
  private int    duties;
  private char   gender;
  private String name;

  /**
   * Default constructor
   */

  public Employee () {
    id     = -1;
    age    = -1;
    duties = -1;
    gender = 'M';
    name   = "";
  }

  /**
   * Alternative constructor
   * @param _id - employee id
   * @param _name - employee name
   * @param _gender - employee gender
   * @param _age - employee age
   * @param _duties - employee duties
   */

  public Employee (int _id, String _name, char _gender, int _age, int _duties) {
    id     = _id;
    name   = _name;
    gender = _gender;
    age    = _age;
    age    = _age;
    duties = _duties;
  }

  /**
   * Convert the employee into a table row
   * @return String[] - the employee details serialized
   */

  public String[] asRow () {
    return new String[] {
      Integer.toString(id),
      name,
      Character.toString(gender),
      Integer.toString(age),
      Integer.toString(duties)
    };
  }

  /**
   * Get id
   * @return id
   */

  public int getId () {
    return this.id;
  }

  /**
   * Set id
   * @param id
   */

  public void setId (int _id) {
    this.id = _id;
  }

  /**
   * Get age
   * @return age
   */

  public int getAge () {
    return this.age;
  }

  /**
   * Set age
   * @param age
   */

  public void setAge (int _age) {
    this.age = _age;
  }

  /**
   * Get duties
   * @return duties
   */

  public int getDuties () {
    return this.duties;
  }

  /**
   * Set duties
   * @param duties
   */

  public void setDuties (int _duties) {
    this.duties = _duties;
  }

  /**
   * Get gender
   * @return gender
   */

  public char getGender () {
    return this.gender;
  }

  /**
   * Set gender
   * @param gender
   */

  public void setGender (char _gender) {
    this.gender = _gender;
  }

  /**
   * Get name
   * @return name
   */

  public String getName () {
    return this.name;
  }

  /**
   * Set name
   * @param name
   */

  public void setName (String _name) {
    this.name = _name;
  }

}
