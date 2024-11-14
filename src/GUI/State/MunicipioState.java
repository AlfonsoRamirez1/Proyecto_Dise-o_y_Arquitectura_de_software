package GUI.State;

import GUI.AdminWindow;

import javax.swing.*;
import java.awt.*;

public class MunicipioState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel municipioLabel = new JLabel("Registrar Municipio");
        gbc.gridx = 0; gbc.gridy = 0;
        adminWindow.add(municipioLabel, gbc);

        adminWindow.municipioNombreField = new JTextField(15);
        gbc.gridx = 0; gbc.gridy = 1;
        adminWindow.add(new JLabel("Nombre Municipio:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.municipioNombreField, gbc);

        JButton registrarMunicipioBtn = new JButton("Registrar Municipio");
        registrarMunicipioBtn.addActionListener(e -> register(adminWindow));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        adminWindow.add(registrarMunicipioBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreMunicipio = adminWindow.municipioNombreField.getText();
        boolean registrado = adminWindow.municipioController.registrarMunicipio(nombreMunicipio);
        adminWindow.mostrarMensaje(registrado, "Municipio");
    }
}
