package Chapter5.SingletonsInPractice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static Chapter5.SingletonsInPractice.BindingAnnotations.Basement;
import static Chapter5.SingletonsInPractice.BindingAnnotations.Penthouse;
import static com.google.common.base.Preconditions.checkNotNull;

public class FourTimesTheSecurity {}

class Building {
  private final Camera camera1;
  private final Camera camera2;
  private final Camera camera3;
  private final Camera camera4;

  @Inject
  public Building(@Basement Camera camera1, @Basement Camera camera2, @Penthouse Camera camera3, @Penthouse Camera camera4) {
    this.camera1 = checkNotNull(camera1);
    this.camera2 = checkNotNull(camera2);
    this.camera3 = checkNotNull(camera3);
    this.camera4 = checkNotNull(camera4);
  }

  public Camera getCamera1() {return camera1;}

  public Camera getCamera2() {return camera2;}

  public Camera getCamera3() {return camera3;}

  public Camera getCamera4() {return camera4;}
}

class BuildingTest {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    Building building = injector.getInstance(Building.class);

    System.out.println(building.getCamera1()); // SimpleCamera@5bda8e08
    System.out.println(building.getCamera2()); // SimpleCamera@1e800aaa
    System.out.println(building.getCamera3()); // SimpleCamera@185a6e9
    System.out.println(building.getCamera4()); // SimpleCamera@6f03482
  }
}