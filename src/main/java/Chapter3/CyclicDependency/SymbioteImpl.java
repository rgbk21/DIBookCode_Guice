package Chapter3.CyclicDependency;

import com.google.inject.Inject;

public class SymbioteImpl implements Symbiote {
  private final Host host;

  @Inject
  public SymbioteImpl(Host host) {
    this.host = host;
  }

  @Override
  public Host getHost() {
    return host;
  }
}
