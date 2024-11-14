package Clases_de_objetos;

public class Localidad {
    private int id;
    private String nombre;
    private Municipio municipio; // Cambiado a tipo Municipio

    // Constructor
    public Localidad(int id, String nombre, Municipio municipio) {
        this.id = id;
        this.nombre = nombre;
        this.municipio = municipio;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Municipio getMunicipio() { return municipio; }
    public void setMunicipio(Municipio municipio) { this.municipio = municipio; }
}
