package Chapter2._1_Basics;

import com.google.inject.Inject;

public class SpellChecker {
  private Dict dictionary;

  @Inject
  SpellChecker(Dict dictionary) {
    this.dictionary = dictionary;
  }

  public boolean validateText(String emailText) {
    System.out.println("Validating email text:" + emailText);
    return dictionary.isValidText(emailText);
  }
}
