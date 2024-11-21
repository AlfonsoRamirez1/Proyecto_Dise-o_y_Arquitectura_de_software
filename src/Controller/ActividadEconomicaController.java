package Controller;

import Clases_de_objetos.ActividadEconomica;
import Model.ActividadEconomicaModel;

public class ActividadEconomicaController {
    private ActividadEconomicaModel actividadEconomicaModel;

    public ActividadEconomicaController() {
        actividadEconomicaModel = new ActividadEconomicaModel();
    }

    public boolean registrarActividadEconomica(String nombreActividad) {
        ActividadEconomica actividad = new ActividadEconomica(0, nombreActividad); // Ajustado para usar dos parámetros
        return actividadEconomicaModel.registrarActividadEconomica(actividad);
    }

    public ActividadEconomica obtenerActividadEconomica(int id) {
        return actividadEconomicaModel.obtenerActividadEconomicaPorId(id);
    }
}