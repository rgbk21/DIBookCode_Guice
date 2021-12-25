package Chapter2._1_Basics;

import Chapter2._1_Basics.GuiceConfig.EmailAbstractModule;
import Chapter2._1_Basics.GuiceConfig.EmailModule;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class Emailer {
  private final SpellChecker spellChecker;

  @Inject
  public Emailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  public void send(String emailText) {
    System.out.println("In Emailer class");
    spellChecker.validateText(emailText);
  }
}

class EmailClient {
  private final Emailer emailer;

  EmailClient(Emailer emailer) {
    this.emailer = emailer;
  }

  public void sendEmail() {
    emailer.send("This is the email text!");
  }
}

class Test {
  public static void main(String[] args) {
    Emailer emailer = Guice.createInjector(new EmailAbstractModule()).getInstance(Emailer.class);
    EmailClient client = new EmailClient(emailer);
    client.sendEmail();
  }
}