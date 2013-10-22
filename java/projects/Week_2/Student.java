

/**
 * File: Student.java
 * Purpose: This Student class contains data relevant to students (id, name,           date of birth)
 * Author: George Czabania
 * Modified: 2013-08-06
 */

public class Student {
  
  private int studentId;
  private String studentName;
  private String studentDob;
  private char studentGender;

  /*
   * Constructors
   */

  public Student() {
    studentId = 0;
    studentName = "";
    studentDob = "";
  }

  /**
   * @param id Students Id
   */

  public Student(int id) {
    studentId = id;
  }

  /**
   * @param id Students Id
   * @param name Students Name
   * @param dob Students DOB
   * @param gender Students gender
   */

  public Student(int id, String name, String dob, char gender) {
    studentId = id;
    studentName = name;
    studentDob = dob;
    studentGender = gender;
  }

  /**
   * Set Student's ID Number
   * @param id
   */

  public void setId(int id) {
    studentId = id;
  }

  /**
   * Return Student's ID Number
   * @return studentId
   */

  public int getStudentId() {
    return studentId;
  }

  /**
   * Set Student's Name
   * @param name
   */

  public void setName(String name) {
    studentName = name;
  }

  /**
   * Return Student's Name
   * @return studentName
   */

  public String getName() {
    return studentName;
  }

  /**
   * Set Student's Date of Birth
   * @param dob
   */

  public void setDob(String dob) {
    studentDob = dob;
  }

  /**
   * Return Student's Date of Birth
   * @return studentDob
   */

  public String getDob() {
    return studentDob;
  }

  /**
   * Set Student's Gender
   * @param gender
   */

  public void setGender(char gender) {
    studentGender = gender;
  }

  /**
   * Return Student's Gender
   * @return studentGender
   */

  public char getGender() {
    return studentGender;
  }

  /**
   * Print Students Details
   */

  public void print() {
    String output =
        "-----------------------------------------\n"
      + " ID:     " + studentId     + " \n"
      + " Name:   " + studentName   + " \n"
      + " DOB:    " + studentDob    + " \n"
      + " Gender: " + studentGender + " \n"
      + "-----------------------------------------\n";
    System.out.println(output);
  }

}
