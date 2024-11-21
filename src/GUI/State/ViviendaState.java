package GUI.State;

import Clases_de_objetos.Localidad;
import Clases_de_objetos.TipoVivienda;
import GUI.AdminWindow;
import GUI.Ventanas_interactivas.Vivienda.ViviendasConsultaWindow;
import GUI.Ventanas_interactivas.Vivienda.ViviendasEditarWindow;
import GUI.Ventanas_interactivas.Vivienda.ViviendasEliminarWindow;

import javax.swing.*;
import java.awt.*;

public class ViviendaState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel viviendaLabel = new JLabel("Registrar Vivienda");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        adminWindow.add(viviendaLabel, gbc);

        gbc.gridwidth = 1;

        adminWindow.viviendaDireccionField = new JTextField(15);
        adminWindow.viviendaNumHabitantesField = new JTextField(5);
        adminWindow.viviendaActividadesField = new JTextField(15);

        gbc.gridx = 0; gbc.gridy = 1;
        adminWindow.add(new JLabel("Dirección:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.viviendaDireccionField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        adminWindow.add(new JLabel("Número de Habitantes:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.viviendaNumHabitantesField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        adminWindow.add(new JLabel("Actividades Económicas:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.viviendaActividadesField, gbc);

        JButton registrarViviendaBtn = new JButton("Registrar Vivienda");
        registrarViviendaBtn.addActionListener(e -> register(adminWindow));
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        adminWindow.add(registrarViviendaBtn, gbc);

        // Añadir el botón para consultar viviendas
        JButton consultarViviendasBtn = new JButton("Consultar Viviendas");
        consultarViviendasBtn.addActionListener(e -> openViviendasWindow());
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        adminWindow.add(consultarViviendasBtn, gbc);

        // Añadir el botón para editar viviendas
        JButton editarViviendasBtn = new JButton("Editar Viviendas");
        editarViviendasBtn.addActionListener(e -> openEditViviendasWindow());
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        adminWindow.add(editarViviendasBtn, gbc);

        // Añadir el botón para eliminar viviendas
        JButton eliminarViviendasBtn = new JButton("Eliminar Viviendas");
        eliminarViviendasBtn.addActionListener(e -> openDeleteViviendasWindow());
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 2;
        adminWindow.add(eliminarViviendasBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String direccion = adminWindow.viviendaDireccionField.getText();
        int numHabitantes = Integer.parseInt(adminWindow.viviendaNumHabitantesField.getText());
        String actividades = adminWindow.viviendaActividadesField.getText();

        TipoVivienda tipoVivienda = null; // Aquí debes enlazar al tipo de vivienda correspondiente
        Localidad localidad = null; // Aquí debes enlazar a la localidad correspondiente

        boolean registrado = adminWindow.viviendaController.registrarVivienda(direccion, tipoVivienda, numHabitantes, actividades, localidad);
        adminWindow.mostrarMensaje(registrado, "Vivienda");
    }

    private void openViviendasWindow() {
        ViviendasConsultaWindow viviendasWindow = new ViviendasConsultaWindow();
        viviendasWindow.setVisible(true);
    }

    private void openEditViviendasWindow() {
        ViviendasEditarWindow viviendasWindow = new ViviendasEditarWindow();
        viviendasWindow.setVisible(true);
    }

    private void openDeleteViviendasWindow() {
        ViviendasEliminarWindow viviendasWindow = new ViviendasEliminarWindow();
        viviendasWindow.setVisible(true);
    }
}