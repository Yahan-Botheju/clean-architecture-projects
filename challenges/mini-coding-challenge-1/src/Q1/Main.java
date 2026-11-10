package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> usernames = new ArrayList<>(List.of(
                "admin",
                "user_yahan",
                "guest",
                "user_kamal",
                "test"
        ));

        usernames.removeIf(username -> !username.startsWith("user_"));
        usernames.forEach(username -> System.out.println(username));


        List<Double> prices = List.of(100.0,250.0,500.0,1200.0);

        prices.forEach(price ->
            System.out.println(price + price * 0.1)
        );
        prices.forEach(System.out::println);


        List<Integer> marks = Arrays.asList(45,85,32,90,67,12);

        marks.sort((a,b)->a.compareTo(b));
        marks.forEach(System.out::println);


        List<String> words = Arrays.asList("Spring", "Java", "Microservices", "API");

        words.sort((a,b) -> b.length()-a.length());
        words.forEach(System.out::println);
    }
}
