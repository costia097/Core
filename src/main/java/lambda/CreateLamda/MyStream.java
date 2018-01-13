package lambda.CreateLamda;

public interface MyStream<T> {

    void map(Checky<? super T,?> check);

    default void doSome() {
        System.out.println("A");
    }
}
