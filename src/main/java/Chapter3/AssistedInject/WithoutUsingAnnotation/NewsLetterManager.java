package Chapter3.AssistedInject.WithoutUsingAnnotation;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.util.ArrayList;
import java.util.List;

public class NewsLetterManager {
  private final List<Recipient> recipients;
  private final DelivererFactory delivererFactory;

  @Inject
  NewsLetterManager(DelivererFactory delivererFactory) {
    this.recipients = new ArrayList<>();
    this.delivererFactory = delivererFactory;
  }

  public void send(NewsLetter newsLetter) {
    for (Recipient recipient : recipients) {
      Deliverer deliverer = delivererFactory.create(newsLetter, "01/01/2022");
      deliverer.deliverNewsLetterTo(recipient);
    }
  }

  public void addRecipient(Recipient recipient) {
    recipients.add(recipient);
  }
}

class Deliverer {
  private final EmailService emailService; // from the Injector
  private final NewsLetter newsLetter; // from the instance's creator
  private final String date; // from the instance's creator

  Deliverer(EmailService emailService, NewsLetter newsLetter, String date) {
    this.emailService = emailService;
    this.newsLetter = newsLetter;
    this.date = date;
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
    Injector injector = Guice.createInjector(new GuiceModule(), new DummyGuiceModule());
    NewsLetterManager manager = injector.getInstance(NewsLetterManager.class);
    manager.addRecipient(new Recipient());
    manager.addRecipient(new Recipient());
    manager.addRecipient(new Recipient());

    manager.send(new NewsLetter());
  }
}