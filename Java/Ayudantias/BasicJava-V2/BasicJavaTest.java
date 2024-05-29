import java.util.Arrays;
import java.util.ArrayList;

public class BasicJavaTest {

    public static void main(String[] args) {

        Integer[] nums = { 3, 5, 1, 2, 1257, 9, 8, 0, 25, -32 };
        ArrayList<Integer> numsArray = new ArrayList<>(Arrays.asList(nums));

        BasicJava.imprimir1255();
        BasicJava.impares();
        BasicJava.suma();
        BasicJava.arreglos(numsArray);
        System.out.println(BasicJava.minimo(numsArray));
        System.out.println(BasicJava.maximo(numsArray));
        System.out.println(BasicJava.promedio(numsArray));
        BasicJava.arregloImpar();
        BasicJava.mayorY(numsArray);
        BasicJava.cuadrado(numsArray);
        BasicJava.eliminarNeg(numsArray);
        BasicJava.minMaxAvg(numsArray);
        BasicJava.combinar(numsArray);
    }
}