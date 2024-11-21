package Controller;

import Clases_de_objetos.Usuario;
import Model.UsuarioModel;

public class UsuarioController {
    private UsuarioModel usuarioModel;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
    }

    public boolean registrarUsuario(int id, String nombreUsuario, String contraseña, String rol) {
        Usuario usuario = new Usuario(id, nombreUsuario, contraseña, rol);
        return usuarioModel.registrarUsuario(usuario);
    }
}