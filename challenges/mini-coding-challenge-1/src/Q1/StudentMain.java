package Q1;

import java.util.Arrays;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Yahan", 22),
                new Student("Amal", 19),
                new Student("Kamal", 25)
        );

        students.sort((a, b) -> a.name.compareTo(b.name));
        students.forEach(System.out::println);
    }
}
