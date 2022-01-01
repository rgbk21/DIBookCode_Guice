package Chapter3.InConstructionProblem;

import com.google.inject.Inject;

public class HostImpl implements Host {
  private final Symbiote symbiote;

  @Inject
  HostImpl(Symbiote symbiote) {
    this.symbiote = symbiote;
  }

  @Override
  public Symbiote getSymbiote() {
    return this.symbiote;
  }

  @Override
  public int calculateAge() {
    return 42;
  }
}
