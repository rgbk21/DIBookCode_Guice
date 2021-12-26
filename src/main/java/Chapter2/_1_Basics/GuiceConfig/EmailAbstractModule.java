package Chapter2._1_Basics.GuiceConfig;

import Chapter2._1_Basics.EnglishSpellChecker;
import Chapter2._1_Basics.FrenchSpellChecker;
import Chapter2._1_Basics.SpellChecker;
import Chapter2._1_Basics.annotations.BindingAnnotations.French;
import Chapter2._1_Basics.annotations.BindingAnnotations.English;
import com.google.inject.AbstractModule;

public class EmailAbstractModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(SpellChecker.class).annotatedWith(English.class).to(EnglishSpellChecker.class);
    bind(SpellChecker.class).annotatedWith(French.class).to(FrenchSpellChecker.class);
  }
}
