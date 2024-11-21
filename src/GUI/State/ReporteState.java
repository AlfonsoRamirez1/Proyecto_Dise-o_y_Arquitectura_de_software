// Código actualizado de ReporteState
package GUI.State;

import GUI.AdminWindow;
import GUI.Ventanas_interactivas.Reportes.ReportesConsultaWindow;
import GUI.Ventanas_interactivas.Reportes.ReportesEditarWindow;
import GUI.Ventanas_interactivas.Reportes.ReportesEliminarWindow;

import javax.swing.*;
import java.awt.*;

public class ReporteState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel reporteLabel = new JLabel("Registrar Reporte");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        adminWindow.add(reporteLabel, gbc);

        gbc.gridwidth = 1;

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

        JButton consultarReportesBtn = new JButton("Consultar Reportes");
        consultarReportesBtn.addActionListener(e -> openReportesWindow());
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        adminWindow.add(consultarReportesBtn, gbc);

        JButton editarReportesBtn = new JButton("Editar Reportes");
        editarReportesBtn.addActionListener(e -> openEditReportesWindow());
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        adminWindow.add(editarReportesBtn, gbc);

        JButton eliminarReportesBtn = new JButton("Eliminar Reportes");
        eliminarReportesBtn.addActionListener(e -> openDeleteReportesWindow());
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        adminWindow.add(eliminarReportesBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String descripcion = adminWindow.reporteDescripcionField.getText();
        String fecha = "2023-10-25"; // Se debe obtener dinámicamente
        int municipioId = 0; // Debe enlazarse a un municipio

        boolean registrado = adminWindow.reporteController.registrarReporte(descripcion, fecha, municipioId);
        adminWindow.mostrarMensaje(registrado, "Reporte");
    }

    private void openReportesWindow() {
        ReportesConsultaWindow reportesWindow = new ReportesConsultaWindow();
        reportesWindow.setVisible(true);
    }

    private void openEditReportesWindow() {
        ReportesEditarWindow reportesWindow = new ReportesEditarWindow();
        reportesWindow.setVisible(true);
    }

    private void openDeleteReportesWindow() {
        ReportesEliminarWindow reportesWindow = new ReportesEliminarWindow();
        reportesWindow.setVisible(true);
    }
}