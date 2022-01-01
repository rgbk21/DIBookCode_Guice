package Chapter3.InConstructionProbSolution;

import com.google.common.base.Preconditions;
import com.google.inject.Guice;
import com.google.inject.Injector;

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    Host host = injector.getInstance(Host.class);
    Symbiote symbiote = injector.getInstance(Symbiote.class);

    Preconditions.checkState(host.getSymbiote() == symbiote);
    Preconditions.checkState(symbiote.getHost() == host);
  }
}
