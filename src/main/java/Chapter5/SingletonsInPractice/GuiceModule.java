package Chapter5.SingletonsInPractice;

import Chapter5.SingletonsInPractice.BindingAnnotations.Basement;
import Chapter5.SingletonsInPractice.BindingAnnotations.Penthouse;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(MasterTerminal.class).in(Singleton.class);
    bind(Camera.class).annotatedWith(Basement.class).to(SimpleCamera.class);
    bind(Camera.class).annotatedWith(Penthouse.class).to(SimpleCamera.class);
  }
}
