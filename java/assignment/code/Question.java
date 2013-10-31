/**
 * class: Question
 * purpose: Ask the user a question
 */

import java.util.Scanner;

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
   * Ask question
   * @param length - length of text
   * @param scanner - Scanner instance
   * @return Object - answer
   */

  public Object ask (Scanner scanner) {

    Object input = null;

    this.print();

    if (type.equals("String")) {
      input = scanner.nextLine();
      if (((String) input).length() < 1) {
        System.out.println("Error! A value must be entered.");
        return this.ask(scanner);
      }
    }

    else if (type.equals("int")) {
      while (! scanner.hasNextInt()) {
        scanner.nextLine();
        this.print();
      }
      input = scanner.nextInt();
      if (((Integer) input) < 0) {
        System.out.println("Error! Negative values are not allowed.");
        return this.ask(scanner);
      }
    }

    else if (type.equals("age")) {
      while (! scanner.hasNextInt()) {
        scanner.nextLine();
        this.print();
      }
      int age = scanner.nextInt();
      if (age < 5 || age > 100) {
        System.out.println("Error! Age must be between 5 and 100 inclusive.");
        return this.ask(scanner);
      }
      input = age;
    }

    else if (type.equals("gender")) {
      String text = scanner.next();
      if (text.length() == 0) {
        scanner.skip("\n");
        text = scanner.next();
      }
      input = text.charAt(0);
      if (input != 'm' && input != 'f') {
        System.out.println("Error! Please enter 'm' or 'f'.");
        return this.ask(scanner);
      }
    }

    else if (type.equals("yesno")) {
      String text = scanner.next();
      if (text.length() == 0) {
        scanner.skip("\n");
        text = scanner.next();
      }
      input = text.charAt(0);
      if (input == 'y') {
        input = true;
      } else if (input == 'n') {
        input = false;
      } else {
        System.out.println("Error! Please enter 'y' or 'n'.");
        return this.ask(scanner);
      }
    }

    return input;

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

  /**
   * Get length
   * @return length
   */

  public int getLength () {
    return this.length;
  }

  /**
   * Set length
   * @param length
   */

  public void setLength (int length) {
    this.length = length;
  }

  /**
   * Print the question
   */

  private void print () {
    System.out.printf("%-" + this.length + "s ", text);
  }

}
