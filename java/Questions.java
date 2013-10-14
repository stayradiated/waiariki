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

  public void ask () {
    this.scanner.skip("\n");
    for (int i = 0; i < this.questions.length; i++) {
      this.askQuestion(this.questions[i]);
    }
  }

  private Object askQuestion (Question question) {
    String text = question.getText();
    this.print(text);
    return this.scanner.nextLine();
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