package Chapter2._1_Basics.GuiceConfig;

import Chapter2._1_Basics.Emailer;
import Chapter2._1_Basics.EmailerIF;
import com.google.inject.AbstractModule;

public class EmailAbstractModule extends AbstractModule {
  @Override
  protected void configure() {
    // Note that service binding in this case is more concise.
    // You don't have to do: binder.bind().to();
    bind(EmailerIF.class).to(Emailer.class);
  }
}
