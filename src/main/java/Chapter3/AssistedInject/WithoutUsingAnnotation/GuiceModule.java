package Chapter3.AssistedInject.WithoutUsingAnnotation;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(DelivererFactory.class).to(DelivererFactoryImpl.class);
  }
}
