/*
PascalCase - CadaPalabraVaConMayuscula -> Nombre de archivos y nombres de clases
camelCase - primeraLetraMinRestoMayus -> Nombres de variables y nombres de métodos

javac NombreArchivo.java -> compilar
java NombreArchivo -> interpretar/ejecutar
 */
import java.util.ArrayList;
import java.util.HashMap;
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

        impresion();
        int resultado = sumatoria(5, 3); // return de sumatoria
        System.out.println(resultado);

        //ARREGLOS / ARRAY / LISTAS: Estructura de datos en la cual podemos guardar valores en distintos índices. Lista de valores
        //Todos los valores deben de tener el mismo tipo de dato
        int[] arreglo; //Declaración
        arreglo = new int[5]; //Inicialización
        arreglo[0] = 4; //Asignación de valor
        arreglo[1] = 8;
        arreglo[2] = 8;
        arreglo[3] = 5;
        arreglo[4] = 9;

        int[] arreglo2 = {4, 8, 8, 5, 9}; //declaración, inicialización y asignación
        System.out.println(arreglo2[2]);

        //ArrayList -> Arreglo dinámico
        ArrayList<Integer> arreglo3 = new ArrayList<Integer>(); //Declaración e Inic
        arreglo3.add(10);
        arreglo3.add(20);
        arreglo3.add(30);
        //.toString() -> permite imprimirlo facilmente
        System.out.println(arreglo3);
        System.out.println(arreglo3.get(2)); //arreglo3[2]

        int dia = 2;
        switch(dia) {
            case 1:
                System.out.println("Lunes");
                break; //Salimos por completo del switch
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break; 
            case 4:
                System.out.println("Jueves");
                break;   
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Solo tenemos 7 días!");
                break;
        }

        /* BUCLES */
        for(int j=0; j<5; j++) { //inicialización; condicional; paso
            System.out.println("hey!");
        }

        int i = 0;
        while(i < 5) { //Primero pregunta por la condicional
            System.out.println("oh!");
            i++;
        }

        int m = 10;
        do { //Primero hace las cosas y al final compara con la condicional
            System.out.println("let's go!");
        } while(m < 5);

        /*
        estudiante = {
            "nombre": "Elena",
            "apellido": "De Troya"
        } 
        Javascript: objeto. Python: diccionario
         */
        HashMap<String, String> estudiante = new HashMap<String, String>();
        estudiante.put("nombre", "Elena");
        estudiante.put("apellido", "De Troya");
        estudiante.put("curso", "Java");
        System.out.println(estudiante.get("nombre"));

    }



    //Permiso función: public, private, protected
    //static: es de mi clase. (Más detalle en la sesión OOP)
    //tipo de valor de retorno: String int double. No hay valor de retorno: void
    //nombreFuncion(parametros a recibir)
    public static int sumatoria(int num1, int num2) {
        return num1+num2;
    }

    private static String hola(String nombre){
        return "Hola "+nombre;
    }

    public static void impresion() {
        System.out.println("Entro al metodo");
    }

}
