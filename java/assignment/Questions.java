/**
 * class: Questions
 * purpose: Ask the user multiple questions
 */

import java.util.Scanner;

public class Questions {

  /**
   * Private variables
   */

  private int        maxLength;
  private Scanner    scanner;
  private Question[] questions;


  /**
   * Constructor
   * @param _questions - an array of questions to ask
   * @param _scanner - the scanner to use
   */

  public Questions (Question[] _questions, Scanner _scanner) {
    this.scanner   = _scanner;
    this.questions = _questions;
    this.findMaxLength();
  }


  /**
   * Ask the questions
   * @return Object[] - the answers
   */

  public Object[] ask () {

    // Create array to hold answers
    Object[] answers = new Object[this.questions.length];
    
    // Skip any newlines
    this.scanner.skip("\n");

    // Ask each question
    for (int i = 0; i < this.questions.length; i++) {
      answers[i] = this.questions[i].ask(this.maxLength, this.scanner);
    }

    return answers;
  }


  /**
   * Find the length longest question
   * @return int - the length of the longest question
   */

  private int findMaxLength () {
    int max = 0;
    for (int i = 0; i < this.questions.length; i++) {
      if (this.questions[i].length > max) {
        max = this.questions[i].length;
      }
    }
    this.maxLength = max;
    return this.maxLength;
  }

}
