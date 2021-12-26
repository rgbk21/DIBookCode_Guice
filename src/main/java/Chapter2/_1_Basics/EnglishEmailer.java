package Chapter2._1_Basics;

import Chapter2._1_Basics.annotations.BindingAnnotations.English;
import com.google.inject.Inject;

class EnglishEmailer implements Emailer {
  private final SpellChecker spellChecker;

  @Inject
  public EnglishEmailer(@English SpellChecker englishSpellChecker) {
    this.spellChecker = englishSpellChecker;
  }

  @Override
  public void send(String emailText) {
    System.out.println("In English Emailer class");
    spellChecker.validateText(emailText);
  }
}
