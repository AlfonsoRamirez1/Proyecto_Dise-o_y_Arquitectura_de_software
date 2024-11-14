package GUI.State;

import GUI.AdminWindow;

import javax.swing.*;
import java.awt.*;

public class ReporteState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel reporteLabel = new JLabel("Registrar Reporte");
        gbc.gridx = 0; gbc.gridy = 0;
        adminWindow.add(reporteLabel, gbc);

        adminWindow.reporteDescripcionField = new JTextField(15);
        gbc.gridx = 0; gbc.gridy = 1;
        adminWindow.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        adminWindow.add(adminWindow.reporteDescripcionField, gbc);

        JButton registrarReporteBtn = new JButton("Registrar Reporte");
        registrarReporteBtn.addActionListener(e -> register(adminWindow));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        adminWindow.add(registrarReporteBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String descripcion = adminWindow.reporteDescripcionField.getText();
        String fecha = "2023-10-25"; // Se debe obtener dinámicamente
        int municipioId = 0; // Debe enlazarse a un municipio

        boolean registrado = adminWindow.reporteController.registrarReporte(descripcion, fecha, municipioId);
        adminWindow.mostrarMensaje(registrado, "Reporte");
    }
}
