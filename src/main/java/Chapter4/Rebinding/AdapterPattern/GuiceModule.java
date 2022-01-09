package Chapter4.Rebinding.AdapterPattern;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(DependencyAdapter.class).in(Singleton.class);
    bind(Dependency.class).to(DependencyAdapter.class);
  }
}
