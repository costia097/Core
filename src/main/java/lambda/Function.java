package lambda;

@FunctionalInterface
public interface Function {
    void fun();

    default void run() {
        System.out.println("run");
    }
}
