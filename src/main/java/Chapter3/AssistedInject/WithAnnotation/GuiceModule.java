package Chapter3.AssistedInject.WithAnnotation;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class GuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new FactoryModuleBuilder().build(Deliverer.Factory.class));
  }
}
