package Chapter2._1_Basics;

import Chapter2._1_Basics.annotations.BindingAnnotations.French;
import com.google.inject.Inject;

class FrenchEmailer implements Emailer {
  private final SpellChecker spellChecker;

  @Inject
  public FrenchEmailer(@French SpellChecker englishSpellChecker) {
    this.spellChecker = englishSpellChecker;
  }

  @Override
  public void send(String emailText) {
    System.out.println("In French Emailer class");
    spellChecker.validateText(emailText);
  }
}
