package Chapter2._1_Basics;

import Chapter2._1_Basics.GuiceConfig.EmailAbstractModule;
import com.google.inject.Guice;

public interface Emailer {
  public void send(String emailText);
}