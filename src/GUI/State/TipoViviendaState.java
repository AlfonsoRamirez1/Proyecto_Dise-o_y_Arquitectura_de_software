package GUI.State;

import GUI.AdminWindow;
import GUI.Ventanas_interactivas.Tipos_de_Vivienda.TiposViviendaConsultaWindow;
import GUI.Ventanas_interactivas.Tipos_de_Vivienda.TiposViviendaEditarWindow;
import GUI.Ventanas_interactivas.Tipos_de_Vivienda.TiposViviendaEliminarWindow;

import javax.swing.*;
import java.awt.*;

public class TipoViviendaState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel tipoViviendaLabel = new JLabel("Registrar Tipo de Vivienda");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        adminWindow.add(tipoViviendaLabel, gbc);

        gbc.gridwidth = 1;

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

        JButton consultarTiposViviendaBtn = new JButton("Consultar Tipos de Vivienda");
        consultarTiposViviendaBtn.addActionListener(e -> openTiposViviendaWindow());
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        adminWindow.add(consultarTiposViviendaBtn, gbc);

        JButton editarTiposViviendaBtn = new JButton("Editar Tipos de Vivienda");
        editarTiposViviendaBtn.addActionListener(e -> openEditTiposViviendaWindow());
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        adminWindow.add(editarTiposViviendaBtn, gbc);

        JButton eliminarTiposViviendaBtn = new JButton("Eliminar Tipos de Vivienda");
        eliminarTiposViviendaBtn.addActionListener(e -> openDeleteTiposViviendaWindow());
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        adminWindow.add(eliminarTiposViviendaBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreTipoVivienda = adminWindow.tipoViviendaNombreField.getText();
        boolean registrado = adminWindow.tipoViviendaController.registrarTipoVivienda(nombreTipoVivienda);
        adminWindow.mostrarMensaje(registrado, "Tipo de Vivienda");
    }

    private void openTiposViviendaWindow() {
        TiposViviendaConsultaWindow tiposViviendaWindow = new TiposViviendaConsultaWindow();
        tiposViviendaWindow.setVisible(true);
    }

    private void openEditTiposViviendaWindow() {
        TiposViviendaEditarWindow tiposViviendaWindow = new TiposViviendaEditarWindow();
        tiposViviendaWindow.setVisible(true);
    }

    private void openDeleteTiposViviendaWindow() {
        TiposViviendaEliminarWindow tiposViviendaWindow = new TiposViviendaEliminarWindow();
        tiposViviendaWindow.setVisible(true);
    }
}