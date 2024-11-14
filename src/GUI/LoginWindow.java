package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private String rolUsuario; // Variable para almacenar el rol del usuario

    public LoginWindow() {
        // Configuración de la ventana de inicio de sesión
        setTitle("Iniciar Sesión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiquetas y campos de texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre de Usuario:"), gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Contraseña:"), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        // Botón para acceder
        JButton loginButton = new JButton("Acceder");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        // Acción del botón
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Autenticar al usuario y obtener el rol
                if (autenticarUsuario(username, password)) {
                    // Decidir cuál ventana abrir según el rol del usuario
                    if ("administrador".equalsIgnoreCase(rolUsuario)) {
                        new AdminWindow().setVisible(true);
                    } else if ("invitado".equalsIgnoreCase(rolUsuario)) {
                        new GuestWindow().setVisible(true);
                    }
                    dispose(); // Cierra la ventana actual
                }
            }
        });
    }

    // Método para autenticar al usuario y guardar el rol
    private boolean autenticarUsuario(String username, String password) {
        String url = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";
        String sql = "SELECT rol FROM Usuarios WHERE nombre_usuario = ? AND contraseña = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Obtener y guardar el rol del usuario
                rolUsuario = rs.getString("rol");
                return true; // La autenticación fue exitosa
            } else {
                JOptionPane.showMessageDialog(this, "Datos incorrectos. Intentelo de nuevo");
                return false; // Falló la autenticación
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false; // Error al conectar a la base de datos
        }
    }
}
