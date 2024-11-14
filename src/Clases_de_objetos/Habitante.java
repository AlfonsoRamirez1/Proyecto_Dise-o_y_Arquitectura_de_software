package Clases_de_objetos;

public class Habitante {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private Vivienda vivienda; // Cambiado a tipo Vivienda

    // Constructor
    public Habitante(int id, String nombre, String apellido, int edad, String genero, Vivienda vivienda) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.vivienda = vivienda;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Vivienda getVivienda() { return vivienda; }
    public void setVivienda(Vivienda vivienda) { this.vivienda = vivienda; }
}
