package Chapter2._1_Basics;

import Chapter2._1_Basics.GuiceConfig.EmailAbstractModule;
import com.google.inject.Guice;

public class EmailClient {
  private final Emailer englishEmailer;

  EmailClient(Emailer englishEmailer) {
    this.englishEmailer = englishEmailer;
  }

  public void sendEmail() {
    englishEmailer.send("This is the email text!");
  }
}

class Test {
  public static void main(String[] args) {
    EnglishEmailer englishEmailer = Guice.createInjector(new EmailAbstractModule()).getInstance(EnglishEmailer.class);
    englishEmailer.send("English Email Text");

    FrenchEmailer frenchEmailer = Guice.createInjector(new EmailAbstractModule()).getInstance(FrenchEmailer.class);
    frenchEmailer.send("French Email Text");
  }
}