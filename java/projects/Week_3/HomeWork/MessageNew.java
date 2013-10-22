/* Program: MessageNew.java
 * Author: Don Kannangara
 * Purpose: This program demonstrates a basic object-oriented program that 
 *          defines a class called Message.  This class has a Message Body
 *          as its only property.  

 * Date:    March 2013   
 *              
*/

public class MessageNew 
{
  private String messageBody;
  
  /* 
   * Sets the messageBody from a given newBody
   * @param newBody - value to set for message
   */
  public void setMessage(String newBody) 
  {
    messageBody = newBody;
  }
  
  /* 
   * "Fetches" or gets the messageBody for a message
   * @return body of message
   */
  public String getMessage() 
  {
    return messageBody;
  }
  
  /* 
   * Outputs the messageBOdy for a message
   */
  public void printMessage () 
  {
    System.out.println(messageBody);
  }
}

 