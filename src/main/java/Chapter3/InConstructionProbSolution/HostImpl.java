package Chapter3.InConstructionProbSolution;

import com.google.inject.Inject;

public class HostImpl implements Host {
  private Symbiote symbiote;

  HostImpl() {}

  @Inject
  public void setSymbiote(Symbiote symbiote) {
    this.symbiote = symbiote;
  }

  @Override
  public Symbiote getSymbiote() {
    return symbiote;
  }

  @Override
  public int calculateAge() {
    return 42;
  }
}
