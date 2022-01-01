package Chapter3;

import com.google.inject.Inject;

public class Amphibian {
  private Gills gills;
  private Lungs lungs;
  private Heart heart;

  /** Constructs a water amphibian with gills and heart */
  @Inject
  Amphibian(Gills gills, Heart heart) {
    this.gills = gills;
    this.heart = heart;
  }

  /** Constructs a land amphibian with lungs and heart */
  @Inject
  Amphibian(Lungs lungs, Heart heart) {
    this.lungs = lungs;
    this.heart = heart;
  }
}

class Gills {}
class Lungs {}
class Heart {}
