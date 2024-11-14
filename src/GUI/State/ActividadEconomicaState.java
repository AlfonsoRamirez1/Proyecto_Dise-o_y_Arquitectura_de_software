package GUI.State;

import GUI.AdminWindow;

import javax.swing.*;
import java.awt.*;

public class ActividadEconomicaState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel actividadLabel = new JLabel("Registrar Actividad Económica");
        gbc.gridx = 0; gbc.gridy = 0;
        adminWindow.add(actividadLabel, gbc);

        adminWindow.actividadNombreField = new JTextField(15);
        gbc.gridx = 0; gbc.gridy = 1;
        adminWindow.add(new JLabel("Nombre Actividad:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.actividadNombreField, gbc);

        JButton registrarActividadBtn = new JButton("Registrar Actividad");
        registrarActividadBtn.addActionListener(e -> register(adminWindow));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        adminWindow.add(registrarActividadBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreActividad = adminWindow.actividadNombreField.getText();
        boolean registrado = adminWindow.actividadEconomicaController.registrarActividadEconomica(nombreActividad);
        adminWindow.mostrarMensaje(registrado, "Actividad Económica");
    }
}
