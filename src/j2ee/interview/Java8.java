package j2ee.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Java8 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Avinash", "Abhinav", "Krishna", "Vishnu", "Sie");

        // Predicate: Takes one argument and returns boolean value
        Predicate<String> predicate = (str) -> str.startsWith("A");
        names.stream().filter(predicate).forEach(System.out::println);

        Consumer<String> consumer = (str) -> {
            if (str.startsWith("A")) {
                System.out.println(str);
            }
        };
        names.forEach(i -> consumer.accept(i));

        BiConsumer<String, String> biConsumer = (str1, str2) -> {
            if (str1.startsWith("A") && str2.startsWith("H")) {
                System.out.println(str2 + " " + str1);
            }
        };

        names.forEach(i -> biConsumer.accept(i, "Hello"));

        Function<String, String> function = (str) -> {
            if (str.startsWith("A")) {
                return str;
            }
            return null;
        };

        names.forEach(i -> System.out.println(function.apply(i)));

        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());
    }
}
