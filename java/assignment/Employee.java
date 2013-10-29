
/**
 * class: Employee
 * purpose: Model a single employee
 */

public class Employee {

  /**
   * Private variables
   */

  private int    id;
  private int    age;
  private int    duties;
  private char   gender;
  private String name;

  /**
   * Default constructor
   */

  public Employee () {
    this.id     = -1;
    this.age    = -1;
    this.duties = -1;
    this.gender = 'm';
    this.name   = "";
  }

  /**
   * Alternative constructor
   * @param id     - employee id
   * @param name   - employee name
   * @param gender - employee gender
   * @param age    - employee age
   * @param duties - employee duties
   */

  public Employee (int id, String name, char gender, int age, int duties) {
    this.id     = id;
    this.name   = name;
    this.gender = gender;
    this.age    = age;
    this.age    = age;
    this.duties = duties;
  }

  /**
   * Convert the employee into an array of Strings
   * @return String[] - the employee details serialized
   */

  public String[] serialize () {
    return new String[] {
      Integer.toString(   this.id     ),
                          this.name    ,
      Character.toString( this.gender ),
      Integer.toString(   this.age    ),
      Integer.toString(   this.duties )
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
