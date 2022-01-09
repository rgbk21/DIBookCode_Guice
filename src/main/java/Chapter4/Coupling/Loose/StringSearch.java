package Chapter4.Coupling.Loose;

import java.util.Collection;
import java.util.HashSet;

import static com.google.common.base.Preconditions.checkNotNull;

// An example of a class with loose coupling
public class StringSearch {
  private final Collection<String> collection;

  StringSearch(Collection<String> collection) {
    this.collection = checkNotNull(collection);
  }

  public String startsWith(String prefix) {
    for (String currStr : collection) {
      if (currStr.startsWith(prefix)) {
        return currStr;
      }
    }
    return null;
  }
}

class Test {
  public static void main(String[] args) {
    Collection<String> collection = new HashSet<>();
    StringSearch stringSearch = new StringSearch(collection);
    stringSearch.startsWith("asdf");
  }
}