package Chapter5.SingletonsInPractice;

import Chapter5.SingletonsInPractice.BindingAnnotations.Basement;
import Chapter5.SingletonsInPractice.BindingAnnotations.Penthouse;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class SecuritySetup {}

class MasterTerminal {
  public MasterTerminal() {
    System.out.println("MasterTerminal Constructor Called");
  }
}

interface Camera {
  MasterTerminal getMasterTerminal();
}

class SimpleCamera implements Camera {
  private final MasterTerminal masterTerminal;

  @Inject
  public SimpleCamera(MasterTerminal masterTerminal) {
    this.masterTerminal = checkNotNull(masterTerminal);
  }

  public MasterTerminal getMasterTerminal() {
    return masterTerminal;
  }
}

class BasementCamera {
  private final Camera simpleCamera;

  @Inject
  public BasementCamera(@Basement Camera simpleCamera) {
    this.simpleCamera = checkNotNull(simpleCamera);
  }

  public Camera getCamera() {
    return simpleCamera;
  }
}

class PenthouseCamera {
  private final Camera simpleCamera;

  @Inject
  public PenthouseCamera(@Penthouse Camera simpleCamera) {
    this.simpleCamera = checkNotNull(simpleCamera);
  }

  public Camera getCamera() {
    return simpleCamera;
  }
}

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    BasementCamera basementCamera1 = injector.getInstance(BasementCamera.class);
    PenthouseCamera penthouseCamera1 = injector.getInstance(PenthouseCamera.class);

    checkState(basementCamera1.getCamera() != penthouseCamera1.getCamera());
    checkState(basementCamera1.getCamera().getMasterTerminal() == penthouseCamera1.getCamera().getMasterTerminal());

    BasementCamera basementCamera2 = injector.getInstance(BasementCamera.class);
    PenthouseCamera penthouseCamera2 = injector.getInstance(PenthouseCamera.class);

    // Since the [Camera, Basement] as well as the [Camera, Penthouse] keys are associated with Prototype scope,
    // getting new BasementCamera or PenthouseCamera objects from the injector should inject new instances of Camera
    // into them.
    checkState(basementCamera1.getCamera() != basementCamera2.getCamera());
    checkState(penthouseCamera1.getCamera() != penthouseCamera2.getCamera());

    // But there should only be a single MasterTerminal that is present in all the classes
    System.out.println(basementCamera1.getCamera().getMasterTerminal()); // MasterTerminal@9d5509a
    System.out.println(basementCamera2.getCamera().getMasterTerminal()); // MasterTerminal@9d5509a
    System.out.println(penthouseCamera1.getCamera().getMasterTerminal()); // MasterTerminal@9d5509a
    System.out.println(penthouseCamera2.getCamera().getMasterTerminal()); // MasterTerminal@9d5509a
  }
}