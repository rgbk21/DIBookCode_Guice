package Chapter4.Rebinding.AdapterPattern;

import com.google.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class DependencyAdapter implements Dependency, Rebindable {
  private final DependencyA dependencyA;
  private final DependencyB dependencyB;
  private boolean useA = true;

  @Inject
  public DependencyAdapter(DependencyA dependencyA, DependencyB dependencyB) {
    this.dependencyA = checkNotNull(dependencyA);
    this.dependencyB = checkNotNull(dependencyB);
  }

  @Override
  public void calculate() {
    if (useA) {
      dependencyA.doSomething();
    } else {
      dependencyB.doSomething();
    }
  }

  @Override
  public void rebind() {
    useA = false;
  }
}

interface Dependency {
  void calculate();
}

interface Rebindable {
  void rebind();
}

class DependencyA {
  public void doSomething() {
    System.out.println("Using Dependency A");
  }
}
class DependencyB {
  public void doSomething() {
    System.out.println("Using Dependency B");
  }
}