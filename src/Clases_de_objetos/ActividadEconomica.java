package Clases_de_objetos;

public class ActividadEconomica {
    private int id;
    private String nombreActividad;

    // Constructor privado para el Builder
    private ActividadEconomica(Builder builder) {
        this.id = builder.id;
        this.nombreActividad = builder.nombreActividad;
    }

    // Getters
    public int getId() { return id; }
    public String getNombreActividad() { return nombreActividad; }

    // Clase estática interna Builder
    public static class Builder {
        private int id;
        private String nombreActividad;

        // Métodos Builder
        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNombreActividad(String nombreActividad) {
            this.nombreActividad = nombreActividad;
            return this;
        }

        public ActividadEconomica build() {
            return new ActividadEconomica(this);
        }
    }
}