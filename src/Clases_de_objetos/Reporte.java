package Clases_de_objetos;

public class Reporte {
    private int id;
    private String tipoReporte;
    private String fechaGeneracion;
    private String datos;

    // Constructor privado para el Builder
    private Reporte(Builder builder) {
        this.id = builder.id;
        this.tipoReporte = builder.tipoReporte;
        this.fechaGeneracion = builder.fechaGeneracion;
        this.datos = builder.datos;
    }

    // Getters
    public int getId() { return id; }
    public String getTipoReporte() { return tipoReporte; }
    public String getFechaGeneracion() { return fechaGeneracion; }
    public String getDatos() { return datos; }

    // Clase estática interna Builder
    public static class Builder {
        private int id;
        private String tipoReporte;
        private String fechaGeneracion;
        private String datos;

        // Métodos Builder
        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTipoReporte(String tipoReporte) {
            this.tipoReporte = tipoReporte;
            return this;
        }

        public Builder setFechaGeneracion(String fechaGeneracion) {
            this.fechaGeneracion = fechaGeneracion;
            return this;
        }

        public Builder setDatos(String datos) {
            this.datos = datos;
            return this;
        }

        public Reporte build() {
            return new Reporte(this);
        }
    }
}