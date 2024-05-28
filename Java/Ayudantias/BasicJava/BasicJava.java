import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    static ArrayList<Integer> numsArray = new ArrayList<>(Arrays.asList(3, 5, 1, 2, 1257, 9, 8, 0, 25, -32));

    public static void imprimir1255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public static void inpares() {
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void suma() {
        int acumulador = 0;
        for (int i = 0; i <= 255; i++) {
            acumulador += i;
            System.out.println("Nuevo numero: " + i + " Suma: " + acumulador);
        }
    }

    public static void arreglos() {
        // Integer[] nums = {3,5,1,2,7,9,8,13,25,32};
        // ArrayList<Integer> numsArray = new ArrayList<>(Arrays.asList(nums1));
        for (int i = 0; i < numsArray.size(); i++) {
            System.out.println(numsArray.get(i));
        }
    }

    public static void maximo() {
        int max = numsArray.get(0);
        for (int i = 0; i < numsArray.size(); i++) {
            if (numsArray.get(i) > max) {
                max = numsArray.get(i);
            }
        }
        System.out.println(max);
    }

    public static void promedio() {
        float suma = 0;
        for (int i = 0; i < numsArray.size(); i++) {
            suma += numsArray.get(i);
        }
        System.out.println("Promedio: " + suma / numsArray.size());
    }

    public static void arregloInpar() {
        ArrayList<Integer> numsInpar = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                numsInpar.add(i);
            }
        }
        System.out.println(numsInpar);
    }
}
