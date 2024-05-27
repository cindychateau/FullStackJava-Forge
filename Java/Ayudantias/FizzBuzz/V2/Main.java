package V2;

public class Main {

    public static void main(String[] args) {
        String resultado = fizzBuzz(9);
        System.out.println(resultado);
        resultado = fizzBuzz(10);
        System.out.println(resultado);
        resultado = fizzBuzz(15);
        System.out.println(resultado);
        resultado = fizzBuzz(2);
        System.out.println(resultado);
    }

    public static String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return number + "";
        }
    }

}