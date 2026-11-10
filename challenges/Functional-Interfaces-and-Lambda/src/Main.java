

public class Main {
    public static void main(String[] args) {
       //addition
       Calculator addition = (a, b) -> a + b;
       System.out.println(addition.calculate(1,2));

       //subtract
       Calculator subtraction = (a, b) -> a - b;
       System.out.println(subtraction.calculate(2,3));

       //multiplication
        Calculator multiplication = (a, b) -> a * b;
        System.out.println(multiplication.calculate(4,5));

        //division
        Calculator division = (a, b) -> a / b;
        System.out.println(division.calculate(3,4));
    }
}