package Chapter4.Rebinding.AdapterPattern;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static com.google.common.base.Preconditions.checkNotNull;

public class LongLived {
  private final Dependency dependency;

  @Inject
  LongLived(Dependency dependency) {
    this.dependency = checkNotNull(dependency);
  }

  public void compute() {
    dependency.calculate();
  }
}

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    LongLived longLived = injector.getInstance(LongLived.class);
    DependencyAdapter adapter = injector.getInstance(DependencyAdapter.class);
    longLived.compute(); // Using dependency A
    adapter.rebind();
    longLived.compute(); // Using dependency B
  }
}