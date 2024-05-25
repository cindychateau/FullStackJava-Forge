package V1;

public class Main {

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        String resultado = fb.fizzBuzz(9);
        System.out.println(resultado);
        resultado = fb.fizzBuzz(10);
        System.out.println(resultado);
        resultado = fb.fizzBuzz(15);
        System.out.println(resultado);
        resultado = fb.fizzBuzz(2);
        System.out.println(resultado);
    }

}