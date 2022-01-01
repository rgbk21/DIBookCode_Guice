package Chapter3.InConstructionProblemWithoutSolution;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

public class HostImpl implements Host {
  private Symbiote symbiote;
  private int symbioteAge;

  HostImpl() {
    System.out.println("In HostImpl Constructor");
  }

  @Inject
  public void setSymbiote(Symbiote symbiote) {
    System.out.println("Enter setSymbiote");
    this.symbiote = symbiote;
    this.symbioteAge = symbiote.calculateAge();
    Preconditions.checkState(symbioteAge == 21);
    System.out.println("Exit setSymbiote");
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
