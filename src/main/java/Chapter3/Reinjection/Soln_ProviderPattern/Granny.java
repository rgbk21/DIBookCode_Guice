package Chapter3.Reinjection.Soln_ProviderPattern;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Granny {
  private final Provider<Apple> appleProvider;

  // Instead of injecting the dependency Apple directly, we instead inject a Provider<Apple>
  // that Granny can then use as required to create and consume a new instance of apple as and when required.
  @Inject
  public Granny(Provider<Apple> appleProvider){
    this.appleProvider = appleProvider;
  }

  public void eat() {
    // This effectively says that before we use an apple, we get it from the Provider, meaning
    //that a new Apple instance is created each time.
    appleProvider.get().consume();
  }
}

class Apple {
  public void consume() {
    System.out.println(this + " apple eaten.");
  }
}

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector();
    Granny granny = injector.getInstance(Granny.class);
    granny.eat();
    granny.eat();
  }
}