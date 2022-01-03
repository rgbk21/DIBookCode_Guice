package Chapter3.AssistedInject.WithoutUsingAnnotation;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DelivererFactoryImpl implements DelivererFactory {
  private final Provider<EmailService> emailServiceProvider;

  @Inject
  DelivererFactoryImpl(Provider<EmailService> emailServiceProvider) {
    this.emailServiceProvider = emailServiceProvider;
  }

  @Override
  public Deliverer create(NewsLetter newsLetter, String date) {
    return new Deliverer(emailServiceProvider.get(), newsLetter, date);
  }
}
