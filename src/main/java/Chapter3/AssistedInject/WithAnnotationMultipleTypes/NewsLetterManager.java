package Chapter3.AssistedInject.WithAnnotationMultipleTypes;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class NewsLetterManager {
  private final List<Recipient> recipients;
  private final Deliverer.Factory delivererFactory;

  @Inject
  NewsLetterManager(Deliverer.Factory factory) {
    this.delivererFactory = checkNotNull(factory);
    this.recipients = new ArrayList<>();
  }

  public void send(NewsLetter newsLetter) {
    for (Recipient recipient : recipients) {
      Deliverer deliverer = delivererFactory.create(newsLetter, "01/01/2022", "MonthlyNewsLetter");
      deliverer.deliverNewsLetterTo(recipient);
    }
  }

  public void addRecipient(Recipient recipient) {
    recipients.add(recipient);
  }
}

class Deliverer {

  /** Factory for {@link Deliverer} */
  interface Factory {
    Deliverer create(NewsLetter newsLetter, @Assisted("date") String date, @Assisted("name") String name);
  }

  private final EmailService emailService; // from the Injector
  private final NewsLetter newsLetter; // from the instance's creator
  private final String date; // from the instance's creator
  private final String name; // from the instance's creator

  @Inject
  Deliverer(EmailService emailService, @Assisted NewsLetter newsLetter, @Assisted("date") String date, @Assisted("name") String name) {
    this.emailService = checkNotNull(emailService);
    this.newsLetter = checkNotNull(newsLetter);
    this.date = checkNotNull(date);
    this.name = checkNotNull(name);
  }

  public void deliverNewsLetterTo(Recipient recipient) {
    System.out.println("Sending newsletter to recipient: " + recipient);
  }
}

class NewsLetter {}
class EmailService {}
class Recipient {}

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    NewsLetterManager manager = injector.getInstance(NewsLetterManager.class);
    manager.addRecipient(new Recipient());
    manager.addRecipient(new Recipient());
    manager.addRecipient(new Recipient());

    manager.send(new NewsLetter());
  }
}