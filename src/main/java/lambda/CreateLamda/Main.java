package lambda.CreateLamda;

import java.util.Collections;

public class Main {

    @FunctionalInterface
    private interface Check {
        void doSome();
        default void doSomeWork(){
            System.out.println(" i am default");
        }
    }

    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<>();
        Checky<String,String> checky = s -> {
            String res =  s + "AA";
            System.out.println(res);
            return res;
        };
        checky.doSomeWork();
    }
}
