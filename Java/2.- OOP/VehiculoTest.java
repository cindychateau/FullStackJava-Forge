class VehiculoTest {

    public static void main(String[] args){

        //Crear un nuevo vehiculo
        Vehiculo auto1 = new Vehiculo();
        //auto1.anio = 2001;
        auto1.setAnio(2001);
        //auto1.marca = "Honda";
        auto1.setMarca("Honda");
        //auto1.modelo = "Civic";
        auto1.setModelo("Civic");
        //auto1.color = "blanco";
        auto1.setColor("blanco");
        //auto1.ruedas = 4;
        auto1.setRuedas(4);

        System.out.println("Marca auto1:"+auto1.getMarca());

        //nuevo Vehiculo
        Vehiculo auto2 = new Vehiculo();
        //auto2.anio = 2002;
        auto2.setAnio(2002);
        //auto2.marca = "Toyota";
        auto2.setMarca("Toyota");
        //auto2.modelo = "Supra";
        auto2.setModelo("Supra");
        //auto2.color = "azul";
        auto2.setColor("azul");
        //auto2.ruedas = 4;
        auto2.setRuedas(4);

        System.out.println("Modelo auto2:"+auto2.getModelo());

        Vehiculo auto3 = new Vehiculo(1991, "Renault","12", "naranja", 4);

        Vehiculo auto4 = new Vehiculo(2024, "BMW", "M4", "negro", 4);

        System.out.println("Color auto3:"+auto3.getColor());

        System.out.println("Marca auto4:"+auto4.getMarca());

        Vehiculo moto1 = new Vehiculo(1998, "Yamaha", "YZF-R1", 2); //Defecto color = "blanco"
        System.out.println("Color moto1:"+moto1.getColor());

        System.out.println(moto1);
        System.out.println(auto4); //Ante un obj busca el método toString.

        System.out.println("Total de vehiculos:"+Vehiculo.getCantidadVehiculos());

    }

}