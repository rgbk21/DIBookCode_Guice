package Chapter3.AssistedInject.WithoutUsingAnnotation;

/** Factory to help Guice build the objects. This factory will be injected wherever code requires
 * an instance of Deliverer object. */
public interface DelivererFactory {
  public Deliverer create(NewsLetter newsLetter, String date);
}
