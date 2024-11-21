package Clases_de_objetos;

public class Municipio {
    private int id;
    private String nombre;

    // Constructor privado para el Builder
    private Municipio(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }

    // Clase estática interna Builder
    public static class Builder {
        private int id;
        private String nombre;

        // Métodos Builder
        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Municipio build() {
            return new Municipio(this);
        }
    }
}