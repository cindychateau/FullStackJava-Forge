public class Project {
    private String nombre;
    private String descripcion;
    private Double costo;

    public Project() {
        this.nombre = "";
        this.descripcion = "";
        this.costo = 0.0;
    }

    public Project(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
        this.costo = 0.0;
    }

    public Project(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = 0.0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }

    public String elevatorPitch() {
        return nombre + " (" + costo + "): " + descripcion;
    }
}
