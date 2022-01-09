package Chapter4.Rebinding.SimpleWay;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import static com.google.common.base.Preconditions.checkNotNull;

public class LongLived {
  private final DependencyA dependencyA;
  private final DependencyB dependencyB;
  private boolean useDependencyA = true;

  @Inject
  LongLived(DependencyA dependencyA, DependencyB dependencyB) {
    this.dependencyA = checkNotNull(dependencyA);
    this.dependencyB = checkNotNull(dependencyB);
  }

  public void rebind() {
    useDependencyA = false;
  }

  public void compute() {
    if (useDependencyA) {
      dependencyA.doSomething();
    } else {
      dependencyB.doSomething();
    }
  }
}

class DependencyA {
  public void doSomething() {
    System.out.println("Using dependency A to perform ops");
  }
}
class DependencyB {
  public void doSomething() {
    System.out.println("Using dependency B to perform ops");
  }
}

class Test {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector();
    LongLived longLived = injector.getInstance(LongLived.class);
    longLived.compute(); // Using dependency A to perform ops
    longLived.rebind();
    longLived.compute(); // Using dependency B to perform ops
  }
}