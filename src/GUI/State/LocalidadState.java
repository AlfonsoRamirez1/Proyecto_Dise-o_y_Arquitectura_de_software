package GUI.State;

import GUI.AdminWindow;

import javax.swing.*;
import java.awt.*;

public class LocalidadState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel localidadLabel = new JLabel("Registrar Localidad");
        gbc.gridx = 0; gbc.gridy = 0;
        adminWindow.add(localidadLabel, gbc);

        adminWindow.localidadNombreField = new JTextField(15);

        gbc.gridx = 0; gbc.gridy = 1;
        adminWindow.add(new JLabel("Nombre Localidad:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.localidadNombreField, gbc);

        JButton registrarLocalidadBtn = new JButton("Registrar Localidad");
        registrarLocalidadBtn.addActionListener(e -> register(adminWindow));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        adminWindow.add(registrarLocalidadBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreLocalidad = adminWindow.localidadNombreField.getText();
        boolean registrado = adminWindow.localidadController.registrarLocalidad(nombreLocalidad);
        adminWindow.mostrarMensaje(registrado, "Localidad");
    }
}
