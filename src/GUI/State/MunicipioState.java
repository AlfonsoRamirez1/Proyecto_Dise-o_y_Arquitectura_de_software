package GUI.State;

import GUI.AdminWindow;
import GUI.Ventanas_interactivas.Municipios.MunicipiosConsultaWindow;
import GUI.Ventanas_interactivas.Municipios.MunicipiosEditarWindow;
import GUI.Ventanas_interactivas.Municipios.MunicipiosEliminarWindow;

import javax.swing.*;
import java.awt.*;

public class MunicipioState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel municipioLabel = new JLabel("Registrar Municipio");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        adminWindow.add(municipioLabel, gbc);

        gbc.gridwidth = 1;

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

        JButton consultarMunicipiosBtn = new JButton("Consultar Municipios");
        consultarMunicipiosBtn.addActionListener(e -> openMunicipiosWindow());
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        adminWindow.add(consultarMunicipiosBtn, gbc);

        JButton editarMunicipiosBtn = new JButton("Editar Municipios");
        editarMunicipiosBtn.addActionListener(e -> openEditMunicipiosWindow());
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        adminWindow.add(editarMunicipiosBtn, gbc);

        JButton eliminarMunicipiosBtn = new JButton("Eliminar Municipios");
        eliminarMunicipiosBtn.addActionListener(e -> openDeleteMunicipiosWindow());
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        adminWindow.add(eliminarMunicipiosBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreMunicipio = adminWindow.municipioNombreField.getText();
        boolean registrado = adminWindow.municipioController.registrarMunicipio(nombreMunicipio);
        adminWindow.mostrarMensaje(registrado, "Municipio");
    }

    private void openMunicipiosWindow() {
        MunicipiosConsultaWindow municipiosWindow = new MunicipiosConsultaWindow();
        municipiosWindow.setVisible(true);
    }

    private void openEditMunicipiosWindow() {
        MunicipiosEditarWindow municipiosWindow = new MunicipiosEditarWindow();
        municipiosWindow.setVisible(true);
    }

    private void openDeleteMunicipiosWindow() {
        MunicipiosEliminarWindow municipiosWindow = new MunicipiosEliminarWindow();
        municipiosWindow.setVisible(true);
    }
}