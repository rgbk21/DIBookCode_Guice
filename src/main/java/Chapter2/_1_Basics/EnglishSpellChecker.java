package Chapter2._1_Basics;

import com.google.inject.Inject;

public class EnglishSpellChecker implements SpellChecker {
  private final Dict dictionary;

  @Inject
  public EnglishSpellChecker(Dict dictionary) {
    this.dictionary = dictionary;
  }

  @Override
  public boolean validateText(String emailText) {
    dictionary.isValidText(emailText);
    System.out.println("In English Spell Checker");
    return true;
  }
}
