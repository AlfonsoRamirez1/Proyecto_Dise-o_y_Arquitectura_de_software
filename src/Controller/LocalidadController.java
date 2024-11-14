package Controller;

import Clases_de_objetos.Localidad;
import Model.LocalidadModel;

public class LocalidadController {
    private LocalidadModel localidadModel;

    public LocalidadController() {
        localidadModel = new LocalidadModel();
    }

    public boolean registrarLocalidad(String nombre) {
        // Aquí deberás manejar la obtención del objeto Municipio basado en ID
        Localidad localidad = new Localidad(0, nombre, null);
        return localidadModel.registrarLocalidad(localidad);
    }

    public Localidad obtenerLocalidad(int id) {
        return localidadModel.obtenerLocalidadPorId(id);
    }
}
