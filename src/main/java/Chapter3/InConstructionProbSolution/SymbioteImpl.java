package Chapter3.InConstructionProbSolution;

import com.google.inject.Inject;

public class SymbioteImpl implements Symbiote {
  private Host host;
  private int hostAge;

  @Inject
  public void setHost(Host host) {
    this.host = host;
    this.hostAge = host.calculateAge();
  }

  @Override
  public Host getHost() {
    return host;
  }
}
