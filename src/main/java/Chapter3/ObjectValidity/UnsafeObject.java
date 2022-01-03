package Chapter3.ObjectValidity;

import com.google.inject.Inject;

import java.util.List;

public class UnsafeObject {
  private final List<Slippery> slippery;
  private final Shady shady;

  @Inject
  public UnsafeObject(Slippery slippery, Shady shady) {
    System.out.println("Inside the UnsafeObject constructor");
    this.shady = shady;
    this.slippery = List.of(slippery);

    init();
  }

  private void init() {
    System.out.println("Inside the init method");
  }
}

class Slippery {
  Slippery() {
    System.out.println("Inside the constructor for Slippery");
  }
}
class Shady {
  Shady() {
    System.out.println("Inside the constructor for Shady");
  }
}
