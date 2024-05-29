import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class BasicJava {

    public static void imprimir1255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public static void impares() {
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

    public static void arreglos(ArrayList<Integer> numsArray) {
        for (int i = 0; i < numsArray.size(); i++) {
            System.out.println(numsArray.get(i));
        }
    }

    public static void arregloImpar() {
        ArrayList<Integer> numsInpar = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                numsInpar.add(i);
            }
        }
        System.out.println(numsInpar);
    }

    public static void mayorY(ArrayList<Integer> numsArray) {
        int contador = 0;
        int y = 3;
        for (int i = 0; i < numsArray.size(); i++) {
            if (numsArray.get(i) > y) {
                contador++;
            }
        }
        System.out.println(contador);
    }

    public static void cuadrado(ArrayList<Integer> numsArray) {
        for (int i = 0; i < numsArray.size(); i++) {
            numsArray.set(i, numsArray.get(i) * numsArray.get(i));
        }
        System.out.println(numsArray);
    }

    public static void eliminarNeg(ArrayList<Integer> numsArray) {
        for (int i = 0; i < numsArray.size(); i++) {
            if (numsArray.get(i) < 0) {
                numsArray.set(i, 0);
            }
        }
        System.out.println(numsArray);
    }

    public static int maximo(ArrayList<Integer> numsArray) {
        int max = numsArray.get(0);
        for (int i = 0; i < numsArray.size(); i++) {
            if (numsArray.get(i) > max) {
                max = numsArray.get(i);
            }
        }
        return max;
    }

    public static float promedio(ArrayList<Integer> numsArray) {
        float suma = 0;
        for (int i = 0; i < numsArray.size(); i++) {
            suma += numsArray.get(i);
        }
        return suma / numsArray.size();
    }

    public static int minimo(ArrayList<Integer> numsArray) {
        int min = numsArray.get(0);
        for (int i = 0; i < numsArray.size(); i++) {
            if (numsArray.get(i) < min) {
                min = numsArray.get(i);
            }
        }
        return min;
    }

    public static void minMaxAvg(ArrayList<Integer> numsArray) {
        int min = minimo(numsArray);
        int max = maximo(numsArray);
        int avg = Math.round(promedio(numsArray));
        Integer[] mmp = { min, max, avg };
        System.out.println(Arrays.toString(mmp));
    }

    // Extra
    public static void combinar(ArrayList<Integer> numsArray) {
        for (int i = 0; i < numsArray.size() - 1; i++) {
            numsArray.set(i, numsArray.get(i + 1));
        }
        numsArray.set(numsArray.size() - 1, 0);
        System.out.println(numsArray);
    }
}
