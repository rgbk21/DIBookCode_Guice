package Chapter5.ScopeBasics;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Family {
  public void giveToothpaste(String memberName, Toothpaste paste) {
    System.out.println(memberName + " is using toothpaste " + paste);
  }
}

class Toothpaste {}

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    Family family = new Family();
    family.giveToothpaste("Alice", injector.getInstance(Toothpaste.class));
    family.giveToothpaste("Bob", injector.getInstance(Toothpaste.class));
    family.giveToothpaste("Charlie", injector.getInstance(Toothpaste.class));
    // Alice is using toothpaste Toothpaste@368f2016
    // Bob is using toothpaste Toothpaste@a1153bc
    // Charlie is using toothpaste Toothpaste@1aafa419
  }
}
