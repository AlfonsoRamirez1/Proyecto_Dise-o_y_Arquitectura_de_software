package Controller;

import Clases_de_objetos.Municipio;
import Model.MunicipioModel;

public class MunicipioController {
    private MunicipioModel municipioModel;

    public MunicipioController() {
        municipioModel = new MunicipioModel();
    }

    public boolean registrarMunicipio(String nombre) {
        Municipio municipio = new Municipio(0, nombre); // Ajustado para usar solo dos parámetros
        return municipioModel.registrarMunicipio(municipio);
    }

    public Municipio obtenerMunicipio(int id) {
        return municipioModel.obtenerMunicipioPorId(id);
    }
}