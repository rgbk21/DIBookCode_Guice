package Chapter3.InConstructionProblem;

import com.google.inject.Inject;

public class SymbioteImpl implements Symbiote {
  private final Host host;
  private final int hostAge;

  @Inject
  SymbioteImpl(Host host) {
    this.host = host;
    this.hostAge = host.calculateAge();
  }

  @Override
  public Host getHost() {
    return this.host;
  }

  @Override
  public int getHostAge() {
    return this.hostAge;
  }
}
