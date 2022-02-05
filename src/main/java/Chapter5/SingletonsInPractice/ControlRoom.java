package Chapter5.SingletonsInPractice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class ControlRoom {
  private final MasterTerminal terminal1;
  private final MasterTerminal terminal2;
  private final MasterTerminal terminal3;
  private final MasterTerminal terminal4;

  @Inject
  public ControlRoom(MasterTerminal t1, MasterTerminal t2, MasterTerminal t3, MasterTerminal t4) {
    this.terminal1 = checkNotNull(t1);
    this.terminal2 = checkNotNull(t2);
    this.terminal3 = checkNotNull(t3);
    this.terminal4 = checkNotNull(t4);
  }

  public MasterTerminal getTerminal1() {
    System.out.println("terminal1: " + terminal1);
    return terminal1;
  }

  public MasterTerminal getTerminal2() {
    System.out.println("terminal2: " + terminal2);
    return terminal2;
  }

  public MasterTerminal getTerminal3() {
    System.out.println("terminal3: " + terminal3);
    return terminal3;
  }

  public MasterTerminal getTerminal4() {
    System.out.println("terminal4: " + terminal4);
    return terminal4;
  }
}

class ControlRoomTest {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    ControlRoom controlRoom = injector.getInstance(ControlRoom.class);

    checkState(controlRoom.getTerminal1() == controlRoom.getTerminal2());
    checkState(controlRoom.getTerminal2() == controlRoom.getTerminal3());
    checkState(controlRoom.getTerminal3() == controlRoom.getTerminal4());
  }
}