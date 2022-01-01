package Chapter3.InConstructionProblem;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Host.class).to(HostImpl.class).in(Singleton.class);
    bind(Symbiote.class).to(SymbioteImpl.class).in(Singleton.class);
  }
}
