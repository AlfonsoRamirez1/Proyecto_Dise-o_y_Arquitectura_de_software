package GUI.State;

import GUI.AdminWindow;
import GUI.Ventanas_interactivas.Actividades_economicas.ActividadesEconomicasConsultaWindow;
import GUI.Ventanas_interactivas.Actividades_economicas.ActividadesEconomicasEditarWindow;
import GUI.Ventanas_interactivas.Actividades_economicas.ActividadesEconomicasEliminarWindow;

import javax.swing.*;
import java.awt.*;

public class ActividadEconomicaState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel actividadLabel = new JLabel("Registrar Actividad Económica");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2; // Asegurarse de que el título ocupe dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el título
        adminWindow.add(actividadLabel, gbc);

        gbc.gridwidth = 1; // Resetear el gridwidth para los demás componentes

        adminWindow.actividadNombreField = new JTextField(15);

        // Configuración para la etiqueta del nombre de la actividad
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START; // Alineación de la etiqueta a la izquierda
        gbc.insets = new Insets(0, 0, 5, 5); // Relleno: margen entre componentes
        adminWindow.add(new JLabel("Nombre Actividad:"), gbc);

        // Configuración para el cuadro de texto del nombre de la actividad
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START; // Alineación del campo de texto a la izquierda
        gbc.insets = new Insets(0, 0, 5, 0);
        adminWindow.add(adminWindow.actividadNombreField, gbc);

        JButton registrarActividadBtn = new JButton("Registrar Actividad");
        registrarActividadBtn.addActionListener(e -> register(adminWindow));

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el botón
        adminWindow.add(registrarActividadBtn, gbc);

        // Agregar botones para consultar, editar y eliminar actividades económicas
        JButton consultarActividadesBtn = new JButton("Consultar Actividades");
        consultarActividadesBtn.addActionListener(e -> openActividadesWindow());
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        adminWindow.add(consultarActividadesBtn, gbc);

        JButton editarActividadesBtn = new JButton("Editar Actividades");
        editarActividadesBtn.addActionListener(e -> openEditActividadesWindow());
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        adminWindow.add(editarActividadesBtn, gbc);

        JButton eliminarActividadesBtn = new JButton("Eliminar Actividades");
        eliminarActividadesBtn.addActionListener(e -> openDeleteActividadesWindow());
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        adminWindow.add(eliminarActividadesBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreActividad = adminWindow.actividadNombreField.getText();
        boolean registrado = adminWindow.actividadEconomicaController.registrarActividadEconomica(nombreActividad);
        adminWindow.mostrarMensaje(registrado, "Actividad Económica");
    }

    private void openActividadesWindow() {
        ActividadesEconomicasConsultaWindow actividadesWindow = new ActividadesEconomicasConsultaWindow();
        actividadesWindow.setVisible(true);
    }

    private void openEditActividadesWindow() {
        ActividadesEconomicasEditarWindow actividadesEditWindow = new ActividadesEconomicasEditarWindow();
        actividadesEditWindow.setVisible(true);
    }

    private void openDeleteActividadesWindow() {
        ActividadesEconomicasEliminarWindow actividadesDeleteWindow = new ActividadesEconomicasEliminarWindow();
        actividadesDeleteWindow.setVisible(true);
    }
}