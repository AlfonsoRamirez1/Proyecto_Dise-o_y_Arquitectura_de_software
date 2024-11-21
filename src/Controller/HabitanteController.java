package Controller;

import Clases_de_objetos.Habitante;
import Clases_de_objetos.Vivienda;
import Model.HabitanteModel;

public class HabitanteController {
    private HabitanteModel habitanteModel;

    public HabitanteController() {
        habitanteModel = new HabitanteModel();
    }

    public boolean registrarHabitante(String nombre, String apellido, int edad, String genero, Vivienda vivienda) {
        Habitante habitante = new Habitante(0, nombre, apellido, edad, genero, vivienda);
        return habitanteModel.registrarHabitante(habitante);
    }

    public Habitante obtenerHabitante(int id) {
        return habitanteModel.obtenerHabitantePorId(id);
    }
}