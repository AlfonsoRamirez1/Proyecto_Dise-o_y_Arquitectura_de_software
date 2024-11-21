package Clases_de_objetos;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String contraseña;
    private String rol;

    // Constructor privado para el Builder
    private Usuario(Builder builder) {
        this.id = builder.id;
        this.nombreUsuario = builder.nombreUsuario;
        this.contraseña = builder.contraseña;
        this.rol = builder.rol;
    }

    // Getters
    public int getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getContraseña() { return contraseña; }
    public String getRol() { return rol; }

    // Clase estática interna Builder
    public static class Builder {
        private int id;
        private String nombreUsuario;
        private String contraseña;
        private String rol;

        // Métodos Builder
        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        public Builder setContraseña(String contraseña) {
            this.contraseña = contraseña;
            return this;
        }

        public Builder setRol(String rol) {
            this.rol = rol;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}