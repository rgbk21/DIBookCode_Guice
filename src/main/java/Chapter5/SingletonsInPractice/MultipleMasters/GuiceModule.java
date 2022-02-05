package Chapter5.SingletonsInPractice.MultipleMasters;

import Chapter5.SingletonsInPractice.MultipleMasters.BindingAnnotations.BasementMaster;
import Chapter5.SingletonsInPractice.MultipleMasters.BindingAnnotations.RoofMaster;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(MasterTerminal.class).annotatedWith(RoofMaster.class).to(MasterTerminalImpl.class).in(Singleton.class);
    bind(MasterTerminal.class).annotatedWith(BasementMaster.class).to(MasterTerminalImpl.class).in(Singleton.class);
  }
}
