package Chapter5.SingletonsInPractice.MultipleMasters;

import Chapter5.SingletonsInPractice.MultipleMasters.BindingAnnotations.BasementMaster;
import Chapter5.SingletonsInPractice.MultipleMasters.BindingAnnotations.RoofMaster;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static com.google.common.base.Preconditions.checkState;

public class MultipleSingletonReferences {}

interface MasterTerminal {}

class MasterTerminalImpl implements MasterTerminal {}

class SecuritySetup {
  private final MasterTerminal terminal1;
  private final MasterTerminal terminal2;
  private final MasterTerminal terminal3;
  private final MasterTerminal terminal4;

  @Inject
  public SecuritySetup(
      @RoofMaster MasterTerminal terminal1,
      @RoofMaster MasterTerminal terminal2,
      @BasementMaster MasterTerminal terminal3,
      @BasementMaster MasterTerminal terminal4) {
    this.terminal1 = terminal1;
    this.terminal2 = terminal2;
    this.terminal3 = terminal3;
    this.terminal4 = terminal4;
  }

  public MasterTerminal getTerminal1() {
    return terminal1;
  }

  public MasterTerminal getTerminal2() {
    return terminal2;
  }

  public MasterTerminal getTerminal3() {
    return terminal3;
  }

  public MasterTerminal getTerminal4() {
    return terminal4;
  }
}

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    SecuritySetup securitySetup = injector.getInstance(SecuritySetup.class);

    checkState(securitySetup.getTerminal1() == securitySetup.getTerminal2());
    checkState(securitySetup.getTerminal3() == securitySetup.getTerminal4());
    checkState(securitySetup.getTerminal1() != securitySetup.getTerminal3());

    // Printing the actual values:
    System.out.println(securitySetup.getTerminal1()); // MasterTerminalImpl@217ed35e
    System.out.println(securitySetup.getTerminal2()); // MasterTerminalImpl@217ed35e
    System.out.println(securitySetup.getTerminal3()); // MasterTerminalImpl@6743e411
    System.out.println(securitySetup.getTerminal4()); // MasterTerminalImpl@6743e411
  }
}


















