package Chapter2._1_Basics;

import Chapter2._1_Basics.GuiceConfig.EmailAbstractModule;
import Chapter2._1_Basics.GuiceConfig.EmailModule;
import com.google.inject.Guice;
import com.google.inject.Inject;

class AdvancedEmailer implements EmailerIF {

  private final SpellChecker spellChecker;

  @Inject
  public AdvancedEmailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  @Override
  public void send(String emailText) {
    System.out.println("In AdvancedEmailer class");
    spellChecker.validateText(emailText);
  }
}

public class Emailer implements EmailerIF {
  private final SpellChecker spellChecker;

  @Inject
  public Emailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  @Override
  public void send(String emailText) {
    System.out.println("In Emailer class");
    spellChecker.validateText(emailText);
  }
}

class EmailClient {
  private final EmailerIF emailer;

  EmailClient(EmailerIF emailer) {
    this.emailer = emailer;
  }

  public void sendEmail() {
    emailer.send("This is the email text!");
  }
}

class Test {
  public static void main(String[] args) {
    EmailerIF emailer = Guice.createInjector(new EmailAbstractModule()).getInstance(EmailerIF.class);
    EmailClient client = new EmailClient(emailer);
    client.sendEmail();
  }
}