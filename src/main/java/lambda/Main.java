package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Map.Entry<Character, Integer>> collect = list.stream().map(Object::getClass)
                .map(Class::getAnnotations)
                .map(annotations -> annotations.length)
                .peek(Integer::byteValue)
                .map(Object::toString)
                .collect(Collectors.groupingBy(o -> o.charAt(0)))
                .entrySet().stream().map(Map.Entry::getKey)
                .collect(Collectors.toMap(Character::charValue, Object::hashCode))
                .entrySet()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
