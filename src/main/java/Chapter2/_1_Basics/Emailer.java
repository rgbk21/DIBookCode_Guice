package Chapter2._1_Basics;

import com.google.inject.Guice;
import com.google.inject.Inject;

public class Emailer {
  private final SpellChecker spellChecker;

  @Inject
  public Emailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  public void send(String emailText) {
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
    Emailer emailer = Guice.createInjector().getInstance(Emailer.class);
    EmailClient client = new EmailClient(emailer);
    client.sendEmail();
  }
}