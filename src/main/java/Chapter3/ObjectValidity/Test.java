package Chapter3.ObjectValidity;

import com.google.common.base.Preconditions;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector();
    UnsafeObject unsafeObject = injector.getInstance(UnsafeObject.class);
    Preconditions.checkNotNull(unsafeObject);
  }
}
