package Controller;

import Clases_de_objetos.Usuario;
import Model.UsuarioModel;

public class UsuarioController {
    private UsuarioModel usuarioModel;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
    }

    public boolean registrarUsuario(int id, String nombreUsuario, String contraseña, String rol) {
        Usuario usuario = new Usuario.Builder()
                .setId(id)
                .setNombreUsuario(nombreUsuario)
                .setContraseña(contraseña)
                .setRol(rol)
                .build();
        return usuarioModel.registrarUsuario(usuario);
    }
}