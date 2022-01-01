package Chapter3.InConstructionProblemWithoutSolution;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

public class SymbioteImpl implements Symbiote {
  private Host host;
  private int hostAge;

  SymbioteImpl() {
    System.out.println("In SymbioteImpl Constructor");
  }

  @Inject
  public void setHost(Host host) {
    System.out.println("Enter setHost");
    this.host = host;
    this.hostAge = host.calculateAge();
    Preconditions.checkState(hostAge == 42);
    System.out.println("Exit setHost");
  }

  @Override
  public Host getHost() {
    return host;
  }

  @Override
  public int calculateAge() {
    return 21;
  }
}
