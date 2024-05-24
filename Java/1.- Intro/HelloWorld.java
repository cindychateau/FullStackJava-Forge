class HelloWorld {

    public static void saludo() {
        System.out.println("Hola Mundo");
    }

    //Sobrecarga: más de un método con el mismo nombre, recibiendo parámetros distintos y teniendo comportamientos diferentes
    public static void saludo(String nombre){
        System.out.println("Hola "+nombre);
    }

    public static String saludo(String nombre, String apellido) {
        return "Hola "+nombre+" "+apellido;
    }

}