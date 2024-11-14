package GUI.State;


import GUI.AdminWindow;

import javax.swing.*;
import java.awt.*;

public class TipoViviendaState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel tipoViviendaLabel = new JLabel("Registrar Tipo de Vivienda");
        gbc.gridx = 0; gbc.gridy = 0;
        adminWindow.add(tipoViviendaLabel, gbc);

        adminWindow.tipoViviendaNombreField = new JTextField(15);
        gbc.gridx = 0; gbc.gridy = 1;
        adminWindow.add(new JLabel("Nombre Tipo de Vivienda:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.tipoViviendaNombreField, gbc);

        JButton registrarTipoViviendaBtn = new JButton("Registrar Tipo de Vivienda");
        registrarTipoViviendaBtn.addActionListener(e -> register(adminWindow));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        adminWindow.add(registrarTipoViviendaBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreTipoVivienda = adminWindow.tipoViviendaNombreField.getText();
        boolean registrado = adminWindow.tipoViviendaController.registrarTipoVivienda(nombreTipoVivienda);
        adminWindow.mostrarMensaje(registrado, "Tipo de Vivienda");
    }
}
