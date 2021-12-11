package Chapter2._1_Basics.GuiceConfig;

import Chapter2._1_Basics.Dict;
import Chapter2._1_Basics.Emailer;
import Chapter2._1_Basics.EmailerIF;
import Chapter2._1_Basics.SpellChecker;
import com.google.inject.Binder;
import com.google.inject.Module;

public class EmailModule implements Module {
  @Override
  public void configure(Binder binder) {
    // Register keys/services explicitly
    // This statement does essentially nothing; it "binds the Emailer class to itself" and does not change Guice's default behavior.
    // You may still want to use this if you prefer your Module class to serve as an explicit manifest for the services it provides.
    // Also, in rare cases, Guice may be unable to validate a binding at injector creation time unless it is given explicitly.
    // Source: https://google.github.io/guice/api-docs/3.0/javadoc/com/google/inject/Binder.html
    binder.bind(Emailer.class);
    binder.bind(SpellChecker.class);
    binder.bind(Dict.class);
    binder.bind(EmailerIF.class).to(Emailer.class);
  }
}
