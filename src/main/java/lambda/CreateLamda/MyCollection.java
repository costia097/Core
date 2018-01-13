package lambda.CreateLamda;

public class MyCollection<T> {
    private static final Integer DEFAULT_SIZE = 10;
    private Object[] buckets = new Object[DEFAULT_SIZE];
    private Integer currentPosition = 0;

    public void add(T t) {
        buckets[currentPosition] = t;
        currentPosition++;
    }

    public void delete(Integer postion) {
        if (postion < DEFAULT_SIZE || postion > 0) {
            buckets[postion] = null;
        }
    }

    public void clean() {
        currentPosition = 0;
        buckets = new Object[DEFAULT_SIZE];
    }

}
