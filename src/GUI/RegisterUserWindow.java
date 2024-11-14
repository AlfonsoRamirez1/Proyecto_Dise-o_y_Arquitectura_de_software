package GUI;

import Controller.UsuarioController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUserWindow extends JFrame {
    private JTextField nombreUsuarioField;
    private JPasswordField contraseñaField;
    private JTextField idField;
    private JTextField rolField;
    private UsuarioController usuarioController;

    public RegisterUserWindow() {
        usuarioController = new UsuarioController();

        // Configuración de la ventana de registro
        setTitle("Registrar Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta de mensaje
        JLabel registerLabel = new JLabel("Ingrese sus datos para registrarse.", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(registerLabel, gbc);

        // Campo de Nombre de Usuario
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nombre de Usuario:"), gbc);

        nombreUsuarioField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nombreUsuarioField, gbc);

        // Campo de Contraseña
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Contraseña:"), gbc);

        contraseñaField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(contraseñaField, gbc);

        // Campo de ID (solo para el objeto, no para la BD)
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("ID (Para funcionamiento del programa. No se usará en BD):"), gbc);

        idField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(idField, gbc);

        // Campo de Rol
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Rol:"), gbc);

        rolField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(rolField, gbc);

        // Botón de Registrar
        JButton registerButton = new JButton("Registrar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);

        // Acción del botón
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nombreUsuario = nombreUsuarioField.getText();
                String contraseña = new String(contraseñaField.getPassword());
                String rol = rolField.getText();

                boolean registrado = usuarioController.registrarUsuario(id, nombreUsuario, contraseña, rol);
                if (registrado) {
                    JOptionPane.showMessageDialog(RegisterUserWindow.this, "Usuario registrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(RegisterUserWindow.this, "Error al registrar usuario.");
                }
            }
        });
    }
}
