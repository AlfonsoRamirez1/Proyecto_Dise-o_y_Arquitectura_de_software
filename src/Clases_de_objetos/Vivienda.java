package Clases_de_objetos;

public class Vivienda {
    private int id;
    private String direccion;
    private TipoVivienda tipoVivienda; // Cambiado a tipo TipoVivienda
    private int numeroHabitantes;
    private String actividadesEconomicas;
    private Localidad localidad; // Cambiado a tipo Localidad

    // Constructor
    public Vivienda(int id, String direccion, TipoVivienda tipoVivienda, int numeroHabitantes, String actividadesEconomicas, Localidad localidad) {
        this.id = id;
        this.direccion = direccion;
        this.tipoVivienda = tipoVivienda;
        this.numeroHabitantes = numeroHabitantes;
        this.actividadesEconomicas = actividadesEconomicas;
        this.localidad = localidad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public TipoVivienda getTipoVivienda() { return tipoVivienda; }
    public void setTipoVivienda(TipoVivienda tipoVivienda) { this.tipoVivienda = tipoVivienda; }

    public int getNumeroHabitantes() { return numeroHabitantes; }
    public void setNumeroHabitantes(int numeroHabitantes) { this.numeroHabitantes = numeroHabitantes; }

    public String getActividadesEconomicas() { return actividadesEconomicas; }
    public void setActividadesEconomicas(String actividadesEconomicas) { this.actividadesEconomicas = actividadesEconomicas; }

    public Localidad getLocalidad() { return localidad; }
    public void setLocalidad(Localidad localidad) { this.localidad = localidad; }
}