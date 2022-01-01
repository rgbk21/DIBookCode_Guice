package Chapter3;

import com.google.inject.Guice;
import com.google.inject.Inject;

public class BrewingVat {
  @Inject private Barley barley;
  @Inject private Yeast yeast;

  public void makeBeer() {
    yeast.add();
    barley.ferment();
    System.out.println("Tada! Beer is ready.");
  }
}

class Barley {
  public void ferment() {
    System.out.println("Ferment Barley");
  }
}

class Yeast {
  public void add() {
    System.out.println("Adding Yeast");
  }
}

class TestBeer {
  public static void main(String[] args) {
    BrewingVat brewingVat = Guice.createInjector().getInstance(BrewingVat.class);
    brewingVat.makeBeer();
  }
}
