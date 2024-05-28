class Vehiculo {

    //Atributos o Variables miembro
    private int anio;
    private String marca;
    private String modelo;
    private String color;
    private int ruedas;

    //Variable estática: se comparte ante todas las instancias y es propia de la clase y no de un objeto específico
    private static int cantidadVehiculos = 0;

    /* Método Constructor: es el encargado de inicializar mi objeto */
    public Vehiculo() {
        //NO inicializo ningún valor
        cantidadVehiculos++;
    }

    /* SOBRECARGA de métodos constructores 
    this = auto3
    anio = 1991
    marca = Renault
    modelo = 12
    color = naranja
    ruedas = 4
    */
    public Vehiculo(int anio, String marca, String modelo, String color, int ruedas){
        //auto3.anio = 1991
        this.anio = anio; 
        //auto3.marca = Renault
        this.marca = marca;
        //auto3.modelo = 12
        this.modelo = modelo;
        //auto3.color = naranja
        this.color = color;
        //auto3.ruedas = 4
        this.ruedas = ruedas;
        cantidadVehiculos++;
    }

    public Vehiculo(int anio, String marca, String modelo, int ruedas){
        this.anio = anio; 
        this.marca = marca;
        this.modelo = modelo;
        this.color = "blanco";
        this.ruedas = ruedas;
        cantidadVehiculos++;
    }

    //Método de los objetos Vehiculo
    public String toString() {
        return "{Anio:"+this.anio+"\n Modelo:"+this.modelo+"\n Marca:"+this.marca+" \nColor:"+this.color+"\n Ruedas:"+this.ruedas+"}";
    }

    /* Como mis atributos son privados, necesito métodos Getters y Setters. Get se encarga de obtener la info. Set se encarga de guardar nueva info */

    public int getAnio() {
        return anio;
    }

    //anio = 2001
    public void setAnio(int anio){
        this.anio = anio; //auto1.anio = 2001
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getRuedas(){
        return ruedas;
    }

    public void setRuedas(int ruedas){
        this.ruedas = ruedas;
    }

    /*Método estatico: propio de la clase y NO de un objeto específico */
    public static int getCantidadVehiculos(){
        return cantidadVehiculos;
    }

}