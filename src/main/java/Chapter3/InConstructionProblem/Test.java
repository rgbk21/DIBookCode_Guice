package Chapter3.InConstructionProblem;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    Host host = injector.getInstance(Host.class);
    Symbiote symbiote = injector.getInstance(Symbiote.class);
  }
}
