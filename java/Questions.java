import java.util.Scanner;

public class Questions {

  private Scanner scanner;
  private Question[] questions;
  private int maxLength;

  public Questions (Question[] _questions, Scanner _scanner) {
    this.scanner = _scanner;
    this.questions = _questions;
    this.calculateMaxLength();
  }

  public Object[] ask () {
    Object[] answers = new Object[this.questions.length];
    this.scanner.skip("\n");
    for (int i = 0; i < this.questions.length; i++) {
      answers[i] = this.askQuestion(this.questions[i]);
    }
    return answers;
  }

  private Object askQuestion (Question question) {
    Object input = null;
    String text = question.getText();
    String type = question.getType();

    this.print(text);

    if (type.equals("String")) {
      input = this.scanner.nextLine();
    }
    else if (type.equals("int")) {
      input = this.scanner.nextInt();
    }
    else if (type.equals("char")) {
      input = this.scanner.nextLine().charAt(0);
    }

    return input;
  }

  private int calculateMaxLength () {
    int max = 0;
    for (int i = 0; i < this.questions.length; i++) {
      if (this.questions[i].length > max) {
        max = this.questions[i].length;
      }
    }
    this.maxLength = max;
    return this.maxLength;
  }

  private void print (String message) {
    System.out.printf("%-" + this.maxLength + "s ", message);
  }

}
