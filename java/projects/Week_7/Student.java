/**
 * File: Student.java
 * Purpose: This Student class contains data relevant to students (id, name,date of birth).  
 *     The command and query methods provide access to the private instance variables.
 *     
 * Author: 
 * Modified: 
 * Dat
 */

public class Student
{
  private int studentID;         // to store student id number
  private String studentName;    // student's name
  private String studentDOB;
 

  /** 
   * Default constructor
   **/
  public Student()
  {
    studentID = 0;        
    studentName = "";
   studentDOB = "";
    
  }
    /**
   * Alternative constructor 1
   * @param student_id
   */
  public Student(int student_id)
  {
    studentID = student_id;        
  }  
  
  /**
   * Alternative constructor 2
   * @param id
   * @param name
   * @param dob
   */
  public Student(int id, String name, String dob)
  {
    studentID = id;        
    studentName = name;
    studentDOB = dob;
  }  
  
  /**
   * Query method to access student's id number
   * @return studentID
   */
  public int getStudentId()
  {
    return studentID;
  }

  /**
   * Command method to assign a value for a student's id number
   * @param Id
   */
  public void setId(int Id)
  {
    studentID = Id;
  }

  /**
   * Query method to access student's name.
   * @return StudentName
   */
  public String getName()
  {
    return studentName;
  }

  /**
   * Command method to assign a value for a student's name
   * @param aName
   */
  public void setName(String aName)
  {
    studentName = aName;
  }
/**
   * Query method to access student's date of Birth.
   * @return course
   */
  public String getDOB()
  {
    return studentDOB;
  }

  /**
   * Command method to assign a value for a student's date of Birth.
   * @param aDOB
   */
  public void setCourse(String aDOB)
  {
    studentDOB = aDOB;
  }

}