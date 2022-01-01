package Chapter3.CyclicDependency;

import com.google.inject.Inject;

public class HostImpl implements Host {
  private final Symbiote symbiote;

  @Inject
  HostImpl(Symbiote symbiote) {
    this.symbiote = symbiote;
  }

  @Override
  public Symbiote getSymbiote() {
    return symbiote;
  }
}
