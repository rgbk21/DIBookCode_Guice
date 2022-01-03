package Chapter3.Reinjection.Problem;

import com.google.inject.Inject;

public class Granny {
  private Apple apple;

  @Inject
  Granny(Apple apple) {
    this.apple = apple;
  }

  public void eat() {
    apple.consume();
    apple.consume();
  }
}

class Apple {
  public void consume() {
    System.out.println("Apple eaten.");
  }
}
