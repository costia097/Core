package lambda.CreateLamda;

@FunctionalInterface
public interface Checky<T,R> {

    R doSome(T t);

    default void doSomeWork(){
        System.out.println(" i am default");
    }

}
