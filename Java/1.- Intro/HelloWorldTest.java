class HelloWorldTest {

    public static void main(String[] args){

        //variable del tipo HelloWorld
        HelloWorld hw = new HelloWorld();
        hw.saludo();
        hw.saludo("Elena");
        System.out.println(hw.saludo("Juana", "De Arco"));
    }

}