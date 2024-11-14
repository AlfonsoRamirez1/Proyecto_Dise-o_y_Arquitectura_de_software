package Controller;

import Clases_de_objetos.Vivienda;
import Clases_de_objetos.TipoVivienda;
import Clases_de_objetos.Localidad;
import Model.ViviendaModel;

public class ViviendaController {
    private ViviendaModel viviendaModel;

    public ViviendaController() {
        viviendaModel = new ViviendaModel();
    }

    public boolean registrarVivienda(String direccion, TipoVivienda tipoVivienda, int numeroHabitantes, String actividadesEconomicas, Localidad localidad) {
        Vivienda vivienda = new Vivienda(0, direccion, tipoVivienda, numeroHabitantes, actividadesEconomicas, localidad);
        return viviendaModel.registrarVivienda(vivienda);
    }

    public Vivienda obtenerVivienda(int id) {
        return viviendaModel.obtenerViviendaPorId(id);
    }
}