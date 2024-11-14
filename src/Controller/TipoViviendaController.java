package Controller;

import Clases_de_objetos.TipoVivienda;
import Model.TipoViviendaModel;

public class TipoViviendaController {
    private TipoViviendaModel tipoViviendaModel;

    public TipoViviendaController() {
        tipoViviendaModel = new TipoViviendaModel();
    }

    public boolean registrarTipoVivienda(String nombre) {
        TipoVivienda tipo = new TipoVivienda(0, nombre);
        return tipoViviendaModel.registrarTipoVivienda(tipo);
    }

    public TipoVivienda obtenerTipoVivienda(int id) {
        return tipoViviendaModel.obtenerTipoViviendaPorId(id);
    }
}
