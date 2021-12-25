package Chapter2._1_Basics;

import com.google.inject.Inject;

public class FrenchSpellChecker implements SpellChecker {
  private final Dict dictionary;

  @Inject
  public FrenchSpellChecker(Dict dictionary) {
    this.dictionary = dictionary;
  }

  @Override
  public boolean validateText(String emailText) {
    dictionary.isValidText(emailText);
    System.out.println("In French Spell Checker");
    return true;
  }
}
