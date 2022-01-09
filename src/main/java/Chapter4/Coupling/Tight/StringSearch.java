package Chapter4.Coupling.Tight;

import java.util.HashSet;
import java.util.Iterator;

import static com.google.common.base.Preconditions.checkNotNull;

// An example of a class with tight coupling
public class StringSearch {
  private final HashSet<String> set;

  StringSearch(HashSet<String> set) {
    this.set = checkNotNull(set);
  }

  public String startsWith(String prefix) {
    for (String currStr : set) {
      if (currStr.startsWith(prefix)) {
        return currStr;
      }
    }
    return null;
  }
}

class Test {
  public static void main(String[] args) {
    HashSet<String> strings = new HashSet<>();
    StringSearch stringSearch = new StringSearch(strings);
    stringSearch.startsWith("asdf");
  }
}