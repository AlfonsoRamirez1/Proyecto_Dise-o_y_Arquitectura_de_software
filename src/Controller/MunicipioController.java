package Controller;

import Clases_de_objetos.Municipio;
import Model.MunicipioModel;

public class MunicipioController {
    private MunicipioModel municipioModel;

    public MunicipioController() {
        municipioModel = new MunicipioModel();
    }

    public boolean registrarMunicipio(String nombre) {
        Municipio municipio = new Municipio.Builder()
                .setId(0) // o cualquier valor inicial apropiado
                .setNombre(nombre)
                .build();
        return municipioModel.registrarMunicipio(municipio);
    }

    public Municipio obtenerMunicipio(int id) {
        return municipioModel.obtenerMunicipioPorId(id);
    }
}