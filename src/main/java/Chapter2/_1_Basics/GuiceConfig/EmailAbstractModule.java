package Chapter2._1_Basics.GuiceConfig;

import Chapter2._1_Basics.Emailer;
import Chapter2._1_Basics.EnglishSpellChecker;
import Chapter2._1_Basics.FrenchSpellChecker;
import Chapter2._1_Basics.SpellChecker;
import com.google.inject.AbstractModule;

public class EmailAbstractModule extends AbstractModule {
  @Override
  protected void configure() {
    // Note that service binding in this case is more concise.
    // You don't have to do: binder.bind().to();
    bind(SpellChecker.class).to(FrenchSpellChecker.class);
  }
}
