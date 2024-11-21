// Código actualizado de LocalidadState
package GUI.State;

import GUI.AdminWindow;
import GUI.Ventanas_interactivas.Localidad.LocalidadesConsultaWindow;
import GUI.Ventanas_interactivas.Localidad.LocalidadesEditarWindow;
import GUI.Ventanas_interactivas.Localidad.LocalidadesEliminarWindow;

import javax.swing.*;
import java.awt.*;

public class LocalidadState implements FormState {
    @Override
    public void setupForm(AdminWindow adminWindow, GridBagConstraints gbc) {
        adminWindow.clearForm();

        JLabel localidadLabel = new JLabel("Registrar Localidad");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        adminWindow.add(localidadLabel, gbc);

        gbc.gridwidth = 1;

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

        JButton consultarLocalidadesBtn = new JButton("Consultar Localidades");
        consultarLocalidadesBtn.addActionListener(e -> openLocalidadesWindow());
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        adminWindow.add(consultarLocalidadesBtn, gbc);

        JButton editarLocalidadesBtn = new JButton("Editar Localidades");
        editarLocalidadesBtn.addActionListener(e -> openEditLocalidadesWindow());
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        adminWindow.add(editarLocalidadesBtn, gbc);

        JButton eliminarLocalidadesBtn = new JButton("Eliminar Localidades");
        eliminarLocalidadesBtn.addActionListener(e -> openDeleteLocalidadesWindow());
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        adminWindow.add(eliminarLocalidadesBtn, gbc);
    }

    @Override
    public void register(AdminWindow adminWindow) {
        String nombreLocalidad = adminWindow.localidadNombreField.getText();
        boolean registrado = adminWindow.localidadController.registrarLocalidad(nombreLocalidad);
        adminWindow.mostrarMensaje(registrado, "Localidad");
    }

    private void openLocalidadesWindow() {
        LocalidadesConsultaWindow localidadesWindow = new LocalidadesConsultaWindow();
        localidadesWindow.setVisible(true);
    }

    private void openEditLocalidadesWindow() {
        LocalidadesEditarWindow localidadesWindow = new LocalidadesEditarWindow();
        localidadesWindow.setVisible(true);
    }

    private void openDeleteLocalidadesWindow() {
        LocalidadesEliminarWindow localidadesWindow = new LocalidadesEliminarWindow();
        localidadesWindow.setVisible(true);
    }
}