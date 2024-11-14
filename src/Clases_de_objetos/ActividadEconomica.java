package Clases_de_objetos;

public class ActividadEconomica {
    private int id;
    private String nombreActividad;

    // Constructor
    public ActividadEconomica(int id, String nombreActividad) {
        this.id = id;
        this.nombreActividad = nombreActividad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreActividad() { return nombreActividad; }
    public void setNombreActividad(String nombreActividad) { this.nombreActividad = nombreActividad; }
}
