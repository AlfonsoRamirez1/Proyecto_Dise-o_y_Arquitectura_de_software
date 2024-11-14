package GUI.State;

import Clases_de_objetos.Vivienda;
import GUI.AdminWindow;

import javax.swing.*;
import java.awt.*;

public class HabitanteState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel habitanteLabel = new JLabel("Registrar Habitante");
        gbc.gridx = 0; gbc.gridy = 0;
        adminWindow.add(habitanteLabel, gbc);

        adminWindow.habitanteNombreField = new JTextField(15);
        adminWindow.habitanteApellidoField = new JTextField(15);
        adminWindow.habitanteEdadField = new JTextField(5);
        adminWindow.habitanteGeneroField = new JTextField(10);

        gbc.gridx = 0; gbc.gridy = 1;
        adminWindow.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.habitanteNombreField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        adminWindow.add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.habitanteApellidoField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        adminWindow.add(new JLabel("Edad:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.habitanteEdadField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        adminWindow.add(new JLabel("Género:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.habitanteGeneroField, gbc);

        JButton registrarHabitanteBtn = new JButton("Registrar Habitante");
        registrarHabitanteBtn.addActionListener(e -> register(adminWindow));
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        adminWindow.add(registrarHabitanteBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombre = adminWindow.habitanteNombreField.getText();
        String apellido = adminWindow.habitanteApellidoField.getText();
        int edad = Integer.parseInt(adminWindow.habitanteEdadField.getText());
        String genero = adminWindow.habitanteGeneroField.getText();

        Vivienda vivienda = null; // Debes enlazar a una vivienda existente
        boolean registrado = adminWindow.habitanteController.registrarHabitante(nombre, apellido, edad, genero, vivienda);
        adminWindow.mostrarMensaje(registrado, "Habitante");
    }
}
