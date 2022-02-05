package Chapter5.SingletonsInPractice;

import Chapter5.SingletonsInPractice.BindingAnnotations.Basement;
import com.google.common.base.Preconditions;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static com.google.common.base.Preconditions.*;

public class MultipleSecuritySetup {}

class BasementFloor {
  private final Camera camera1;
  private final Camera camera2;

  @Inject
  public BasementFloor(@Basement Camera camera1, @Basement Camera camera2) {
    this.camera1 = checkNotNull(camera1);
    this.camera2 = checkNotNull(camera2);
  }

  public Camera getCamera1() {
    return camera1;
  }

  public Camera getCamera2() {
    return camera2;
  }
}

class BasementFloorTest {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    BasementFloor basementFloor = injector.getInstance(BasementFloor.class);

    checkState(basementFloor.getCamera1() != basementFloor.getCamera2());
  }
}








