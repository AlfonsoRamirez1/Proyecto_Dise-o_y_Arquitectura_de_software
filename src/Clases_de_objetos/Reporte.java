package Clases_de_objetos;

public class Reporte {
    private int id;
    private String tipoReporte;
    private String fechaGeneracion;
    private String datos;

    // Constructor
    public Reporte(int id, String tipoReporte, String fechaGeneracion, String datos) {
        this.id = id;
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.datos = datos;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoReporte() { return tipoReporte; }
    public void setTipoReporte(String tipoReporte) { this.tipoReporte = tipoReporte; }

    public String getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(String fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public String getDatos() { return datos; }
    public void setDatos(String datos) { this.datos = datos; }
}
