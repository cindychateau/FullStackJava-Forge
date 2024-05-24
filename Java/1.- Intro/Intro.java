/*
PascalCase - CadaPalabraVaConMayuscula -> Nombre de archivos y nombres de clases
camelCase - primeraLetraMinRestoMayus -> Nombres de variables y nombres de métodos

javac NombreArchivo.java -> compilar
java NombreArchivo -> interpretar/ejecutar
 */
public class Intro {

    /*Método principal: el que se ejecuta al hacer la ejecución del archivo */
    public static void main(String[] args){
        System.out.println("¡Hola mundo!");

        //Variables Primitivas -> Que solo guardan el valor
        int numero = 1; //int es un número entero
        double pi = 3.14159; //double es un número con decimales
        boolean bool = true; //boolean = true o false
        char unCaracter = 'A'; // char es un solo caracter

        //Variables de tipo Objeto -> Guardar el valor, tienen métodos pre-fabricados que me complementan
        Integer numeroObjeto = 100;
        Double numeroDoble = 5.55; //número con puntos decimales
        Character unCaracterObj = 'A';
        String abc = "ABC"; //cadena de caracteres

        System.out.println(numero);
        numero++;
        System.out.println(numero);

        /* Cadenas o Stringss */
        String cadena = "Buenos dias a todos mis Compañeros";
        System.out.println( cadena.length() ); //La cantidad de caracteres en mi cadena
        char letra = cadena.charAt(1);
        System.out.println(letra);
        
        int a = cadena.indexOf("Buenos"); //el indice en donde se encuentra la palabra
        int b = cadena.indexOf("todos"); // 14
        int c = cadena.indexOf("Todos"); // -1 no encuentra la palabra
        System.out.println(a+" "+ b+" "+ c); //Concantenamos dos o + textos

        System.out.println(cadena.toLowerCase());
        System.out.println(cadena.toUpperCase());

        String str1 = "Buenos dias";
        String str2 = " alegria";
        System.out.println(str1.concat(str2)); // Concatenar 2 textos

        String x = "hola";
        String y = "Hola";
        System.out.println(x.equals(y)); // Comparación -> true o false 
        System.out.println(x.equalsIgnoreCase(y)); //Ignorando mayúsculas

        numero = numeroObjeto;

        /*
        CONDICIONALES
         */
        if(numero == 100) { // == != > >= < <=
            System.out.println("Numeros iguales");
        } else {
            System.out.println("Numeros distintos");
        }

        int edadInfante = 3;
        if(edadInfante < 2) {
            System.out.println("Es un bebe");
        } else if(edadInfante < 4) {
            System.out.println("Es un toddler");
        } else {
            System.out.println("Es un niño");
        }

        boolean estaLloviendo = false; //NO está lloviendo
        int temperatura = 20;
        // && : AND implica que AMBAS condicionales deben cumplirse
        if(temperatura > 18 && !estaLloviendo) {
            System.out.println("Demos un paseo!");
        }

        int edad = 16;
        boolean permisoPadres = true;
        if(edad >= 18 || permisoPadres ) {
            System.out.println("Puedes obtener tu licencia de conducir");
        }

    }

}
