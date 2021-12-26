package Chapter3;

import static com.google.common.base.Preconditions.checkState;

import Chapter2._1_Basics.GuiceConfig.EmailAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class Amplifier {
  private Guitar guitar;
  private Speaker speaker;
  private Footpedal footpedal;

  @Inject
  private void setUp(Guitar guitar, Speaker speaker, Footpedal footpedal) {
    this.guitar = guitar;
    this.speaker = speaker;
    this.footpedal = footpedal;
  }

//  @Inject
//  public Amplifier setGuitar(Guitar guitar) {
//    this.guitar = guitar;
//    return this;
//  }
//
//  @Inject
//  public Amplifier setSpeaker(Speaker speaker) {
//    this.speaker = speaker;
//    return this;
//  }
//
//  @Inject
//  public Amplifier setFootpedal(Footpedal footpedal) {
//    this.footpedal = footpedal;
//    return this;
//  }

  public void playMusic() {
    guitar.setUpGuitar();
    speaker.setUpSpeaker();
    footpedal.setUpFootpedal();
    System.out.println("WAAAAAH!");
  }
}

class Guitar {
  public void setUpGuitar() {
    System.out.println("Guitar set up!");
  }
}
class Speaker {
  public void setUpSpeaker() {
    System.out.println("Speaker set up!");
  }
}
class Footpedal {
  public void setUpFootpedal() {
    System.out.println("FootPedal Set up!");
  }
}

class Test {
  public static void main(String[] args) {
    Amplifier amplifier = Guice.createInjector(new EmailAbstractModule()).getInstance(Amplifier.class);
    amplifier.playMusic();
  }
}